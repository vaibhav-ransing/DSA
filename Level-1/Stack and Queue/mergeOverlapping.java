import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class mergeOverlapping {
    
    public static class pair implements Comparable<pair>{
        int start;
        int end;
        pair(int start, int end){
            this.start = start;
            this.end = end;
        }
        public int compareTo(pair o){
            return this.start - o.start;
        }
    }
    public static void printInterval(int[] start, int[] end){
        PriorityQueue<pair> pq = new PriorityQueue<>();
        for(int i=0;i<start.length;i++){
            pq.add(new pair(start[i], end[i]));
        }
        Stack<pair> stack = new Stack<>();
        while(pq.size()>0){
            pair peek = pq.remove();
            if(stack.size()==0){
                stack.push(peek);
            }else{
                if(stack.peek().end>=peek.start){
                    pair stakPeek = stack.pop();
                    int st = Math.min(stakPeek.start, peek.start);
                    int ed = Math.max(stakPeek.end, peek.end);
                    pair p = new pair(st , ed);
                    stack.push(p);
                }else{
                    stack.push(peek);
                }
            }
        }
        pair[] ans= new pair[stack.size()];
        int j=0;
        while(stack.size()>0){
            pair peek = stack.pop();
            ans[j++]=peek;
        }
        for(int i=ans.length-1;i>=0;i--)
            System.out.println(ans[i].start+" "+ans[i].end);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int start[] = new int[n];
        int end[] = new int[n];
        for(int i=0;i<n;i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            start[i]=s;
            end[i]=e;
        }
        System.out.println("----------");
        printInterval(start, end);
    }
}
