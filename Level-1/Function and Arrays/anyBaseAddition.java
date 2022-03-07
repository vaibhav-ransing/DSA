import java.util.Scanner;

public class anyBaseAddition {
    
    public static int getValueIndecimal(int n, int b){

        double ans=0;
        int count=0;
        while(n>0){
            int digit = n%10;
           
            ans = ans + digit*(Math.pow(b, count));
            n= n/10;
            count++;
        }

        int value = (int)ans;
        return value;
   }

   public static int decimalToanyBase(int num, int tobase){

    double retNum=0;
    int count=0;
    while(num!=0){
        int nextNum = num/tobase;
        int remainder = num-(nextNum*tobase);
        retNum = retNum + remainder*Math.pow(10, count);
        count++;
        num= nextNum;
    }
    
    int value = (int)retNum;
    return value;
   }

    public static void main(String[] args) {

        // Scanner sc = new Scanner(System.in);
        // int b = sc.nextInt();
        // int n1 = sc.nextInt();
        // int n2 = sc.nextInt();
        int b=8;
        int n1= 777;
        int n2 = 1;

        int val1 = getValueIndecimal(n1, b);
        int val2 = getValueIndecimal(n2, b);

        int addedAns = val1+val2;
        System.out.println(decimalToanyBase(addedAns, b));
    }
}
