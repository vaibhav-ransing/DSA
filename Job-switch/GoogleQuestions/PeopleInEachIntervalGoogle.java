package SweepLine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class PeopleInEachIntervalGoogle {
   

    public static void googleInterview(List<UserStartEnd> list) {
        List<int[]> listWithStartEndTime = new ArrayList<>(); // idx, time, 0->start, 1->end
        for (int i = 0; i < list.size(); i++) {
            UserStartEnd u = list.get(i);
            listWithStartEndTime.add(new int[] { i, u.start, 0 }); // idx, startTime, 0
            listWithStartEndTime.add(new int[] { i, u.end, 1 }); // idx, endTime, 1
        }
        Collections.sort(listWithStartEndTime, (a, b) -> a[1] - b[1]); // Sort by time
        HashSet<Integer> set = new HashSet<>(); // To track current users on call

        int prevTime = -1;
        for (int i = 0; i < listWithStartEndTime.size(); i++) {
            int[] currEvent = listWithStartEndTime.get(i); // idx, time, isStart
            int idx = currEvent[0];
            int time = currEvent[1];
            boolean isStart = currEvent[2] == 0;

            if (prevTime != -1 && prevTime != time) {
                System.out.print(prevTime + " - " + time + ": ");
                List<String> onCallUsers = new ArrayList<>();
                for (int key : set) {
                    onCallUsers.add(list.get(key).name);
                }
                System.out.println(String.join(", ", onCallUsers));
            }

            if (isStart) { // start
                set.add(idx);
            } else { // end
                set.remove(idx);
            }

            prevTime = time;
        }
    }

    public static void main(String[] args) {
        // Creating users
        UserStartEnd abby = new UserStartEnd("Abby", 1, 10);
        UserStartEnd ben = new UserStartEnd("Ben", 5, 7);
        UserStartEnd carla = new UserStartEnd("Carla", 6, 12);
        UserStartEnd david = new UserStartEnd("David", 15, 17);

        // Adding users to the list
        List<UserStartEnd> users = new ArrayList<>();
        users.add(abby);
        users.add(ben);
        users.add(carla);
        users.add(david);

        // Run the method to generate the rotation table
        googleInterview(users); 
    }

    static class UserStartEnd {
        String name;
        int start;
        int end;

        public UserStartEnd(String name, int start, int end) {
            this.name = name;
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "User{name='" + name + "', start=" + start + ", end=" + end + "}";
        }
    }
}
 
}
