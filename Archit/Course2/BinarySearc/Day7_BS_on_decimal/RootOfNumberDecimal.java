package Course2.BinarySearc.Day7_BS_on_decimal;

public class RootOfNumberDecimal {
    
    public static double squareRoot(long n, int d) {
        // Write your code here.
        double left = 0.0, right = n*1.0;
        // 1e-1 = 10^-d

        while(right - left >= Math.pow(10, -d) ){
            double mid = (left+right)/2;
            if(mid*mid <= n){
                left = mid;
            }else{
                right = mid;
            }
        }
        return right;
    }

}
