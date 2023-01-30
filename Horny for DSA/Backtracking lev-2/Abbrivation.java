public class Abbrivation{

    static void subsequence(String s,String ans, int i){
        if(s.length()==i){
            System.out.println(ans);
            return;
        }
        subsequence(s, ans+s.charAt(i), i+1);
        subsequence(s, ans, i+1);
    }
    //          abbrivation(pep, p, 2, 1)
    static void abbrivation(String s, String ans, int i, int count){
        if(i==s.length()){
            if(count==0){
                System.out.println(ans);
            }else{
                System.out.println(ans+count);
            }
            return;
        }

        abbrivation(s, count!=0?ans+count+s.charAt(i):ans+s.charAt(i), i+1, 0);
        abbrivation(s, ans, i+1, count+=1);
    }

    public static void main(String[] args) {
        abbrivation("pep", "", 0, 0);
    }
}