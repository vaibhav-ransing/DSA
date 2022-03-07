public class cat_2d {
    
    static void tss(int arr[] , int tar, int index, String ans){
        if(index==arr.length || tar<0)
            return;
        if(tar==0){
            System.out.println(ans);
        }
        tss(arr, tar-arr[index], index+1, ans+" "+arr[index]);
        tss(arr, tar, index+1, ans);
    }

    static void tssDp(int arr[] , int tar){
        boolean dp[][] = new boolean[arr.length+1][tar+1];
        dp[0][0] = true;
        for(int i=1; i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(j==0){
                    dp[i][j] = true;
                }else{
                    if(j-arr[i-1]>=0 && dp[i-1][j-arr[i-1]])
                            dp[i][j] = true;    
                    else{
                        dp[i][j]= dp[i-1][j];
                    }
                }
            }
        }
        display(dp);
    }
    
    static void display(boolean arr[][]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++)
                System.out.print(arr[i][j]+" ");
            System.out.println();
        }
    }

    static void coinChangeCombi(int arr[], int sum){
        int dp[][] = new int[arr.length+1][sum+1];
        dp[0][0]=1;
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = dp[i-1][j];
                if(j-arr[i-1]>=0){
                    dp[i][j]+= dp[i][j-arr[i-1]];
                }
            }
        }
        // displayInt(dp);
        System.out.println(dp[dp.length-1][dp[0].length-1]);
    }
    static void coinChangeCombiOneD(int arr[] , int sum){
        int dp[] = new int[sum+1];
        dp[0]=1;
        for(int index=0;index<arr.length;index++){
            for(int i=1;i<dp.length;i++){
                if(i-arr[index]>=0){
                    dp[i]+=dp[i-arr[index]];
                }
            }
        }
        for(int i=0;i<dp.length;i++)
            System.out.print(dp[i]+" ");
    }


    static void coinChangePermu(int arr[], int sum){
        int dp[][] = new int[arr.length+1][sum+1];
        dp[0][0]=1;
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = dp[i-1][j];
                if(j-arr[i-1]>0){
                    dp[i][j]+= dp[i][j-arr[i-1]];
                    dp[i][j]+= 2*(dp[i-1][j-arr[i-1]]);
                 }else if(j-arr[i-1]==0){
                     dp[i][j] =1;
                 }
            }
        }
        // displayInt(dp);
        System.out.println(dp[dp.length-1][dp[0].length-1] -1);
    }
    static void coinChangePermuOneD(int[] arr , int sum){
        int[] dp = new int[sum+1];
        dp[0]=1;
        // for(int index=0;index<arr.length;index++){
        //     for(int i=1;i<dp.length;i++){
                
        //     }
        // }
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<arr.length;j++){
                if(i-arr[j]>=0){
                    dp[i]+=dp[i-arr[j]];
                }
            }
        }
        System.out.println(dp[dp.length-1]);
    }
    
    static void displayInt(int arr[][]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++)
                System.out.print(arr[i][j]+" ");
            System.out.println();
        }
    }
    static void display(double arr[][]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++)
                System.out.print(arr[i][j]+" ");
            System.out.println();
        }
    }

    static void zeroOneKnap(int cap[], int wt[], int weight){
        int dp[][] = new int[wt.length+1][weight+1];

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(j-wt[i-1]>=0){
                    int included = dp[i-1][j-wt[i-1]]+ cap[i-1];
                    int exclude = dp[i-1][j];
                    dp[i][j] = Math.max(included, exclude);
                }else{
                    int exclude = dp[i-1][j];
                    dp[i][j] = Math.max(dp[i][j-1], exclude);
                }
            }
        }
        // displayInt(dp);
        System.out.println(dp[dp.length-1][dp[0].length-1]);
    }

    static void fractionalKnapSack(int cap[], int wt[], int weight){
        double val=0;
        int index=0;
        
        while(weight!=0 && index!=cap.length){
            int maxIndex = getBestCap(cap, wt);
            if(weight - wt[maxIndex]>=0){
                weight -= wt[maxIndex];
                val+=cap[maxIndex];
                // System.out.println(wt[maxIndex]+" "+ cap[maxIndex] +" val "+val);
                cap[maxIndex] = 0;
            }else{
                double divisor = wt[maxIndex];
                double coeff = cap[maxIndex];
                val+=weight*(coeff/divisor*100)/100 ;
                weight = 0;
            }
            index++;
        }
        System.out.println(val);
        
    }
    static int  getBestCap(int cap[], int wt[]){
        int index=0;
        double val=0;
        for(int i=0;i<cap.length;i++){
            if( cap[i]/wt[i]> val ){
                val = cap[i]/wt[i];
                index = i;
            }
        }
        return index;
    }

    static void unboundedKnap(int cap[], int wt[], int weight){

        int dp[] = new int[weight+1];
        
        for(int index= 0; index<wt.length; index++){
            for(int j=1;j<dp.length;j++){
                if(j-wt[index]>=0){
                    int include = dp[j-wt[index]] + cap[index];
                    dp[j] = Math.max(include, dp[j]); 
                }
            }
        }

        for(int i=0;i<dp.length;i++){
            System.out.print(dp[i]+" ");
        }
    }

    public static void main(String[] args) {
        // int arr[] = {4,2,7,1,3};
        // int arr[] = {4,9,9,2,12,8,14,7,14,9,8,12,11,4,10,17,1,13,2,18,12,10,11};
        // tss(arr, 5);
        
        // int arr[] = {2,3,5,6};
        // coinChangePermu(arr, 7);
        

        int[] cap =  {15, 14, 10, 45, 30};
        int[] wt = {2, 5, 1, 3, 4};
        int weight = 7;
        unboundedKnap(cap, wt, weight);
    }
}
