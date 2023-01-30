package CP.Bits;

public class Base7 {
    

    public String convertToBase7(int num) {
        long ans = 0, power = 1;

        while(num!=0){
            int rem = num%7;
            ans += rem* Math.pow(10, power);
            power++;
        }
        return String.valueOf(ans);

    }


    public static void main(String[] args) {
        
    }
}
