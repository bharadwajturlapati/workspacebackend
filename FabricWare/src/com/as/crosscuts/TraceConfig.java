package com.as.crosscuts;

public class TraceConfig {
  private boolean isEnabled;
  private String defaultLocation;
  private String traceTo;

  public boolean getIsenabled() {
    return isEnabled;
  }

  public void setIsenabled(boolean isenabled) {
    this.isEnabled = isenabled;
  }

  public String getDefaultlocation() {
    return defaultLocation;
  }

  public void setDefaultlocation(String defaultlocation) {
    this.defaultLocation = defaultlocation;
  }

  public String getTraceTo() {
    return traceTo;
  }

  public void setTraceTo(String traceTo) {
    this.traceTo = traceTo;
  }
}
