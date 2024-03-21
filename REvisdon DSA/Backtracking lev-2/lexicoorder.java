import java.util.ArrayList;
import java.util.List;

public class lexicoorder {

    public static List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            dfs(list, i, n);
        }
        System.out.println(list);
        return list;
    }

    public static void dfs(List<Integer> list, int i, int n) {
        if (i > n) {
            return;
        }
        System.out.println(i+" "+n);
        list.add(i);
        for (int j = 0; j < 10; j++) {
            dfs(list, i * 10 + j, n);
        }
    }

    public static void main(String[] args) {
        lexicalOrder(13);
    }
}
