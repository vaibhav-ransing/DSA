import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<String> al  =new ArrayList<>();
        
        al = getMazePaths(n,m);
        System.out.print(al);
    }
    
    public static ArrayList<String> getMazePaths(int sr, int sc) {
        ArrayList<String> al  =new ArrayList<>();
        int arr[][] = new int[sr][sc];
         StringBuilder ans = new StringBuilder();
        printPath(arr , 0, 0, ans, al);
        return al;
    }
    static void printPath(int arr[][], int r, int c, StringBuilder ans, ArrayList<String> al){

        if(r==arr.length-1 && c==arr[0].length-1){
            // System.out.println(ans);
            al.add(ans.toString());
            return;
        }
        if(r==arr.length || c==arr[0].length)
            return;

        ans.append("r");
        printPath(arr, r, c+1, ans, al);
        ans.delete(ans.length()-1, ans.length());
        
        ans.append("d");
        printPath(arr, r+1, c, ans, al);
        ans.delete(ans.length()-1, ans.length());
     }

}