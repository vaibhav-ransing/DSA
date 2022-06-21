import java.util.HashMap;

public class distinctPalSubseq {
    

    static void solution(String s){
        int n = s.length();
        int dp[][] = new int[n][n];

        int next[] = new int[n];
        int prev[] = new int[n];
        // abacda
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                prev[i] = map.get(ch);
            }else{
                prev[i] = -1;
            }
            map.put(ch, i);
        }
        map.clear();;
        for(int i=n-1; i>=0; i--){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                next[i] = map.get(ch);
            }else{
                next[i] = n;
            }
            map.put(ch, i);
        }

        for(int gap=0; gap<n; gap++){
            for(int i=0, j=gap; j<n; j++, i++){
                char c1 = s.charAt(i);
                char c2 = s.charAt(j);
                if(gap==0){
                    dp[i][j]=1;
                }else if(gap==1){
                    dp[i][j]= 2;
                }else{

                    int left = dp[i][j-1];
                    int right = dp[i+1][j];
                    int mid = dp[i+1][j-1];
                    if(c1!=c2){
                        dp[i][j]= left+right - mid;
                    }else{
                        int nxt = next[i];
                        int prv = prev[j];
                        if(nxt>prv){
                            dp[i][j]= 2*mid+2;
                        }else if(nxt==prv){
                            dp[i][j] = 2*mid +1;
                        }else{
                            dp[i][j] = 2*mid - dp[nxt+1][prv-1];
                        }
                    }
                }

            }
        }
        // System.out.println(dp[0][n-1]);
        for(int d[]: dp){
            for(int val: d){
                System.out.print(val+" ");
            }
            System.out.println();
        }

    }


    public static void main(String[] args) {
        solution("bccb");
    }
}
