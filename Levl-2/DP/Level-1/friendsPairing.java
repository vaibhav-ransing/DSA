public class friendsPairing {

    static void recSon(String s, String ans){
        if(s.length()==0){
            System.out.println(ans);
            return;
        }
        recSon(s.substring(1), ans+s.charAt(0)+"-");
        for(int i=1;i<s.length();i++){
            String left = s.substring(1, i);
            String right = s.substring(i+1,s.length());
            recSon(left+right, ans+s.charAt(0)+s.charAt(i)+"-");
        }
    }
    
    static void dpSoln(int n){  
        int dp[]= new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<dp.length;i++){
            dp[i] = dp[i-1] + (i-1)*dp[i-2];
        }
        // for(int i=0;i<dp.length;i++)
        //     System.out.print(dp[i]+" ");
        System.out.println(dp[dp.length-1]);
    }
    static void printEncodint(String str, int index, String ans){
        if(str.length()==0){
            for(int i=0; i<ans.length();i++){
                if(ans.charAt(i)=='`')
                    return;
            }
            System.out.println(ans);
            return;
        }
        printEncodint(str.substring(1), index, ans+((char) (Integer.parseInt(str.substring(0,1))+96) )); 
        if(str.length()>=2 && Integer.parseInt(str.substring(0,2))<27){
            printEncodint(str.substring(2), index, ans+((char) (Integer.parseInt(str.substring(0,2))+96) )); 
        }                                                                                           
    }

    public static void main(String[] args) {
        // recSon("abcd", "");
        dpSoln(5);
    }
}
