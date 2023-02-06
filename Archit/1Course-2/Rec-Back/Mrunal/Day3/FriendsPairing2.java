public class FriendsPairing2 {

    public static void solution4(int n, int idx, boolean[] used, String ans){
        if(idx==n){
            System.out.println(ans);
            return;
        }
        if(used[idx]){
            solution4(n, idx+1, used, ans);
        }else{
            used[idx] = true;
            solution4(n, idx+1, used, ans+ "("+(idx+1)+")");
            for(int j=idx+1; j<n; j++){
                if(!used[j]){
                    used[j]=true;
                    solution4(n, idx+1, used, ans+ "("+(idx+1)+(j+1)+")");
                    used[j]=false;
                }
            }
            used[idx] = false;
        }
    }
    public static void friendsPair2(int n){
        boolean[] used = new boolean[n];
        solution4(n, 0, used, "");
    }

    public static void main(String[] args) {
        friendsPair2(3);
    }
}
