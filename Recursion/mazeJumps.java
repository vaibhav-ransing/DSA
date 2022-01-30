import java.util.Scanner;

public class mazeJumps {
    
    static void print(int arr[][], StringBuilder ans, int r, int c){
        if(r==arr.length-1 && c== arr[0].length-1){
            System.out.println(ans);
            return;
        }
        if(r>arr.length || c>arr[0].length){
            return;
        }
        for(int i=r; i<arr.length;i++){
            for(int j=c;j<arr[0].length;j++){
                ans.append("h");
                ans.append(Integer.toString(j));       
                print(arr, ans, r, c+j);
                ans.delete(ans.length()-2,ans.length());    
            }
            ans.append("v");
            ans.append(Integer.toString(i));
            print(arr, ans, r+i, c);
            ans.delete(ans.length()-2,ans.length());
        }
    }

    static void print2(int arr[][], StringBuilder ans, int r, int c){

        if(r==arr.length-1 && c== arr[0].length-1){
            System.out.println(ans);
            return;
        }
        if(r>arr.length || c>arr[0].length){
            return;
        }
        for(int i=1;i<arr[0].length;i++){
            ans.append('h');
            ans.append(i);
            print2(arr, ans, r, c+i);
            ans.delete(ans.length()-2, ans.length());
        }
        for(int i=1;i<arr.length;i++ ){
            ans.append("v");
            ans.append(i);
            print2(arr, ans, r+i, c);
            ans.delete(ans.length()-2, ans.length());
        }
        for(int i=1;i<arr.length;i++){
            for(int j=1;j<arr[0].length;j++){
                if(i==j){
                    ans.append("d");
                    ans.append(i);
                    print2(arr, ans, r+i, c+i);
                    ans.delete(ans.length()-2, ans.length());
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // int m = sc.nextInt();
        int n = 4;
        int m = 4;
        StringBuilder ans = new StringBuilder();
        int arr[][] = new int[n][m];
        print2(arr, ans, 0, 0);
    }
}
