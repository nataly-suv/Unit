import java.util.ArrayList;
import java.util.List;

public class AverageValueСompare {
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();


    public String comparisonAverageValue(AverageValue listOne, AverageValue listTwo) {

        if (listOne.averageValue() > listTwo.averageValue()) {
            return "Первый список имеет большее среднее значение";
        } else if (listOne.averageValue() < listTwo.averageValue()) {
            return "Второй список имеет большее среднее значение";
        }
        return "Средние значения равны";
    }
}
