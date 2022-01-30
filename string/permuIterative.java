public class permuIterative {
    

    static void solution(String s){
        int permutations=1;
        int n = s.length();
        for(int i=2; i<=n;i++){
            permutations = permutations*i;
        }
        for(int i=0; i<permutations;i++)
            print(s, i);
    }

    static void print(String str, int val){

        StringBuilder ans = new StringBuilder();
        StringBuilder s = new StringBuilder(str);
        int n = str.length();

        for(int i=n; i>=1;i--){
            int coeff = val/i;
            int remainder = val - i*coeff;
            ans.append(s.charAt(remainder));
            s.delete(remainder, remainder+1);
            val = coeff;

        }
        
        System.out.println(ans);

    }

    public static void main(String[] args) {
        solution("abc");

    }
}
