package examples.equality;

import java.util.Objects;

public final class UserId {
  private final String value;

  public UserId(String value) {
    this.value = value;
  }

  @Override
  public boolean equals(Object other) {
    return other instanceof UserId userId && value.equals(userId.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
