import java.io.*;
import java.util.*;

public class Main {

    static void graph(boolean arr[][]){
        boolean visited[] = new boolean[arr.length];
        int count = -1;
        for(int i=0;i<arr.length;i++){
            if(visited[i]==false){
                helper(arr, visited, i);
                count++;
            }
        }
        System.out.println(count);
    }
    static void helper(boolean arr[][], boolean visited[], int index){
        if(visited[index])  
            return;
        visited[index] = true;
        System.out.println("visited "+index);
        for(int i=0;i<arr[0].length;i++){
            if(arr[index][i]==true && visited[i]==false){
                helper(arr, visited, i);
            }
        }
    }
    
    static void stringReducer(String s){
        String ans = "";
        char prev = s.charAt(0);
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)!=prev){
                ans+=prev;
                prev = s.charAt(i);
            }
        }
        if(ans.charAt(ans.length()-1)!=prev)
            ans+=prev;
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {

        boolean arr[][] = {{false, true, false,false,true},
                            {true, false,false,false,false},
                            {false,false,false,true,false},
                            {false,false,true,false,false},
                            {true, false,false,false,false}};
        // graph(arr);
        stringReducer("ghhrkkb");

    }
}