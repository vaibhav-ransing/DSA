package First20;

public class FriendsPairing {

    // https://leetcode.com/discuss/general-discussion/1349122/friends-pairing-problem

    public static void friendsPairing(int n) {
        boolean[] used = new boolean[n];
        solution(0, n, used, "");
    }

    public static void solution(int idx, int n, boolean[] used, String asf) {

        if (idx == n) {
            System.out.println(asf);
            return;
        }

        if (used[idx]) {
            solution(idx + 1, n, used, asf);
        } else {
            used[idx] = true;
            solution(idx + 1, n, used, asf + (idx + 1) + "-");
            for (int j = idx + 1; j < n; j++) {
                if (!used[j]) {
                    used[j] = true;
                    solution(idx + 1, n, used, asf + (idx + 1) + (j + 1) + "-");
                    used[j] = false;
                }
            }
            used[idx] = false;
        }
    }

    public static int countFriendsPairings(int n) {

        if (n <= 2)
            return n;
        return countFriendsPairings(n - 1) + (n - 1) * countFriendsPairings(n - 2);
    }

    public static void main(String[] args) {
        friendsPairing(3);
    }
}