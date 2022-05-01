import java.io.*;
import java.util.*;

public class goldMine2 {
    
    static int max = 0;
    static int temp = 0;
	public static void getMaxGold(int[][] arr, int i, int j, boolean visited[][], int ans){
		//write your code here
        if(i<0 || j<0 || i==arr.length || j==arr[0].length || arr[i][j]==0 ||  visited[i][j] ==true){
            max = Math.max(temp, max);
            return;
        }
        
        visited[i][j] = true;
        temp+= arr[i][j];
        getMaxGold(arr, i-1, j, visited, ans+arr[i][j]);
        getMaxGold(arr, i+1, j, visited, ans+arr[i][j]);
        getMaxGold(arr, i, j-1, visited, ans+arr[i][j]);
        getMaxGold(arr, i, j+1, visited, ans+arr[i][j]);

	}
    
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int[][] arr = new int[m][n];
		for(int i = 0; i < arr.length; i++){
			for(int j = 0 ; j  < arr[0].length; j++){
				arr[i][j] = scn.nextInt();
			}
		}
        boolean visited[][] = new boolean[m][n];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(visited[i][j]==false && arr[i][j]!=0){
                    temp = 0;
                    getMaxGold(arr, i, j, visited, 0);
                }
            }
        }
		System.out.println(max);
	}
}
