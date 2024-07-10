package PickNotPick;

import java.util.Arrays;
import java.util.HashMap;

public class PaintingWall {

    HashMap<String, Integer> map = new HashMap<>();

    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        return rec(0, cost, time, 0);
    }

    public int rec(int idx, int[] cost, int[] time, int currTime) {
        if (idx == cost.length)
            return 0;

        int painterDo = Integer.MAX_VALUE;
        painterDo = Math.min(painterDo, cost[idx] + rec(idx + 1, cost, time, currTime + time[idx]));

        int frePainter = Integer.MAX_VALUE;
        if (currTime > 0) {
            frePainter = Math.min(frePainter, rec(idx + 1, cost, time, currTime - 1));
        }

        return Math.min(painterDo, frePainter);
    }

}
