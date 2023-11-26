import java.util.ArrayList;
import java.util.List;

public class AverageValue {
    List<Integer> list = new ArrayList<>();
    public AverageValue(List<Integer> list) {
        this.list = list;
    }

    public double averageValue() {
        int average = 0;
        int sum = 0;
        for (Integer elem : list) {
            sum = sum + elem;
        }
        average = sum / list.size();
        return average;
    }
}
