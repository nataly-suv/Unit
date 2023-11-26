import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AverageValueTest {

    // проверка правильности расчета среднего значения
    @Test
    void checkAverageValue() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        AverageValue averageValue = new AverageValue(list);

        assertThat(averageValue.averageValue()).isEqualTo(3);
    }

    // проверка, что среднее значение первого списка больше
    @Test
    void firstAverageMore() {
        AverageValueСompare averageValueСompare = new AverageValueСompare();

        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

        AverageValue listOne = new AverageValue(list1);
        AverageValue listTwo = new AverageValue(list2);

        assertThat(averageValueСompare.comparisonAverageValue(listOne, listTwo)).isEqualTo("Первый список имеет большее среднее значение");
    }

    // проверка, что среднее значение второго списка больше
    @Test
    void secondAverageMore() {
        AverageValueСompare averageValueСompare = new AverageValueСompare();

        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        AverageValue listOne = new AverageValue(list1);
        AverageValue listTwo = new AverageValue(list2);

        assertThat(averageValueСompare.comparisonAverageValue(listOne, listTwo)).isEqualTo("Второй список имеет большее среднее значение");
    }

    // проверка, что средние значения равны
    @Test
    void equalAverageMore() {
        AverageValueСompare averageValueСompare = new AverageValueСompare();

        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        AverageValue listOne = new AverageValue(list1);
        AverageValue listTwo = new AverageValue(list2);

        assertThat(averageValueСompare.comparisonAverageValue(listOne, listTwo)).isEqualTo("Средние значения равны");
    }
}
