package examples.datetime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.junit.jupiter.api.Test;

class DaylightSavingArithmeticTest {
  @Test
  void 夏時間開始日のplusDaysとplusHoursは同じ時刻にならない() {
    ZonedDateTime beforeSpringForward =
        ZonedDateTime.of(2024, 3, 9, 12, 0, 0, 0, ZoneId.of("America/New_York"));

    assertEquals(
        "2024-03-10T12:00-04:00[America/New_York]",
        DaylightSavingArithmetic.addCalendarDay(beforeSpringForward).toString());
    assertEquals(
        "2024-03-10T13:00-04:00[America/New_York]",
        DaylightSavingArithmetic.addTwentyFourHours(beforeSpringForward).toString());
    assertNotEquals(
        DaylightSavingArithmetic.addCalendarDay(beforeSpringForward),
        DaylightSavingArithmetic.addTwentyFourHours(beforeSpringForward));
  }
}
