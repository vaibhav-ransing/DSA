public class MinJumpsPlusMinus_I {

    public static int minJumps(int x) {
        int start = 0;
        int jump = 1;
        while (start < x) {
            start += jump;
            jump++;
        }
        if ((start - x) % 2 == 0)
            return jump - 1;
        else {
            start += jump;
            jump++;
            if((start - x)%2==0)
                return jump;
            else
                return jump+1;
        }
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }
}