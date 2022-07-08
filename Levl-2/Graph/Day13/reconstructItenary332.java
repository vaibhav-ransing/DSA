import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class reconstructItenary332 {
    
    static HashMap<String, PriorityQueue<String>> map;
    public List<String> findItinerary(List<List<String>> tickets) {
        map = new HashMap<>();
        for(List<String> ticket: tickets){
            String src = ticket.get(0);
            String dest = ticket.get(1);
            if(map.containsKey(src)){
                map.get(src).add(dest);
            }else{
                PriorityQueue<String> temp = new PriorityQueue<>();
                temp.add(dest);
                map.put(src, temp);
            }
        }
        // Stack<String> ans = new Stack<>();
        LinkedList<String> ans = new LinkedList<>();
        dfs("JFK", ans);
        return ans;
    }
    static void dfs(String src,LinkedList<String> ans){
        if(map.containsKey(src) == false ){
            ans.addFirst(src);
            return;
        }

        while(map.get(src).size() > 0){
            String nbr = map.get(src).remove();
             dfs(nbr, ans);
        }
        ans.addFirst(src);
    }

    // static HashMap<String, ArrayList<String>> map;
    // public List<String> findItinerary(List<List<String>> tickets) {
    //     map = new HashMap<>();
    //     for(List<String> ticket: tickets){
    //         String src = ticket.get(0);
    //         String dest = ticket.get(1);
    //         if(map.containsKey(src)){
    //             map.get(src).add(dest);
    //         }else{
    //             ArrayList<String> temp = new ArrayList<>();
    //             temp.add(dest);
    //             map.put(src, temp);
    //         }
    //     }
    //     // Stack<String> ans = new Stack<>();
    //     LinkedList<String> ans = new LinkedList<>();
    //     dfs("JFK", ans);
    //     return ans;
    // }
    // static void dfs(String src,LinkedList<String> ans){
    //     if(map.containsKey(src) == false || map.get(src).size() == 0){
    //         ans.addFirst(src);
    //         return;
    //     }
    //     for(String nbr: map.get(src)){
    //         map.get(src).remove(nbr);
    //         dfs(nbr, ans);
    //     }
    //     ans.push(src);
    // }

    public static void main(String[] args) {
        
    }
}
