import com.example.Cat;
import com.example.Feline;
import com.example.Predator;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CatTest {
    @Test
    public void getFoodTest() throws Exception {
        Predator predatorMock = mock(Predator.class);
        when(predatorMock.eatMeat()).thenReturn(List.of("Мясо"));

        Cat cat = new Cat(predatorMock);
        List<String> food = cat.getFood();
        assertEquals(List.of("Мясо"), food);
    }
    @Test
    public void getSoundTest(){
        Predator predatorMock = mock(Predator.class);
        Cat cat = new Cat(predatorMock);
        assertEquals("Мяу", cat.getSound());
    }
}
