import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import praktikum.Bun;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BunTest {

    // Метод для генерации тестовых данных (в классе Bun нет валидации на некорректные значения)
    static Stream<Arguments> correctBunParameters() {
        return Stream.of(
        Arguments.of("Краторная булка",1255),
        Arguments.of("Флюоресцентная булка",988),
        Arguments.of("Флюоресцентная булка",0.00f),
        Arguments.of("",0.00f),
        Arguments.of(null,0.00f)
    );
    }

    @ParameterizedTest
    @DisplayName("bun возвращает корректные значения")
    @MethodSource("correctBunParameters")
    void bunShouldReturnsCorrectValues(String expectedName, float expectedPrice) {
        Bun bun = new Bun(expectedName,expectedPrice);

        assertEquals(expectedName, bun.getName(), "Тип булочки не совпадает");
        assertEquals(expectedPrice, bun.getPrice(), "Цена булочки не совпадает");
    }

}
