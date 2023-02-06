package CP.Modulo;

public class LargeFactorial {
    public long[] factorial(long a[], int n) {
        int factorial[] = new int[100006];
        factorial[0] = factorial[1] = 1;
        for(int i=2; i<factorial.length; i++){
            factorial[i] = (factorial[i-1]*i)%100007;
        }

        long[] ans = new long[n];
        for(int i=0; i<=n; i++){
            ans[i] = factorial[(int) a[i]];
        }
        return ans;
    }

    public static void main(String[] args) {
        
    }
}
