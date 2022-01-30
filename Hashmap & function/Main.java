import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


public class Main {
    
    public static Character maxFrequencyCharacter(String s){
        HashMap<Character , Integer> map = new HashMap<>();
        int max = 0;
        char ans = s.charAt(0);
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
                int val = map.get(c);
                if(val>max){
                    max = val;
                    ans = c;
                }
            }else{
                map.put(c, 1);
            }
        }
        return ans;
    }

    public static void printCommonElements(int[] arr1 , int arr2[]){
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i=0;i<arr1.length;i++){
            if(map.containsKey(arr1[i])){
                map.put(arr1[i] , map.get(arr1[i])+1); 
            }else{
                map.put(arr1[i], 1);
            }
        }
        for(int i=0;i<arr2.length;i++){
            if(map.containsKey(arr2[i])){
                
                System.out.println(arr2[i]);
                map.remove(arr2[i]);
            }
        }
    }

    public static void printConsequtiveElements(int arr[]){
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<arr.length;i++){
            map.put(arr[i], 1);
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max)
                max = arr[i];
            if(arr[i]<min)
                min = arr[i];
        }
        String ans = "";
        
        for(int i=0;i<map.size();i++){
            String temp = "";
            int val = arr[i];
            map.remove(arr[i]);
            for(int j=val-1; j>=min; j--){
                if(map.containsKey(j)){
                    temp = j+" "+temp;
                    map.remove(j);
                }else break;
            }
            for(int j = val+1; j<=max;j++){
                if(map.containsKey(j)){
                    int n = temp.length();
                    temp = temp+" "+j;
                    map.remove(j);
                }
                else break;
            }
            System.out.println(temp);
            if(temp.length()>ans.length())
                ans = temp;
        }
        System.out.println(ans);
        
    }

    public static void main(String[] args) {
        int arr[]  ={8,1,5,10,3,12,11,6,9,2};
        printConsequtiveElements(arr);








        // Scanner sc = new Scanner(System.in);
        // int n1 = sc.nextInt();
        // int arr1[] = new int[n1];
        // for(int i=0;i<n1;i++){
        //     arr1[i] = sc.nextInt();
        // }
        // int n2 = sc.nextInt();
        // int arr2[] = new int[n2];
        // for(int i=0;i<n2;i++){
        //     arr2[i] = sc.nextInt();
        // }
        // printCommonElements(arr1, arr2);
    }
}
