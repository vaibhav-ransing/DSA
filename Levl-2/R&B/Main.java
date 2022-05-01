// import java.io.*;
import java.util.*;

public class Main {
  
  public static void solveSudoku(int[][] board, int i, int j, int count) {
        if(i==board.length){
            display(board);
            return;
        }
        int ni=0, nj=0;
        if(j==board.length-1){
            ni = i+1;
            nj=0;
        }else{
            ni=i;
            nj = j+1;
        }
        if(board[i][j]!=0){
            solveSudoku(board, ni, nj, count);
        }else{
            for(int k=1; k<10;k++){
                if(isSafeSudoku(board, i, j, k)){
                    board[i][j] = k;
                    solveSudoku(board, ni, nj, count+1);
                    board[i][j] = 0;
                }
            }
        }
    }

    static boolean isSafeSudoku(int arr[][] , int row, int col, int val){
        for(int i=0;i<arr.length; i++){
            if(arr[row][i]==val)
                return false;
            if(arr[i][col]==val)
                return false;
        }
        int startRow = 3*(row/3);
        int startCol = 3*(col/3);
        for(int i= startRow; i<startRow+3; i++){
            for(int j= startCol; j<startCol+3; j++){
                if(arr[i][j]==val)
                    return false;
            }
        }
        return true;
    }   
    public static void display(int[][] board){
        for(int i = 0; i < board.length; i++){
          for(int j = 0; j < board[0].length; j++){
            System.out.print(board[i][j] + " ");
          }
          System.out.println();
        }
    }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int[][] arr = new int[9][9];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        arr[i][j] = scn.nextInt();
      }
    }

    solveSudoku(arr, 0, 0,1);
  }
}
