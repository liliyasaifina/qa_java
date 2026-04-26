import com.example.Lion;
import com.example.Predator;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LionTest {

    @Test
    public void lionGetKittensTest() throws Exception {

        int expectedKittensCount = 5;
        Predator predatorMock = mock(Predator.class);
        when(predatorMock.getKittens()).thenReturn(expectedKittensCount);

        Lion lion = new Lion("Самец", predatorMock);
        int actualKittensCount = lion.getKittens();
        assertEquals(expectedKittensCount, actualKittensCount);
    }

    @Test
   public void lionGetFoodTest() throws Exception {
        Predator predatorMock = mock(Predator.class);
        List<String> expectedFood = List.of("Мясо", "Рыба");
        when(predatorMock.getFood("Хищник")).thenReturn(expectedFood);

        Lion lion = new Lion("Самец", predatorMock);
        List<String> actualFood = lion.getFood();
        assertEquals(expectedFood, actualFood);
    }
}
