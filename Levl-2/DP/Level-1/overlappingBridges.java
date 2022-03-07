import java.util.Scanner;

public class overlappingBridges {
    
    static void dpSoln(int north[], int south[]){
        int n=north.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(north[j]<north[i]){
                    swap(north, south, i, j);
                }
                else if(north[j]==north[i]){
                    if(south[j]<south[i])
                        swap(north, south, i, j);
                }
            }
        }

        for(int i=0;i<n;i++)
            System.out.print(north[i]+" ");
        System.out.println();
        for(int i=0;i<n;i++)
            System.out.print(south[i]+" ");
        System.out.println();
        
        int max=0;
        int dp[] = new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(south[j]<south[i])
                    dp[i] = Math.max(dp[i], dp[j]);
                
            }
            dp[i]+=1;
            max = Math.max(max, dp[i]);
        }
        // System.out.println(max);
        for(int i=0;i<dp.length;i++)
            System.out.print(dp[i]+" ");
    }

    static void swap(int north[], int south[], int i, int j){
        int temp = north[i];
        north[i] = north[j];
        north[j]= temp;
        
        int temp2 = south[i];
        south[i] = south[j];
        south[j] = temp2;
    }
    public static void main(String[] args) {
        // int north[] = {10,2,8,17,21,50,41,60,80,1};
        // int south[] = {20,7,15,3,40,4,57,80,90,30};
        // dpSoln(north, south);

        int north[] = {83,73,48,86,6,96,45,34,49,64,25,45,43,70,70,53};
        int south[] = {3,24,97,90,43,14,62,51,17,84,78,92,6,58,76,43};
        dpSoln(north, south);

        // Scanner sc = new Scanner(System.in);
        // int n=sc.nextInt();
        // int north[] = new int[n];
        // int south[] = new int[n];
        // for(int i=0;i<n;i++){
        //     int x = sc.nextInt();
        //     int y = sc.nextInt();
        //     north[i] = x;
        //     south[i] = y;
        // }


    }
}
