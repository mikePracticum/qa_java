import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class FelineParameterizedTest {

    private final int kittensCount;
    private final int expectedKittens;

    public FelineParameterizedTest(int kittensCount, int expectedKittens) {
        this.kittensCount = kittensCount;
        this.expectedKittens = expectedKittens;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 1},
                {2, 2},
                {5, 5},
                {0, 0} // добавляем случай, когда котят нет
        });
    }

    @Test
    public void testGetKittens() {
        Feline feline = new Feline();
        assertEquals(expectedKittens, feline.getKittens(kittensCount));
    }
}
