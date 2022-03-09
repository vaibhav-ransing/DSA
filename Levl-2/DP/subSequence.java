import java.util.ArrayDeque;
import java.io.*;
import java.util.*;

public class subSequence{
    
    static class Pair{
        int i;
        String psf;
        Pair(String psf, int i){
            this.psf = psf;
            this.i = i;
        }
    }

    static void soln(int arr[]){
        int dp[] = new int[arr.length+1];
        for(int i=1;i<dp.length;i++){
            
            for(int j=i-1;j>0;j--){
                if(arr[j-1]<=arr[i-1]){
                    dp[i] = Math.max(dp[j], dp[i]);
                }
            }
            dp[i]+=1;
        }
        int val=Integer.MIN_VALUE;
        for(int i=0;i<dp.length;i++){
            val = Math.max(val, dp[i]);
            System.out.print(dp[i]+"  ");
        }
        System.out.println();
        for(int i=0;i<arr.length;i++){
            if(i==0)
                System.out.print("   ");
            if(i==9)
                System.out.print(" ");
            System.out.print(arr[i]+" ");
        }

        System.out.println();
        System.out.println(val);

        ArrayDeque<Pair> queue = new ArrayDeque<>();
        // for(int i=dp.length-1;i>0;i--){
        for(int i=1;i<dp.length;i++){
            if(dp[i]==val){
                queue.add(new Pair(""+arr[i-1], i));
                while(queue.size()>0){
                    Pair peek = queue.remove();
                    boolean found = false;
                    int v = dp[peek.i]-1;
                    for(int j=peek.i-1;j>0;j--){
                    // for(int j=1;j<peek.i;j++){
                        if(dp[j]==v && arr[j-1]<arr[peek.i-1]){
                            queue.add(new Pair(arr[j-1]+" -> "+peek.psf, j));
                            found = true;
                        }
                    }
                    if(!found)
                        System.out.println(peek.psf);
                }
            }
        }
        
    }
    
    static void maxSumSubSeq(int arr[]){
        int dp[] = new int[arr.length+1];

        for(int i=1;i<dp.length;i++){
            dp[i] = arr[i-1];
            int max = Integer.MIN_VALUE;
            for(int j=i-1;j>0;j--){
                if(arr[i-1]>arr[j-1]){
                    max = Math.max(max, dp[j]);
                }
            }
            if(max!=Integer.MIN_VALUE)
                dp[i]+= max;
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<dp.length;i++)
            max = Math.max(max, dp[i]);
        System.out.print(max);
    }

    static void bitoniceSqubSeq(int arr[]){

        int inc[] = new int[arr.length];

        inc[0]=1;
        for(int i=1;i<inc.length;i++){
            for(int j=i-1; j>=0;j--){
                if(arr[j]<arr[i])
                    inc[i] = Math.max(inc[i], inc[j]);

            }
            inc[i] += 1;
        }
        int n = arr.length;
        int lds[]=new int[n];

        for(int i=n-1;i>=0;i--){
            int max=0;
            for(int j=n-1;j>i;j--){
                if(arr[i]>=arr[j])
                    max=Math.max(max,lds[j]);
            }
            lds[i]=max+1;
        }

        int max = 0;
        for(int i=0;i<arr.length;i++){
            max = Math.max(max, lds[i]+inc[i]);
        }
        System.out.println(max-1);

    }

    static void overlappingBridges(int arr1[], int arr2[]){
        sort(arr1, arr2);
        
        int dp[] = new int[arr2.length+1];
        for(int i=1;i<dp.length;i++){
            
            for(int j=i-1;j>0;j--){
                if(arr2[j-1]<=arr2[i-1]){
                    dp[i] = Math.max(dp[j], dp[i]);
                }
            }
            dp[i]+=1;
        }
        int val=Integer.MIN_VALUE;
        for(int i=0;i<arr1.length;i++){
            val = Math.max(val, dp[i]);
            System.out.print(arr2[i]+" ");
        }
        // System.out.println(val);
    }
   
    static void sort(int arr1[], int arr2[]){
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr1.length;j++){
                if(arr1[j]>arr1[i] || (arr1[j]==arr1[i] && arr2[i]<arr2[j])){
                    swap(arr1, i, j);
                    swap(arr2, i, j);
                }
            }
        }
    }
    static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    static void ABCseq(String s){
        int n = s.length();
        int dp[][] = new int[3][n+1];
        for(int i=1;i<dp[0].length;i++){
            for(int j=0;j<dp.length;j++){
                if(j==0 && s.charAt(i-1)=='a'){
                    dp[j][i] = 2*dp[j][i-1] +1;
                }else if(j==1 && s.charAt(i-1)=='b'){
                    dp[j][i] = 2*dp[j][i] +dp[j-1][i-1]; ;
                }else if(j==2 && s.charAt(i-1)=='c'){
                    dp[j][i] = 2*dp[j][i-1] +dp[j-1][i-1]; ;
                }else{
                    dp[j][i] = dp[j][i-1];
                }
            }
        }
        System.out.println(dp[2][n]);
    }

    static void perfectSquare(int n){
        int dp[] = new int[n+1];
        for(int i=1;i<dp.length;i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j=1;j*j<=i;j++){
                int val = (int) Math.pow(j, 2);
                if(i-val>=0){
                    dp[i] = Math.min(dp[i], dp[i-val] );
                }
            }
            dp[i]+=1;
        }   
        for(int i=0;i<dp.length;i++)
            System.out.print(dp[i]+" ");
    }

    public static void main(String []args){
        // int arr[] = {52,9,11,56,23,59,18,91,28,41, 1 ,30,14};
        // int x[] = {10,22,9,33,21,50,41,60,80,1};
        // // bitoniceSqubSeq(arr);
        // Scanner sc=new Scanner(System.in);
        // int n=sc.nextInt();

        // int arr[]=new int[n];

        // for(int i=0;i<n;i++)
        //     arr[i]=sc.nextInt();
        // bitoniceSqubSeq(arr);

        // int arr1[] = {10,2,8,17,21,50,41,60,80,1};
        // int arr2[] = {20,7,15,3,40,4,57,80,90,30};
        // int arr1[] = {1,3,2,2};
        // int arr2[] = {4,1,3,7};
        // overlappingBridges(arr1, arr2);

        // ABCseq("abcabc");
        perfectSquare(11);
    }
}
