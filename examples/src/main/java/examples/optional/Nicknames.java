package examples.optional;

import java.util.Optional;

public final class Nicknames {
  private Nicknames() {}

  public static String displayName(Optional<String> nickname) {
    return nickname.orElse("anonymous");
  }
}
