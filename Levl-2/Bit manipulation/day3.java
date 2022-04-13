import java.util.Collections;

public class day3 {
  
    static void minFlipsAtoB(int a, int b){
        int xor = (a ^ b);
        System.out.println(Integer.toBinaryString(xor));
        int count=0;
        while(xor!=0){
            count++;
            xor-= (xor & -xor);
        }
        System.out.println(count);
    }
    
    static void soln(int n){
        // C-00 G-01 A-10 T-11
        // 00011011
        StringBuilder ans = new StringBuilder();
        while(n!=0){
            int temp = (n&3);
            n = n>>2;
            if(temp==0){
                ans.insert(0, 'C');
            }else if(temp==1){
                ans.insert(0, 'G');
            }else if(temp==2){
                ans.insert(0, 'A');
            }else{
                ans.insert(0, 'T');
            }
        }

        System.out.println(ans);
    }

    public static void powerOfFour(int n){
        if((n &(n-1))!=0){
            System.out.println(false);
            return;
        }
        int count=0;
        while(n!=1){
            count++;
            n=n>>1;
        }
        System.out.println((count&1)==0);
    }

    public static void threeTimes(int arr[]){
        
    }

    public static void main(String[] args) {
        // soln(27);
        powerOfFour(2);
    }
}
