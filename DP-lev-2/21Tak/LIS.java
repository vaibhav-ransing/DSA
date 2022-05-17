import java.util.ArrayDeque;

public class LIS{
    
    static void LIS2(int arr[]){
        int dp[] = build_Dp(arr);
        int max=0;
        System.out.println();
        for(int val: dp){
            max = Math.max(max, val);
        }
        System.out.println(max);
        printPath(arr, dp, max);
    }

    static int[] build_Dp(int arr[]){
        int dp[] = new int[arr.length];
        dp[0]=1;
        for(int i=1; i<arr.length; i++){
            for(int j=0; j<i; j++){
                if(arr[j]<arr[i]){
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i]+=1;
        }
        return dp;
    }
    static class pair{
        int i;
        String asf;
        pair(int i, String asf){
            this.i=i;
            this.asf = asf;
        }
    }
    static void printPath(int arr[], int dp[], int max){
        ArrayDeque<pair> queue = new ArrayDeque<>();
        for(int i=0; i<dp.length; i++){
            if(dp[i]==max){
                queue.add(new pair(i, arr[i]+""));
            }
        }
        while(queue.size()>0){
            pair peek = queue.pop();
            int i=peek.i;
            if(dp[i]==1){
                System.out.println(peek.asf);
                continue;
            }
           for(int j=i-1; j>=0; j--){
                if(arr[j]<arr[i] && dp[j]==dp[i]-1){
                    queue.add(new pair(j, arr[j]+" -> "+peek.asf));
                }
            }
        }
    }
    


    static void LIS_MaxSum(int arr[]){
        int dp[] = new int[arr.length];
        dp[0]=arr[0];
        for(int i=1; i<dp.length; i++){
            for(int j=0; j<i; j++){
                if(arr[j]<arr[i]){
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i]+=arr[i];
        }
        int max=0;
        for(int val: dp){
            System.out.print(val+" ");
            max = Math.max(max, val);
        }
        System.out.println(max);
    }

    static void bitonic(int arr[]){
        int revArr[] = reverseArray(arr);

        int inc[] = build_Dp(arr);
        int dec[] = build_Dp(revArr);
        for(int val:inc)
            System.out.print(val+" ");
        System.out.println();
        int decRev[] = reverseArray(dec);
        for(int val:decRev)
            System.out.print(val+" ");
    }
    
    static int[] reverseArray(int arr[]){
        int revArr[] = new int[arr.length];
        int t=0;
        for(int i=arr.length-1; i>=0; i--){
            revArr[t++]=arr[i];
        }
        return revArr;
    }
    public static void main(String []args){
        int arr[] = {1,5,2,6,3,4,1};
        
        // LIS2(arr);
        // LIS_MaxSum(arr);
        bitonic(arr);
    }

}