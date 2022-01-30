import java.util.ArrayList;
import java.util.Scanner;

public class subSeq {
    
    static void print(String str, int index, StringBuilder ans, ArrayList<String> al){
        
        if(index==str.length()){
            // System.out.println(ans);
            al.add(ans.toString());
            return;
        }
        // abc
        // ""
        print(str, index+1, ans,al);
        ans = ans.append(str.charAt(index));
        
        print(str, index+1, ans, al);
        ans = ans.delete(ans.length()-1, ans.length());
    }
    public static ArrayList<String> gss(String str) {
        ArrayList<String> al = new ArrayList<>();
        StringBuilder ans = new StringBuilder();
        print(str, 0, ans, al);
        return al;
    }                             

    public static void main(String[] args) {
        // String str ="abc";
        StringBuilder ans = new StringBuilder();
        // print(str, 0, ans);

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        ArrayList<String> al = gss(str);
        System.out.println(al);
    }
}
