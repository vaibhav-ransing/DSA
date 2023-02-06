
public class FriendsPairing {

    public static void solution(int n, int idx, String ans, boolean prevPaired, boolean[] used) {
        if (idx >= n) {
            System.out.println(ans);
            return;
        }
        if (used[idx] == false) {
            for (int i = idx; i <= n; i++) {
                used[i] = true;
                for (int j = i + 1; j <= n; j++) {
                    if (used[j] == false) {
                        used[j] = true;
                        solution(n, idx + 1, ans.length() == 0 ? ans + "" + j : ans + "-" + j, false, used);
                        if (!prevPaired) {
                            solution(n, idx + 1, ans + j, true, used);
                        }
                        used[j] = false;
                    }
                }
                used[i] = false;
            }
        } else {
            solution(n, idx + 1, ans, prevPaired, used);
        }
    }

    public static void sol2(int n, int idx, String ans, boolean prevPaired, boolean[] used) {
        if(idx>n){
            System.out.println(ans);
            return;
        }
        System.out.println(ans);
        for (int i = idx + 1; i <= n; i++) {
            sol2(n, idx + 1, ans.length() == 0 ? ans + idx : ans + "-" + idx, false, used);
            if(!prevPaired && ans.length()!=0){
                sol2(n, idx+1, ans+idx+"-", true, used);
            }
        }
    }

    public static void sol3(int n, int idx, String ans, boolean prevPaired, boolean[] used) {
        if(idx>=n+1){
            System.out.println(ans);
            return;
        }
            if(used[idx]){
                sol3(n, idx+1, ans, prevPaired, used);
            }else{
                used[idx] = true;
                sol3(n, idx + 1, ans.length() == 0 ? ans + idx : ans + "-" + idx, false, used);
                for(int i=idx+1; i<=n+1; i++){
                    used[i-1] = true;
                    if(!prevPaired && ans.length()!=0){
                        sol3(n, 1, ans+(i-1)+"-", true, used);
                    }
                    used[i-1] = false;
                }
                used[idx] = false;
            }
    }

    public static void friendsPair(int n) {
        boolean[] used = new boolean[n + 1];
        sol3(n, 1, "", false, used);
    }

    public static void main(String[] args) {
        friendsPair(3);
    }
}
