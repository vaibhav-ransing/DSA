public class mazePath {
    
     static void printPath(int arr[][], int r, int c, StringBuilder ans){

        if(r==arr.length-1 && c==arr[0].length-1){
            System.out.println(ans);
            return;
        }
        if(r==arr.length || c==arr[0].length)
            return;

        ans.append("r");
        printPath(arr, r, c+1, ans);
        ans.delete(ans.length()-1, ans.length());
        
        ans.append("d");
        printPath(arr, r+1, c, ans);
        ans.delete(ans.length()-1, ans.length());
     }

    public static void main(String[] args) {
        int arr[][] = new int[3][3];
        StringBuilder ans = new StringBuilder();
        printPath(arr, 0, 0, ans);
    }
}
