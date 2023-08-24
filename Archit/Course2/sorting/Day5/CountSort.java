package Day5;


public class CountSort {

    public static void countSortStable(int[] arr){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int[] ansArr = new int[arr.length];

        for(int val : arr){
            min = Math.min(min, val);
            max = Math.max(max, val);
        }

        int d = max-min+1;
        int[] prefixArr = new int[d];
        
        // Create the Frequency array
        for(int val : arr){
            prefixArr[val-min]++;
        }

        // Convert the frequency array to pre fix array
        for(int i=1; i<prefixArr.length; i++){
            prefixArr[i] += prefixArr[i-1];
        }

        // Iterate from the end of arr
        // get the prefixFreq value for that current index array
        // put the ansArr[prefixFreq - 1] = arr[i]
        // reduce the prefixFreqArray value by one for that idx
        for(int i=arr.length-1; i>=0; i--){
            int preFixFreq = prefixArr[arr[i] - min];
            ansArr[preFixFreq - 1] = arr[i];
            prefixArr[arr[i] - min]--;
        }
    }

    public static void countSort(int[] arr){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int val : arr){
            min = Math.min(min, val);
            max = Math.max(max, val);
        }
        int d = max-min+1;
        int[] freqArr = new int[d];
        
        for(int val : arr){
            freqArr[val-min]++;
        }

        int idx = 0;
        for(int i=0; i<freqArr.length; i++){
            int currFreq = freqArr[i];
            while(currFreq>0){
                arr[idx++] = min+i;
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = {3,8,4,8,1,3,2,1,2};
        countSortStable(arr);
    }
}
