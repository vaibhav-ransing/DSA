public class FriendsPairing {
    

    public static void solution(int i, int n, boolean[] used, String asf){
        if(i>n){
            System.out.println(asf);
            return;
        }
        if(used[i]){
            solution(i+1, n, used, asf);
        }else{
            used[i] = true;
            solution(i+1, n, used, asf+ "( "+i+") ");

            for(int j=i+1; j<=n; j++){
                used[j] = true;
                solution(i+1, n, used, asf+ "( "+i+j +") ");
                used[j] = false;
            }
            used[i] = false;
        }

    }

    public static void main(String[] args) {
        boolean[] used = new boolean[4];
        solution(1, 3, used, "");
    }
}
