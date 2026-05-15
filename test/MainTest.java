import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import main_runner.Main;
import org.junit.jupiter.api.Test;

class MainTest {

  @Test
  void mainRunsWithoutError() {
    assertDoesNotThrow(() -> Main.main(new String[]{}));
  }
}
