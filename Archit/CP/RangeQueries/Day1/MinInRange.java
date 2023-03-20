package CP.RangeQueries.Day1;

import java.util.concurrent.locks.Condition;

import org.w3c.dom.Node;

// https://cses.fi/problemset/task/1649
public class MinInRange {
    
    
    static int[] nodes;
    public static void construct(int idx, int left, int right, int arr[]){
        if(left>right) return;
        if(left==right){
            nodes[idx] = arr[left];
        }
        int mid = (left+right)/2;
        construct(2*mid+1, left, mid, arr);
        construct(2*mid+2, mid+1, right, arr);
        nodes[idx] = Math.min(nodes[2*mid+1], nodes[2*mid+2]);
    }
    


    public static void main(String[] args) {
        
    }
}
