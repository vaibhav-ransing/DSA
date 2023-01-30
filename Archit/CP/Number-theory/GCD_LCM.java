
public class GCD_LCM {
    
    public static int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b, a%b);
    }

    static int[] lcmAndGcd(int a, int b){
        int hcf = gcd(a, b);
        int lcm = (a*b)/hcf;
        return new int[]{lcm, hcf};
    }

    public static void main(String[] args) {
        
    }

}
