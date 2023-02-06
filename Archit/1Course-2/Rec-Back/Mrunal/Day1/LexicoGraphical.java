public class LexicoGraphical {
    

    public static void dfs(int i, int n){
        if(i>n){
            return;
        }
        System.out.println(i);
        for(int j=0; j<10; j++){
            dfs(i*10+j, n);
        }
    }

    public static void solution(int n){
        for(int i=1; i<10; i++){
            dfs(i, n);
        }
    }



    public static void main(String[] args) {
        
    }
}
