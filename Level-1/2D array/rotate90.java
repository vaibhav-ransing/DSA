public class rotate90 {
    
    static void transPose(int arr[][]){
        
        for(int i=0; i<arr.length;i++){
            for(int j=i+1; j<arr[0].length;j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i]=temp;
            }
        }
        colRev(arr);
        display(arr);
    }

    static void display(int arr[][]){
        for(int i=0; i<arr.length;i++){
            for(int j=0; j<arr[0].length;j++){
                System.out.print(" "+arr[i][j]);
            }
            System.out.println();
        }
    }
    static void colRev(int arr[][]){
        for(int i=0;i<arr.length;i++){
            int j1 = 0;
            int j2 = arr[0].length-1;

            while(j2>j1){
                int temp = arr[i][j1];
                arr[i][j1] = arr[i][j2];
                arr[i][j2] = temp;

                j1++;
                j2--;
            }
        }
    }
    public static void main(String[] args) {

        int arr[][] = {{1,2,3,4},
                        {11,12,13,14},
                        {21,22,23,24},
                        {31,32,33,34}};

         
    }
}

