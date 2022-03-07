public class encoding {
    
    static void soln(String s){
        int dp[] = new int[s.length()+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<dp.length;i++){
            char ch = s.charAt(i-1);
            if(ch=='0'){
                // 12063
                int together = Integer.parseInt(s.substring(i-2, i));
                if(together<=25){
                System.out.println(together+" "+i);
                    if(i-2>=0){
                        dp[i]+=dp[i-2];
                    }
                }
            }else{
                dp[i] = dp[i-1];
                int together = Integer.parseInt(s.substring(i-2, i));
                if(together<=26){
                    if(i-2>=0){
                        dp[i]+=dp[i-2];
                    }
                }
                
            }
        }
        System.out.println(dp[dp.length-1]);
    }


    public static void main(String[] args) {
        String s = "1263";
        soln(s);
        // int val = s.charAt(0)-'0';
        // System.out.println( (int)('z'-'a') );
        // '0' is 48
    }
}
