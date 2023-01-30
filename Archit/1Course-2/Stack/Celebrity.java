public class Celebrity {
    public static int celebrity(int M[][], int n){
    	
        int ans = 0;
        for(int i=1; i<M.length; i++){
            if(M[ans][i]==1){
                ans = i;
            }
        }
        for(int i=0; i<M.length; i++){
            if(i!=ans){
                if(M[ans][i]!=0){
                    ans = -1;
                }
                if(M[i][ans]!=1){
                    ans = -1;
                }
            }
        }
        return ans;
    }
}
