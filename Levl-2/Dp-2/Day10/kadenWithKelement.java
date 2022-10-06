package Day10;

// https://practice.geeksforgeeks.org/problems/largest-sum-subarray-of-size-at-least-k3121/1
public class kadenWithKelement {
    
    public static long maxSumWithK(long arr[], long n, long k){
        long[] kdp = new long[(int)n];
        kdp[0] = arr[0];
        for(int i=1; i<kdp.length; i++){
            if(kdp[i-1]>0){
                kdp[i] = kdp[i-1]+arr[i];
            }else{
                kdp[i] = arr[i];
            }
        }
        long win[] = new long[(int)(n-k+1)];               
        for(int i=0; i<k; i++){
            win[0]+=arr[i];
        }
        for(int i=1; i<win.length; i++){
            win[i] = win[i-1]-arr[i-1]+arr[(int)(i+k-1)];
        }

        long ans = win[0];
        for(int i=0; i<win.length-1; i++){
            ans = Math.max(ans, Math.max(kdp[i]+win[i+1], win[i+1]));
        }

        return ans;
    }



    public static void main(String[] args) {
        long arr[] = {-4, -2, 1, -3};
        maxSumWithK(arr, arr.length, 2);
    }
}
