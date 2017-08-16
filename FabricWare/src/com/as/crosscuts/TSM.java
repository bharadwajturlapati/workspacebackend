package com.as.crosscuts;

public class TSM {
  private String datetime;
  private String whichComponentTsmIn;

  public TSM(String dateTime, String whichComponentin) {
    this.datetime = dateTime;
    this.whichComponentTsmIn = whichComponentin;
  }

  public String getWhichComponentTsmIn() {
    return whichComponentTsmIn;
  }

  public String getDatetime() {
    return datetime;
  }

}
