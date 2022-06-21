public class kadensAlgosubstring {
    


    static void solution(int arr[]){
        int left=0;
        int max=Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++){

            int curr = arr[i];
            if(left<0){
                left = curr;
            }else{
                left+=curr;
            }
            max = Math.max(max, left);
        }
        System.out.println(max);
    }

    public static int kConcatenationMaxSum(int arr[], int k){
        
        if(k==1){
            return (int) kadens(arr);
        }else{
            return (int) helper(arr, k);
        }  
    }
    public static long helper(int arr[], int k){
        long left=0;
        long max=Long.MIN_VALUE;
        long arrSum = 0;
        for(int val: arr){
            arrSum+=val;
        }
        long mid = arrSum<0?0:(k-2)*arrSum;
        k=2;
        System.out.println(mid+" "+k);
        while(k>0){
            for(int i=0; i<arr.length; i++){

                int curr = arr[i];
                if(left<0){
                    left = curr;
                }else{
                    left+=curr;
                }
                max = Math.max(max, left);
            }
            k--;  
            System.err.println("left "+" "+left);
        }
        return max+mid;
    }

    public static long kadens(int arr[]){
        long left=0;
        long max=Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){

            int curr = arr[i];
            if(left<0){
                left = curr;
            }else{
                left+=curr;
            }
            max = Math.max(max, left);
        }
        return max;
    }



    // Maximum Sum Subarray with at least Size K | ////////////
    static void ksubarray(int arr[], int k){
        int dp[] = new int[arr.length];
        int left = Integer.MIN_VALUE, max = Integer.MIN_VALUE;
        int ff = 0;
        
        for(int i=0; i<k; i++){
            int curr= arr[i];
            ff+=curr;
            if(left<0){
                left=curr;
            }else{
                left+=curr;
            }
            dp[i] = left;
        }
        max = dp[k-1];
        int l=0, r=k;
        while(r<arr.length){
            ff-=arr[l];
            ff+=arr[r];
            left = dp[l];
            dp[r] = left>0?ff+left:ff;
            max = Math.max(max, dp[r]);
            // int arr[] = {3,7,4,5,2};
            System.out.println(left+" "+ff+" "+ dp[r]);
            r++;
            l++;
        }
        System.out.println("max"+" "+max);
        System.out.println();
        for(int val: dp){
            System.out.print(val+" ");
        }
    }

    public static void main(String[] args) {
        // int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
        // solution(arr);

        // int arr[] = {1,2};
        // System.out.println(kConcatenationMaxSum(arr, 3));
        
        int arr[] = {3,7,4,5};
        ksubarray(arr, 2);
    }
}
