package examples.optional;

import java.util.Optional;

public final class OptionalApiDesign {
  private OptionalApiDesign() {}

  public static String displayFromOptionalArgument(Optional<String> nickname) {
    return nickname.orElse("guest");
  }

  public static String displayFromNullableArgument(String nickname) {
    return Optional.ofNullable(nickname).orElse("guest");
  }

  public record Profile(Optional<String> nickname) {
    public String displayName() {
      return nickname.orElse("guest");
    }
  }
}
