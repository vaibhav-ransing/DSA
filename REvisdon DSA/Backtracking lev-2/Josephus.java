public class Josephus {
    

    static int soln(int n, int k){
        if(n==1)
            return 0;
        int x = soln(n-1, k);
        int y = (x+k)%n;
        return y;
    }


    public static void main(String[] args) {
        
    }
}
