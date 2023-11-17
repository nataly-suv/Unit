//Напишите тесты, покрывающие на 100% метод evenOddNumber,
// который проверяет, является ли переданное число четным или нечетным

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class CheckNumTest {

    private CheckNum checkNum;
    @BeforeEach
    void setUp() {

       checkNum = new CheckNum();
    }

   // проверка четного числа
    @Test
    void evenOddNumberTestEven(){
        assertThat(checkNum.evenOddNumber(10)).isTrue();
    }

    // проверка нечетного числа
    @Test
    void evenOddNumberTestUnEven(){
        assertThat(checkNum.evenOddNumber(11)).isFalse();
    }


}
