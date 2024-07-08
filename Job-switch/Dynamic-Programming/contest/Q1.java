import java.util.HashSet;

public class Q1 {

    public int numberOfAlternatingGroups(int[] colors) {
        int count = 0;
        int n = colors.length;
        for (int i = 1; i <= n; i++) {
            if (colors[i - 1] != colors[i] && colors[i] != colors[(i + 1) % n])
                count++;
        }
        return count;
    }

    public int numberOfAlternatingGroups2(int[] colors) {
        int count = 0;
        int n = colors.length;
        for (int i = 1; i <= n; i++) {
            if (colors[(i - 1) % n] != colors[i % n] && colors[i % n] != colors[(i + 1) % n]) {
                count++;
            }
        }
        return count;
    }

    // [1,1,0,1,0], k = 3
    // 1,0,1,0,0 k = 10
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int count = 0;
        int n = colors.length;
        int i = 0, j = 1;
        while (j < n + k) {
            if (colors[(j - 1) % n] != colors[j % n] || i == j)
                j++;
            else
                i++;

            if (j - i == k - 1) {
                i++;
                count++;
            }
        }
        return count;
    }
}
