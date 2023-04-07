
public class WineBuyingSelling {
    

    static long wineSelling(int Arr[],int N){
        long ans = 0l;

        int si = getIndex(Arr, 0, true);
        int bi = getIndex(Arr, 0, false);

        while(true){

            while(si<N && Arr[si]>=0) si++;
            while(bi<N && Arr[bi]<=0) bi++;
            if(bi>=N || si>=N) break;

            int sellValue = -Arr[si];
            int buyValue = Arr[bi];
            int dist = Math.abs(si-bi);

            ans += dist*Math.min(sellValue, buyValue);
            Arr[si] += Math.abs(Math.min(sellValue, buyValue));
            Arr[bi] -= Math.abs(Math.min(sellValue, buyValue));
        }
        System.out.println(ans);
        return ans;
    }
    public static int getIndex(int arr[], int idx, boolean sell){
        
        if(sell){
            for(int i=idx; i<arr.length; i++){
                if(arr[i] < 0) return i;
            }
        }else{
            for(int i=idx; i<arr.length; i++){
                if(arr[i] > 0) return i;
            }
        }
        return arr.length;
    }

    public static void main(String[] args) {
        int arr[] = {-5,-1,6};
        wineSelling(arr, arr.length);
    }
}
