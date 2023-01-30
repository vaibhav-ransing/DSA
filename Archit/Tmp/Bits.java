package Tmp;

public class Bits {
    
    public static String decimalToAnyBase(int val, int targetBase){
        return "";
    }
    public static void oddEven(){
        int n =5;
        int andValue = n&1;
        if(andValue==1){
            System.out.println("odd");
        }else{
            System.out.println("Even");
        }
    }
    public static void checkSetBit(int n){

        int count = 0;
        while(n!=0){
            if((n&1)==1){
                count++;
            }
            n = n>>1;
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        checkSetBit(5);
    }
}
