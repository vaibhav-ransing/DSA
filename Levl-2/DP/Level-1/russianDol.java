import java.util.Scanner;

class russianDol{

    static void dpSoln(int len[], int wid[]){
        sort(len, wid);
        int n=wid.length;
        
        int dp[] = new int[n];
        dp[0]=1;
        for(int i=1;i<n;i++){
            for(int j=0; j<i;j++){
                if(wid[j]<wid[i])
                    dp[i] = Math.max(dp[i], dp[j]);
            }
            dp[i]+=1;
        }
        int ans = 0;
        for(int i=0;i<n;i++)
            ans = Math.max(ans, dp[i]);
        System.out.println(ans);
    }
    static void sort(int len[], int wid[]){
        for(int i=0;i<len.length;i++){
            for(int j=i+1;j<len.length;j++){
                if(len[i]>len[j]){
                    int temp = len[i];
                    len[i] = len[j];
                    len[j] = temp;

                    int temp2 = wid[i];
                    wid[i] = wid[j];
                    wid[j] = temp2;
                }else if(len[i]==len[j]){
                    if(wid[i]>wid[j]){
                        int temp = len[i];
                        len[i] = len[j];
                        len[j] = temp;

                        int temp2 = wid[i];
                        wid[i] = wid[j];
                        wid[j] = temp2;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        // int len[] = {4,7,1,7,9};
        // int wid[] = {2,5,1,2,3};
        // dpSoln(len, wid);
        // int len[] = {17,26,25,48,63,42,9,4,21,68,58};
        // int wid[] = {5,18,34,84,72,86,55,70,45,76,51};
        // dpSoln(len, wid);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int len[] = new int[n];
        int wid[] = new int[n];
        for(int i=0;i<n;i++){
            len[i] = sc.nextInt();
            wid[i] = sc.nextInt();
        }
        dpSoln(len, wid);
    }
}