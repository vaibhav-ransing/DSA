import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class day3 {
    
    static void findPair_i_j(int arr[]){
        // arr[j] - arr[i] = j-i         
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++)
            arr[i] = arr[i]-i;
        
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            }else{
                map.put(arr[i], 1);
            }
        }
        int count=0;
        for( int key: map.keySet()){
            int total = map.get(key);
            if(total>1){
                // int quo = factorial(total);
                // int rem = factorial(total-2)*2;
                // int val = quo/rem;
                // count+=val;
                count+= total*(total-1)/2;
            }
        }
    }
    static int factorial(int n){
        int ans = 1;
        while(n!=0){
            ans = ans*n;
            n--;
        }
        return ans;
    }

    static void uniqueElementsInKwindow(int arr[], int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        // 1 2 1 3 4 2 3        
        // 4
        for(int i=0;i<k;i++){
            int key = arr[i];
            map.put(key, map.getOrDefault(key, 0)+1);
        }
        System.out.print(map.size()+" ");
        for(int i=k;i<arr.length;i++){
            int key = arr[i];
            map.put(key, map.getOrDefault(key, 0)+1);

            int release = arr[i-k];
            if(map.get(release)==1)
                map.remove(release);
            else
                map.put(release, map.get(release)-1);
                
            System.out.print(map.size()+" ");
            System.out.println();
            
        }
    }

    static void employeeManager(String arr[]){
        // arr = AC, BC, CF, ...
        HashMap<Character, ArrayList<Character>> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            char parent = arr[i].charAt(1);
            char child = arr[i].charAt(0);
            if(parent==child){
                if(map.containsKey(child)==false){
                    ArrayList<Character> temp = new ArrayList<>();
                    map.put(child, temp);
                }
                continue;
            }

            if(map.containsKey(parent)){
                ArrayList<Character> temp = map.get(parent);
                temp.add(child);
                map.put(parent, temp);
            }else{
                ArrayList<Character> temp = new ArrayList<>();
                temp.add(child);
                map.put(parent, temp);
            }
            if(map.containsKey(child)==false){
                ArrayList<Character> temp = new ArrayList<>();
                map.put(child, temp);
            }

        } 

        for(char key: map.keySet()){
            int count = size(key, map);
            System.out.println(key+" "+(count-1));

        }
    }
    static int size(char parent, HashMap<Character, ArrayList<Character>> map){
        int res = 0;
        for(char child: map.get(parent)){
            res+=size(child, map);
        }
        return res+1;
    }

    static void longestConsequtiveOnes(int arr[]){
        int maxLen=0;
        int temp = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                maxLen = Math.max(maxLen, temp);
                temp=0;
            }else{
                temp++;
            }
        }
    }

    static boolean pairSumDivisibleByK(int arr[], int k){
        int freq[] = new int[k];
        for(int i=0;i<arr.length;i++){
            int key = arr[i]%k;
            freq[key]++;
        }
        int start=1;
        int end = k-1;

        while(start<end){
            if((freq[start]+freq[end])%2!=0)
                return false;
        }
        if((k%2==1 && freq[k%2]%2!=0) || freq[0]%2!=0 ){
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        // String arr[] = {"AC", "BC", "CF", "DE","EF","FF"};
        // employeeManager(arr);
        int arr[] = {1,2,1,3,4,2,3};
        uniqueElementsInKwindow(arr, 4);
    }
}
