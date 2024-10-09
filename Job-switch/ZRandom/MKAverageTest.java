package ZRandom;

import java.util.*;

public class MKAverageTest {

    class MKAverage {

        int m;
        int k;
        ArrayList<Integer> list;

        public MKAverage(int m, int k) {
            this.m = m;
            this.k = k;
            list = new ArrayList<>();
        }

        public void addElement(int num) {
            list.add(num);
        }

        public int calculateMKAverage() {
            if (list.size() < m)
                return -1;

            // Copy the last m elements into a new list
            List<Integer> sublist = list.subList(list.size() - m, list.size());

            // Sort the sublist to easily remove the smallest k and largest k elements
            List<Integer> sortedList = new ArrayList<>(sublist);
            Collections.sort(sortedList);

            // Remove the smallest k and largest k elements
            int sum = 0;
            for (int i = k; i < sortedList.size() - k; i++) {
                sum += sortedList.get(i);
            }

            // Calculate the average by dividing by (m - 2 * k)
            return sum / (m - 2 * k);
        }
    }

}
