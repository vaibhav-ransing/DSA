import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class amazonQuestion {


    static void getMinSum(int n){
        StringBuilder s = new StringBuilder(Integer.toString(n));
        String p1="";
        String p2="";
        int len = s.length();
        for(int i=0;i<len;i++){
            // System.out.println("sInside "+s);
            if(i%2==0){
                int smallestDigit = findMin(s);
                p1 = p1+smallestDigit;
            }else{
                int smallestDigit = findMin(s);
                p2 = p2+smallestDigit;
            }
        }
        // System.out.println(p1);
        // System.out.println(p2);
        int p1Val = Integer.parseInt(p1);
        int p2Val = Integer.parseInt(p2);
        System.out.println(p1Val+p2Val);
    }
    static int findMin(StringBuilder s){
        int min=Integer.MAX_VALUE;
        int minIndex=0;
        for(int i=0;i<s.length();i++){
            int val= s.charAt(i)-'0';
            if(val<min)
                minIndex = i;
            min = Math.min(min, val);
        }
        // System.out.println("sPre "+s);
        s.delete(minIndex, minIndex+1);
        // System.out.println("sDeleted "+s);
        return min;
    }

    public static void main(String[] args) {
        // int n=4325;
        int n=867;
        getMinSum(n);
    }
}

// muddit

// class test {

//     static void add(String ques,String ans1,String ans2){
//         if(ques.length()%2!=0&&ques.length()==1){
//             ans1+=ques.charAt(0);
//             System.out.println(Integer.parseInt(ans1));
//             System.out.println(Integer.parseInt(ans2));
//             return;
//         }
//         if(ques.length()%2==0&&ques.length()==2){
//             ans1+=ques.charAt(0);
//             ans2+=ques.charAt(1);
//             System.out.println(ans1);
//             System.out.println(ans2);
//             return;
//         }
       
//         char ch=ques.charAt(0);
//         char ch2=ques.charAt(1);
//         add(ques.substring(2), ans1+ch, ans2+ch2);
//     }

//     static void add2(String ques,String ans1,String ans2){
        
//         if(ques.length()==0){
//             System.out.println(Integer.parseInt(ans1));
//             System.out.println(Integer.parseInt(ans2));
//             return;
//         }
        
//         if(ques.length()%2!=0){
//             char ch=ques.charAt(0);
//             add2(ques.substring(1), ans1+ch, ans2);
//         }
//         if(ques.length()%2==0){
//             char ch=ques.charAt(0);
//             add2(ques.substring(1), ans1, ans2+ch);
//         }
//     }

//     static String sort(String s,String n){
//         ArrayList<String> ch=new ArrayList<>();
        
//         for(int i=0;i<s.length();i++){  
//             String ns=""+s.charAt(i);
//             ch.add(ns);
//         }
//         Collections.sort(ch);
//         for(int i=0;i<s.length();i++){
//             n+=ch.get(i);
//         }
//         return n;
//     }
    

//     public static void main(String[] args) {
//         //Scanner sc=new Scanner(System.in);
//         int n=145678;
//         String s=Integer.toString(n);
//         String newS=sort(s, "");
//         System.out.println(newS);
        
//         add2(newS, "", "");
//     }
// }