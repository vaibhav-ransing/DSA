import java.util.Scanner;

public class nQueen {
    
    static void print(int arr[][], int index, int r, int c, String ans){

        if(index==arr.length ){
            System.out.println(ans+".");
            return;
        }
        if(index>=arr.length)
            return;
        for(int i=0;i<arr.length;i++){

            if(isSafe(arr, i, c)){
                arr[i][c] = 1;
                print(arr, index+1, i,c+1, ans+c+"-"+i+", ");
                arr[i][index] = 0;
            }
        }
    }
    static boolean isSafe(int arr[][], int r, int c){
        
        for(int i=r;i>=0;i--){
            if(arr[r][c]==1)
                return false;
        }
        for(int i=c;i>=0;i--){
            if(arr[r][i]==1)
                return false;
        }
        if(c>r || c==r) {
            for(int i=r,j=c;i>=0;i--,j--){
                if(arr[i][j]==1)
                    return false;
            }
            for(int i=r,j=c;i<arr.length;i++,j--){
                if(j>=0){
                    if(arr[i][j]==1)
                        return false;
                }
            }
        }else{
            for(int i=r,j=c;j>=0;i--,j--){
                if(arr[i][j]==1)
                    return false;
            }
            for(int i=r,j=c;j>=0;i++,j--){
                if(i<arr.length){
                    if(arr[i][j]==1)
                        return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[][] = new int[n][n];
        print(arr, 0, 0, 0,"");
    }
}
