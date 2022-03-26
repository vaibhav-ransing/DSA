import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class day8 {
    
    public static ArrayList<ArrayList<String>> groupAnagrams(String[] strs) {
		// write your code here
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<strs.length;i++){
            ArrayList<String> al = new ArrayList<>();
            String s1 = strs[i];
            if(set.contains(s1))
                continue;
            al.add(s1);
            for(int j=i+1;j<strs.length;j++){              
                String s2 = strs[j];
                if(isAnagram(s1, s2)){
                    al.add(s2);
                    set.add(s2);
                }
            }
            ans.add(al);
        }
		return ans;
	}
    static boolean isAnagram(String s1, String s2){
        if(s1.length()!=s2.length())
            return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s1.length();i++){
            char ch = s1.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        for(int i=0;i<s2.length();i++){
            char ch = s2.charAt(i);
            if(map.containsKey(ch)==false)
                return false;
            else{
                int val = map.get(ch);
                if(val==1)
                    map.remove(ch);
                else{
                    map.put(ch, val-1);
                }
            }
        }

        return true;
    }


    static void maxConsecutiveOnes(int arr[]){
        int count = 0;
        int len = 0;
        int i=0 , j=0;
        while(i<arr.length && j<arr.length){
            while(count<2 && j<arr.length){
                if(arr[j]==0){
                    count++;
                    if(count==2){
                        j++;
                        break;
                    }
                }
                len = Math.max(len, j-i+1);
                j++;
            }
            while(count>1 && i<arr.length){
                if(arr[i]==0){
                    i++;
                    count--;
                    break;
                }
                i++;
            }
        }
        System.out.println(len);
    }
    
    static void maxConsecutiveOnesK_flips(int arr[],int k){ 
        int count = 0;
        int len = 0;
        int i=0 , j=0;
        while(i<arr.length && j<arr.length){
            while(count<=k && j<arr.length){
                if(arr[j]==0){
                    count++;
                    if(count==k+1){
                        j++;
                        break;
                    }
                }
                len = Math.max(len, j-i+1);
                j++;
            }
            while(count>k && i<arr.length){
                if(arr[i]==0){
                    i++;
                    count--;
                    break;
                }
                i++;
            }
        }
        System.out.println(len);
    }

    public static int longestSubstringWithAtMostKUniqueCharacters(String s, int k) {
		HashMap<Character, Integer> map  = new HashMap<>();
        int i=0, j=0;
        int len = 0;
        boolean aquire = true;
        // ("aabcbcdbca", 2);
        while(true){
            boolean f1= false, f2 = false;
            // aab cbc dbca
            while(j<s.length() && aquire){
                char ch = s.charAt(j);
				
                if(map.containsKey(ch)==false){
					// System.out.println(i+" "+j+" "+ch);
                    map.put(ch, 1);
                    if(map.size()>k){
                        aquire = false;
                    }else
						len = Math.max(len, j-i+1);
                }else{
					// System.out.println(i+" "+j+" "+ch);
                    map.put(ch, map.get(ch)+1);
                    len = Math.max(len, j-i+1);
                }
				j++;
                f1 = true;
            }
            while(i<s.length() && aquire==false){
                char ch = s.charAt(i);
                if(map.get(ch)==1){
                    map.remove(ch);
                    aquire = true;
                }else{
                    map.put(ch, map.get(ch)-1);
                }
                f2 = true;
				i++;
            }
            if(f1==false && f2==false)
                break;

        }
		return len;
	}
	
    public static void countOf_SubstringWithAtMostKUniqueCharacters(String s, int k){
        HashMap<Character, Integer> map  = new HashMap<>();
        int i=0, j=0;
        int len = 0, count=0;
        boolean aquire = true;
        // ("aabcbcdbca", 2);
        while(true){
            boolean f1= false, f2 = false;
            // aab cbc dbca
            while(j<s.length() && aquire){
                char ch = s.charAt(j);
				
                if(map.containsKey(ch)==false){
					// System.out.println(i+" "+j+" "+ch);
                    map.put(ch, 1);
                    if(map.size()>k){
                        aquire = false;
                    }else{
						len = Math.max(len, j-i+1);
                        count+=j-i;
                    }
                }else{
					// System.out.println(i+" "+j+" "+ch);
                    map.put(ch, map.get(ch)+1);
                    len = Math.max(len, j-i+1);
                    count+=j-i;
                }
				j++;
                f1 = true;
            }

            while(i<s.length() && aquire==false){
                char ch = s.charAt(i);
                if(map.get(ch)==1){
                    map.remove(ch);
                    aquire = true;
                }else{
                    map.put(ch, map.get(ch)-1);
                }
                f2 = true;
				i++;
            }
            if(f1==false && f2==false)
                break;

        }
        System.out.println(count);
    }

    public static void countOf_SubstringWithExactlyKUniqueCharacters(String s, int k){
        // countAtMost(s,k) - countAtMost(s, k-1);
    }
    public static void equivalentSubarray(int arr[]){
        // 1. You are given an array of integers(arr).
        // 2. You have to find the count of equivalent subarrays.
        // 3. A subarray is equivalent if,
        //    count of unique integers in the subarray = count of unique integers in the given array.
        // count of substring with exactly k unique characters here k is distinct elenmts in arr
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }
        int k = set.size();
    }


    //  practice

    static void groupAnagram(String arr[]){
        // abac baca d pq qp
        // String arr[] = {"pepcoding", "codingpep", "pepper", "rapper", "repepp"};
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        HashMap<HashMap<Character , Integer> , ArrayList<String>> map = new HashMap<>();

        for(String s: arr){
            HashMap<Character, Integer> temp = new HashMap<>();
            for(int j=0; j<s.length();j++){
                char ch = s.charAt(j);
                temp.put(ch, temp.getOrDefault(ch, 0)+1);
            }   
            if(map.containsKey(temp)){
                ArrayList<String> al = map.get(temp);
                al.add(s);
            }else{
                ArrayList<String> al = new ArrayList<>();
                al.add(s);
                map.put(temp, al);
            }
        }

        for(ArrayList<String> val: map.values()){
            ans.add(val);
        }
        System.out.println(ans);
    }

    public static ArrayList<ArrayList<String>> groupShiftedStrings(String[] strs) {
        // abc efg  d lnp rtu
        HashMap<String , ArrayList<String>> map = new HashMap<>();

        for(String s: strs){
            char prev = s.charAt(0);
            String key  =  "*";
            for(int i=1;i<s.length();i++){
                char curr = s.charAt(i);
                int diff = curr - prev;
                if(diff<0)
                    diff+=26;
                prev = curr;
                key+=diff+"*";
            }
            if(map.containsKey(key)){
                ArrayList<String> al =map.get(key);
                al.add(s);
            }else{
                ArrayList<String> al = new ArrayList<>();
                al.add(s);
                map.put(key, al);
            }
        }
        ArrayList<ArrayList<String>> ans=  new ArrayList<>();
        for(ArrayList<String> al: map.values()){
            ans.add(al);
        }

		return null;
	}

    public static void maxConsecutiveOne(int arr[], int k){
        // 1,1,0,0,1,1,1
        int count = 0 , len=0, i=0, j=0;
        boolean release = false;

        while(true){
            while(j<arr.length && release==false){
                count+= arr[j++]==0 ? 1: 0;
                release= count>k? true: false;
                len = release==false? Math.max(len, j-i): len; 
            }

            while(i<arr.length && release){
                count-=arr[i++]==0? 1:0;
                release = count<=k? false: true;
            }

            if(j==arr.length)
                break;
        }
        System.out.println(len);
    }

    public static void longestSubstringWithAtMostKUniqueCharacter(String s, int k){
        // aabcbcdbca
        HashMap<Character, Integer> map = new HashMap<>();
        int i=0, j=0, len=0;
        boolean release = false;
        while(true){
            while(j<s.length() && release==false){
                char ch = s.charAt(j++);
                map.put(ch, map.getOrDefault(ch, 0)+1);
                release = map.size()>k ? true: false;
                len = release==false? Math.max(len, j-i): len;
            }
            while(i<s.length() && release==true){
                char ch = s.charAt(i++);
                if(map.get(ch)==1){
                    map.remove(ch);
                    release= false;
                }else
                    map.put(ch, map.get(ch)-1);
            }
            if(j>=s.length())
                break;
        }
        System.out.println(len);
    }

    public static void countOf_SubstringWithAtMostKUniqueCharacter(String s, int k){
        //  aabc    bcdbca  2  
        HashMap<Character, Integer> map = new HashMap<>();
        int i=0, j=0, maxLen=0, count=0;
        boolean release = false;

        while(true){
            while(j<s.length() && release==false){
                char ch = s.charAt(j);
                if(map.containsKey(ch)==false && map.size()==k){
                    release=true;
                }else{
                    map.put(ch, map.getOrDefault(ch, 0)+1);
                    j++;
                    count+=j-i;
                }

            }
            while(i<s.length() && release){
                char ch = s.charAt(i++);
                if(map.get(ch)==1){
                    map.remove(ch);
                    release= false;
                }else
                    map.put(ch, map.get(ch)-1);
                // System.out.println("releas "+ i+" "+j+" "+count);
            }
            if(j==s.length())
                break;
        }
        System.out.println(count);

    }

    public static void main(String[] args) {
        // int arr[] = {1,1,0,0,1,1,1};
        // maxConsecutiveOne(arr, 1);
        // longestSubstringWithAtMostKUniqueCharacter("aabcbcdbca", 2);
        countOf_SubstringWithAtMostKUniqueCharacter("aabcbcdbca",2);


    }
}
