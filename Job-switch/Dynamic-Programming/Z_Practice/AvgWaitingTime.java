public class AvgWaitingTime {

    public double averageWaitingTime1(int[][] customers) {
        int ttp = 0;
        int ans = 0;
        for (int[] cc : customers) {
            int curtomerArival = cc[0];
            int timeTakenToFinishOrder = cc[1];

            ttp = Math.max(ttp, curtomerArival);

            int waitedBeforeOrderStarted = ttp - curtomerArival;

            ans += waitedBeforeOrderStarted + timeTakenToFinishOrder;

            ttp += timeTakenToFinishOrder;
        }

        return ans / (double) customers.length;
    }

    public double averageWaitingTime(int[][] customers) {
        double ttp = 0;  // total time passed
        double ans = 0;  // number of hours customers waited
        for (int[] cc : customers) {
            double curtomerArival = cc[0];
            double timeTakenToFinishOrder = cc[1];

            ttp = Math.max(ttp, curtomerArival) + timeTakenToFinishOrder;

            // customer total waiting since arival
            ans += ttp - curtomerArival;
        }
        return ans / (double) customers.length;
    }
}
