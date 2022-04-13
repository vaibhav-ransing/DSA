public class day2 {
    
    public static void AllRepeatingExceptTwo(int arr[]){
        // 23 27 23 17 17 37

        int num = 0;
        for(int i=0;i<arr.length;i++){
            // System.out.println(arr[i]);
            num = num^arr[i];
        }
        int rb = (num & -num);
        int num1=0;
        int num2=0;
        for(int i=0;i<arr.length;i++){
            if((rb & arr[i])==0){
                num1 = (num1 ^ arr[i]);
            }else{
                num2 = (num2 ^ arr[i]);
            }
        }
        System.out.println(num1);
        System.out.println(num2);
    }

    public static void ARETwo(int arr[]){
        int v = 0;
        for(int val: arr){
            v = v^val;
        }
        int rb = (v&-v);
        System.out.println(Integer.toBinaryString(rb));
        int num1=0, num2=0;
        for(int val: arr){
            if((val & rb) ==0){
                num1 = (num1^val);
            }else{
                num2 = (num2^val);
            }
        }
        System.out.println(num1);
        System.out.println(num2);
    }

    public static void findDublicateAndMissing(int arr[]){
        int num=0;
        
        for(int i=1;i<=arr.length;i++){
            int ci = arr[i-1];
            num = num^ci^i;
        }
        // System.out.println(num);
        int rsb = (num & -num);
        int n1=0, n2=0;
        for(int i=0;i<arr.length;i++){
            if((rsb & arr[i])==0){
                n1 = n1^arr[i];
            }else{
                n2 = n2^arr[i];
            }
        }
        for(int i=1;i<=arr.length;i++){
            if((rsb & i)==0){
                n1^=i;
            }else
                n2^=i;
        }
        System.out.println(n1);
        System.out.println(n2);
    }

    public static void powerOfTwo(int n){
        System.out.println((n&-n)==n);
    }
    public static void powerOfFour(int n){
        if((n&-n)!=n){
            System.out.println(false);
            return;
        }
        int count=0;
        while((n&1)!=1){
            n=n>>>2;
            count++;
        }  
        System.out.println(count/2==0?false:true); 
    }
    

    

    public static void main(String[] args) {
        // int arr[] = {23,23,27,37,17,17};
        // ARETwo(arr);
        int arr[] = {1,2,3,2,5,6,7};
        findDublicateAndMissing(arr);
    }
}
