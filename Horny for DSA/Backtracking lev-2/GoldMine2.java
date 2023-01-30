public class GoldMine2 {
    

    static int max = 0;
    static int temp = 0;
    static String strAns = "";
	public static void getMaxGold(int[][] arr){
        boolean[][] visited = new boolean[arr.length][arr[0].length];

        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(visited[i][j]==false){
                    temp = 0;
                    strAns = "";
                    dfs(arr, visited, i, j, 0, strAns);
                }
            }
        }
        System.out.println(max);
	}
    public static void dfs(int[][] arr, boolean[][] visited, int i, int j, int sum, String strAns1){
        if(i<0 || i==arr.length || j<0 || j==arr[0].length || visited[i][j] || arr[i][j]==0){
            if(sum>max){
                strAns = strAns1;
            }
            max = Math.max(max, sum);
            return;
        }
        visited[i][j]=true;
        String tempStr = strAns+" - "+arr[i][j];
        // temp+=arr[i][j];
        sum+=arr[i][j];
        int dir[][] = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        for(int[] d: dir){
            int ii = i+d[0];
            int jj = j+d[1];
            dfs(arr, visited, ii, jj, sum, tempStr);
        }
    }




    public static void main(String[] args) {
        int arr[][] = {{0 ,1, 4, 2, 8, 2,},
                        {4 ,3, 6, 5, 0, 4,},
                        {1 ,2, 4, 1, 4, 6,},
                        {2 ,0, 7, 3, 2, 2,},
                        {3 ,1, 5, 9, 2, 4,},
                        {2 ,7, 0, 8, 5, 1,}};
    }
}
