import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.verify;

public class LionTest {

    @Test
    public void testGetKittensCallsFelineGetKittens() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = new Lion("Самец", feline);

        // Устанавливаем поведение мока
        Mockito.when(feline.getKittens()).thenReturn(3);

        int kittens = lion.getKittens();
        assertEquals(3, kittens);

        // Проверяем, что метод getKittens был вызван
        verify(feline).getKittens();
    }

    @Test
    public void testGetFoodReturnsPredatorFood() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = new Lion("Самец", feline);

        // Устанавливаем поведение мока
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы"));

        List<String> food = lion.getFood();
        assertEquals(List.of("Животные", "Птицы"), food);

        // Проверяем, что метод getFood был вызван с аргументом "Хищник"
        verify(feline).getFood("Хищник");
    }

    @Test
    public void testLionCreationWithMaleSex() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = new Lion("Самец", feline);
        assertEquals(true, lion.doesHaveMane());
    }

    @Test
    public void testLionCreationWithFemaleSex() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = new Lion("Самка", feline);
        assertEquals(false, lion.doesHaveMane());
    }

    @Test
    public void testLionCreationWithInvalidSex() {
        Feline feline = Mockito.mock(Feline.class);
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion("Неизвестный пол", feline);
        });
        assertEquals("Используйте допустимые значения пола животного - самей или самка", exception.getMessage());
    }
}
