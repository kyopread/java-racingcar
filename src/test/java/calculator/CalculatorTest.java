package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class CalculatorTest {

    @DisplayName("사칙연산 테스트(덧셈)")
    @Test
    void plusTest() {
        String formula = "1 + 3";

        Calculator calculator = new Calculator();
        int result = calculator.calculate(formula);

        assertThat(result).isEqualTo(4);
    }

    @DisplayName("사칙연산 테스트(뺄셈)")
    @Test
    void minusTest() {
        String formula = "3 - 2";

        Calculator calculator = new Calculator();
        int result = calculator.calculate(formula);

        assertThat(result).isEqualTo(1);
    }

    @DisplayName("사칙연산 테스트(곱셈)")
    @Test
    void multipleTest() {
        String formula = "3 * 2";

        Calculator calculator = new Calculator();
        int result = calculator.calculate(formula);

        assertThat(result).isEqualTo(6);
    }

    @DisplayName("사칙연산 테스트(나눗셈)")
    @Test
    void divideTest() {
        String formula = "5 / 2";

        Calculator calculator = new Calculator();
        int result = calculator.calculate(formula);

        assertThat(result).isEqualTo(2);
    }

    @DisplayName("사칙연산 테스트(나눗셈) - 0으로 나누는 경우")
    @Test
    void divideByZeroTest() {
        String formula = "5 / 0";

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Calculator calculator = new Calculator();
                    int result = calculator.calculate(formula);
                });
    }

    @DisplayName("여러수식 동작 테스트")
    @Test
    void multiNumbersTest() {
        String formula = "2 + 6 * 4 / 2";

        Calculator calculator = new Calculator();
        int result = calculator.calculate(formula);

        assertThat(result).isEqualTo(16);
    }

    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"", " "})
    void blankOrNullTest(String value) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Calculator calculator = new Calculator();
                    int result = calculator.calculate(value);
                });
    }
}