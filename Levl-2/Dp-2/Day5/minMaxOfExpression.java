package Day5;

import java.util.ArrayList;

public class minMaxOfExpression {
    
    static void solution(String s){
        // 1+2*3+4*5
        ArrayList<Character> operator = new ArrayList<>();
        ArrayList<Integer> num = new ArrayList<>();
        for(char ch: s.toCharArray()){
            if(ch=='*' || ch=='+'){
                operator.add(ch);
            }else{
                num.add(ch-'0');
            }
        }
        int n = num.size();
        int dp[][] = new int[n][n];
        for(int gap=0; gap<n; gap++){
            for(int i=0, j=gap; j<n; j++, i++){
                if(gap==0){
                    dp[i][j] = num.get(i);
                }else if(gap==1){
                    char op = operator.get(j-1);
                    dp[i][j] = op=='*'?num.get(i)*num.get(j):num.get(i)+num.get(j);
                }else{
                    for(int k=i; k<j; k++){
                        char op = operator.get(k);
                        int left = dp[i][k];
                        int down = dp[k+1][j];
                        int val = op=='*'?left*down:left+down;
                        if(gap==2)
                            System.out.println(" i="+i+" j="+j+" k="+k+" " +" "+left+" " +down+" "+val);
                        dp[i][j] = Math.max(val, dp[i][j]);
                    }
                }
            }
        }
        System.out.println();
        for(int d[]: dp){
            for(int val: d){
                System.out.print(val+" ");
            }
            System.out.println();
        }

    }


    public static void main(String[] args) {
        solution("1+2*3+4*5");
    }
}
