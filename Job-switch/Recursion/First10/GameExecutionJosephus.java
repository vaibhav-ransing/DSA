package First10;

public class GameExecutionJosephus {

    public static int solution(int n, int k) {
        if(n==1){
            return 0;
        }
        int x = solution(n-1, k);
        return (x + k)%n;
    }

    // public static int helper(int n, int k, int cn, int soilderLeft) {
    //     if (soilderLeft == 1) {
    //         System.out.println(cn);
    //         return cn;
    //     }
    //     int nextCN = ((cn + (k - 1)) > n) ? (n- (cn + (k - 1))) : cn + k;
    //     System.out.println((n-soilderLeft) +"   curr_idx_n= "+cn +"   next_idx= "+nextCN);
    //     return helper(n, k, nextCN, soilderLeft - 1);
    // }

    public static void main(String[] args) {
        solution(8, 3);
    }
}