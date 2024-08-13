import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HippodromeTest {
@Test
public void whenNullHorses() {
    Throwable exception = assertThrows(
            IllegalArgumentException.class,
            () -> {
                new Hippodrome(null);
            }
    );
    assertEquals("Horses cannot be null.", exception.getMessage());
}
    @Test
public void whenEmptyOrSpacesString() {


    }

}
