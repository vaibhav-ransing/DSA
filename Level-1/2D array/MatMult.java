import java.util.Scanner;
class MatMult{
    static void print(int arr[][]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    static void MatrixMult(int arr1[][], int arr2[][]){
        if(arr1[0].length==arr2.length){
            int newArr[][] = new int[arr1.length][arr2[0].length];

            for(int i=0;i<newArr.length;i++){
                for(int j=0;j<newArr[0].length;j++){
                    // for(int k=0;k<arr1[0].length;k++){
                    //     newArr[i][j] +=arr1[i][k]*arr2[k][j];    
                    // }
                    newArr[i][j] = sum(arr1, arr2, i, j);
                }
            }
            print(newArr);
        }
        else{
            System.out.println("invalid input");
        }
    }

    static int sum(int arr1[][], int arr2[][], int x, int y){
        int sum=0;
        for(int i=0; i<arr1[0].length;){
            for(int j=0; i<arr2.length;j++){
                sum+= arr1[x][j] * arr2[i++][y];
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr1[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr1[i][j]= sc.nextInt();
            }
        }
        System.out.println("next arrya inputs");
        int n1 = sc.nextInt();
        int m1 = sc.nextInt();
        int arr2[][] = new int[n1][m1];
        for(int i=0;i<n1;i++){
            for(int j=0;j<m1;j++){
                arr2[i][j]= sc.nextInt();
            }
        }

        MatrixMult(arr1, arr2);



    }
}

