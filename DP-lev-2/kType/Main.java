package kType;
import java.io.*;
import java.util.*;

public class Main {

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
        // 2 3 1 5 6 4
        for(int gap=0; gap<dp.length; gap++){
            for(int i=0, j=gap; j<dp.length; j++, i++){
                if(gap==0){
                    if(j==0){
                        dp[i][j] = arr[j]*arr[j+1];
                    }else if(j==arr.length-1){
                        dp[i][j] = arr[j]*arr[j-1];
                    }else{
                        dp[i][j] = arr[j]*arr[j-1]*arr[j+1];
                    }
                }else{
                    
                }
            }
        }
    }


  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = scn.nextInt();
    }
    solution(arr);
  }

}