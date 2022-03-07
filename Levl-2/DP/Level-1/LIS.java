public class LIS {      
    
    static int maxLIS(int arr[], int n, String ans){
        if(n==0){
           System.out.println(ans);
           if(isInc(arr, ans))
                return ans.length();
            return 0;
        }
        if(n<0)
            return 0;

        return Math.max(maxLIS(arr, n-1, ans+(n-1)), maxLIS(arr, n-1, ans));
    }

    static boolean isInc(int arr[], String ans){
        // if(ans.length()>1){
        for(int i=0;i<ans.length()-1;i++){
            int x = ans.charAt(i)-'0'; 
            int x1 = ans.charAt(i+1)-'0';
            if(arr[x]<arr[x1])
                return false;
        }
    // }
        return true;
    }
        
    static void LisDP(int arr[]){
        int n = arr.length;
        int dp[] = new int[n];
        dp[0]=1;

        for(int i=1;i<dp.length;i++){
            int maxLis=0;
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i])
                    maxLis = Math.max(maxLis, dp[j]);
            }
            if(maxLis== 0)
                dp[i]=1;
            else
                dp[i]=1+maxLis;
        }
        for(int i=0;i<dp.length;i++){
            System.out.println(dp[i]+" ");
        }
    }

    static void lisNlogn(int arr[]){
        int n = arr.length;
        int tail[] = new int[n];
        tail[0] = arr[0];
        // {8,100,150,10,12,14,110};
        int index=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>tail[index]){
                tail[index+1] = arr[i];
                index++;
            }else{
                append(tail, arr[i], index);
            }
        }
        System.out.println(index+1);
        for(int x=0;x<tail.length;x++)
            System.out.print(tail[x]+" ");
    }
    static void append(int tail[], int val, int index){
        int i=0;
        int j = index;
        while(j>=i){
            int mid = (i+j)/2; 
            if(tail[mid]>val){
                j=mid-1;
            }else{
                i=mid+1;
            }
        }
        tail[i] = val;
        for(int x=0;x<tail.length;x++)
            System.out.print(tail[x]+" ");
        System.out.println();
    }

    public static void main(String[] args) {
        // int arr[] = {4,10,6,5,8,11,2,20};
        // int arr[] = {30,20,10};
        // System.out.println(maxLIS(arr, arr.length,""));

        // int arr[] = {3,4,2,8,10,5,1};
        // int arr[] = {4,2,3,8,10,5,1};
        // LisDP(arr);
        int arr[] = {8,100,150,10,12,14,110};
        // int arr[] = {8,2,3,1,4};
        lisNlogn(arr);

    }
}
          