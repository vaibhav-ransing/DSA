
public class FibonacciNo {
    

    public static int soln(int n){
        if(n==1 || n==2){
            return 1;
        }
        if(n==0)
            return 0;
        return soln(n-1) + soln(n-2);
    }

    public static void main(String[] args) {
        System.out.println(soln(3));
    }
    
}

