import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CatTest {

    @Test
    public void testGetSoundReturnsMeow() {
        Feline feline = Mockito.mock(Feline.class);
        Cat cat = new Cat(feline);
        String sound = cat.getSound();
        assertEquals("Мяу", sound);
    }

    @Test
    public void testGetFoodCallsEatMeatMethod() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Cat cat = new Cat(feline);

        // Устанавливаем поведение мока
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы"));

        List<String> food = cat.getFood();
        assertEquals(List.of("Животные", "Птицы"), food);

        // Проверяем, что метод eatMeat был вызван
        Mockito.verify(feline).eatMeat();
    }

    // Добавляем тест для случая, когда eatMeat возвращает пустой список
    @Test
    public void testGetFoodReturnsEmptyList() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Cat cat = new Cat(feline);

        // Устанавливаем поведение мока
        Mockito.when(feline.eatMeat()).thenReturn(List.of());

        List<String> food = cat.getFood();
        assertEquals(List.of(), food); // Проверяем, что возвращается пустой список

        // Проверяем, что метод eatMeat был вызван
        Mockito.verify(feline).eatMeat();
    }
}
