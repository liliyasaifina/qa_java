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
    boolean expectedHasMane;

    public LionManeTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters(name = "Пол животного: {0} {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Самец", true},
                {"Самка", false}
        });
    }

    @Test
    public void lionManeTest() throws Exception {
        Predator predatorMock = mock(Predator.class);
        {
            Lion lion = new Lion(sex, predatorMock);
            assertEquals(expectedHasMane, lion.doesHaveMane());
        }
    }
}
