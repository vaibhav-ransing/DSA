public class Josephus {
    

    public static int solution(int n, int k){
        if(n==0){
            return 0;
        }
        int temp = solution(n-1, k);
        return (temp+k)%n;
    }


    public static void choduMrunal(int i){

        choduMrunal(i);
    }


    public static void main(String[] args) {
        
    }
}
