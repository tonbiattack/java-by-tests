package examples.generics;

import java.util.List;

public final class NumberTotals {
    private NumberTotals() { }

    public static double sum(List<? extends Number> values) {
        return values.stream().mapToDouble(Number::doubleValue).sum();
    }
}
