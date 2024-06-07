import java.util.HashSet;

class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[] rmin = new int[arr.length];
        rmin[arr.length-1] = arr[arr.length-1];
        for(int i=arr.length-2; i>=0; i--){
            rmin[i] = Math.min(arr[i], rmin[i+1]);
        }   
        // HashSet<Integer> set = new HashSet<>();
        // for(int va : rmin){
        //     set.add(va);
        // }
        // return set.size();
        int count=1;
        int max = -1;

        for(int i=0; i<arr.length-1; i++){
            max = Math.max(max, arr[i]);
            int rminVal = rmin[i+1];
            if(rminVal >= max)
                count++;
        }
        return count;
    }
}