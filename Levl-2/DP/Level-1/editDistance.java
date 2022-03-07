public class editDistance { 

    static int minEdit(String s1, String s2, int n1, int n2, int count){

        if(n1==0){
            return count;
        }
        if(n2==0){
            return Integer.MAX_VALUE;
        }
            
        if(s1.charAt(n1-1)==s2.charAt(n2-1)){
            return minEdit(s1, s2, n1-1, n2-1, count);
        }else{
            int del = minEdit(s1, s2, n1-1, n2, count+1);
            int replace = minEdit(s1.substring(0,n1-1)+s2.charAt(n2-1), s2, n1-1, n2-1, count+1);
            int add = minEdit(s1+s2.charAt(n2-1), s2, n1-1, n2-1, count+1);
            return Math.min(Math.min(del, replace), add);   
        }
    }

    static int ed(String s1, String s2, int m, int n){
        if(m==0)
            return n;
        if(n==0)
            return m; 

        if(s1.charAt(m-1)==s2.charAt(n-1))
            return ed(s1, s2, m-1, n-1);
        else{
            int add = 1+ed(s1, s2, m, n-1);
            int del = 1+ed(s1, s2, m-1, n);
            int rep = 1+ed(s1, s2, m-1, n-1);

            return    
                Math.min(Math.min(del, rep), add);  
        }
    }

    static void edDP(String s1, String s2){
        int n = s2.length();
        int m = s1.length();
        int dp[][] = new int[n+1][m+1];

        for(int i=0;i<dp.length;i++){
            dp[i][0]=i;
        }
        for(int i=0;i<dp[0].length;i++){
            dp[0][i]=i;
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(s1.charAt(j-1)==s2.charAt(i-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    int add =1+ dp[i-1][j-1];
                    int del =1+ dp[i][j-1];
                    int rep =1+ dp[i-1][j-1];
                    dp[i][j] =  Math.min(Math.min(add, del), rep);
                }
            }
        }
        System.out.println(dp[dp.length-1][dp[0].length-1]);
        display(dp);
    }
    static void display(int arr[][]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }


    
    public static void main(String[] args) {
        String s1 = "SATURDAY";  // s1 into s2
        String s2 = "SUNDAY";  // s1 into s2
        int n1 = s1.length();
        int n2 = s2.length();
        // System.out.println(minEdit(s1, s2, n1, n2, 0));
        // System.out.println(ed(s1, s2, s1.length(), s2.length()));

        // SATURDAY SUNDAY  8 , 6

        edDP(s1, s2);

    }
}
