public class day6 {
    
    static void soln(int i, int n){
        if(i>n){
            return;
        }
        System.out.println(i);
        for(int j=0;j<10; j++){
            soln(10*i+j, n);
        }
    }

    


    public static void main(String[] args) {
        int n=10;
        for(int i=1;i<10;i++){
            soln(i, n);
        }
    }
}
