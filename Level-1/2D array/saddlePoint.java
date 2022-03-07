import java.util.Scanner;

class main{ 

    static void saddlePoint(int arr[][]){
        
        for(int i=0;i<arr.length;i++){
            int mincolNum = arr[i][0];
            int minColIndex = 0;

            for(int j=1; j<arr[0].length;j++){
                int num = arr[i][j];
                if(mincolNum>num){
                    mincolNum = num;
                    minColIndex = j;
                }
            }
            Boolean isSaddle=true;
            for(int j=0;j<arr.length;j++){
                int maxNum = arr[i][minColIndex];
                int num = arr[j][minColIndex];
                if(maxNum<num)
                    isSaddle=false;
            }
            if(isSaddle){
                System.out.println(arr[i][minColIndex]);
                return;
            }
        }
        System.out.println("no saddle point");

        System.out.println("Invalid input");
    }

    public static void main(String[] args) {
        // int arr[][]={{1,2,3,4},
        //              {5,6,7,8},
        //              {110,100,90,120},
        //              {13,14,15,16}};
        // 
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[][] = new int[n][n]; 
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        saddlePoint(arr);
    }
}
