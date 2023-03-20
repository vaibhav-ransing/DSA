public class GoldMine2 {

    static int max = 0;
	public static void getMaxGold(int[][] arr){
        boolean[][] visited = new boolean[arr.length][arr.length];
        int max = 0;
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length; j++){
                if(visited[i][j]==false){
                    max = Math.max(max, helper(arr, visited, i, j, 0));
                }
            }
        }
        System.out.println(max);
	}
    static int helper(int[][] arr, boolean[][] visited, int row, int col, int cost){
        if(visited[row][col] || arr[row][col]==0){
            return cost;
        }
        int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        for(int i=0; i<dir.length; i++){
            int rr = row+dir[i][0];
            int cc = col+dir[i][1];
            if(rr>=0 && rr<arr.length && cc>=0 && cc<arr[0].length){
                if(visited[rr][cc]==false && arr[rr][cc]!=0){
                    cost+=helper(arr, visited, rr, cc, cost);
                }
            }
        }
        return cost+arr[row][col];
    }   
    public static void main(String[] args) {
        
    }
}
