public class rangeAddition {
    
    public static int[] Range(int length, int[][] updates) {
        // write your code here. 
        int ans[] = new int[length];

        for(int[] curr: updates){
            int s= curr[0];
            int e = curr[1];
            int val = curr[2];
            for(int i=s; i<=e; i++){
                ans[i]+=val;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        
    }
}
