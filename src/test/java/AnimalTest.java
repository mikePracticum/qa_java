import com.example.Animal;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AnimalTest {

    @Test
    public void testGetFoodReturnsHerbivoreFood() throws Exception {
        Animal animal = new Animal();
        List<String> food = animal.getFood("Травоядное");
        assertTrue(food.contains("Трава"));
        assertTrue(food.contains("Различные растения"));
    }

    @Test
    public void testGetFoodReturnsPredatorFood() throws Exception {
        Animal animal = new Animal();
        List<String> food = animal.getFood("Хищник");
        assertTrue(food.contains("Животные"));
        assertTrue(food.contains("Птицы"));
        assertTrue(food.contains("Рыба"));
    }

    @Test(expected = Exception.class)
    public void testGetFoodThrowsExceptionForInvalidAnimalType() throws Exception {
        Animal animal = new Animal();
        animal.getFood("Некорректный тип"); // должно выбросить исключение
    }

    @Test
    public void testGetFamilyReturnsCorrectFamily() {
        Animal animal = new Animal();
        String family = animal.getFamily();
        assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", family);
    }
}

