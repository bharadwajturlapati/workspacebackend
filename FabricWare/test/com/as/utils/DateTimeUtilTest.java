package com.as.utils;

import org.junit.Test;
import static org.fest.assertions.api.Assertions.assertThat;

public class DateTimeUtilTest {
  
  @Test
  public void testDateGenerated() {
    String dateTime = DateTimeUtil.getDateTimeString();
    assertThat(dateTime).isNotNull();
    assertThat(dateTime.length()).isGreaterThan(10);
    assertThat(dateTime.length()).isLessThan(70);
  }

}
