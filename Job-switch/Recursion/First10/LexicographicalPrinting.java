package First10;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalPrinting {

    public static List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 10; i++) { // starting of every number
            dfs(list, i, n);
        }
        System.out.println(list);
        return list;
    }

    public static void dfs(List<Integer> list, int i, int n) {
        if (i > n) {
            return;
        }
        list.add(i);
        for (int j = 0; j < 10; j++) { // start*10 +(0-9)  for each start digit.
            dfs(list, i * 10 + j, n);
        }
    }

    public static void main(String[] args) {
        lexicalOrder(100);
    }
}
