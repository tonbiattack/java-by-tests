package examples.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;

public final class DateParts {
  private DateParts() {}

  public static LocalDate dateOf(LocalDateTime dateTime) {
    return dateTime.toLocalDate();
  }

  public static LocalDateTime startOfDay(LocalDate date) {
    return date.atStartOfDay();
  }
}
