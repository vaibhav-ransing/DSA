package CP.Bits;

public class bitCount {
    
    public int[] countBits(int n) {
        int [] arr = new int[n+1];
        for(int i=1; i<=n; i++){
            int cb = (n&(1<<i));
            if(cb==1){
                arr[i] = arr[i-1]+1;
            }
        }
        return arr;
    }
}
