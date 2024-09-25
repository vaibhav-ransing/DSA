package SweepLine.Easy;

public class MaxPopulationYear {

    public int maximumPopulation(int[][] logs) {
        int[] timeline = new int[101];
        int start = 101;
        int stop = 0;
        for (int[] log : logs) {
            timeline[log[0] - 1950]++;
            timeline[log[1] - 1950]--;
            start = Math.min(start, log[0] - 1950);
            stop = Math.max(stop, log[1] - 1950);
        }

        int pop = 1;
        int year = start + 1950;
        for (int i = start + 1; i <= stop; i++) {
            timeline[i] += timeline[i - 1];
            if (timeline[i] > pop) {
                pop = timeline[i];
                year = i + 1950;
            }
        }
        return year;
    }
}
