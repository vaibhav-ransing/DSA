import java.util.Scanner;

public class kpc {
    
    static void printKpc(String val, StringBuilder ans,int index){

        if(index== val.length()){
            System.out.println(ans);
            return;
        }

        char num = val.charAt(index);
        String s = kpcArr[num- '0'];

        for(int i=0; i<s.length();i++){
            
            ans.append(s.charAt(i));
            printKpc(val, ans, index+1);   
            ans.delete(ans.length()-1, ans.length());
            // index--;
        }

    }
    static void printKpcRc(String val, String ans,int index){

        if(index== val.length()){
            System.out.println(ans);
            return;
        }

        char num = val.charAt(index);
        String s = kpcArr[num- '0'];

        for(int i=0; i<s.length();i++){
            printKpcRc(val, ans+s.charAt(i), index+1);   
        }
    }
      
    static String kpcArr[] = {".;", "abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // String val  = sc.nextLine();
        String val = "678";
        StringBuilder ans = new StringBuilder();
        int index=0;
        // printKpc(val, ans, index);
        printKpcRc(val, "", index);

    }
}

// import java.util.ArrayList;
// import java.util.Scanner;

// public class kpc {
    
//     static void printKpc(String val, StringBuilder ans,int index, ArrayList<String> al){

//         if(index== val.length()){
//             al.add(ans.toString());
//             return;
//         }

//         char num = val.charAt(index);
//         String s = kpcArr[num- '0'];

//         for(int i=0; i<s.length();i++){
            
//             ans.append(s.charAt(i));
//             printKpc(val, ans, index+=1, al);   
//             ans.delete(ans.length()-1, ans.length());
//             index--;
//         }

//     }
      
//     static String kpcArr[] = {".;", "abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         String val = sc.nextLine();
//         StringBuilder ans = new StringBuilder();
//         int index=0;
//         ArrayList<String> al  = new ArrayList<>();
//         printKpc(val, ans, index, al);

//     }
// }
