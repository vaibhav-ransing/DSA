package Course2.Strings.Day1;

public class AddOne {
    
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i=n-1; i>=0; i--){
            if(digits[i]==9){
                digits[i] = 0;
            }else{
                digits[i]++;
                return digits;
            }
        }
        int[] res = new int[n+1];
        res[0] = 1;
        return res;
    }


    public static void main(String[] args) {
        
    }
}
