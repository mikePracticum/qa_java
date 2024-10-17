import com.example.Feline;
import com.example.Animal;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FelineTest {

    @Test
    public void testEatMeatReturnsPredatorFood() throws Exception {
        Feline feline = new Feline();
        List<String> food = feline.eatMeat();
        assertTrue(food.contains("Животные"));
        assertTrue(food.contains("Птицы"));
        assertTrue(food.contains("Рыба"));
    }

    @Test
    public void testGetFamilyReturnsFelineFamily() {
        Feline feline = new Feline();
        String family = feline.getFamily();
        assertEquals("Кошачьи", family);
    }

    @Test
    public void testGetKittensReturnsOneKitten() {
        Feline feline = new Feline();
        int kittens = feline.getKittens();
        assertEquals(1, kittens);
    }

    @Test
    public void testGetKittensWithArgument() {
        Feline feline = new Feline();
        int kittens = feline.getKittens(3);
        assertEquals(3, kittens);
    }

    // Добавим тест для проверки поведения getFood в Animal
    @Test
    public void testGetFoodWithHerbivoreKind() throws Exception {
        Feline feline = new Feline();
        List<String> food = feline.getFood("Травоядное");
        assertTrue(food.contains("Трава"));
        assertTrue(food.contains("Различные растения"));
    }

    @Test
    public void testGetFoodWithUnknownKind() {
        Feline feline = new Feline();
        Exception exception = assertThrows(Exception.class, () -> {
            feline.getFood("Неизвестный");
        });
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
    }
}
