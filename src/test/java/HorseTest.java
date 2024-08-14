import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.nio.charset.Charset;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HorseTest {

    public static Stream<String> SpaceCharactersForHorseNameString() {
        return Stream.of("", " ",  "\t", "\n");
    }

    @Test
    public void whenNullHorses() {
        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new Horse(null,1,2);
                }
        );
        assertEquals("Name cannot be null.", exception.getMessage());
    }
    @ParameterizedTest
    @MethodSource("SpaceCharactersForHorseNameString")
     void whenEmptyOrSpacesNameString() {
        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new Horse("",1,2);
                }
        );
        assertEquals("Name cannot be blank.", exception.getMessage());

    }
    @Test
    public void whenSpeedIsLessThanZero()
    {
        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new Horse("horse",-1,2);
                }
        );
        assertEquals("Speed cannot be negative.", exception.getMessage());
    }
    @Test
    public void whenDistanceIsLessThanZero()
    {
        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new Horse("horse",1,-2);
                }
        );
        assertEquals("Distance cannot be negative.", exception.getMessage());
    }
    @Test
    public void whenGetNameReturns()
    {
        Horse horse = new Horse("Simon",10);
        assertEquals("Simon",horse.getName());
    }
    @Test
    public void whenGetSpeedReturns()
    {
        Horse horse = new Horse("Simon",20);
        assertEquals(2,horse.getSpeed());
    }
    @Test
    public void whenGetDistanceReturns()
    {
        Horse horse = new Horse("Simon",30,50);
        assertEquals(50,horse.getDistance());
        Horse horseWithoutDistance = new Horse("Simon",30);
        assertEquals(0,horse.getDistance());
    }
    @Test
    public void checkRandomDouble()
    {
        try (MockedStatic<Horse> horseMockedStatic =  Mockito.mockStatic(Horse.class)) {
            Horse horse = new Horse("Pyoes", 20, 30);
            horse.move();
            horseMockedStatic.verify(() -> Horse.getRandomDouble(0.2, 0.9));

        }
    }
    @ParameterizedTest
    @ValueSource(doubles = {1, 2})
    void method_move_check_getRandomDouble_sum(double numbers) {
        try (MockedStatic<Horse> horseMockedStatic = Mockito.mockStatic(Horse.class)) {
            Horse horse = new Horse("Pyoes", 20, 30);
            horseMockedStatic.when(() -> Horse.getRandomDouble(0.2, 0.9)).thenReturn(numbers);
            double distance = horse.getDistance();
            horse.move();
            assertEquals(distance + horse.getSpeed() * numbers, horse.getDistance());
        }
    }
}


