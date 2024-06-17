import java.util.HashMap;

public class PairsFormingCompleteDays {
    public long countCompleteDayPairs(int[] hours) {
        int[] arr = new int[25];
        int count = 0;
        for (int i = 0; i < hours.length; i++) {
            hours[i] %= 24;
        }

        for (int hr : hours) {
            int rem = 24 - hr;
            count += arr[rem];
            arr[hr]++;
        }
        return count;
    }

    public long countCompleteDayPairsHn(int[] hours) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < hours.length; i++) {
            int curr = hours[i] % 24;
            int rem = 24 - curr;
            System.out.println(curr +" "+ rem +" "+map.getOrDefault(rem, 0));

            count += map.getOrDefault(rem, 0);

            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }
        return count;
    }

}
