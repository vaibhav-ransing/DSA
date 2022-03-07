import java.util.Scanner;

public class exitPoint {
    
    static void exit(int arr[][]){

        int i=0,j=0;
        int dir=0;
        int coun=0;
        while(true){
             dir = (dir + arr[i][j])%4;
             if(dir==0){
                 j++;
                 if(j==arr[0].length){
                     j=j-1;
                     System.out.println(i);
                     System.out.println(j);
                     return;
                    }
                }
                else if(dir==1){
                    i++;
                    if(i==arr.length){
                        i=i-1;
                        
                        System.out.println(i);
                        System.out.println(j);
                    return;
                }
             }
             else if(dir==2){
                j--;
                if(j==-1){
                    j=j+1;
                    System.out.println(i);
                    System.out.println(j);
                    return;
                }
             }
             else if(dir==3){
                i--;
                if(i==-1){
                    i=0;
                    System.out.println(i);
                    System.out.println(j);
                    return;
                }
             }
        }

    }



    public static void main(String[] args) {
        // int arr[][]={{0,0,1,0},
        //              {1,0,0,0},
        //              {0,0,0,0},
        //              {1,0,1,0}};
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m = sc.nextInt();
        int arr[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        exit(arr);
        // System.out.println(4%4);
    }
}
