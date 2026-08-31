package examples.annotation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RuntimeLabelsTest {
  @Test
  void RUNTIME保持のannotationはreflectionから取得できる() {
    var label = RuntimeLabels.BillingService.class.getAnnotation(RuntimeLabels.Label.class);

    assertEquals("billing", label.value());
  }
}
