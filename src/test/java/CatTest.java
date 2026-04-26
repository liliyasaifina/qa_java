import com.example.Cat;

import com.example.Predator;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CatTest {
    Predator predatorMock;
    @Before
    public void setPredator(){
        predatorMock = mock(Predator.class);
    }
    @Test
    public void getFoodTest() throws Exception {

        when(predatorMock.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        Cat cat = new Cat(predatorMock);
        List<String> food = cat.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }
    @Test
    public void getSoundTest(){
        Cat cat = new Cat(predatorMock);
        assertEquals("Мяу", cat.getSound());
    }
}
