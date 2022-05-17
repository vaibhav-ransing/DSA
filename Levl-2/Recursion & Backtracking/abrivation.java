public class abrivation {
    


    static void solution(String str, int i, String asf, int count){
        if(i==str.length()){
            System.out.println(asf+(count==0? "":count));
            return;
        }

        solution(str, i+1, asf+(count==0?"":count)+str.charAt(i), 0);
        solution(str, i+1, asf, count+1);

    }

    public static void main(String[] args) {
        solution("pep", 0, "", 0);
    }
}
