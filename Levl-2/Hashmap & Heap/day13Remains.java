import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class day13Remains {
    
    static class pair implements Comparable<pair>{
        char ch;
        int freq;
        pair(char ch, int freq){
            this.ch=ch;
            this.freq = freq;
        }
        public int compareTo(pair o){
            return this.freq - o.freq;
        }
    }
    static void reArangeString(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        PriorityQueue<pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(char key: map.keySet()){
            pair p = new pair(key, map.get(key));
            pq.add(p);
        }
        StringBuilder ans = new StringBuilder();
        pair prev = null;
        while(pq.size()>0){
            pair peek = pq.remove();
            ans.append(peek.ch);
            peek.freq--;
            if(prev!=null && prev.freq>0){
                pq.add(prev);
            }
            prev = peek;
        }
        ans= ans.length()==s.length()? ans: new StringBuilder();
        System.out.println(ans.toString());

    }

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    static int ceilOfTree(Node node, int data, int ceil){
        if(node==null)
            return ceil;
        if(node.data>=data && ceil>node.data){
            ceil = node.data;
        }
        if(data>node.data){
            ceil = Math.min(ceil, ceilOfTree(node.right, data, ceil));
        }else
            ceil = Math.min(ceil, ceilOfTree(node.left, data, ceil));
        return ceil;
    }
    static void addNode(Node node, int data){

        if(data<node.data){
            if(node.left==null){
                node.left = new Node(data, null, null);
                return;
            }
            addNode(node.left, data);
        }
        else{
            if(node.right==null){
                node.right = new Node(data, null, null);
                return;
            }
            addNode(node.right, data);
        }
    }

    static int[] avoidFlood(int arr[]){

        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int[] ans = new int[arr.length];

        for(int i=0;i<arr.length;i++){
            int val = arr[i];
            if(val==0){
                pq.add(i);
            }else{
                ans[i]=-1;
                if(map.containsKey(arr[i])){
                    if(pq.isEmpty()){
                        return new int[0];
                    }else{
                        int peekIndex = pq.remove();
                        int preLakeIndex = map.get(arr[i]);
                        if(peekIndex< preLakeIndex)
                            return new int[0];

                        ans[peekIndex] = arr[i];
                    }
                }else{
                    // set.add(val);
                    map.put(val, i);
                }
            }
        }
        for(int i=0;i<ans.length;i++)
            System.out.print(ans[i]+" ");
        return ans;
    }

    static int[] avoidFloodTreemap(int arr[]){

        HashMap<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> set = new TreeSet<>();
        int ans[] = new int[arr.length];
        // 1,  0, 2,0, 3,0, 2,0,0,0, 1, 2, 3
        // [-1,1,-1,2,-1,3,-1,2,1,1,-1,-1,-1]
        for(int i=0;i<arr.length;i++){
            int val = arr[i];
            if(val==0){
                set.add(i);
                ans[i]=1;
            }else{
                ans[i]=-1;
                if(map.containsKey(val)){
                    Integer ceil = set.ceiling(map.get(val));
                    if(ceil==null)
                        return new int[0];
                    ans[ceil] = val;
                    map.put(val, i);
                    set.remove(ceil);

                }else{
                    map.put(val, i);
                }
            }
        }
        for(int i=0;i<ans.length;i++)
            System.out.print(ans[i]+" ");

        return ans;
    }

    static class pair2 implements Comparable{
        int x;
        int height;
        pair2(int x, int height){
            this.x = x;
            this.height = height;
        }
        public int compareTo(Object other){
            pair2 o = (pair2)other;
            if(this.x!=o.x){
                return this.x - o.x;
            }else
                return this.height - o.height;
        }
    }
    static void skyline(int arr[][]){
        ArrayList<pair2> al = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        List<List<Integer>> ans = new ArrayList<>();
        for(int[] rect: arr){
            int s = rect[0];
            int e = rect[1];
            int h = rect[2];

            pair2 ps = new pair2(s, -h);
            pair2 pe = new pair2(e, h);
            al.add(ps);
            al.add(pe);
        }
        Collections.sort(al);
        int cht = 0;
        pq.add(0);
        for(int i=0;i<al.size();i++){
            int x = al.get(i).x;
            int ht = al.get(i).height;

            if(ht<0){
                pq.add(-ht);
            }else{
                pq.remove(ht);
            }
            if(cht != pq.peek()){
                List<Integer> temp = new ArrayList<>();
                temp.add(x);
                temp.add(pq.peek());
                ans.add(temp);
                cht = pq.peek();
            }
        }
        
    }

    static void brickWall(ArrayList<ArrayList<Integer>> wall){

        HashMap<Integer, Integer> map = new HashMap<>();
        for(List<Integer> al: wall){
            int sum=0;
            for(int i=0;i<al.size()-1;i++){
                int brick = al.get(i);
                sum+=brick;
                map.put(sum, map.getOrDefault(sum, 0)+1);
            }
        }
        int max = 0;
        for(int count: map.values()){
            max = Math.max(max, count);
        }
        // return wall.size()-max;
    }

    static void subDomain(String[] arr){
        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0;i<arr.length;i++){
            String sp1[] = arr[i].split(" ");
            int count = Integer.parseInt(sp1[0]);
            String domain[] = sp1[1].split("\\.");
            StringBuilder temp = new StringBuilder();
            for(int j=domain.length-1;j>=0;j--){
                temp.append(domain[j]);
                map.put(temp.toString(), map.getOrDefault(temp.toString(), 0)+count);
            }
        }
        List<String> ans = new ArrayList<>();
        for(String key: map.keySet()){
            ans.add(key+" "+map.get(key));
        }
        System.out.println(ans);
    }

    static class pair3{
        int s;
        int e;
        int freq;

    }
    static void SmallestSubarrayWithAllOccurrencesOfTheMostFrequentElement(int arr[]){
        // HashMap<pair3> map = new HashMap<>();

    }
    static int count=0;
    static void capacityCombination(int cap[], int freq[], int k){
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=0;i<cap.length;i++){
            for(int j=0;j<freq[i];j++){
                al.add(cap[i]);
            }
        }
        // System.out.println(al);
        ArrayList<Integer> ans = new ArrayList<>();
        HashSet<HashMap<Integer, Integer>> set = new HashSet<>();
        subSeq(al, 0, ans, k,set);
        System.out.println(count);
    }
    static void subSeq(ArrayList<Integer> al, int index, ArrayList<Integer> ans, int k,HashSet<HashMap<Integer, Integer>> set){
        if(index==al.size()){
            int sum = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int val: ans){
                map.put(val, map.getOrDefault(val, 0)+1);
                sum+=val;
            }
            
            if(sum<=k && set.contains(map)==false){
                System.out.println(ans);
                set.add(map);
                count++;
            }
            return;
        }
        ans.add(al.get(index));
        subSeq(al, index+1, ans, k,set);
        ans.remove(al.get(index));
        subSeq(al, index+1, ans, k, set);
    }



    public static void main(String[] args) {
        int[] cap = {1,2,3};
        int[] freq = {1,2,1};

        capacityCombination(cap, freq, 6);
    }

}
