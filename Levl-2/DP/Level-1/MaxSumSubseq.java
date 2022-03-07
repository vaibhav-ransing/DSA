public class MaxSumSubseq {
    
    static int maxLIS(int arr[], int n, String ans){
        if(n==0){
           if(isInc(arr, ans))
                return sum(arr, ans);
            return 0;
        }
        if(n<0)
            return 0;

        return Math.max(maxLIS(arr, n-1, ans+(n-1)), maxLIS(arr, n-1, ans));
    }
    static boolean isInc(int arr[], String ans){
        for(int i=0;i<ans.length()-1;i++){
            int x = ans.charAt(i)-'0'; 
            int x1 = ans.charAt(i+1)-'0';
            if(arr[x]<arr[x1])
                return false;
        }
        return true;
    }

    static int sum(int arr[], String ans){
        int sum=0;
        for(int i=0;i<ans.length();i++){
            int x = ans.charAt(i)-'0'; 
            sum+=arr[x];
        }
        return sum;
    }

    static void incSum(int arr[]){
        int n = arr.length;
        int dp[] = new int[n];

        for(int i=0;i<arr.length;i++){
            dp[i] = arr[i];
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    dp[i] = Math.max(dp[i], arr[i]+dp[j]);
                }
            }
        }
        for(int i=0;i<dp.length;i++){
            System.out.println(dp[i]+" ");
        }
    }

    static void MSIS(int[] arr, int n){
		int msis[] = new int[n];
		for(int i=0; i<n; i++){
			msis[i]  = arr[i];
			for(int j=0; j<i; j++){
                if(arr[j] < arr[i])
				    msis[i] = Math.max(msis[i], arr[i] + msis[j]);
			}
		}
        for(int i=0;i<msis.length;i++){
            System.out.println(msis[i]+" ");
        }
		// int res = msis[0];
		// for(int i=0; i<n; i++)
		//     res = Math.max(res, msis[i]);
		// return res;
	}

    public static void main(String[] args) {
        int arr[] = {4,3,2,8,10,5,1};
        // System.out.println(maxLIS(arr, arr.length, ""));

        // int arr[] = {3,20,4,6,7,30};
        // MSIS(arr, arr.length);
        incSum(arr);
    }
}
