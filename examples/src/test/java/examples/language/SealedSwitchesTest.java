package examples.language;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SealedSwitchesTest {
  @Test
  void sealed型の全許可サブタイプをswitchで分岐できる() {
    assertEquals("card:1234", SealedSwitches.describe(new SealedSwitches.Card("1234")));
    assertEquals("bank:tx-42", SealedSwitches.describe(new SealedSwitches.BankTransfer("tx-42")));
  }
}
