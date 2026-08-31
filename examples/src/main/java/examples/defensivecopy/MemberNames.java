package examples.defensivecopy;

import java.util.List;

public final class MemberNames {
  private final List<String> names;

  public MemberNames(List<String> names) {
    this.names = List.copyOf(names);
  }

  public List<String> values() {
    return names;
  }
}
