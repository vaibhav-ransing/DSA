
public class Abbriviation {
    
    public static void solution(String str, String asf,int count, int idx){
        // pep
        if(idx==str.length()){
            System.out.println(count==0?asf:asf+count);
            return;
        }
        solution(str, count==0?asf+str.charAt(idx):asf+count+str.charAt(idx) , 0, idx+1);
        solution(str, asf, count+1, idx+1);
    }

    public static void usingBit(String str){
        int n =str.length()-1;
        int mask = 1<<n;
        mask = (mask - 1) | mask;
        System.out.println(Integer.toBinaryString(mask));
        for(int i=0; i<=mask; i++){
            System.out.println("i "+i);
            String ans = "";
            int count = 0;
            int idx = 0;
            while(idx!=32 && idx<str.length()){
                if((i&(1<<idx))==1){
                    count++;
                }else{
                    ans = count==0?(str.charAt(n-idx)+ans):(str.charAt(n-idx)+(count+ans));
                    count=0;
                }
                idx++;
            }
            System.out.println(ans);
        }
    }

    public static void main(String[] args) {
        usingBit("pep");
    }
}
