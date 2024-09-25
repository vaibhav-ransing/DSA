package SweepLine.Easy;

import java.util.Arrays;

public class MeetingsRooms {

    public boolean canAttendMeetings(int[][] arr) {
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        int prevEnd = -1;
        for (int[] meet : arr) {
            int currStart = meet[0];
            int currEnd = meet[1];
            if (currStart < prevEnd)
                return false;
            prevEnd = currEnd;
        }
        return true;
    }
}
