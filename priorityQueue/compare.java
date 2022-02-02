import java.util.PriorityQueue;

public class compare {
    
    static class student implements Comparable<student> {
        String name;
        int ht;
        int wt;
        student( String name , int ht, int wt){
            this.name = name;
            this.ht = ht;
            this.wt = wt;
        }

        public int compareTo(student other){
            return this.ht - other.ht;
        }
    }
  
    public static void printStudentSortedToHeight(student arr[]){
        PriorityQueue<student> pq = new PriorityQueue<>();
        for(int i=0;i<arr.length;i++)
            pq.add(arr[i]);
        for(int i=0;i<arr.length;i++){
            System.out.println(pq.peek().ht);
            pq.remove();
        }
    }

    public static void main(String[] args) {
        student[] bacche = new student[3];
        bacche[0] = new student("mudd", 180, 50);
        bacche[1] = new student("vbr", 140, 60);
        bacche[2] = new student("prt", 170, 30);
        printStudentSortedToHeight(bacche);

        
    }
}
