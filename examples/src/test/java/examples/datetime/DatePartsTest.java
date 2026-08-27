package examples.datetime;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

class DatePartsTest {
  @Test
  void LocalDateTimeから取り出したLocalDateには時刻が含まれない() {
    assertEquals(LocalDate.of(2026, 8, 27), DateParts.dateOf(LocalDateTime.of(2026, 8, 27, 9, 30)));
  }

  @Test
  void LocalDateから作るLocalDateTimeはその日の開始時刻になる() {
    assertEquals(
        LocalDateTime.of(2026, 8, 27, 0, 0), DateParts.startOfDay(LocalDate.of(2026, 8, 27)));
  }
}
