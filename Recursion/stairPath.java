import java.util.Scanner;

class stairPath {
    

    static void print(int stairs, StringBuilder ans){    

        if(ansSum(ans, stairs)){
            System.out.println(ans);
            return;
        }
        if(ans.length()==stairs)
            return;
        for(int i=1;i<4;i++){
            ans.append(Integer.toString(i));
            print(stairs, ans);
            ans.delete(ans.length()-1,ans.length());
        }
    }
    
    static boolean ansSum(StringBuilder ans, int steps){
        int sum=0;
        for(int i=0;i<ans.length();i++){
            int dig = ans.charAt(i) - '0';
            sum+=dig;
        }
        if(sum==steps)
            return true;
        return false;
    }
    public static void main(String[] args) {
        StringBuilder ans = new StringBuilder(); 
        Scanner sc=  new Scanner(System.in);
        print(sc.nextInt(), ans);
    }
}

// import java.io.*;
// import java.util.*;

// class Main {

//     public static void main(String[] args) throws Exception {
        
//         Scanner sc = new Scanner(System.in);
//         int stairs = sc.nextInt();
//         System.out.println(getStairPaths(stairs));
//     }

//     public static ArrayList<String> getStairPaths(int n) {
//         ArrayList<String> al = new ArrayList<>();
//         StringBuilder ans = new StringBuilder();
//         print(n, ans, al);
//         return al;
//     }

//         static void print(int stairs, StringBuilder ans,ArrayList<String> al){    

//         if(ansSum(ans, stairs)){
//             al.add(ans.toString());
//             return;
//         }
//         if(ans.length()==stairs)
//             return;
//         for(int i=1;i<4;i++){
//             ans.append(Integer.toString(i));
//             print(stairs, ans,al);
//             ans.delete(ans.length()-1,ans.length());
//         }
//     }

//     static boolean ansSum(StringBuilder ans, int steps){
//         int sum=0;
//         for(int i=0;i<ans.length();i++){
//             int dig = ans.charAt(i) - '0';
//             sum+=dig;
//         }
//         if(sum==steps)
//             return true;
//         return false;
//     }


// }