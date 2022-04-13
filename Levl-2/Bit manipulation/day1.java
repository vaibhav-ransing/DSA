public class day1 {
    
    static void rightMostSetBit(int n){
        int rsb = (n & -n);
    }
    static void kernighansAlgo(int n){
        // count all 1's in binary of a no.
        int count=0;
        while(n!=0){
            int rsb = (n & -n);
            count++;
            n-=rsb;
        }
        System.out.println(count);
    }

    static void josephus(int n){
        // alternate no. dies in circle find survivour
        int x=0;
        while(Math.pow(2, x)<=n){
            x++;
        }
        int l = n - (int)Math.pow(2, x-1);
        System.out.println(2*l+1);
    }


    public static void main(String[] args) {
        // kernighansAlgo(57);
        josephus(7);
    }
}
