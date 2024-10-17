import com.example.Animal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class AnimalParameterizedTest {

    private final String animalKind;
    private final List<String> expectedFood;

    public AnimalParameterizedTest(String animalKind, List<String> expectedFood) {
        this.animalKind = animalKind;
        this.expectedFood = expectedFood;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")}
        });
    }

    @Test
    public void testGetFoodReturnsCorrectFood() throws Exception {
        Animal animal = new Animal();
        List<String> food = animal.getFood(animalKind);
        assertEquals(expectedFood, food);
    }

    @Test(expected = Exception.class)
    public void testGetFoodThrowsExceptionForInvalidAnimalType() throws Exception {
        Animal animal = new Animal();
        animal.getFood("Некорректный тип"); // должно выбросить исключение
    }
}
