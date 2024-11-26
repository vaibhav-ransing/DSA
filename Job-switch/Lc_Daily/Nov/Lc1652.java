package Lc_Daily.Nov;

import java.util.Arrays;

public class Lc1652 {

    public int[] decrypt(int[] arr, int k) {
        int n = arr.length;
        int extras = (k < 0 ? -k : k) / n;
        int sum = Arrays.stream(arr).sum();
        
    }
}
