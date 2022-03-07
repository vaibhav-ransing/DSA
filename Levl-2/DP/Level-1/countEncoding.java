import java.util.Scanner;

public class countEncoding {

    static void printEncoding(String s, int index, int size, String str){
        if(index==size){
            if(s.length()==0)
                return;
            int val = Integer.parseInt(s);
            val+=97;
            System.out.println((char)val);
            return;
        }

        if(Integer.parseInt(s+str.charAt(index))<27)
            printEncoding(s+str.charAt(index), index+1, size, str);
        printEncoding(s, index+1, size, str);
    }
    // static int rec(String s, String ans, int n){
    //     if(s.length()==0 || ans.length()==n)
    //         return 1;

    //     int one = rec(s.substring(1), ans+s.charAt(0),n );
    //     int two=0;
    //     if(s.length()>=2 && Integer.parseInt(s.substring(0,2))<27)
    //         two=rec(s.substring(2), ans+s.charAt(0)+s.charAt(1) ,n);

    //     return one+two;
    // }
    // static int rec(String s, String ans, int n){
    //     if(s.length()==0 || ans.length()==n){
    //         System.out.println(ans);
    //         return 1;
    //     }
    //     if(s.charAt(0)==0)
    //         return 0;

    //     int one = rec(s.substring(1), ans+(char)(96+ Integer.parseInt(s.substring(0, 1))),n );
    //     int two=0;
    //     if(s.length()>=2 && Integer.parseInt(s.substring(0,2))<27)
    //         two=rec(s.substring(2), ans+(char)(96+ Integer.parseInt(s.substring(0, 2))) ,n);
    //     return one+two;
    // }

    static void pepRec(String s, String ans){
        if(s.length()==0){
            System.out.println(ans);
            return;
        }else if(s.length()==1){
            int charVal = (s.charAt(0) - '0')+96;
            System.out.println(ans+ (char)charVal);
            return;
        }else{
            int charVal1 = (s.charAt(0) - '0')+96;
            pepRec(s.substring(1), ans+ (char)charVal1);

            String twoIndex = s.substring(0,2);
            if(Integer.parseInt(twoIndex)<27){
                int charVal2 = Integer.parseInt(twoIndex) +96;
                pepRec(s.substring(2), ans + (char)charVal2);
            }
        }
    }

    static void dpSoln(String s){
        int dp[] = new int[s.length()];

        dp[0]=1;
        for(int i=1;i<dp.length;i++){
            int iVal = s.charAt(i)-'0';
            if(iVal==0){
                if(s.charAt(i-1)-'0'<=2){
                    if(s.charAt(i-1)-'0'==0){
                        System.out.println(0);
                        return;
                    }else{
                        dp[i] = dp[i-1];
                        continue;
                    }
                }else{
                    System.out.println(0);
                    return;
                }
            }
            String numStr = s.substring(i-1,i)+s.substring(i, i+1);
            int num = Integer.parseInt(numStr);
            // System.out.println(num);
            if(num<27 && num/10!=0)
                dp[i]=1+dp[i-1];
            else
                dp[i] = dp[i-1];
        }
        for(int i=0; i<dp.length;i++)
            System.out.print(dp[i]+" ");
        // System.out.println(dp[dp.length-1]);
    }


    public static void main(String[] args) {
        // String s = "2344492034";
        String s = "110022";
        // String s = "90";
        dpSoln(s);
        

    }
}
