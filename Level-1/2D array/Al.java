import java.util.ArrayList;

public class Al {
    


    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> a = new ArrayList<>();

        ArrayList<Integer> a1 = new ArrayList<>();
        a1.add(1);   
        a1.add(2);   
        a1.add(3); 

        ArrayList<Integer> a2 = new ArrayList<>();
        a2.add(1);   
        a2.add(2);   
        a2.add(3);
        
        a.add(a1);
        a.add(a2);
        System.out.println(a);
    }
}
