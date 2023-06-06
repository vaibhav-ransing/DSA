package Course2.Strings.Day1;

// lc 43
public class MultiplyTwoString {
    
    public String addStrings(String num1, String num2) {
        
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;
        int carry = 0;

        StringBuilder res = new StringBuilder();
        while(p1 >= 0 || p2 >= 0){
            int d1 = p1>=0 ? num1.charAt(p1) - '0' : 0;
            int d2 = p2>=0 ? num2.charAt(p2) - '0' : 0;
            int sum = d1 + d2 + carry;
            carry = sum/10;
            res.append(sum%10);
            p1--;
            p2--;
        }
        if(carry>0){
            res.append(carry);
        }
        return res.reverse().toString();
    }

    public String multiplySingle(String num, int dig){
        int p1 = num.length() - 1;
        int carry = 0;
        StringBuilder res = new StringBuilder(); 
        while(p1 >=0 || carry > 0 ){
            int d1 = (p1 >=0) ? num.charAt(p1) - '0' : 0;
            int prod = d1*dig + carry;
            res.append(prod%10);
            carry = prod/10;

            p1--;
        }
        // if(carry > 0) res.append(carry);
        return res.reverse().toString();
    }

    public String multiply(String num1, String num2) {
        String res = "0";
        int count = 0;

        for(int i=num2.length() - 1; i>=0; i--){
            int dig = num2.charAt(i) - '0';
            String temp = multiplySingle(num1, dig);
            for(int c=0; c<count; c++){
                temp+=0;
            }
            res = addStrings(res, temp);
            count++;
        }
        if(res.charAt(0) == '0') return "0";
        return res;
    }

}
