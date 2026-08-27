package examples.datetime;

import java.time.ZonedDateTime;

public final class DaylightSavingArithmetic {
  private DaylightSavingArithmetic() {}

  public static ZonedDateTime addCalendarDay(ZonedDateTime time) {
    return time.plusDays(1);
  }

  public static ZonedDateTime addTwentyFourHours(ZonedDateTime time) {
    return time.plusHours(24);
  }
}
