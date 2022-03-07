import java.util.HashSet;

public class ccPermutation {
    
    static void printCount(int arr[], int amt, int index, String ans, HashSet h){

        if(amt==0){
            // System.out.println(ans);
            h.add(ans);
            return;
        }
        if(amt<0 || index==arr.length)
            return;

        for(int i=index;i<arr.length;i++){
            printCount(arr, amt-arr[i], index, ans+arr[i]+"-",h);
            printCount(arr, amt, index+1, ans,h);
        }
    }

    static void dpPermuCount(int arr[], int amt){
        int dp[]= new int[amt+1];
        dp[0]=1;

        for(int i=1;i<dp.length;i++){
            for(int j=0;j<arr.length;j++){
                if(i-arr[j]>=0){
                    dp[i]+=dp[i-arr[j]];
                }
            }
        }
        // for(int i=0;i<dp.length;i++)
        //     System.out.print(dp[i]+" ");
        System.out.println(dp[dp.length-1]);
    }
    public static void main(String[] args) {
        int arr[]= {2,3,5,6};
        int amt= 10;
        int index=0;
        String ans="";
        HashSet h = new HashSet<String>();

        // printCount(arr, amt, index, ans,h);
        // System.out.println(h);
            
    
        dpPermuCount(arr, amt);
        // System.out.println();
        // dpCoinChange2(arr, amt);
        
    }
}
