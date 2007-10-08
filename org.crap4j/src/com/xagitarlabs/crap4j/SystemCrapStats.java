package com.xagitarlabs.crap4j;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import com.xagitarlabs.crap4j.gauge.CrapImageGenerator;
import com.xagitarlabs.crap4j.gauge.NewCrapImageGenerator;
import com.xagitarlabs.crap4j.util.FileUtil;
import com.xagitarlabs.crap4j.util.FormatUtil;
import com.xagitarlabs.crap4j.util.MyStringBuilder;
import com.xagitarlabs.crap4j.util.StreamCopier;

public class SystemCrapStats {

	
	private float total;
	private float crapNumber;
	private float median;
	private float average;
	private double stdDev;
	private int methodCount;
	private List<? extends Crap> crapSubjects;
	private String name;
  private CrapProject crapProject;
  private int crapMethodCount;
  private float crapThreshold = 8.0f;
  private int crapWorkLoad;
  private float crapPercentWarningThreshold;
  private float crapPercentCriticalThreshold;
	
	public SystemCrapStats(List<? extends Crap> crapValues, 
                         String name, 
                         CrapProject crapProject, 
                         float crapThreshold, 
                         float crapPercentWarningThreshold, 
                         float crapPercentCriticalThreshold) {
		validateParams(crapValues);
		this.name = name;
    this.crapProject = crapProject;
		this.total = 0;
		this.crapSubjects = crapValues;
    this.crapThreshold = crapThreshold;
    this.crapPercentWarningThreshold = crapPercentWarningThreshold;
    this.crapPercentCriticalThreshold = crapPercentCriticalThreshold;

		this.methodCount = crapSubjects.size();
		this.total = computeTotalCrap(crapValues);
		this.average = total / methodCount;
		this.crapNumber = average;
		this.median = computeMedian();
		this.stdDev = computeStdDev();
    this.crapMethodCount = countCrapMethods(crapValues);
    this.crapWorkLoad = computeCrapWorkLoad(crapValues);
	}

	private int computeCrapWorkLoad(List<? extends Crap> crapValues) {
    int crapLoad = 0;
    for (Crap method : crapValues) {
      crapLoad += method.getCrapLoad(crapThreshold);
    }
    return crapLoad;    
  }

  private int countCrapMethods(List<? extends Crap> crapValues) {
	  int count = 0;
    for (Crap method : crapValues) {
      if (method.getCrap() >= crapThreshold)
        count++;
    }
    return count;
  }

  private float computeTotalCrap(List<? extends Crap> crapValues) {
		float totalCrap = 0;
		for (Crap method : crapValues) {
			totalCrap += method.getCrap();
		}
		return totalCrap;
	}

	private void validateParams(List<? extends Crap> crapValues) {
		if (crapValues == null/* || crapValues.size() < 1*/)
			throw new IllegalArgumentException("Cannot compute for null values");
	}
	
	public float getCrapNumber() {
		return crapNumber;
	}

	public float getAverage() {
		return average;
	}

	public float getMedian() {
		return median;
	}

	public double getStdDev() {
		return stdDev;
	}

	public float getTotal() {
		return total;
	}

	public int getSubjectCount() {
		return methodCount;
	}

	private double computeStdDev() {
		// Note we are not sampling, we have the whole population, so use N, not N - 1
		return Math.sqrt(computeVariance() / getSubjectCount());
	}

	private float computeVariance() {
		float[] crapScores = crapScores(crapSubjects);
		float variance = 0;
		for (int i = 0; i < crapScores.length; i++) {
			float diff = ((float)crapScores[i]) - getAverage();
			variance += Math.pow(diff,2.0);
		}
		return variance;
	}

	private float computeMedian() {
		float[] crapNumbers = crapScores(crapSubjects);
		Arrays.sort(crapNumbers);
		return crapNumbers[crapNumbers.length / 2];

	}

	private float[] crapScores(List<? extends Crap> list) {
		float[] crapNumbers = new float[crapSubjects.size()];
		for (int i=0; i < list.size(); i++) {
			crapNumbers[i] = list.get(i).getCrap();
		}
		return crapNumbers;
	}

	@Override
	public String toString() {
    NumberFormat nf = FormatUtil.getNumberFormatter();
		StringBuilder buf = new StringBuilder();
		buf.append(name).append("\n_____________________\n");
		buf.append("Total Crap: ").append(nf.format(total)).append(", ");
		buf.append("Crap: ").append(nf.format(crapNumber)).append(", ");
		buf.append("Median: ").append(nf.format(median)).append(", ");
		buf.append("Average: ").append(nf.format(average)).append(", ");
		buf.append("Std Dev: ").append(nf.format(stdDev)).append(", ");
		buf.append("Method Count: ").append(methodCount).append(", ");
    buf.append("crapMethodCount: ").append(nf.format((crapMethodCount))).append(", ");
    buf.append("crapMethodPercent: ").append(nf.format((crapMethodPercent()))).append("%");

//		buf.append(assessment);
		return buf.toString();
	}

	public List<? extends Crap> getSubjects() {
		return crapSubjects;
	}

	public void printAllSubjectComplexities() {
		List<? extends Crap> crapValues = getSubjects();
		System.out.println("Subject breakdown");
		System.out.println("----------------------");	
		Collections.sort(crapValues, Crap.comparator);
		for (Crap crap : crapValues) {
			System.out.println(crap);
		}
	}
  
  public String toXml() {
    MyStringBuilder s = new MyStringBuilder();
    s.start("<crap_result>");
    crapProject.toXml(s);
    s.start("<stats>");
    CrapProject.itemToXml(s, "name", name);
    NumberFormat nf = FormatUtil.getNumberFormatter();
    CrapProject.itemToXml(s, "totalCrap", nf.format(total));
    CrapProject.itemToXml(s, "crap", nf.format(crapNumber));
    CrapProject.itemToXml(s, "median", nf.format(median));
    CrapProject.itemToXml(s, "average", nf.format(average));
    CrapProject.itemToXml(s, "stdDev", nf.format(stdDev));
    CrapProject.itemToXml(s, "methodCount", Integer.toString(methodCount));
    CrapProject.itemToXml(s, "crapMethodCount", Integer.toString(crapMethodCount));
    CrapProject.itemToXml(s, "crapMethodPercent", nf.format(crapMethodPercent()));
    CrapProject.itemToXml(s, "crapLoad", Integer.toString(crapWorkLoad));
    CrapProject.itemToXml(s, "crapThreshold", Integer.toString((int) crapThreshold));
    s.start("<histogram>");
    int ones = crapLessThan(2.0f);
    int twos = (crapBetween(2.0f, 4.0f));
    int fours = (crapBetween(4.0f, 8.0f));
    int eights = (crapBetween(8.0f, 16.0f));
    int sixteens = (crapBetween(16.0f, 32.0f));
    int thirtytwos = (crapBetween(32.0f, 64.0f));
    int sixtyfours = (crapBetween(64.0f, 128.0f));
    int one28s = (crapBetween(128.0f, 256.0f));
    int two56s = (crapGE(256.0f));
    int[] places = {ones, twos, fours, eights, sixteens, thirtytwos, sixtyfours, one28s, two56s};
    Arrays.sort(places);
    int largest = places[places.length-1];
    float scale = 170.0f / (float)largest;
    int minHeight = 20;
    makeHist(s, "one", Integer.toString(ones), nf.format(adjustedHeight(ones, scale)));
    makeHist(s, "two", Integer.toString(twos), nf.format(adjustedHeight(twos, scale)));
    makeHist(s, "four", Integer.toString(fours), nf.format(adjustedHeight(fours, scale)));
    makeHist(s, "eight", Integer.toString(eights), nf.format(adjustedHeight(eights, scale)));
    makeHist(s, "sixteen", Integer.toString(sixteens), nf.format(adjustedHeight(sixteens, scale)));
    makeHist(s, "thirtytwo", Integer.toString(thirtytwos), nf.format(adjustedHeight(thirtytwos, scale)));
    makeHist(s, "sixtyfour", Integer.toString(sixtyfours), nf.format(adjustedHeight(sixtyfours, scale)));
    makeHist(s, "one28", Integer.toString(one28s), nf.format(adjustedHeight(one28s, scale)));
    makeHist(s, "two56", Integer.toString(two56s), nf.format(adjustedHeight(two56s, scale)));
    s.end("</histogram>");
    s.end("</stats>");
    s.start("<methods>");
    List<? extends Crap> crapValues = getSubjects();
    Collections.sort(crapValues, Crap.comparator);
    MethodCrap.setCrapLoadThreshold(crapThreshold);
    for (Crap crap : crapValues) {
      crap.toXml(s);
    }
    s.end("</methods>");
    s.end("</crap_result>");
    return s.toString();
  }

  private float adjustedHeight(int ones, float scale) {
    float minHeight = 28;
    if (ones > 0) 
      return Math.max(ones  * scale, minHeight);
    else
      return 0f;
  }

  private void makeHist(MyStringBuilder s, String place, String value, String height) {
    s.start("<hist>");
    CrapProject.itemToXml(s, "place", place);
    CrapProject.itemToXml(s, "value", value);
    CrapProject.itemToXml(s, "height", height+"px");
    s.end("</hist>");
  }

  private int crapBetween(float f, float f2) {
    int count = 0;
    for (Crap method : crapSubjects) {
      if (method.getCrap() >= f && method.getCrap() < f2)
        count++;
    }
    return count;
  }

  private int crapLessThan(float f) {
    int count = 0;
    for (Crap method : crapSubjects) {
      if (method.getCrap() < f)
        count++;
    }
    return count;
  }
  
  private int crapGE(float f) {
    int count = 0;
    for (Crap method : crapSubjects) {
      if (method.getCrap() >= f)
        count++;
    }
    return count;
  }

  private float crapMethodPercent() {
    return ((float)crapMethodCount / (float)methodCount)*100.0f;
  }

  public void writeXmlToFile(String statsXml) {
    File out = getXmlReportFile();
    FileUtil.writeFile(out, statsXml);
  }

  private File getXmlReportFile() {
    return crapProject.getReportFile();
  }

  public void generatePicture() {
    CrapImageGenerator cig = new CrapImageGenerator(crapMethodPercent(), 
                                                  crapProject.outputDir(), 
                                                  "crapGauge.png",
                                                  crapPercentWarningThreshold,
                                                  crapPercentCriticalThreshold);
    cig.makeGaugeAndWriteToFile();
  }

  public void generateBarPicture() {
    NewCrapImageGenerator cig = new NewCrapImageGenerator(crapMethodPercent(), 
                                                  crapProject.outputDir(), 
                                                  "crapBar.png", false, /*
                                                  crapPercentWarningThreshold,*/
                                                  crapPercentCriticalThreshold * 100.0f);
    cig.makeGaugeAndWriteToFile();
  }

  
  public void generateHtml() {
    copyImages();
    try {
      StreamSource xmlFile = new StreamSource(getXmlReportFile());
      generateMainPage(xmlFile);
      generateDetailCrapPage(xmlFile);
      generateDetailCrapLoadPage(xmlFile);
      generateDetailComplexityPage(xmlFile);
      generateDetailCoveragePage(xmlFile);
    } catch (Exception ex) {
      ex.printStackTrace();
    } 
  }

  private void copyImages() {
    copyFile(getRelativeResource("g_backbar.gif"), 
             new File(crapProject.outputDir(), "g_backbar.gif"));
    copyFile(getRelativeResource("g_colorbar3.jpg"), 
        new File(crapProject.outputDir(), "g_colorbar3.jpg"));
    
  }

  public void copyFile(InputStream stream, File outFile) {
    try {
      BufferedInputStream f = new BufferedInputStream(new DataInputStream(stream));
      BufferedOutputStream out = new BufferedOutputStream(new DataOutputStream(new FileOutputStream(outFile)));
      new StreamCopier(f, out, false);
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  private void makeHtml(StreamSource xmlFile, InputStream xslt, File outDetail) throws TransformerConfigurationException, TransformerFactoryConfigurationError, TransformerException {
    StreamSource xsltFile = new StreamSource(xslt);
    Transformer transformer = TransformerFactory.newInstance().newTransformer(xsltFile);
    transformer.transform(xmlFile, new StreamResult(outDetail));
  }

  private void generateMainPage(StreamSource xmlFile) throws FileNotFoundException, TransformerFactoryConfigurationError, TransformerConfigurationException, TransformerException {
    InputStream xslt = getRelativeResource("report.xslt");
    File outDetail = crapProject.getReportHtmlFile();    
    makeHtml(xmlFile, xslt, outDetail);
  }

  private void generateDetailCrapPage(StreamSource xmlFile) throws FileNotFoundException, TransformerFactoryConfigurationError, TransformerConfigurationException, TransformerException {
    InputStream xslt = getRelativeResource("detail_crap.xslt");
    File outDetail = new File(crapProject.outputDir(), "detail_crap.html");

    makeHtml(xmlFile, xslt, outDetail);
  }

  private void generateDetailCrapLoadPage(StreamSource xmlFile) throws FileNotFoundException, TransformerFactoryConfigurationError, TransformerConfigurationException, TransformerException {
    InputStream xslt = getRelativeResource("detail_crap_load.xslt");
    File outDetail = new File(crapProject.outputDir(), "detail_crap_load.html");

    makeHtml(xmlFile, xslt, outDetail);
  }
  
  private void generateDetailComplexityPage(StreamSource xmlFile) throws FileNotFoundException, TransformerFactoryConfigurationError, TransformerConfigurationException, TransformerException {
    InputStream xslt = getRelativeResource("detail_complexity.xslt");
    File outDetail = new File(crapProject.outputDir(), "detail_complexity.html");

    makeHtml(xmlFile, xslt, outDetail);
  }

  private void generateDetailCoveragePage(StreamSource xmlFile) throws FileNotFoundException, TransformerFactoryConfigurationError, TransformerConfigurationException, TransformerException {
    InputStream xslt = getRelativeResource("detail_coverage.xslt");
    File outDetail = new File(crapProject.outputDir(), "detail_coverage.html");

    makeHtml(xmlFile, xslt, outDetail);
  }

  public InputStream getRelativeResource(String file) {
    return SystemCrapStats.class.getResourceAsStream(file);
  }

  public void writeReport() {
    writeXmlToFile(toXml());
    generatePicture();
    generateBarPicture();
    generateHtml();
  }
}
