public class abreviation{


    static void soln(String s,String ans, int count, int idx){
        if(idx==s.length()){
            if(count!=0) ans = ans+count;
            System.out.println(ans);
            return;
        }

        soln(s, ans+(count==0?"":count)+s.charAt(idx), 0, idx+1);
        soln(s, ans, count+1, idx+1);
    }

    public static void main(String[] args) {
        soln("pep", "", 0, 0);
    }
}