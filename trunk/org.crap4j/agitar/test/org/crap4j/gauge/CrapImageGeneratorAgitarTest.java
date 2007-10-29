/**
 * Generated by Agitar build: JUnitFactory Version 2.1.0.000576 (Build date: Oct 19, 2007) [2.1.0.000576]
 * JDK Version: 1.5.0_11
 *
 * Generated on Oct 26, 2007 4:00:49 PM
 * Time to generate: 03:02.639 seconds
 *
 */

package org.crap4j.gauge;

import com.agitar.lib.junit.AgitarTestCase;
import com.agitar.lib.mockingbird.Mockingbird;
import com.agitar.lib.mockingbird.MockingbirdSystem;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.IndexColorModel;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigInteger;
import java.text.NumberFormat;
import javax.imageio.ImageIO;
import org.crap4j.util.FormatUtil;

public class CrapImageGeneratorAgitarTest extends AgitarTestCase {
    
    public Class getTargetClass()  {
        return CrapImageGenerator.class;
    }
    
    public void testConstructor() throws Throwable {
        CrapImageGenerator crapImageGenerator = new CrapImageGenerator(100.0F, "testCrapImageGeneratorDir", " ", 1000.0F, 0.0F);
        assertEquals("crapImageGenerator.crapScore", 100.0F, ((Number) getPrivateField(crapImageGenerator, "crapScore")).floatValue(), 1.0E-6F);
        assertEquals("crapImageGenerator.dir", "testCrapImageGeneratorDir", getPrivateField(crapImageGenerator, "dir"));
        float actual = ((Image) getPrivateField(crapImageGenerator, "needle")).getAccelerationPriority();
        assertEquals("crapImageGenerator.needle.getAccelerationPriority()", 0.5F, actual, 1.0E-6F);
        assertEquals("crapImageGenerator.crapGaugeFilename", " ", getPrivateField(crapImageGenerator, "crapGaugeFilename"));
        assertEquals("crapImageGenerator.crapPercentWarningThreshold", 1000.0F, ((Number) getPrivateField(crapImageGenerator, "crapPercentWarningThreshold")).floatValue(), 1.0E-6F);
        assertEquals("crapImageGenerator.crapPercentCriticalThreshold", 0.0F, ((Number) getPrivateField(crapImageGenerator, "crapPercentCriticalThreshold")).floatValue(), 1.0E-6F);
        float actual2 = ((Image) getPrivateField(crapImageGenerator, "gauge")).getAccelerationPriority();
        assertEquals("crapImageGenerator.gauge.getAccelerationPriority()", 0.5F, actual2, 1.0E-6F);
    }
    
    public void testConstructor1() throws Throwable {
        CrapImageGenerator crapImageGenerator = new CrapImageGenerator(100.0F, "testCrapImageGeneratorDir", "", 1000.0F, 0.0F);
        assertEquals("crapImageGenerator.crapScore", 100.0F, ((Number) getPrivateField(crapImageGenerator, "crapScore")).floatValue(), 1.0E-6F);
        assertEquals("crapImageGenerator.dir", "testCrapImageGeneratorDir", getPrivateField(crapImageGenerator, "dir"));
        float actual = ((Image) getPrivateField(crapImageGenerator, "needle")).getAccelerationPriority();
        assertEquals("crapImageGenerator.needle.getAccelerationPriority()", 0.5F, actual, 1.0E-6F);
        assertEquals("crapImageGenerator.crapGaugeFilename", "CRI.png", getPrivateField(crapImageGenerator, "crapGaugeFilename"));
        assertEquals("crapImageGenerator.crapPercentWarningThreshold", 1000.0F, ((Number) getPrivateField(crapImageGenerator, "crapPercentWarningThreshold")).floatValue(), 1.0E-6F);
        assertEquals("crapImageGenerator.crapPercentCriticalThreshold", 0.0F, ((Number) getPrivateField(crapImageGenerator, "crapPercentCriticalThreshold")).floatValue(), 1.0E-6F);
        float actual2 = ((Image) getPrivateField(crapImageGenerator, "gauge")).getAccelerationPriority();
        assertEquals("crapImageGenerator.gauge.getAccelerationPriority()", 0.5F, actual2, 1.0E-6F);
    }
    
    public void testConstructor2() throws Throwable {
        CrapImageGenerator crapImageGenerator = new CrapImageGenerator(100.0F, "testCrapImageGeneratorDir", null, 1000.0F, 0.0F);
        assertEquals("crapImageGenerator.crapScore", 100.0F, ((Number) getPrivateField(crapImageGenerator, "crapScore")).floatValue(), 1.0E-6F);
        assertEquals("crapImageGenerator.dir", "testCrapImageGeneratorDir", getPrivateField(crapImageGenerator, "dir"));
        float actual = ((Image) getPrivateField(crapImageGenerator, "needle")).getAccelerationPriority();
        assertEquals("crapImageGenerator.needle.getAccelerationPriority()", 0.5F, actual, 1.0E-6F);
        assertEquals("crapImageGenerator.crapGaugeFilename", "CRI.png", getPrivateField(crapImageGenerator, "crapGaugeFilename"));
        assertEquals("crapImageGenerator.crapPercentWarningThreshold", 1000.0F, ((Number) getPrivateField(crapImageGenerator, "crapPercentWarningThreshold")).floatValue(), 1.0E-6F);
        assertEquals("crapImageGenerator.crapPercentCriticalThreshold", 0.0F, ((Number) getPrivateField(crapImageGenerator, "crapPercentCriticalThreshold")).floatValue(), 1.0E-6F);
        float actual2 = ((Image) getPrivateField(crapImageGenerator, "gauge")).getAccelerationPriority();
        assertEquals("crapImageGenerator.gauge.getAccelerationPriority()", 0.5F, actual2, 1.0E-6F);
    }
    
    public void testConvertDegrees() throws Throwable {
        CrapImageGenerator crapImageGenerator = new CrapImageGenerator(100.0F, "testCrapImageGeneratorDir", "testCrapImageGeneratorFilename", 1000.0F, 0.0F);
        double result = ((Number) callPrivateMethod("org.crap4j.gauge.CrapImageGenerator", "convertDegrees", new Class[] {float.class}, crapImageGenerator, new Object[] {new Float(100.0F)})).doubleValue();
        assertEquals("result", 8.831366015091307, result, 1.0E-6);
    }
    
    public void testDrawCrapOnGaugeWithAggressiveMocks() throws Throwable {
        CrapImageGenerator crapImageGenerator = (CrapImageGenerator) Mockingbird.getProxyObject(CrapImageGenerator.class, true);
        Graphics2D graphics2D = (Graphics2D) Mockingbird.getProxyObject(Graphics2D.class);
        Font font = (Font) Mockingbird.getProxyObject(Font.class);
        FontMetrics fontMetrics = (FontMetrics) Mockingbird.getProxyObject(FontMetrics.class);
        Rectangle2D rectangle2D = (Rectangle2D) Mockingbird.getProxyObject(Rectangle2D.class);
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(graphics2D.getFont(), font);
        Color BLACK = Color.BLACK;
        Mockingbird.setReturnValue(false, font, "deriveFont", "(int,float)java.awt.Font", new Object[] {new Integer(2), new Float(14.0F)}, null, 1);
        graphics2D.setFont(null);
        Mockingbird.setNormalReturnForVoid();
        Mockingbird.setReturnValue(false, graphics2D, "getFontMetrics", "()java.awt.FontMetrics", new Object[] {}, fontMetrics, 1);
        Mockingbird.setReturnValue(false, fontMetrics, "getStringBounds", "(java.lang.String,java.awt.Graphics)java.awt.geom.Rectangle2D", rectangle2D, 1);
        graphics2D.setColor(BLACK);
        Mockingbird.setNormalReturnForVoid();
        Mockingbird.setReturnValue(rectangle2D.getWidth(), 2.0);
        Mockingbird.setReturnValue(false, graphics2D, "drawString", "(java.lang.String,float,float)void", null, 1);
        Mockingbird.enterTestMode(CrapImageGenerator.class);
        callPrivateMethod("org.crap4j.gauge.CrapImageGenerator", "drawCrapOnGauge", new Class[] {Graphics2D.class, int.class, int.class, float.class}, crapImageGenerator, new Object[] {graphics2D, new Integer(0), new Integer(0), new Float(3.2350425E-5F)});
        assertTrue("Test call resulted in expected outcome", true);
    }
    
    public void testDrawCrapOnGaugeWithAggressiveMocks1() throws Throwable {
        CrapImageGenerator crapImageGenerator = (CrapImageGenerator) Mockingbird.getProxyObject(CrapImageGenerator.class, true);
        Graphics2D graphics2D = (Graphics2D) Mockingbird.getProxyObject(Graphics2D.class);
        Font font = (Font) Mockingbird.getProxyObject(Font.class);
        FontMetrics fontMetrics = (FontMetrics) Mockingbird.getProxyObject(FontMetrics.class);
        Rectangle2D rectangle2D = (Rectangle2D) Mockingbird.getProxyObject(Rectangle2D.class);
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(graphics2D.getFont(), font);
        Color BLACK = Color.BLACK;
        Mockingbird.setReturnValue(false, font, "deriveFont", "(int,float)java.awt.Font", new Object[] {new Integer(2), new Float(14.0F)}, null, 1);
        graphics2D.setFont(null);
        Mockingbird.setNormalReturnForVoid();
        Mockingbird.setReturnValue(false, graphics2D, "getFontMetrics", "()java.awt.FontMetrics", new Object[] {}, fontMetrics, 1);
        Mockingbird.setReturnValue(false, fontMetrics, "getStringBounds", "(java.lang.String,java.awt.Graphics)java.awt.geom.Rectangle2D", rectangle2D, 1);
        graphics2D.setColor(BLACK);
        Mockingbird.setNormalReturnForVoid();
        Mockingbird.setReturnValue(rectangle2D.getWidth(), 2.0);
        Mockingbird.setReturnValue(false, graphics2D, "drawString", "(java.lang.String,float,float)void", null, 1);
        Mockingbird.enterTestMode(CrapImageGenerator.class);
        callPrivateMethod("org.crap4j.gauge.CrapImageGenerator", "drawCrapOnGauge", new Class[] {Graphics2D.class, int.class, int.class, float.class}, crapImageGenerator, new Object[] {graphics2D, new Integer(0), new Integer(0), new Float(3.5000002F)});
        assertTrue("Test call resulted in expected outcome", true);
    }
    
    public void testDrawCrapScoreOnGaugeWithAggressiveMocks() throws Throwable {
        CrapImageGenerator crapImageGenerator = (CrapImageGenerator) Mockingbird.getProxyObject(CrapImageGenerator.class, true);
        Graphics2D graphics2D = (Graphics2D) Mockingbird.getProxyObject(Graphics2D.class);
        NumberFormat numberFormat = (NumberFormat) Mockingbird.getProxyObject(NumberFormat.class);
        Font font = (Font) Mockingbird.getProxyObject(Font.class);
        FontMetrics fontMetrics = (FontMetrics) Mockingbird.getProxyObject(FontMetrics.class);
        Rectangle2D rectangle2D = (Rectangle2D) Mockingbird.getProxyObject(Rectangle2D.class);
        setPrivateField(crapImageGenerator, "crapScore", new Float(3.3592705E31F));
        setPrivateField(crapImageGenerator, "crapPercentCriticalThreshold", new Float(1.9015271E28F));
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(FormatUtil.getNumberFormatter(), numberFormat);
        Color red = Color.red;
        Color BLACK = Color.BLACK;
        Color DARK_GRAY = Color.DARK_GRAY;
        Mockingbird.setReturnValue(false, numberFormat, "format", "(double)java.lang.String", new Object[] {new Double(2.802596928649634E-45)}, "", 1);
        Mockingbird.setReturnValue(false, Mockingbird.getProxyObject(StringBuilder.class), "toString", "()java.lang.String", "", 1);
        Mockingbird.setReturnValue(graphics2D.getFont(), font);
        Mockingbird.setReturnValue(false, font, "deriveFont", "(int,float)java.awt.Font", new Object[] {new Integer(0), new Float(14.0F)}, null, 1);
        graphics2D.setFont(null);
        Mockingbird.setNormalReturnForVoid();
        Mockingbird.setReturnValue(false, graphics2D, "getFontMetrics", "()java.awt.FontMetrics", new Object[] {}, fontMetrics, 1);
        Mockingbird.setReturnValue(false, fontMetrics, "getStringBounds", "(java.lang.String,java.awt.Graphics)java.awt.geom.Rectangle2D", rectangle2D, 1);
        Mockingbird.setReturnValue(rectangle2D.getWidth(), -2.0);
        Mockingbird.setReturnValue(rectangle2D.getHeight(), 9.0);
        graphics2D.setColor(red);
        Mockingbird.setNormalReturnForVoid();
        Mockingbird.setReturnValue(rectangle2D.getWidth(), -1.0);
        Mockingbird.setReturnValue(rectangle2D.getHeight(), 0.0);
        graphics2D.fillRect(-1, 6, 5, 5);
        Mockingbird.setNormalReturnForVoid();
        graphics2D.setColor(BLACK);
        Mockingbird.setNormalReturnForVoid();
        Mockingbird.setReturnValue(rectangle2D.getWidth(), -1.0);
        Mockingbird.setReturnValue(rectangle2D.getHeight(), -1.0);
        Mockingbird.setReturnValue(false, graphics2D, "drawRect", "(int,int,int,int)void", new Object[] {new Integer(-2), new Integer(5), new Integer(6), new Integer(5)}, null, 1);
        graphics2D.setColor(DARK_GRAY);
        Mockingbird.setNormalReturnForVoid();
        Mockingbird.setReturnValue(rectangle2D.getWidth(), -1.0);
        Mockingbird.setReturnValue(rectangle2D.getHeight(), 0.0);
        Mockingbird.setReturnValue(false, graphics2D, "drawRect", "(int,int,int,int)void", new Object[] {new Integer(-1), new Integer(6), new Integer(5), new Integer(4)}, null, 1);
        graphics2D.setColor(BLACK);
        Mockingbird.setNormalReturnForVoid();
        Mockingbird.setReturnValue(rectangle2D.getWidth(), 0.0);
        Mockingbird.setReturnValue(rectangle2D.getHeight(), -1.0);
        Mockingbird.setReturnValue(false, graphics2D, "drawRect", "(int,int,int,int)void", new Object[] {new Integer(-2), new Integer(5), new Integer(8), new Integer(5)}, null, 1);
        graphics2D.setColor(BLACK);
        Mockingbird.setNormalReturnForVoid();
        Mockingbird.setReturnValue(rectangle2D.getWidth(), 6.0);
        Mockingbird.setReturnValue(false, graphics2D, "drawString", "(java.lang.String,int,int)void", null, 1);
        Mockingbird.enterTestMode(CrapImageGenerator.class);
        callPrivateMethod("org.crap4j.gauge.CrapImageGenerator", "drawCrapScoreOnGauge", new Class[] {Graphics2D.class, int.class, int.class, float.class}, crapImageGenerator, new Object[] {graphics2D, new Integer(0), new Integer(50), new Float(2.8E-45F)});
        assertTrue("Test call resulted in expected outcome", true);
    }
    
    public void testDrawNeedleWithAggressiveMocks() throws Throwable {
        CrapImageGenerator crapImageGenerator = (CrapImageGenerator) Mockingbird.getProxyObject(CrapImageGenerator.class, true);
        Image image = (Image) Mockingbird.getProxyObject(Image.class);
        Graphics2D graphics2D = (Graphics2D) Mockingbird.getProxyObject(Graphics2D.class);
        setPrivateField(crapImageGenerator, "needle", image);
        Mockingbird.enterRecordingMode();
        graphics2D.translate(1, 1);
        Mockingbird.setNormalReturnForVoid();
        Mockingbird.setReturnValue(false, crapImageGenerator, "convertDegrees", "(float)double", new Object[] {new Float(2.8E-45F)}, new Double(2.802596928649634E-45), 1);
        graphics2D.rotate(2.802596928649634E-45);
        Mockingbird.setNormalReturnForVoid();
        graphics2D.translate(-1, -1);
        Mockingbird.setNormalReturnForVoid();
        Mockingbird.setReturnValue(false, image, "getWidth", "(java.awt.image.ImageObserver)int", new Integer(0), 1);
        Mockingbird.setReturnValue(false, image, "getHeight", "(java.awt.image.ImageObserver)int", new Integer(0), 1);
        Mockingbird.setReturnValue(false, graphics2D, "drawImage", "(java.awt.Image,int,int,int,int,java.awt.image.ImageObserver)boolean", Boolean.FALSE, 1);
        Mockingbird.enterTestMode(CrapImageGenerator.class);
        callPrivateMethod("org.crap4j.gauge.CrapImageGenerator", "drawNeedle", new Class[] {int.class, int.class, Graphics2D.class, float.class}, crapImageGenerator, new Object[] {new Integer(2), new Integer(2), graphics2D, new Float(2.8E-45F)});
        assertTrue("Test call resulted in expected outcome", true);
    }
    
    public void testGetBackgroundColor() throws Throwable {
        CrapImageGenerator crapImageGenerator = new CrapImageGenerator(100.0F, "testCrapImageGeneratorDir", "testCrapImageGeneratorFilename", 1000.0F, 0.0F);
        Color result = (Color) callPrivateMethod("org.crap4j.gauge.CrapImageGenerator", "getBackgroundColor", new Class[] {float.class}, crapImageGenerator, new Object[] {new Float(100.0F)});
        assertEquals("result.getAlpha()", 255, result.getAlpha());
    }
    
    public void testGetBackgroundColor1() throws Throwable {
        CrapImageGenerator crapImageGenerator = new CrapImageGenerator(100.0F, "testCrapImageGeneratorDir", "testCrapImageGeneratorFilename", 0.0F, 1000.0F);
        Color result = (Color) callPrivateMethod("org.crap4j.gauge.CrapImageGenerator", "getBackgroundColor", new Class[] {float.class}, crapImageGenerator, new Object[] {new Float(100.0F)});
        assertEquals("result.getAlpha()", 255, result.getAlpha());
    }
    
    public void testGetBackgroundColor2() throws Throwable {
        CrapImageGenerator crapImageGenerator = new CrapImageGenerator(-1090.8712F, "testCrapImageGeneratorDir", "testCrapImageGeneratorFilename", 100.0F, 1000.0F);
        Color result = (Color) callPrivateMethod("org.crap4j.gauge.CrapImageGenerator", "getBackgroundColor", new Class[] {float.class}, crapImageGenerator, new Object[] {new Float(100.0F)});
        assertEquals("result.getAlpha()", 255, result.getAlpha());
    }
    
    public void testGetGaugeHeight() throws Throwable {
        CrapImageGenerator crapImageGenerator = new CrapImageGenerator(100.0F, "testCrapImageGeneratorDir", "testCrapImageGeneratorFilename", 1000.0F, 0.0F);
        callPrivateMethod("org.crap4j.gauge.CrapImageGenerator", "getGaugeHeight", new Class[] {}, crapImageGenerator, new Object[] {});
        assertTrue("Test call resulted in expected outcome", true);
        // dependencies on static and environment state led to removal of 2 assertions
    }
    
    public void testGetGaugeWidth() throws Throwable {
        CrapImageGenerator crapImageGenerator = new CrapImageGenerator(100.0F, "testCrapImageGeneratorDir", "testCrapImageGeneratorFilename", 1000.0F, 0.0F);
        callPrivateMethod("org.crap4j.gauge.CrapImageGenerator", "getGaugeWidth", new Class[] {}, crapImageGenerator, new Object[] {});
        assertTrue("Test call resulted in expected outcome", true);
        // dependencies on static and environment state led to removal of 2 assertions
    }
    
    public void testIsEmpty() throws Throwable {
        boolean result = ((Boolean) callPrivateMethod("org.crap4j.gauge.CrapImageGenerator", "isEmpty", new Class[] {String.class}, null, new Object[] {""})).booleanValue();
        assertTrue("result", result);
    }
    
    public void testIsEmpty1() throws Throwable {
        boolean result = ((Boolean) callPrivateMethod("org.crap4j.gauge.CrapImageGenerator", "isEmpty", new Class[] {String.class}, null, new Object[] {" "})).booleanValue();
        assertFalse("result", result);
    }
    
    public void testIsEmpty2() throws Throwable {
        boolean result = ((Boolean) callPrivateMethod("org.crap4j.gauge.CrapImageGenerator", "isEmpty", new Class[] {String.class}, null, new Object[] {null})).booleanValue();
        assertTrue("result", result);
    }
    
    public void testIsInUpperHalfOfGauge() throws Throwable {
        CrapImageGenerator crapImageGenerator = new CrapImageGenerator(100.0F, "testCrapImageGeneratorDir", "testCrapImageGeneratorFilename", 1000.0F, 0.0F);
        boolean result = ((Boolean) callPrivateMethod("org.crap4j.gauge.CrapImageGenerator", "isInUpperHalfOfGauge", new Class[] {float.class}, crapImageGenerator, new Object[] {new Float(0.0F)})).booleanValue();
        assertFalse("result", result);
    }
    
    public void testIsInUpperHalfOfGauge1() throws Throwable {
        CrapImageGenerator crapImageGenerator = new CrapImageGenerator(100.0F, "testCrapImageGeneratorDir", "testCrapImageGeneratorFilename", 1000.0F, 0.0F);
        boolean result = ((Boolean) callPrivateMethod("org.crap4j.gauge.CrapImageGenerator", "isInUpperHalfOfGauge", new Class[] {float.class}, crapImageGenerator, new Object[] {new Float(100.0F)})).booleanValue();
        assertFalse("result", result);
    }
    
    public void testIsInUpperHalfOfGauge2() throws Throwable {
        CrapImageGenerator crapImageGenerator = new CrapImageGenerator(100.0F, "testCrapImageGeneratorDir", "testCrapImageGeneratorFilename", 1000.0F, 0.0F);
        boolean result = ((Boolean) callPrivateMethod("org.crap4j.gauge.CrapImageGenerator", "isInUpperHalfOfGauge", new Class[] {float.class}, crapImageGenerator, new Object[] {new Float(3.500035F)})).booleanValue();
        assertTrue("result", result);
    }
    
    public void testIsRunningHeadless() throws Throwable {
        boolean result = ((Boolean) callPrivateMethod("org.crap4j.gauge.CrapImageGenerator", "isRunningHeadless", new Class[] {}, null, new Object[] {})).booleanValue();
        assertFalse("result", result);
    }
    
    public void testIsValidFilename() throws Throwable {
        CrapImageGenerator crapImageGenerator = new CrapImageGenerator(100.0F, "testCrapImageGeneratorDir", "testCrapImageGeneratorFilename", 1000.0F, 0.0F);
        boolean result = ((Boolean) callPrivateMethod("org.crap4j.gauge.CrapImageGenerator", "isValidFilename", new Class[] {String.class}, crapImageGenerator, new Object[] {" "})).booleanValue();
        assertTrue("result", result);
    }
    
    public void testIsValidFilename1() throws Throwable {
        CrapImageGenerator crapImageGenerator = new CrapImageGenerator(100.0F, "testCrapImageGeneratorDir", "testCrapImageGeneratorFilename", 1000.0F, 0.0F);
        boolean result = ((Boolean) callPrivateMethod("org.crap4j.gauge.CrapImageGenerator", "isValidFilename", new Class[] {String.class}, crapImageGenerator, new Object[] {""})).booleanValue();
        assertFalse("result", result);
    }
    
    public void testIsValidFilename2() throws Throwable {
        CrapImageGenerator crapImageGenerator = new CrapImageGenerator(100.0F, "testCrapImageGeneratorDir", "testCrapImageGeneratorFilename", 1000.0F, 0.0F);
        boolean result = ((Boolean) callPrivateMethod("org.crap4j.gauge.CrapImageGenerator", "isValidFilename", new Class[] {String.class}, crapImageGenerator, new Object[] {null})).booleanValue();
        assertFalse("result", result);
    }
    
    public void testMain() throws Throwable {
        String[] strings = new String[2];
        Graphics2D graphics2D = (Graphics2D) Mockingbird.getProxyObject(Graphics2D.class);
        strings[0] = "";
        strings[1] = "";
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(true, CrapImageGenerator.class, "isEmpty", "(java.lang.String)boolean", Boolean.TRUE, 1);
        RenderingHints.Key KEY_ANTIALIASING = RenderingHints.KEY_ANTIALIASING;
        Object VALUE_ANTIALIAS_ON = RenderingHints.VALUE_ANTIALIAS_ON;
        RenderingHints.Key KEY_RENDERING = RenderingHints.KEY_RENDERING;
        Object VALUE_RENDER_QUALITY = RenderingHints.VALUE_RENDER_QUALITY;
        Color white = Color.white;
        Mockingbird.setReturnValue(true, CrapImageGenerator.class, "showUsage", "()void", new Object[] {}, null, 1);
        Boolean boolean2 = Boolean.FALSE;
        Mockingbird.setReturnValue(true, CrapImageGenerator.class, "isEmpty", "(java.lang.String)boolean", boolean2, 1);
        Mockingbird.setReturnValue(true, Float.class, "parseFloat", "(java.lang.String)float", new Float(2.8E-45F), 1);
        CrapImageGenerator crapImageGenerator = (CrapImageGenerator) Mockingbird.getProxyObject(CrapImageGenerator.class, true);
        Mockingbird.replaceObjectForRecording(CrapImageGenerator.class, "<init>(float,java.lang.String,java.lang.String,float,float)", crapImageGenerator);
        setPrivateField(crapImageGenerator, "gauge", null);
        setPrivateField(crapImageGenerator, "crapScore", new Float(10.0F));
        setPrivateField(crapImageGenerator, "dir", "");
        setPrivateField(crapImageGenerator, "crapGaugeFilename", "");
        Mockingbird.setReturnValue(false, crapImageGenerator, "getGaugeWidth", "()int", new Object[] {}, new Integer(0), 1);
        Mockingbird.setReturnValue(false, crapImageGenerator, "getGaugeHeight", "()int", new Object[] {}, new Integer(0), 1);
        BufferedImage bufferedImage = (BufferedImage) Mockingbird.getProxyObject(BufferedImage.class);
        Mockingbird.replaceObjectForRecording(BufferedImage.class, "<init>(int,int,int)", bufferedImage);
        Mockingbird.setReturnValue(false, bufferedImage, "createGraphics", "()java.awt.Graphics2D", new Object[] {}, graphics2D, 1);
        graphics2D.setRenderingHint(KEY_ANTIALIASING, VALUE_ANTIALIAS_ON);
        Mockingbird.setNormalReturnForVoid();
        graphics2D.setRenderingHint(KEY_RENDERING, VALUE_RENDER_QUALITY);
        Mockingbird.setNormalReturnForVoid();
        graphics2D.setBackground(white);
        Mockingbird.setNormalReturnForVoid();
        graphics2D.clearRect(0, 0, 0, 0);
        Mockingbird.setNormalReturnForVoid();
        Mockingbird.setReturnValue(false, graphics2D, "drawImage", "(java.awt.Image,int,int,int,int,java.awt.image.ImageObserver)boolean", boolean2, 1);
        Mockingbird.setReturnValue(false, crapImageGenerator, "drawCrapOnGauge", "(java.awt.Graphics2D,int,int,float)void", new Object[] {graphics2D, new Integer(0), new Integer(0), new Float(10.0F)}, null, 1);
        Mockingbird.setReturnValue(false, crapImageGenerator, "drawCrapScoreOnGauge", "(java.awt.Graphics2D,int,int,float)void", new Object[] {graphics2D, new Integer(0), new Integer(0), new Float(10.0F)}, null, 1);
        Mockingbird.setReturnValue(false, crapImageGenerator, "drawNeedle", "(int,int,java.awt.Graphics2D,float)void", new Object[] {new Integer(0), new Integer(0), graphics2D, new Float(1.0F)}, null, 1);
        Mockingbird.replaceObjectForRecording(File.class, "<init>(java.lang.String,java.lang.String)", Mockingbird.getProxyObject(File.class));
        FileOutputStream fileOutputStream = (FileOutputStream) Mockingbird.getProxyObject(FileOutputStream.class);
        Mockingbird.replaceObjectForRecording(FileOutputStream.class, "<init>(java.io.File)", fileOutputStream);
        Mockingbird.setReturnValue(true, ImageIO.class, "write", "(java.awt.image.RenderedImage,java.lang.String,java.io.OutputStream)boolean", new Object[] {bufferedImage, "png", fileOutputStream}, boolean2, 1);
        Mockingbird.setReturnValue(false, fileOutputStream, "close", "()void", new Object[] {}, null, 1);
        Mockingbird.setReturnValue(true, System.class, "getProperty", "(java.lang.String)java.lang.String", new Object[] {"java.awt.headless"}, "", 1);
        Mockingbird.setReturnValue(false, Mockingbird.getProxyObject(String.class), "toUpperCase", "()java.lang.String", "true", 1);
        Mockingbird.enterTestMode(CrapImageGenerator.class);
        CrapImageGenerator.main(strings);
        boolean actual = ((Boolean) callPrivateMethod("org.crap4j.gauge.CrapImageGenerator", "isRunningHeadless", new Class[] {}, null, new Object[] {})).booleanValue();
        assertFalse(".isRunningHeadless()", actual);
    }
    
    public void testMakeGaugeAndWriteToFileWithAggressiveMocks() throws Throwable {
        CrapImageGenerator crapImageGenerator = (CrapImageGenerator) Mockingbird.getProxyObject(CrapImageGenerator.class, true);
        Graphics2D graphics2D = (Graphics2D) Mockingbird.getProxyObject(Graphics2D.class);
        IOException iOException = (IOException) Mockingbird.getProxyObject(IOException.class);
        setPrivateField(crapImageGenerator, "gauge", null);
        setPrivateField(crapImageGenerator, "crapScore", new Float(10.0F));
        setPrivateField(crapImageGenerator, "dir", "");
        setPrivateField(crapImageGenerator, "crapGaugeFilename", "");
        RenderingHints.Key KEY_ANTIALIASING = RenderingHints.KEY_ANTIALIASING;
        Object VALUE_ANTIALIAS_ON = RenderingHints.VALUE_ANTIALIAS_ON;
        RenderingHints.Key KEY_RENDERING = RenderingHints.KEY_RENDERING;
        Object VALUE_RENDER_QUALITY = RenderingHints.VALUE_RENDER_QUALITY;
        Color white = Color.white;
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(false, crapImageGenerator, "getGaugeWidth", "()int", new Object[] {}, new Integer(0), 1);
        Mockingbird.setReturnValue(false, crapImageGenerator, "getGaugeHeight", "()int", new Object[] {}, new Integer(0), 1);
        BufferedImage bufferedImage = (BufferedImage) Mockingbird.getProxyObject(BufferedImage.class);
        Mockingbird.replaceObjectForRecording(BufferedImage.class, "<init>(int,int,int)", bufferedImage);
        Mockingbird.setReturnValue(false, bufferedImage, "createGraphics", "()java.awt.Graphics2D", new Object[] {}, graphics2D, 1);
        graphics2D.setRenderingHint(KEY_ANTIALIASING, VALUE_ANTIALIAS_ON);
        Mockingbird.setNormalReturnForVoid();
        graphics2D.setRenderingHint(KEY_RENDERING, VALUE_RENDER_QUALITY);
        Mockingbird.setNormalReturnForVoid();
        graphics2D.setBackground(white);
        Mockingbird.setNormalReturnForVoid();
        graphics2D.clearRect(0, 0, 0, 0);
        Mockingbird.setNormalReturnForVoid();
        Boolean boolean2 = Boolean.FALSE;
        Mockingbird.setReturnValue(false, graphics2D, "drawImage", "(java.awt.Image,int,int,int,int,java.awt.image.ImageObserver)boolean", boolean2, 1);
        Mockingbird.setReturnValue(false, crapImageGenerator, "drawCrapOnGauge", "(java.awt.Graphics2D,int,int,float)void", new Object[] {graphics2D, new Integer(0), new Integer(0), new Float(10.0F)}, null, 1);
        Mockingbird.setReturnValue(false, crapImageGenerator, "drawCrapScoreOnGauge", "(java.awt.Graphics2D,int,int,float)void", new Object[] {graphics2D, new Integer(0), new Integer(0), new Float(10.0F)}, null, 1);
        Mockingbird.setReturnValue(false, crapImageGenerator, "drawNeedle", "(int,int,java.awt.Graphics2D,float)void", new Object[] {new Integer(0), new Integer(0), graphics2D, new Float(1.0F)}, null, 1);
        Mockingbird.replaceObjectForRecording(File.class, "<init>(java.lang.String,java.lang.String)", Mockingbird.getProxyObject(File.class));
        FileOutputStream fileOutputStream = (FileOutputStream) Mockingbird.getProxyObject(FileOutputStream.class);
        Mockingbird.replaceObjectForRecording(FileOutputStream.class, "<init>(java.io.File)", fileOutputStream);
        Mockingbird.setReturnValue(true, ImageIO.class, "write", "(java.awt.image.RenderedImage,java.lang.String,java.io.OutputStream)boolean", new Object[] {bufferedImage, "png", fileOutputStream}, boolean2, 1);
        Mockingbird.setException(false, fileOutputStream, "close", "()void", new Object[] {}, iOException, 1);
        Mockingbird.setReturnValue(false, iOException, "printStackTrace", "()void", new Object[] {}, null, 1);
        Mockingbird.enterTestMode(CrapImageGenerator.class);
        crapImageGenerator.makeGaugeAndWriteToFile();
        assertTrue("Test call resulted in expected outcome", true);
    }
    
    public void testShowUsage() throws Throwable {
        callPrivateMethod("org.crap4j.gauge.CrapImageGenerator", "showUsage", new Class[] {}, null, new Object[] {});
        boolean actual = ((Boolean) callPrivateMethod("org.crap4j.gauge.CrapImageGenerator", "isRunningHeadless", new Class[] {}, null, new Object[] {})).booleanValue();
        assertFalse(".isRunningHeadless()", actual);
    }
    
    public void testValidateArgs() throws Throwable {
        String[] strings = new String[1];
        callPrivateMethod("org.crap4j.gauge.CrapImageGenerator", "validateArgs", new Class[] {String[].class}, null, new Object[] {strings});
        boolean actual = ((Boolean) callPrivateMethod("org.crap4j.gauge.CrapImageGenerator", "isRunningHeadless", new Class[] {}, null, new Object[] {})).booleanValue();
        assertFalse(".isRunningHeadless()", actual);
    }
    
    public void testValidateArgs1() throws Throwable {
        PrintStream printStream = (PrintStream) Mockingbird.getProxyObject(PrintStream.class);
        MockingbirdSystem.out = printStream;
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(false, printStream, "println", "(java.lang.String)void", new Object[] {"Usage: crapScore destination_directory"}, null, 1);
        Mockingbird.setReturnValue(true, System.class, "exit", "(int)void", new Object[] {new Integer(0)}, null, 1);
        Mockingbird.enterTestMode(CrapImageGenerator.class);
        callPrivateMethod("org.crap4j.gauge.CrapImageGenerator", "validateArgs", new Class[] {String[].class}, null, new Object[] {null});
        boolean actual = ((Boolean) callPrivateMethod("org.crap4j.gauge.CrapImageGenerator", "isRunningHeadless", new Class[] {}, null, new Object[] {})).booleanValue();
        assertFalse(".isRunningHeadless()", actual);
    }
    
    public void testValidateArgs2() throws Throwable {
        String[] strings = new String[0];
        PrintStream printStream = (PrintStream) Mockingbird.getProxyObject(PrintStream.class);
        MockingbirdSystem.out = printStream;
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(false, printStream, "println", "(java.lang.String)void", new Object[] {"Usage: crapScore destination_directory"}, null, 1);
        Mockingbird.setReturnValue(true, System.class, "exit", "(int)void", new Object[] {new Integer(0)}, null, 1);
        Mockingbird.enterTestMode(CrapImageGenerator.class);
        callPrivateMethod("org.crap4j.gauge.CrapImageGenerator", "validateArgs", new Class[] {String[].class}, null, new Object[] {strings});
        boolean actual = ((Boolean) callPrivateMethod("org.crap4j.gauge.CrapImageGenerator", "isRunningHeadless", new Class[] {}, null, new Object[] {})).booleanValue();
        assertFalse(".isRunningHeadless()", actual);
    }
    
    public void testValidateCrapScore() throws Throwable {
        String result = (String) callPrivateMethod("org.crap4j.gauge.CrapImageGenerator", "validateCrapScore", new Class[] {String.class}, null, new Object[] {" "});
        assertEquals("result", " ", result);
    }
    
    public void testValidateCrapScore1() throws Throwable {
        String result = (String) callPrivateMethod("org.crap4j.gauge.CrapImageGenerator", "validateCrapScore", new Class[] {String.class}, null, new Object[] {""});
        assertEquals("result", "", result);
    }
    
    public void testValidateCrapScore2() throws Throwable {
        Object result = callPrivateMethod("org.crap4j.gauge.CrapImageGenerator", "validateCrapScore", new Class[] {String.class}, null, new Object[] {null});
        assertNull("result", result);
    }
    
    public void testValidateOutputDirectory() throws Throwable {
        String result = (String) callPrivateMethod("org.crap4j.gauge.CrapImageGenerator", "validateOutputDirectory", new Class[] {String.class}, null, new Object[] {" "});
        assertEquals("result", " ", result);
    }
    
    public void testValidateOutputDirectory1() throws Throwable {
        PrintStream printStream = (PrintStream) Mockingbird.getProxyObject(PrintStream.class);
        MockingbirdSystem.out = printStream;
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(false, printStream, "println", "(java.lang.String)void", new Object[] {"Usage: crapScore destination_directory"}, null, 1);
        Mockingbird.setReturnValue(true, System.class, "exit", "(int)void", new Object[] {new Integer(0)}, null, 1);
        Mockingbird.enterTestMode(CrapImageGenerator.class);
        String result = (String) callPrivateMethod("org.crap4j.gauge.CrapImageGenerator", "validateOutputDirectory", new Class[] {String.class}, null, new Object[] {null});
        assertNull("result", result);
    }
    
    public void testWriteImageToFile() throws Throwable {
        CrapImageGenerator crapImageGenerator = new CrapImageGenerator(100.0F, "testCrapImageGeneratorDir", "testCrapImageGeneratorFilename", 1000.0F, 0.0F);
        callPrivateMethod("org.crap4j.gauge.CrapImageGenerator", "writeImageToFile", new Class[] {BufferedImage.class}, crapImageGenerator, new Object[] {new BufferedImage(100, 1000, 1)});
        assertTrue("Test call resulted in expected outcome", true);
        // dependencies on static and environment state led to removal of 1 assertion
    }
    
    public void testDisplayOnScreenThrowsHeadlessException() throws Throwable {
        int[] ints = new int[16];
        BufferedImage bufferedImage = new BufferedImage(100, 1000, 12, new IndexColorModel(1, 10, ints, 0, 0, BigInteger.ONE));
        try {
            callPrivateMethod("org.crap4j.gauge.CrapImageGenerator", "displayOnScreen", new Class[] {BufferedImage.class}, null, new Object[] {bufferedImage});
            fail("Expected HeadlessException to be thrown");
        } catch (HeadlessException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(GraphicsEnvironment.class, ex);
        }
    }
    
    public void testDrawCrapOnGaugeThrowsNullPointerException() throws Throwable {
        CrapImageGenerator crapImageGenerator = new CrapImageGenerator(100.0F, "testCrapImageGeneratorDir", "testCrapImageGeneratorFilename", 1000.0F, 0.0F);
        try {
            callPrivateMethod("org.crap4j.gauge.CrapImageGenerator", "drawCrapOnGauge", new Class[] {Graphics2D.class, int.class, int.class, float.class}, crapImageGenerator, new Object[] {null, new Integer(100), new Integer(1000), new Float(100.0F)});
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(CrapImageGenerator.class, ex);
        }
    }
    
    public void testDrawNeedleThrowsNullPointerException() throws Throwable {
        CrapImageGenerator crapImageGenerator = new CrapImageGenerator(100.0F, "testCrapImageGeneratorDir", "testCrapImageGeneratorFilename", 1000.0F, 0.0F);
        try {
            callPrivateMethod("org.crap4j.gauge.CrapImageGenerator", "drawNeedle", new Class[] {int.class, int.class, Graphics2D.class, float.class}, crapImageGenerator, new Object[] {new Integer(100), new Integer(1000), null, new Float(100.0F)});
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(CrapImageGenerator.class, ex);
            float actual = ((Image) getPrivateField(crapImageGenerator, "needle")).getAccelerationPriority();
            assertEquals("crapImageGenerator.needle.getAccelerationPriority()", 0.5F, actual, 1.0E-6F);
        }
    }
    
    public void testMainThrowsArrayIndexOutOfBoundsException() throws Throwable {
        String[] argv = new String[1];
        argv[0] = "";
        try {
            CrapImageGenerator.main(argv);
            fail("Expected ArrayIndexOutOfBoundsException to be thrown");
        } catch (ArrayIndexOutOfBoundsException ex) {
            assertEquals("ex.getMessage()", "1", ex.getMessage());
            assertThrownBy(CrapImageGenerator.class, ex);
        }
    }
    
    public void testMainThrowsArrayIndexOutOfBoundsException1() throws Throwable {
        String[] argv = new String[1];
        try {
            CrapImageGenerator.main(argv);
            fail("Expected ArrayIndexOutOfBoundsException to be thrown");
        } catch (ArrayIndexOutOfBoundsException ex) {
            assertEquals("ex.getMessage()", "1", ex.getMessage());
            assertThrownBy(CrapImageGenerator.class, ex);
        }
    }
    
    public void testMainThrowsNullPointerException() throws Throwable {
        String[] argv = new String[5];
        argv[1] = "testString";
        try {
            CrapImageGenerator.main(argv);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
        }
    }
    
    public void testMainThrowsNumberFormatException() throws Throwable {
        String[] argv = new String[5];
        argv[0] = ") must be >= 1";
        argv[1] = "testString";
        try {
            CrapImageGenerator.main(argv);
            fail("Expected NumberFormatException to be thrown");
        } catch (NumberFormatException ex) {
            assertEquals("ex.getMessage()", "For input string: \") must be >= 1\"", ex.getMessage());
        }
    }
}

