package QuestionsCSWMIK.DSU;

import java.util.*;
import java.util.stream.IntStream;

public class FindAllPeopleSecret {

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);
        List<Integer> ans = new ArrayList<>();
        TreeSet<Integer> set = new TreeSet<>();
        DSU ds = new DSU(n);

        // Union the first person with 0
        ds.union(0, firstPerson);

        int idx = 0;
        while (idx < meetings.length) {
            int currentTime = meetings[idx][2];
            List<int[]> currentMeetings = new ArrayList<>();

            // Gather all meetings at the same time
            while (idx < meetings.length && meetings[idx][2] == currentTime) {
                currentMeetings.add(meetings[idx]);
                idx++;
            }

            // Union all pairs that meet at the current time
            for (int[] meet : currentMeetings) {
                ds.union(meet[0], meet[1]);
            }

            // Check if they are connected to person 0
            for (int[] meet : currentMeetings) {
                if (ds.find(meet[0]) != ds.find(0)) {
                    ds.parent[meet[0]] = meet[0];
                }
                if (ds.find(meet[1]) != ds.find(0)) {
                    ds.parent[meet[1]] = meet[1];
                }
            }

            // Add the valid people to the set
            for (int[] meet : currentMeetings) {
                if (ds.find(meet[0]) == 0) {
                    set.add(meet[0]);
                }
                if (ds.find(meet[1]) == 0) {
                    set.add(meet[1]);
                }
            }
        }

        // Convert set to a sorted list
        ans.addAll(set);
        return ans;
    }

    static class DSU {
        int parent[];

        DSU(int n) {
            this.parent = new int[n];
            IntStream.range(0, n).forEach(i -> parent[i] = i);
        }

        int find(int u) {
            if (parent[u] == u)
                return u;
            return parent[u] = find(parent[u]);
        }

        void union(int u, int v) {
            int pu = find(u);
            int pv = find(v);

            if (pv == pu)
                return;
            parent[pv] = pu;
        }
    }

}