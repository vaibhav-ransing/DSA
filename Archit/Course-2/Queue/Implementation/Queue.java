import java.util.Comparator;
import java.util.PriorityQueue;

public class Queue {

    static class Cricketer {
    // static class Cricketer implements Comparable<Cricketer> {
        int age;
        String name;
        int score;
        // Cricketer(){}
        Cricketer(int age, String name, int score){
            this.age = age;
            this.name = name;
            this.score = score;
        }
        // public int compareTo(Cricketer o){
        //     // Min heap 
        //     return this.age - o.age;
        // }
    } 
    static class CricketAgeComparator implements Comparator<Cricketer> {

        @Override
        public int compare(Cricketer t, Cricketer o) {
            return t.age - o.age;
        }
        
    }

    public static void main(String[] args) {
        

        PriorityQueue<Cricketer> pq = new PriorityQueue<>(new CricketAgeComparator());
        pq.add( new Cricketer(22, "vaibahv", 3000) );
        pq.add(new Cricketer(25, "Rahul", 2000));
        pq.add(new Cricketer(20, "Pratick", 2500));

        // while(pq.size()>0){
        //     System.out.println(pq.remove().age);
        // }

        PriorityQueue<Cricketer> pq2 = new PriorityQueue<>(
            (t,o) ->{
                return t.age-o.age;
            }
        );

        pq2.add( new Cricketer(22, "vaibahv", 3000) );
        pq2.add(new Cricketer(25, "Rahul", 2000));
        pq2.add(new Cricketer(20, "Pratick", 2500));
        
        while(pq2.size()>0){
            System.out.println(pq.remove().age);
        }
    }
}
