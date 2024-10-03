package ZRandom.Dp;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

import Leetcode.Rotated.searchInRotatedArr2;

public class RaceCar {

    public int racecar(int target) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] { 0, 1, 0 }); // position, speed, cost

        Set<String> visited = new HashSet<>();
        visited.add(0 + " " + 1); // Mark the initial state as visited

        while (queue.size() > 0) {
            int[] curr = queue.poll();
            int currPosition = curr[0];
            int speed = curr[1];
            int cost = curr[2];
            if (currPosition == target)
                return cost;
            int newPos = currPosition + speed;
            int newSpeed = speed * 2;
            String accelState = newPos + " " + newSpeed;

            // Accelerate
            if (!visited.contains(accelState) && Math.abs(newPos) <= 2 * target) {
                visited.add(accelState);
                queue.add(new int[] { newPos, newSpeed, cost + 1 });
            }

            int reverseSpeed = speed > 0 ? -1 : 1;
            String reverseState = currPosition + " " + reverseSpeed;

            if (!visited.contains(reverseState)) {
                queue.add(new int[] { currPosition, reverseSpeed, cost + 1 });
                visited.add(reverseState);
            }
        }
        return -1;
    }
}
