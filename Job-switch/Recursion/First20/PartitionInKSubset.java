package First20;

import java.util.ArrayList;

public class PartitionInKSubset {

    public static void solution(int n, int k) {
        ArrayList<ArrayList<String>> kSubsetList = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            kSubsetList.add(new ArrayList<>());
        }
        dfs(n, k, k, kSubsetList);
    }

    public static void dfs(int n, int k, int idx, ArrayList<ArrayList<String>> kSubsetList) {

        if (k < 0 || (k != 0 && idx == n)) {
            return;
        }
        if (k == 0 && idx == n) {
            System.out.println(kSubsetList);
            return;
        }
        for (int i = 0; i < kSubsetList.size(); i++) {
            ArrayList<String> temp = kSubsetList.get(i);
            temp.add((idx + 1) + "");
            dfs(n, temp.size() == 1 ? k - 1 : k, idx + 1, kSubsetList);
            temp.remove(temp.size() - 1);
        }
    }

    public static void dfsPep(int n, int k, int idx, ArrayList<ArrayList<String>> kSubsetList) {

        if (k < 0 || (k != 0 && idx == n)) {
            return;
        }
        if (k == 0 && idx == n) {
            System.out.println(kSubsetList);
            return;
        }
        for (int i = 0; i < kSubsetList.size(); i++) {
            ArrayList<String> temp = kSubsetList.get(i);
            if (temp.size() > 0) {
                temp.add(idx + "");
                dfsPep(n, k, idx + 1, kSubsetList);
                temp.remove(temp.size() - 1);
            } else {
                temp.add(idx + "");
                dfsPep(n, k - 1, idx + 1, kSubsetList);
                temp.remove(temp.size() - 1);
                break;
            }
        }
    }

    public static void helper2(int n, int k, boolean[] used, int idx, String asf) {
        if (k == 0 && idx == n) {
            System.out.println(asf);
            return;
        }
        if ((k == 0 && idx != n) || (idx == n && k != 0)) {
            System.out.println(k + " " + idx + "  --  " + asf);
            return;
        }

        if (used[idx]) {
            helper2(n, k, used, idx + 1, asf);
        } else {
            used[idx] = true;
            helper2(n, k - 1, used, idx + 1, asf + idx + "-");
            for (int j = idx + 1; j < n; j++) {
                if (!used[j]) {
                    used[j] = true;
                    helper2(n, k, used, idx + 1, asf + j);
                    used[j] = false;
                }
            }
            used[idx] = false;
        }
    }

    public static void main(String[] args) {
        solution(3, 2);
    }
}
