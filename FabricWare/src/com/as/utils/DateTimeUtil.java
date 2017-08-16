package com.as.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateTimeUtil {
  private DateTimeUtil() {

  }

  public static String getDateTimeString() {
    Date dateObject = new Date();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
    return simpleDateFormat.format(dateObject);
  }
}
