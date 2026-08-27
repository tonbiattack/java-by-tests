package examples.language;

public final class SealedSwitches {
  private SealedSwitches() {}

  public static String describe(Payment payment) {
    return switch (payment) {
      case Card card -> "card:" + card.lastFour();
      case BankTransfer transfer -> "bank:" + transfer.reference();
    };
  }

  public sealed interface Payment permits Card, BankTransfer {}

  public record Card(String lastFour) implements Payment {}

  public record BankTransfer(String reference) implements Payment {}
}
