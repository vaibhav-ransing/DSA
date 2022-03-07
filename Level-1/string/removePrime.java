import java.util.ArrayList;

public class removePrime {
    

    static void solution(ArrayList<Integer> al){  
        
        for(int i=al.size()-1; i>=0;i--){
            if(isPrime(al.get(i))){
                al.remove(i);
            }
        }
        System.out.println(al);
    }
    static boolean isPrime(int x){

        if(x==0 || x==1)
            return false;
        for(int i=2; i*i<x;i++){
            if(x%i==0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        // 3 12 13 15
        al.add(3);
        al.add(12);
        al.add(13);
        al.add(15);
        solution(al);
    }
}
