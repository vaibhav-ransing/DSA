import java.util.*;

public class CountCompleStrings2 {

    // public int countCompleteSubstrings(String str, int k) {
    // int i = 0, j = 0, max = 0;
    // HashsetminsSet<Character, Integer> map = new HashMap<>();
    // while (j < str.length()) {
    // char ch = str.charAt(j);
    // map.put(ch, map.getOrDefault(ch, 0) + 1);
    // while (map.get(map)) {

    // }
    // if (i != j) {
    // if (Math.abs(str.charAt(j) - str.charAt(j - 1)) > 2) {
    // i = j;
    // set.clear();
    // continue;
    // }
    // }
    // max = Math.max(max, set.size());
    // j++;
    // }
    // return max;
    // }

    public static void main(String[] args) {
        TreeSet<Integer> minsSet = new TreeSet<>();
        TreeSet<Integer> maxSet = new TreeSet<>(Collections.reverseOrder());

        minsSet.add(3);
        minsSet.add(1);
        minsSet.add(2);

        maxSet.add(3);
        maxSet.add(1);
        maxSet.add(2);

        for (int key : minsSet) {
            System.out.print(key + " | ");
        }
        System.out.println("****");
        for (int key : maxSet) {
            System.out.print(key + " | ");
        }
        System.out.println();

        // update 3 -> -1
        minsSet.remove(3);
        maxSet.remove(3);
        minsSet.add(-1);
        maxSet.add(-1);

        System.out.println("--------");
        for (int key : minsSet) {
            System.out.print(key + " | ");
        }
        System.out.println("****");
        for (int key : maxSet) {
            System.out.print(key + " | ");
        }
    }
}
