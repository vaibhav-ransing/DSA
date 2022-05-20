public class burstBaloon {
    
    static void solution(int arr[]){
        // 2 3 7 5
        boolean[] visited = new boolean[arr.length];
        recursive(arr, visited, 0, 0);
        System.out.println(sum);
    }
    static int sum=0;
    static void recursive(int arr[], boolean visited[], int ans, int used){
        if(used==arr.length){
            sum = Math.max(sum, ans);
            return;
        }

        for(int i=0; i<arr.length; i++){
            if(visited[i]==false){
                visited[i] =true;
                int temp = arr[i];
                int l=i-1;
                int r = i+1;

                while(l>=0 && visited[l]!=false ){
                    l--;
                }
                if(l>=0)
                    temp*=arr[l];
                
                while(r<arr.length && visited[r]!=false){
                    r++;
                }
                if(r<arr.length)
                    temp*=arr[r];
                
                recursive(arr, visited, ans+temp, used+1);
                visited[i]=false;
            }
            
        }
    }


    static void dpSolution(int arr[]){
        int dp[][] = new int[arr.length][arr.length];
        for(int gap=0; gap<dp.length; gap++){
            for(int i=0, j=gap; j<dp.length; j++, i++){
                for(int k=i; k<=j; k++){
                    int left = k==i? 0: dp[i][k-1];
                    int right = k==j? 0: dp[k+1][j];
                    int val = arr[k];
                    if(i>0) val*=arr[i-1];
                    if(j<arr.length-1) val*=arr[j+1];
                    int tv = left+right+val;
                    dp[i][j] = Math.max(dp[i][j], tv);
                }
            }
        }

        // for(int d[]: dp){
        //     for(int val: d){
        //         System.out.print(val+" ");
        //     }
        //     System.out.println();
        // }
        System.out.println(dp[0][dp.length-1]);
    }

    public static void main(String[] args) {
        int arr[] = {2,3,1,5,6,4};
        // solution(arr);
        dpSolution(arr);
    }
}
