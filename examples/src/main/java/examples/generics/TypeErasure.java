package examples.generics;

import java.util.ArrayList;
import java.util.List;

public final class TypeErasure {
  private TypeErasure() {}

  public static boolean listsWithDifferentTypeArgumentsShareRuntimeClass() {
    List<String> words = new ArrayList<>();
    List<Integer> numbers = new ArrayList<>();
    return words.getClass() == numbers.getClass();
  }
}
