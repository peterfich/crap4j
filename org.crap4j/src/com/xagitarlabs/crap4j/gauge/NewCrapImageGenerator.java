package com.xagitarlabs.crap4j.gauge;

/*
 * Originally from a Sun demo, but heavily modified by Dan, then by Bob.
 * @(#)JPEGFlip.java	1.6  98/12/03
 *
 * Copyright 1998 by Sun Microsystems, Inc.,
 * 901 San Antonio Road, Palo Alto, California, 94303, U.S.A.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of Sun Microsystems, Inc. ("Confidential Information").  You
 * shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement
 * you entered into with Sun.
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.xagitarlabs.crap4j.util.FormatUtil;

public class NewCrapImageGenerator {

	private static final String NB_GIF = "background.gif";
	private static final String MARKER_GIF = "marker.gif";
	private static final String NEEDLE_GIF = "needle.gif";
	private static final String BACKGROUND_GIF = "meter_background.gif";
	private Image gauge;
	private Image needle;
	private float crapScore;
	private String dir;
	private String crapGaugeFilename = "CRI.png";
	private boolean useBlueBackground;
  private float crapThreshold;

	public NewCrapImageGenerator(float crapNumber, String dir, String filename, boolean useBlueBackground, float crapThreshold) {
		this.crapScore = crapNumber;
		this.dir = dir;
		this.useBlueBackground = useBlueBackground;
		if (isValidFilename(filename))
			this.crapGaugeFilename = filename;
		gauge = new ImageIcon(NewCrapImageGenerator.class.getResource(NB_GIF))
				.getImage();
		needle = new ImageIcon(NewCrapImageGenerator.class.getResource(MARKER_GIF))
				.getImage();
    this.crapThreshold = crapThreshold;
	}

	private boolean isValidFilename(String filename) {
		return !isEmpty(filename);
	}

	public void makeGaugeAndWriteToFile() {
		writeImageToFile(makeGauge());
	}

	private void writeImageToFile(BufferedImage bi) {
		File file = new File(dir, crapGaugeFilename);
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(file);
			boolean ok = ImageIO.write(bi, "png", out); // writeAsJpeg(bi, out);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	
	private BufferedImage makeGauge() {
		int w = 420;
		int totalHeight = 100;
		int imgHeight = 40;
		int xOffset = 40;
		int yOffset = 6;
		int markerOffset = 14;
		int textOffset = 20;
		
		int totalWidth = w+xOffset*2;
		
		BufferedImage bufferedImage = new BufferedImage(totalWidth, totalHeight,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D imageGraphics = bufferedImage.createGraphics();
		imageGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		imageGraphics.setRenderingHint(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);
		if(useBlueBackground){
			imageGraphics.setBackground(new Color(238,238,255));
		} else {
			imageGraphics.setBackground(new Color(255,255,255));
		}
		imageGraphics.clearRect(0, 0, totalWidth, totalHeight);
		
		drawShadowRect(imageGraphics, xOffset, yOffset, w, imgHeight);
		drawGreenRect(imageGraphics, xOffset, yOffset, w/3, imgHeight);
		drawRedRect(imageGraphics, xOffset+w/3, yOffset, w*2/3, imgHeight);
		
		drawIncrementsOnGauge(imageGraphics, w, imgHeight+textOffset, xOffset);
		drawMarker(w,imgHeight+markerOffset,imageGraphics, crapScore, xOffset);
		return bufferedImage;

	}
	
	private void drawShadowRect(Graphics2D imageGraphics, int xOffset, int yOffset, int width, int height){
		Color gray = getShadowColor();
		imageGraphics.setColor(gray);
		imageGraphics.fillRect(xOffset+2, yOffset+2, width+2, height+2);
	}
	
	private void drawGreenRect(Graphics2D imageGraphics, int xOffset, int yOffset, int x, int y) {
		Color defGreen = getDefGreen();
		Color darkerGreen = new Color(144,250,144);
	    GradientPaint greenPaint = new GradientPaint(xOffset, yOffset*2, darkerGreen, xOffset+x, yOffset*2,
	            defGreen);
	    imageGraphics.setPaint(greenPaint);
		imageGraphics.fillRect(xOffset, yOffset, x, y);
		imageGraphics.setColor(Color.BLACK);
		imageGraphics.drawRect(xOffset, yOffset,x,y);
	}
	
	private void drawRedRect(Graphics2D imageGraphics, int xOffset, int yOffset, int x, int y) {
		Color defRed = getDefRed();
		Color darkerRed = new Color(221,50,50);
	    GradientPaint redPaint = new GradientPaint(xOffset, yOffset*2, defRed, xOffset+x, yOffset*2,
	            darkerRed);
	    imageGraphics.setPaint(redPaint);
		imageGraphics.fillRect(xOffset, yOffset, x, y);
		imageGraphics.setColor(Color.BLACK);
		imageGraphics.drawRect(xOffset, yOffset,x,y);
	}

	private void drawMarker(int w, int h,  Graphics2D big, float crapScore, int offset){
		int scaleWidth=w;
		int needleW = 30;
		int needleH = 20;
		int x = crapScore>MAX_INCR 
        ? (scaleWidth+(offset-needleW/2))
        : getPixelScore(crapScore, offset, scaleWidth, needleW);
		int y= (int)(h);

		int shadowX = x+2;
		int shadowY = y+2;

		Polygon shadow = new Polygon(new int[] { shadowX, shadowX + needleW / 2, shadowX + needleW }, 
                                 new int[] { shadowY, shadowY - needleH, shadowY },
                                 3);
		big.setColor(getShadowColor());
		big.fillPolygon(shadow);
		//big.drawImage(needle, x, y, needleW, needleH, null);
		big.setColor(Color.YELLOW);
		Polygon p = new Polygon(new int[]{x, x+needleW/2, x+needleW}, 
                            new int[]{y, y-needleH, y}, 
                            3);

		big.fillPolygon(p);
		big.setColor(Color.BLACK);
		
		big.drawPolygon(p);
		drawCrapScore(w, h, big, crapScore, x, y+2);
	}

	private Color getShadowColor() {
		return new Color(170,170,170,155);
	}

	private int getPixelScore(float crapScore, int offset, int scaleWidth,
			int needleW) {
		if(crapScore <0){
			return 0;
		}
		return (int)((crapScore/15)*scaleWidth)+(offset-needleW/2);

	}
	
	private static final int FIRST_INCR = 0;
	private static final int SECOND_INCR = 5;
	private static final int THIRD_INCR = 10;
	private static final int MAX_INCR = 15;

	private void drawCrapScore(int w, int h, Graphics2D big, float crapScore2,
			int x, int y) {
		big.setColor(getBackgroundColor(crapScore2));
		int rectWidth = 65;
		int rectHeight = 30;
		int xOffset=18;
		int startX = x-xOffset;
		int startY = y;
		big.fillRect(startX,startY, rectWidth, rectHeight);
		
		String val = FormatUtil.getNumberFormatter().format(crapScore);
		if(crapScore>=100f){
			val="100.0";
		} 
		Rectangle2D bounds = big.getFontMetrics().getStringBounds(val, big);
		int boundsW = (int)bounds.getWidth();

		int textStart= x-xOffset+((rectWidth-boundsW)/2);
		if(textStart <0){
			textStart=0;
		}

		big.setColor(Color.BLACK);
		big.drawRect(startX,startY, rectWidth, rectHeight);
		big.drawString(val, textStart,y+(rectHeight*5/6));
	}


	private void drawIncrementsOnGauge(Graphics2D big, int width, int height, int offset){
		big.setColor(Color.BLACK);
		Font currFont = big.getFont();
		Font bigger = currFont.deriveFont(Font.PLAIN, 24);
		big.setFont(bigger);
		FontMetrics fm = big.getFontMetrics();
		int y = height+14;
		int xOffset = offset-6;
		big.drawString(Integer.toString(FIRST_INCR),
				xOffset, y);
		int x = xOffset+(width/3);
		big.drawString(Integer.toString(SECOND_INCR), x, y);
		x=xOffset+((width*2)/3);
		big.drawString(Integer.toString(THIRD_INCR), x, y);
		
		x=(xOffset-10)+width;
		big.drawString(Integer.toString(MAX_INCR)+"+", x, y);
	}
	
	private Color getDefGreen(){
		return new Color(224,255,224);
	}
	private Color getDefRed(){
		return new Color(255,224,224);
	}

	private Color getBackgroundColor(float crapScore2) {
		return crapScore > crapThreshold ? getDefRed() : getDefGreen();
	}

	private static void showUsage() {
		System.out.println("Usage: crapScore destination_directory");
	}

	public static void main(String argv[]) {
		validateArgs(argv);
		String crapScore = validateCrapScore(argv[0]);
		String dir = validateOutputDirectory(argv[1]);
		boolean useBlueBackground = false;
		useBlueBackground = argv.length==3&&argv[2] != null;
		NewCrapImageGenerator demo = new NewCrapImageGenerator(Float
				.parseFloat(crapScore), dir, null, useBlueBackground, 15);
		//    demo.makeGaugeAndWriteToFile(); // standard usage.

		// In the main, let's see the image too!
		BufferedImage bi = demo.makeGauge();
		demo.writeImageToFile(bi);
		if (!isRunningHeadless())
			displayOnScreen(bi);
	}

	private static String validateOutputDirectory(String dir) {
		if (isEmpty(dir)) {
			showUsage();
			System.exit(0);
		}
		return dir;
	}

	private static String validateCrapScore(String crapScore) {
		if (isEmpty(crapScore)) {
			showUsage();
		}
		return crapScore;
	}

	private static boolean isEmpty(String s) {
		return s == null || s.length() == 0;
	}

	private static void validateArgs(String[] argv) {
		if (argv == null || argv.length == 0) {
			showUsage();
			System.exit(0);
		}
	}

	private static boolean isRunningHeadless() {
		String headlessProperty = System.getProperty("java.awt.headless");
		return headlessProperty != null
				&& headlessProperty.toUpperCase().equals("true");
	}

	private static void displayOnScreen(BufferedImage bi) {
		JFrame frame = new JFrame();
		JPanel gaugePanel = new JPanel();
		gaugePanel.add(new JLabel(new ImageIcon(bi)));
		frame.getContentPane().add(gaugePanel);

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		frame.pack();
		frame.setVisible(true);
	}

}
