import java.util.ArrayDeque;
import java.io.*;
import java.util.*;

public class longestIncSubseq{
    
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
        int dec[] = new int[arr.length];

        inc[0]=1;
        dec[0]=1;
        for(int i=1;i<inc.length;i++){
            for(int j=i-1; j>=0;j--){
                if(arr[j]<arr[i])
                    inc[i] = Math.max(inc[i], inc[j]);
                if(arr[j]>arr[i])
                    dec[i] = Math.max(dec[i], dec[j]);

            }
            dec[i]+=1;
            inc[i] += 1;
        }
        int max = 0;
        for(int i=0;i<arr.length;i++){
            max = Math.max(max, dec[i]+inc[i]);
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(inc[i]+" ");
        }
        System.out.println();
        for(int i=0;i<arr.length;i++){
            System.out.print(dec[i]+" ");
        }
        System.out.println();
        System.out.println(max-1);
    }

    public static void main(String []args){
        // int arr[] = {52,9,11,56,23,59,18,91,28,41, 1 ,30,14};
        
        // bitoniceSqubSeq(arr);
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int arr[]=new int[n];

        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        bitoniceSqubSeq(arr);
    }
}
