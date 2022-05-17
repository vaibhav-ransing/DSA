public class matrixChainMult {
    
    
    static void solution(int arr[]){
        // A  B  C  D  E
        // 10 20 30 40 50 60
        int dp[][]  = new int[arr.length][arr.length];
        for(int gap=0; gap<arr.length; gap++){
            for(int i=0, j=i+gap; j<arr.length; i++){
                dp[i][j] =1;
            }
        }
        for(int d[]: dp){
            for(int val: d){
                System.out.print(val+" ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        int arr[] = {10,20,30,40,50,60};
        solution(arr);
    }
}
