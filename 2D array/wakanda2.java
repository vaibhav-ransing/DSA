import java.util.Scanner;

public class wakanda2 {
    

    static void print(int arr[][]){
        for(int g=0;g<arr[0].length;g++){
            for(int i=0,j=g;j<arr[0].length;i++,j++){
                System.out.println(arr[i][j]);
            }       
        }
    }
    

    public static void main(String[] args) {
        // int arr[][] = { {1,2,3,4},
        //                 {11,22,33,44},
        //                 {44,55,66,77},
        //                 {12,13,14,15}};
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[][] = new int[n][m]; 
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        print(arr);
    }
}
