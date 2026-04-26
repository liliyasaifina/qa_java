import com.example.Lion;
import com.example.Predator;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LionTest {
    Predator predatorMock;
    @Before
    public void setPredator(){
        predatorMock = mock(Predator.class);
    }

    @Test
    public void lionGetKittensTest() throws Exception {

        int expectedKittensCount = 5;
        when(predatorMock.getKittens()).thenReturn(expectedKittensCount);

        Lion lion = new Lion("Самец", predatorMock);
        int actualKittensCount = lion.getKittens();
        assertEquals(expectedKittensCount, actualKittensCount);
    }

    @Test
   public void lionGetFoodTest() throws Exception {

        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(predatorMock.getFood("Хищник")).thenReturn(expectedFood);

        Lion lion = new Lion("Самец", predatorMock);
        List<String> actualFood = lion.getFood();
        assertEquals(expectedFood, actualFood);
    }

    @Test
    public void lionErrorSex(){
        try {
            new Lion("Неизвестно", predatorMock);
        } catch (Exception exception) {
            assertTrue(exception.getMessage().contains("Используйте допустимые значения пола животного - самец или самка"));
        }
    }
    }

