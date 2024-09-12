package DoLastWeek.Expression;

import java.util.ArrayList;
import java.util.List;

public class Cards24 {

    public boolean judgePoint24(int[] cards) {
        List<Integer> list = new ArrayList<>();  // make it double
        for (int val : cards) {
            list.add(val);
        }
        return rec(list);
    }

    public boolean rec(List<Integer> list) {
        if (list.size() == 1) {
            if (list.get(0) == 24)
                return true;
        }
        // TC: O(n^3) + O(n^2 * 6^n)
        boolean ans = false;
        for (int i = 0; i < list.size(); i++) { // n
            for (int j = 0; j < list.size(); j++) { // n
                if (i != j) {
                    int ci = list.get(i);
                    int cj = list.get(j);

                    List<Integer> nextList = new ArrayList<>();
                    for (int k = 0; k < list.size(); k++) { // n
                        if (k != i && k != j) {
                            nextList.add(list.get(k));
                        }
                    }
                    int ns = nextList.size() == 0 ? 1 : nextList.size();

                    // 6 rec calls so : 6^n
                    nextList.add(ns - 1, ci + cj);
                    ans |= rec(nextList);
                    nextList.remove(ns - 1);

                    nextList.add(ns - 1, ci - cj);
                    ans |= rec(nextList);
                    nextList.remove(ns - 1);

                    nextList.add(ns - 1, -ci + cj);
                    ans |= rec(nextList);
                    nextList.remove(ns - 1);

                    nextList.add(ns - 1, ci * cj);
                    ans |= rec(nextList);
                    nextList.remove(ns - 1);

                    if (cj != 0) {
                        nextList.add(ns - 1, ci / cj);
                        ans |= rec(nextList);
                        nextList.remove(ns - 1);
                    }
                    if (ci != 0) {
                        nextList.add(ns - 1, cj / ci);
                        ans |= rec(nextList);
                        nextList.remove(ns - 1);
                    }
                }
            }
        }
        return ans;
    }

    public class Soln {

        public boolean judgePoint24(int[] cards) {
            List<Double> list = new ArrayList<>();
            for (int val : cards) {
                list.add((double) val); // Convert to double for floating-point operations
            }
            return rec(list);
        }

        public boolean rec(List<Double> list) {
            if (list.size() == 1) {
                // Use epsilon for floating-point comparison
                if (Math.abs(list.get(0) - 24) < 1e-6)
                    return true;
            }
            boolean ans = false;
            for (int i = 0; i < list.size(); i++) { // n
                for (int j = 0; j < list.size(); j++) { // n
                    if (i != j) {
                        double ci = list.get(i);
                        double cj = list.get(j);

                        List<Double> nextList = new ArrayList<>();
                        for (int k = 0; k < list.size(); k++) { // n
                            if (k != i && k != j) {
                                nextList.add(list.get(k));
                            }
                        }
                        int ns = nextList.size() == 0 ? 1 : nextList.size();

                        // 6 rec calls so : 6^n
                        nextList.add(ns - 1, ci + cj);
                        ans |= rec(nextList);
                        nextList.remove(ns - 1);

                        nextList.add(ns - 1, ci - cj);
                        ans |= rec(nextList);
                        nextList.remove(ns - 1);

                        nextList.add(ns - 1, cj - ci);
                        ans |= rec(nextList);
                        nextList.remove(ns - 1);

                        nextList.add(ns - 1, ci * cj);
                        ans |= rec(nextList);
                        nextList.remove(ns - 1);

                        if (Math.abs(cj) > 1e-6) { // Avoid division by zero
                            nextList.add(ns - 1, ci / cj);
                            ans |= rec(nextList);
                            nextList.remove(ns - 1);
                        }
                        if (Math.abs(ci) > 1e-6) { // Avoid division by zero
                            nextList.add(ns - 1, cj / ci);
                            ans |= rec(nextList);
                            nextList.remove(ns - 1);
                        }
                    }
                }
            }
            return ans;
        }

    }

}
