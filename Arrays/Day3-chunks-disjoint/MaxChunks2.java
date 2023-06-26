
public class MaxChunks2 {
    
    public int maxChunksToSorted(int[] arr) {
        int[] rmin = new int[arr.length];
        rmin[arr.length-1] = arr[arr.length-1];
        for(int i=arr.length-2; i>=0; i--){
            rmin[i] = Math.min(arr[i], rmin[i+1]);
        }   
        int count=0;
        for(int i=0; i<arr.length-1; i++){
            int cv = arr[i];
            int rminVal = rmin[i+1];
            if(rminVal >= cv)
                count++;
        }
        return count;
    }
}
