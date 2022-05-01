public class Josephus {
    

    static void solution(int n, int k, int count, int idx){
        if(count==n){
            System.out.println(idx);
            return;
        }
        
        solution(n, k, count+1, (idx+k)%n);
    }

    static void lexiCographical(int n,  int i){
        if(i>n)
            return;
        System.out.println(i);
        for(int k=0;k<n;k++){
            lexiCographical(n, 10*i+k);
        }
    }
    public static void main(String[] args) {
        // solution(8, 3, 0, 0);
        for(int i=1;i<10;i++){
            lexiCographical(10, i);
        }
    }
}
