package com.xagitarlabs.crap4j.util;

import java.text.NumberFormat;

public class FormatUtil {

  public static NumberFormat getNumberFormatter() {
    NumberFormat nf = NumberFormat.getInstance();
    nf.setMaximumFractionDigits(2);
    nf.setMinimumFractionDigits(2);
    nf.setGroupingUsed(false);
    return nf;
  }

}
