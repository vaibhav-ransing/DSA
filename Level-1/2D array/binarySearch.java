import java.util.Scanner;

public class binarySearch {
    
    static void isPresent(int arr[][], int x){
        int row=0;
        int col = arr.length-1;

        while(row<=arr.length-1 && col>=0){
            if(arr[row][col]<x){
                row+=1;
            }else if(arr[row][col]>x){
                col--;
            }else{
                System.out.println(row);
                System.out.println(col);
                return;
            }
        }
        System.out.println("not preset");
    }
    

    public static void main(String[] args) {
        int arr[][]={{11,12,13,14},
                      {21,22,23,24},
                      {31,32,33,34},
                      {41,42,43,44}};
        isPresent(arr, 32);

    Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr1[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr1[i][j]= sc.nextInt();
            }
        }
        
    }

}
