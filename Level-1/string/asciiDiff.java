public class asciiDiff {

    static void diff(String str){
        StringBuilder s = new StringBuilder(str);
        StringBuilder ans = new StringBuilder();

        for(int i=0; i<s.length()-1;i++){
            int charDiff = s.charAt(i) - s.charAt(i+1);
            ans.append(s.charAt(i));
            ans.append(charDiff);
        }
        ans.append(s.charAt(s.length()-1));
        System.out.println(ans);


    }


    public static void main(String[] args) {
        diff("pepCODinG");
    }
}
