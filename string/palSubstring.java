import java.util.Scanner;

public class palSubstring { 

    static boolean ispal(String s){
        int i=0;
        int j= s.length()-1;
        boolean f= true;
        while(j>i){
            if(s.charAt(i)!=s.charAt(j)){
                f = false;
                break;
            }
            i++;
            j--;
        }
        if(f){
            return true;
        }
        return false;
    }
    static void printPalSubs(String s){
        int n= s.length();
        for(int i=0;i<n;i++){
            for(int j=i+1; j<=n;j++){
                if(ispal(s.substring(i,j))){
                    System.out.println(s.substring(i, j));
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        printPalSubs(s);

        // System.out.println(ispal("abca"));
        // printPalSubs("abccd");
    }
}
