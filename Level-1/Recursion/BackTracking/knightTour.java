import java.util.Scanner;

public class knightTour {
    
    public static void printKt(int arr[][], int n, int r, int c, int count){

        
        if(r<0 || c<0 || r>=arr.length || c>=arr.length || arr[r][c]>0)
            return;

        if(count==arr.length*arr.length){
            arr[r][c]=count; 
            for(int i=0;i<arr.length;i++){
                for(int j=0;j<arr.length;j++){
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
            
            arr[r][c]=0;     
            return;
        }

        arr[r][c]=count;        
        printKt(arr, n, r+2, c+1, count+1);
        arr[r][c]=0; 
        
        arr[r][c]=count; 
        printKt(arr, n, r+1, c+2, count+1);
        arr[r][c]=0;

        arr[r][c]=count;         
        printKt(arr, n, r-1, c+2, count+1);
        arr[r][c]=0;        
        
        arr[r][c]=count; 
        printKt(arr, n, r-2, c+1, count+1);
        arr[r][c]=0;  
        
        arr[r][c]=count; 
        printKt(arr, n, r-2, c-1, count+1);
        arr[r][c]=0;
        
        arr[r][c]=count; 
        printKt(arr, n, r-1, c-2, count+1);
        arr[r][c]=0;
        
        arr[r][c]=count; 
        printKt(arr, n, r+1, c-2, count+1);
        arr[r][c]=0;
        
        arr[r][c]=count; 
        printKt(arr, n, r+2, c-1, count+1);
        arr[r][c]=0;        
    }

    

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        // int n = sc.nextInt();
        // int r = sc.nextInt();
        // int c = sc.nextInt();
        int arr[][] = new int[5][5];
        printKt(arr, 5, 2, 0, 1);


    }
}
