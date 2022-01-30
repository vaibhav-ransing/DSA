import java.util.Scanner;

public class powerLog {
   
    public static int power(int x, int n){
        if(n==0)
            return 1;
        
        return x*power(x, n-1);
    }

    public static void main(String[] args) {
        System.out.println(power(2, 5));
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(power(x, n));
    }
}
