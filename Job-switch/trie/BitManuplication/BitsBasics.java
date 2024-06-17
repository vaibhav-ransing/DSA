package BitManuplication;

public class BitsBasics {

    public static void main(String[] args) {

        System.out.println(122 >> 1); // divide by 2

        System.out.println(123 & 1); // is last bit is 1 means it is odd so its & will be 1

        // given a number tell if it's xth bit is 1 or not
        int a = 12345;
        int x = 3;
        if (((a >> x) & 1) == 1) {
            System.out.println("x-th bit is 1");
        } else {
            System.out.println("x-th bit is 0");
        }

        // Turn xth bit
        a = a | (1 << x);

    }
}