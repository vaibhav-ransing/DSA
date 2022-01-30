// import java.util.Scanner;

// class spiral{

//     static void printSpiral(int arr[][]){
//         int minRow=0;
//         int maxRow = arr.length-1;
//         int minCol = 0;
//         int maxCol = arr[0].length-1;
//         // int i=0,j=0;
//         int n=0;
//         while(true){
            
                
//             for(int i=minRow;i<=maxRow;i++){
//                 if(n<arr.length*arr[0].length){
//                     System.out.println(arr[i][minCol]);
//                     n++;   
//                 }
//             }
//             minCol+=1;

//             for(int i=minCol;i<=maxCol;i++){
//                 if(n<arr.length*arr[0].length){
//                     System.out.println(arr[maxRow][i]);
//                     n++;
//                 }
                
//             }
//             maxRow-=1;

//             for(int i=maxRow;i>=minRow;i--){
//                 if(n<arr.length*arr[0].length){
//                     System.out.println(arr[i][maxCol]);
//                     n++;
//                 }
                
//             }
//             maxCol-=1;

//             for(int i=maxCol;i>=minCol;i--){
//                 if(n<arr.length*arr[0].length){
//                     System.out.println(arr[minRow][i]);
//                     n++;
//                 }
                
//             }
//             minRow+=1;
        
//         }
//     }
//     public static void main(String[] args) {
//         // int arr[][]={{11,12,13,14,15},
//         //               {21,22,23,24,25},
//         //               {31,32,33,34,35},
//         //               {41,42,43,44,45}};
                    
//         Scanner sc = new Scanner(System.in);
//         int n=sc.nextInt();
//         int m = sc.nextInt();
//         int arr[][] = new int[n][m];
//         for(int i=0;i<n;i++){
//             for(int j=0;j<m;j++){
//                 arr[i][j]=sc.nextInt();
//             }
//         }
//         System.out.println("ans belos");
//         printSpiral(arr);
//     }
// }

import java.io.*;
import java.util.*;

class Main {
    
    static void printSpiral(int arr[][]){
        int minRow=0;
        int maxRow = arr.length-1;
        int minCol = 0;
        int maxCol = arr[0].length-1;
        // int i=0,j=0;
        int n=0;
        
        while(true){
            
            if(n==arr.length*arr[0].length )
                break;

            for(int i=minRow;i<=maxRow;i++){
                if(n<arr.length*arr[0].length){
                    System.out.println(arr[i][minCol]);
                    n++;
                }
            }
            minCol+=1;

            for(int i=minCol;i<=maxCol;i++){
                if(n<arr.length*arr[0].length){
                    System.out.println(arr[maxRow][i]);
                    n++;
                }
                
            }
            maxRow-=1;

            for(int i=maxRow;i>=minRow;i--){
                if(n<arr.length*arr[0].length){
                    System.out.println(arr[i][maxCol]);
                    n++;
                }
                
            }
            maxCol-=1;

            for(int i=maxCol;i>=minCol;i--){
                if(n<arr.length*arr[0].length){
                    System.out.println(arr[minRow][i]);
                    n++;
                }
                
            }
            minRow+=1;
            
            
        }
    }
    static void print(int arr[][]){
        int dir=0;
        while(dir<arr[0].length){

            if(dir%2==0){
                for(int i=0;i<arr.length;i++){
                    System.out.println(arr[i][dir]);
                }
                dir+=1;
            }
            else{
                for(int i=arr.length-1;i>=0;i--){
                    System.out.println(arr[i][dir]);
                }
                dir+=1;
            }
        }
        
    }
    

    public static void main(String[] args) throws Exception {
        
        // Scanner sc = new Scanner(System.in);
        // int n=sc.nextInt();
        // int m = sc.nextInt();
        // int arr[][] = new int[n][m];
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         arr[i][j]=sc.nextInt();
        //     }
        // }
        int arr[][] = {{11,12,13,14,15},
                        {21,22,23,24,25},
                        {31,32,33,34,35}};

        // printSpiral(arr);
        print(arr);
        
    }

}


