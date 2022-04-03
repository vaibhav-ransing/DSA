import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Stack;

public class day9 {
    // max frequency stack

    class maxFreqStack{

        HashMap<Integer, Stack<Integer>> map;
        HashMap<Integer, Integer> freqMap;
        int maxFreq = 0;
        maxFreqStack(){
            map = new HashMap<>();
            freqMap = new HashMap<>();
        }

        void push(int x){
            int newFreq = freqMap.getOrDefault(x, 0)+1;
            maxFreq = Math.max(maxFreq, newFreq);
            freqMap.put(x, newFreq);
            if(map.containsKey(newFreq)){
                Stack<Integer> s = map.get(newFreq);
                s.push(x);
            }else{
                Stack<Integer> s = new Stack<>();
                s.push(x);
                map.put(newFreq, s);
            }
        }

        int pop(){
            if(maxFreq==0)
                return 0;
            Stack<Integer> s = map.get(maxFreq);
            int peek = s.pop();
            
            if(freqMap.get(peek)==1){
                freqMap.remove(peek);
            }else{
                freqMap.put(peek, freqMap.get(peek)-1);
            }

            if(map.get(maxFreq).size()==0){
                map.remove(maxFreq);
                maxFreq--;
            }
            return peek;
        }
    }

    class RandomizedSet {

        HashMap<Integer, Integer> map;
        ArrayList<Integer> list;
        public RandomizedSet() {
            map = new HashMap<>();
            list = new ArrayList<>();
        }
        
        public boolean insert(int val) {
            if(map.containsKey(val)){
                return false;
            }else{
                list.add(val);
                int index = list.size();
                map.put(val, index-1);
                return true;
            }
        }
        
        public boolean remove(int val) {
            if(map.containsKey(val)==false){
                return false;
            }else{
                int index = map.get(val);
                Collections.swap(list, index, list.size()-1);
                map.put(list.get(index), index);
                map.remove(val);
                list.remove(list.size()-1);
                return true;
            }
        }
        
        public int getRandom() {
            int max = list.size()-1;
            int randomNum = 0 + (int)(Math.random() * max);
            return list.get(randomNum);
        }
    }

    class RandomizedSetRepetition{
        HashMap<Integer , HashSet<Integer>> map;
        ArrayList<Integer> list ;
        Random r;
        RandomizedSetRepetition(){
            map = new HashMap<>();
            list = new ArrayList<>();
            r = new Random();
        }
        public boolean insert(int val) {
            boolean flag = true;
            list.add(val);
            int index = list.size()-1;
            if(map.containsKey(val)){
                HashSet<Integer> set  = map.get(val);
                set.add(index);
                flag = false;
            }else{
                HashSet<Integer> set = new HashSet<>();
                set.add(index);
                map.put(val, set);
            }
            return flag;
        }
        
        public boolean remove(int val) {
            if(map.containsKey(val)==false)
                return false;
                
            HashSet<Integer> set = map.get(val);
            int remidx=0;
            for(int ind: set){
                remidx=  ind;
                break;
            }
            set.remove(remidx);
            if(set.size()==0){
                map.remove(val);
            }

            if(remidx==list.size()-1){
                list.remove(remidx);
            }else{
                int li = list.size()-1;
                Collections.swap(list, remidx, li);
                list.remove(li);
                int newVal = list.get(remidx);
                HashSet<Integer> newSet = map.get(newVal);
                newSet.remove(li);
                newSet.add(remidx);
            }

            return true;
        }
        
        public int getRandom() {
            int index = r.nextInt(list.size());

            return list.get(index);   
        }

    }

    static void recurringSequanceFraction(int num, int den){
        int val = num/den;
        int rem = num%den;
        HashSet<Integer> set = new HashSet<>();
        String res = val+"";
        if(rem!=0){
            StringBuilder ans = new StringBuilder();
            // ans.append("(");
            helper(rem, den, set, ans);
            res = res+"."+ ans.toString();
        }
        System.out.println(res);
    }

    static void helper(int num, int den, HashSet<Integer> set, StringBuilder ans){
        int rem = (num*10)%den;
        int quo = (num*10)/den;
        if((set.contains(quo) && set.contains(rem)) || rem==0){
            if(rem==0){
                ans.append(quo);
            }else{
                for(int i=0;i<ans.length();i++){
                    char ch = ans.charAt(i);
                    if((ch-'0')==quo){
                        ans.insert(i, "(");
                        break;
                    }
                }
                ans.append(")");
                return;
            }
        }else{
            set.add(quo);
            set.add( rem);
            ans.append(quo);
            helper(rem, den, set, ans);
        }
    }


    static void countofSubarrayExactKuniqueChar(String s, int k){
        // aabcbcdbca k=2 12
        int i=0, j=0, count = 0;
        boolean release = false;
        HashMap<Character, Integer> map = new HashMap<>();
         while(true){
             boolean f1 = false, f2 = false;
             while(j<s.length() && release==false){
                 char ch = s.charAt(j);
                 f1 = true;
                //  System.out.println("aquire "+i+" "+j+" "+ch);
                if(map.containsKey(ch)==false && map.size()==k){
                    release = true;
                }else{
                    map.put(ch, map.getOrDefault(ch, 0)+1);
                    if(map.size()==k){
                        count+=1;
                    }
                    j++;
                }
               
                f1 = true;
             }
             if(j==s.length()){
                // System.out.println("release trues ");
                release =true;
            }
             while(i<s.length() && release){
                 char ch = s.charAt(i);
                //  System.out.println("release "+i+" "+j+" "+ch);
                 if(map.get(ch)==1){
                    release = false;
                    map.remove(ch); 
                 }else{
                     map.put(ch, map.get(ch)-1);
                 }
                 if(map.size()==k)
                    count+=1;
                i++;
                f2 = true;
             }
             if(f1==false && f2==false){
                // System.out.println(i+" "+j+" "+f1+" "+f2);
                 break;
             }
         }
         System.out.println(count);
    }

    static void countofSubarrayAtmostKuniqueChar(String s, int k){
        HashMap<Character, Integer> map = new HashMap<>();
        int i=0, j=0, count=0;
        // aabcbcdbca k=3
        boolean release = false;
        while(true){

            while(j<s.length() && release==false){
                char ch = s.charAt(j);
                System.out.println(i+" "+j +" "+ch);
                if(map.containsKey(ch)==false && map.size()==k){
                    release =true;
                }else{
                    map.put(ch, map.getOrDefault(ch, 0)+1);
                    j++;
                    count+= j-i;
                }
            }
            while(i<s.length() && release){
                char ch = s.charAt(i++);
                System.out.println(i+" "+j +" "+ch);
                if(map.get(ch)==1){
                    map.remove(ch);
                    release =false;
                }else
                    map.put(ch, map.get(ch)-1);
            }
            if(j==s.length())
                break;
        }
        System.out.println(count);
    }
    
    
    
    
    
    public static void main(String[] args) {
        recurringSequanceFraction(84, 87);
        

        StringBuilder ans = new StringBuilder();
        // ans.append("hello");
        // ans.insert(1, "s");
        // System.out.println( ans);


    }
}
