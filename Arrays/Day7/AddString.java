package Day7;

public class AddString {

    public String addStrings(String num1, String num2) {
        
        int p1 = num1.length()-1;
        int p2 = num2.length()-1;
        int carry = 0;
        StringBuilder res = new StringBuilder();

        while(p1>=0 || p2>=0){
            int v1 = p1>=0? (int)(num1.charAt(p1) - '0') : 0;
            int v2 = p2>=0? (int)(num2.charAt(p2) - '0') : 0;
            int total = v1 + v2 + carry;
            res.append(total%10);
            carry = total/10;
            p1--;
            p2--;
        }
        if(carry != 0) res.append(carry);
        return res.reverse().toString();
    }

    public static void main(String[] args) {

    }
}
