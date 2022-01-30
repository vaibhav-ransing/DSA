class floodFill{

    static void print(int arr[][], int r, int c, String ans, boolean visited[][]){

        if(r==arr.length-1 && c==arr[0].length-1){
            System.out.println(ans);
            return;
        }
        if(arr[r][c]==1)
            return;

        if(r<0 || c<0 || r>=arr.length || c>=arr[0].length || visited[r][c]==true )
            return;

        visited[r][c]=true;
        print(arr, r+1, c, ans+"d", visited);    //d
        print(arr, r, c+1, ans+"r", visited);    //r
        print(arr, r-1, c, ans+"t", visited);    //t
        print(arr, r, c-1, ans+"l", visited);    //l
        visited[r][c]=false;
        
    }

    public static void main(String[] args) {
        int arr[][] = { {0,0,0},
                        {1,0,1},
                        {0,0,0}};
        boolean[][] visited = new boolean[3][3];
        print(arr, 0, 0, "",  visited);
    }
}