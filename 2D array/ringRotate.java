import java.util.Scanner;

class x{

    static void ringRotate(int arr[][], int r, int s){
        
        int minRow = s-1;
        int minCol = s-1;
        int maxRow = arr.length-s;
        int maxCol = arr[0].length-s;
        int size = 2*(maxRow-minRow)+2*(maxCol-minCol);
        int oneDArr[] = new int[size];


        // fill oneDArr
        fillOneDArr(arr, oneDArr, s);

        // rotate oneDArr
        rotate(oneDArr, r);

        // fill arr witb oneDArr
        fillTwoDArr(arr, oneDArr, s);
        
        // displa arr
        display(arr);
    }
    static void rotate(int oneDArr[], int r){
        r = r%oneDArr.length;
        if(r<0){
            r+=oneDArr.length;
        }
    reverse(oneDArr, 0, oneDArr.length-r-1);
    reverse(oneDArr, oneDArr.length-r, oneDArr.length-1);
    reverse(oneDArr, 0, oneDArr.length-1);
}

    static void reverse(int oneDArr[], int i, int j){
    
    while(j>i){
        int temp = oneDArr[i];
        oneDArr[i]=oneDArr[j];
        oneDArr[j]= temp;
        j--;
        i++;
    }
}

    static void fillOneDArr(int arr[][], int oneDArr[], int s){

        int minRow = s-1;
        int minCol = s-1;
        int maxRow = arr.length-s;
        int maxCol = arr[0].length-s;
        int index=0;
        for(int i=minRow;i<=maxRow;i++){
            oneDArr[index] = arr[i][minCol];
            index++;       
        }
        minCol++;
        for(int i=minCol;i<=maxCol;i++){
            oneDArr[index]=arr[maxRow][i];
            index++;
        }
        maxRow--;
        for(int i=maxRow;i>=minRow;i--){
            oneDArr[index] = arr[i][maxCol];
            index++;
        }   
        maxCol--;
        for(int i=maxCol;i>=minCol;i--){
            oneDArr[index]=arr[minRow][i];
            index++;
        }
        minRow++;
    }

    static void fillTwoDArr(int arr[][], int oneDArr[], int s){
        int minRow = s-1;
        int minCol = s-1;
        int maxRow = arr.length-s;
        int maxCol = arr[0].length-s;
        int index=0;
        for(int i=minRow;i<=maxRow;i++){
            arr[i][minCol] =oneDArr[index];
            index++;       
        }
        minCol++;
        for(int i=minCol;i<=maxCol;i++){
            arr[maxRow][i] = oneDArr[index];
            index++;
        }
        maxRow--;
        for(int i=maxRow;i>=minRow;i--){
            arr[i][maxCol] =oneDArr[index] ;
            index++;
        }  
        maxCol--;
        for(int i=maxCol;i>=minCol;i--){
            arr[minRow][i] =oneDArr[index];
            index++;
        }
        minRow++;

    }


    static void display(int arr[][]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(" "+ arr[i][j]);
            }
            System.out.println();
        }
    }
    
  
   
   
    public static void main(String[] args) {
        // int arr[][]=  {{11,12,13,14,15,16,17},
        //                 {21,22,23,24,25,26,27},
        //                 {31,32,33,34,35,36,37},
        //                 {41,42,43,44,45,46,47},
        //                 {51,52,53,54,55,56,57}};

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[][] = new int[n][m]; 
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        int s = sc.nextInt();
        int r = sc.nextInt();   
        ringRotate(arr, r, s);
    }   
}