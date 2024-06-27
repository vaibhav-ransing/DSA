package Random;

public class UglyNumber1 {

    public boolean isUgly(int n) {
        int arr[] = { 2, 3, 5 };
        int idx = 2;
        while (n != 0 && idx >= 0) {
            System.out.println(n +" "+ (n % arr[idx] == 0));
            if (n % arr[idx] == 0) {
                n = n / arr[idx];
            } else {
                idx--;
            }
        }
        return n == 0;
    }
}
