import java.io.*;
import java.util.*;

public class Main {
    static void display(int arr[][]){
        for(int r[]: arr){
            for(int val: r){
                if(val==1){
                    System.out.print("q" +"/t");
                }else{
                    System.out.print("-"+"/t");
                }
            }
            System.out.println();
        }
    }

     static void queenCombQueencChooses(int arr[][], int qp, int row, int col){
        if(qp==arr.length+1){
            display(arr);
            return;
        }
        if(row==arr.length)
            return;

        int nr, nc;
        if(col==arr.length-1){
            nr= row+1;
            nc = 0;
        }else{
            nr=row;
            nc = col+1;
        }
        arr[row][col] = 1;
        queenCombQueencChooses(arr, qp+1, nr, nc);
        arr[row][col] = 0;
        queenCombQueencChooses(arr, qp, nr, nc);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] chess = new int[n][n];
        
        queenCombQueencChooses(chess, 1, 0, 0);
    }
}