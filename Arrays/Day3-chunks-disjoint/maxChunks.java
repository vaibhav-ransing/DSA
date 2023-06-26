
public class maxChunks {

    public int maxChunksToSorted(int[] arr) {
        int count = 0;
        int max = -1;
        
        for(int i=0; i<arr.length; i++){
            max = Math.max(max, arr[i]);
            if(max==i)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        
    }
}
