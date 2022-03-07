public class fibbo {
    
    static int fi(int n, int memo[]){
        if(n==0 || n==1)
            return n;

        if(memo[n-1]==-1 ){
            memo[n-1] = fi(n-1, memo)+fi(n-2, memo);
        }
        return memo[n-1];
    }

    static int fiRec(int n, int memo[]){
        if(n==0 || n==1)
            return n;

        return fi(n-1, memo)+fi(n-2, memo);
        
    }

    public static void main(String[] args) {
        int n=5;
        int memo[] = new int[n]; 
        for(int i=0;i<n;i++){
            memo[i]=-1;
        }
        System.out.println(fi(n,memo));
    }
}

