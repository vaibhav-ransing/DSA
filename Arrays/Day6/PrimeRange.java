package Arrays.Day6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PrimeRange {
    public static boolean isPrime(int n) {
        for (int div = 2; div * div <= n; div++) {
            if(n%div==0)
                return false;
        }
        return true;
    }

    public static List<Integer> primeRangeList(int n){
        boolean arr[] = new boolean[n+1];
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.fill(arr,true);

        for(int i=2; i*i<arr.length; i++){
            if(arr[i] && isPrime(i)){
                list.add(i);  // this will also work
                int curr = i+i;
                while(curr <= n){
                    arr[curr] = false;
                    curr+=i;
                }
            }
        }
        // // this will also work
        // for(int i=2; i<arr.length; i++){
        //     if(arr[i]){
        //         list.add(i);
        //     }
        // }
        System.out.println(list);
        return null;
    }

    public static void main(String[] args) {
        primeRangeList(15);
    }
}
