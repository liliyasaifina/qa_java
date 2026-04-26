import com.example.Lion;
import com.example.Predator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

@RunWith(Parameterized.class)
public class LionManeTest {
    String sex;
    Boolean expectedHasMane;

    public LionManeTest(String sex, Boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters(name = "Пол животного: {0} {1} {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Самец", true},
                {"Самка", false},
                {"Неизвестно", null}
        });
    }

    @Test
    public void lionManeTest() throws Exception {
        Predator predatorMock = mock(Predator.class);
        if (expectedHasMane != null) {
            Lion lion = new Lion(sex, predatorMock);
            assertEquals(expectedHasMane, lion.doesHaveMane());
        } else {
            Exception exception = assertThrows(Exception.class, () -> {
                new Lion(sex, predatorMock);
            });
            assertTrue(exception.getMessage().contains("Используйте допустимые значения пола животного - самец или самка"));
                   }
    }
}
