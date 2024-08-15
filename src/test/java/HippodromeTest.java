import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class HippodromeTest {
    @Mock
    List<Horse> mockHorsesList;
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
@Test
     public void getHorsesTest()
     {
         List<Horse> horseList = new ArrayList<>();
         for (int i = 0; i < 30; i++) {
             horseList.add(new Horse("Name"+i, i));

         }
        Hippodrome hippodrome = new Hippodrome(horseList);
         assertArrayEquals(horseList.toArray(), hippodrome.getHorses().toArray(new Horse[0]));
     }
     @Test
    public void moveTest() {
         for (int i = 0; i < 50; i++) {
             mockHorsesList.add(new Horse("name" + i, i));
         }
         Hippodrome hippodrome = new Hippodrome(mockHorsesList);
         hippodrome.move();
         for (Horse horse : mockHorsesList) {
             Mockito.verify(horse).move();
         }
     }
    @Test
   public void getWinner() {
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            horses.add(new Horse("Name", 1, i));
        }
     Hippodrome hippodrome = new Hippodrome(horses);
        assertEquals(49, hippodrome.getWinner().getDistance());
    }
}
