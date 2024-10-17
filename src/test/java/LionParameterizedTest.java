import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    private final String sex;
    private final boolean expectedHasMane;

    public LionParameterizedTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void testLionManeBasedOnSex() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = new Lion(sex, feline);
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }

    @Test
    public void testLionCreationWithInvalidSex() {
        Feline feline = Mockito.mock(Feline.class);
        String invalidSex = "Неизвестный пол";
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion(invalidSex, feline);
        });
        assertEquals("Используйте допустимые значения пола животного - самей или самка", exception.getMessage());
    }
}
