import org.junit.Test;

import java.util.ArrayList;

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

        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new Hippodrome(new ArrayList<Horse>());
                }
        );
        assertEquals("Horses cannot be null.", exception.getMessage());
    }

}
