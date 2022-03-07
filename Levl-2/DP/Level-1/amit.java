import java.util.Scanner;

public class amit {
    
    static void createGraph(int mat[][], int x[], int y[]){
        for(int i=0;i<x.length;i++){
            mat[x[i]][y[i]]=1;
        }
    }

    static void checkSoln(int mat[][], int x, String ans, int index, String inp){

        int n = mat.length;
        if(index==4){
            printAns(ans, inp);
            return;
        }

        for(int i=x;i<n;i++){
            for(int j=1;j<n;j++){
                if(mat[i][j]==1){
                    checkSoln(mat, j, ans+j, index+1, inp);
                }
            }
            return;
        }
    }
    
    static void printAns(String ans, String inp){
        StringBuilder printA=new StringBuilder();
        for(int i=0;i<ans.length();i++){
            char c = ans.charAt(i);
            int x = c-'0'; 
            
            printA.append(inp.charAt(x-1));
        }
        System.out.println(printA);
    }
    
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // int n=sc.nextInt();  //no of edges
        // int m= sc.nextInt();  // arr length
        // int x[] = new int[m];
        // int y[] = new int[m];
        // sc.nextLine(); 
        // String inp = sc.nextLine();
        // for(int i=0;i<m;i++){
        //     x[i] = sc.nextInt();
        // }
        // for(int i=0;i<m;i++){
        //     y[i] = sc.nextInt();
        // }
        // int mat[][] = new int[n+1][n+1];
        // createGraph(mat, x, y);
        // checkSoln(mat, 1, "1", 1, inp);
        

        int n=5;  //no of edges
        int m= 4;  // arr length
        String inp = "abaca";
        int x[] = {1,1,3,4};
        int y[] = {2,3,4,5};
        int mat[][] = new int[n+1][n+1];
        createGraph(mat, x, y);
        int z = 1;
        checkSoln(mat, 1, "1", z, inp);
        System.out.println(z);

        // for(int i=0;i<mat.length;i++){
        //     for(int j=0;j<mat.length;j++){
        //         System.out.print(mat[i][j]+" ");
        //     }
        //     System.out.println();
        // }
    }
}
