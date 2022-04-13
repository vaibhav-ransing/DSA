public class gb{
    static boolean goodBadNumber(int num){

        String bn = Integer.toBinaryString(num);
        System.out.println(bn);
        char prev = bn.charAt(0);
        for(int i=1;i<bn.length();i++){
           char ch = bn.charAt(i);
           if(prev == ch && ch=='1')
               return false;
           prev = ch;
            
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(goodBadNumber(11));
    }
}