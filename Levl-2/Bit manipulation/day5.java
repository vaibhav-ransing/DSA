public class day5 {
    
    public static long ncr(long n, long r){
        if(n < r){
            return 0L;    
        }
        
        long res = 1L;
        
        for(long i = 0L; i < r; i++){
            res = res * (n - i);
            res = res / (i + 1);
        }
        
        return res;
    }
    
    public static long solution(long n, int k, int i) {
      if(n==0){
          return 0L;
      }
      long mask = 1<<i;
      long res1=0;
      long res0 = 0;
      if((mask & n)==0){
          solution(n, k, i-1);
      }else{
            res1= solution(n, k, i-1);
            res0 = ncr(n,k);
      }  
      return res1+res0;


    }


    public static void main(String[] args) {
        
    }
}
