import java.util.Comparator;
import java.util.PriorityQueue;

public class compare {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int val , Node left, Node right){
            this.data= val;
            this.left = left;
            this.right = right;
        }
    }

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
    static class compareWithWeight implements Comparator<student>{
        public int compare(student s1 , student s2){
            return s1.wt - s2.wt;
        }
    }

    public static void printStudentSortedToHeight(student arr[]){
        PriorityQueue<student> pq = new PriorityQueue<>();
        for(int i=0;i<arr.length;i++)
            pq.add(arr[i]);
        for(int i=0;i<arr.length;i++){
            System.out.println(pq.peek().ht+ " "+pq.peek().wt);
            pq.remove();
        }
        //  print based on wt
        System.out.println("print with respect to weight ");
        PriorityQueue<student> pq2 = new PriorityQueue<>(new compareWithWeight());
        for(int i=0;i<arr.length;i++)
            pq2.add(arr[i]);
        for(int i=0;i<arr.length;i++){
            System.out.println(pq2.peek().ht+ " "+pq2.peek().wt);
            pq2.remove();
        }
    }

    public static void leetcode(int pre[] , int inorder[]){
        Node root = null;
        int start = 0;
        int end = pre.length;
        for(int i=0;i<pre.length;i++){
            int val = pre[i];
            
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
