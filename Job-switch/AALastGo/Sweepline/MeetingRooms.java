package AALastGo.Sweepline;

import java.util.TreeMap;

public class MeetingRooms {

    public boolean meetingRoomClash(int[][] meets) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] meet : meets) {
            map.put(meet[0], map.getOrDefault(meet[0], 0) + 1);
            map.put(meet[1], map.getOrDefault(meet[1], 0) - 1);
        }
        int count = 0;
        for (int key : map.keySet()) {
            count += map.get(key);
            if (count > 1)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(2, 5);
        map.put(4, 11);
        map.put(6, 15);
        map.put(8, 12);

        int justGreater = map.ceilingKey(1);
        System.out.println(justGreater);

        if (map.floorKey(1) != null) {
            int smallerJust = map.floorKey(1);
            System.out.println(smallerJust);
        } else {
            System.out.println("No smaller than 1");
        }
    }
}
