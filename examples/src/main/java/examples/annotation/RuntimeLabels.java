package examples.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public final class RuntimeLabels {
  private RuntimeLabels() {}

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  public @interface Label {
    String value();
  }

  @Label("billing")
  public static final class BillingService {}
}
