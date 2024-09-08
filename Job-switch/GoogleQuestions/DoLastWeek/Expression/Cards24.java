package DoLastWeek.Expression;

import java.util.ArrayList;
import java.util.List;

public class Cards24 {

    public boolean judgePoint24(int[] cards) {

    }

    public boolean rec(List<Integer> list) {
        if (list.size() == 1) {
            if (list.get(0) == 24)
                return true;
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i != j) {
                    int ci = list.get(i);
                    int cj = list.get(j);
                    List<Integer> nextList = new ArrayList<>();
                    for (int i = 0; i < list.size(); i++) {

                    }
                }
            }
        }
    }

}
