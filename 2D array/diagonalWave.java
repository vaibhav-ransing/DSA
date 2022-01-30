import java.util.Scanner;

public class diagonalWave {
    
    static void print2(int arr[][]){
       
        int n=arr.length;
        int i,j;
        int count=0;
        for(int gap=0;gap<n;gap++){
            if(count%2==1){
                for(i=n-1, j=gap; j>=0;i--,j--){
                    System.out.print(" "+arr[i][j]);
                }
                System.out.println();
            }
            
            else{
                for(i=n-gap-1, j=0; i<n;i++,j++){
                    System.out.print(" "+arr[i][j]);
                }
                System.out.println();
            }
            count++;
        }

        for(int gap=1; gap<n;gap++){
            if(count%2==0){
            
                for(i=0,j=gap;j<n; i++,j++){
                    System.out.print(" "+arr[i][j]);
                }
                System.out.println();
            
            }

            else{
                for(i=n-gap-1,j=n-1;i>=0; i--,j--){
                    System.out.print(" "+arr[i][j]);
                }
                System.out.println();
            }
            
            count++;
        }
    }

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // int arr[][] = new int[n][n];
        
        // for(int i=0; i<n;i++){
        //     for(int j=0;j<n;j++){
        //         arr[i][j]=sc.nextInt();
        //     }
        // }

        
        int arr[][] = { {61, 62, 63, 64, 65},
                        {75, 76, 77, 78, 79},
                        {11, 12, 14, 15, 16},
                        {21, 22, 23, 24, 25},
                        {51, 52, 53, 54, 55}};
        print2(arr);
    }
}
