package Arrays.Day1;

public class RangeSum {
    // https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/arrays-and-strings/range_addition/ojquestion
    
    public static int[] getModifiedArray(int n, int[][] queries) {
        int arr[] = new int[n];
        for(int[] query : queries){
            int start = query[0];
            int end = query[1] + 1;
            int inc = query[2];

            arr[start] += inc;
            if(end < n)
                arr[end] -= inc;
        }
        for(int i=1; i<arr.length; i++){
            arr[i]+=arr[i-1];
        }
        return arr;
    }

    public static void main(String[] args) {
        int[][] queries = {
            {1,  3,  2},
            {2,  4,  3},
            {0,  2, -2}
        };
        getModifiedArray(5, queries);
    }
}
