package Day7;

public class MultipyString {

    public String multiply(String num1, String num2) {
        String res = "0";
        int count = 0;

        for (int i = num2.length() - 1; i >= 0; i--) {
            int digit = num2.charAt(i) - '0';
            String temp = singleDigitMultiply(num1, digit);
            for (int c = 0; c < count; c++) {
                temp += "0";
            }
            res = addStrings(res, temp);
            count++;
        }
        if (res.charAt(0) == '0')
            return "0";
        return res;

    }

    public String singleDigitMultiply(String num, int digit) {

        StringBuilder ans = new StringBuilder();
        int carry = 0;
        int idx = num.length() - 1;

        while (idx >= 0) {
            int c2 = (int) (num.charAt(idx) - '0');
            int total = digit * c2 + carry;
            ans.append(total % 10);
            carry = total / 10;
            idx--;
        }
        if (carry != 0)
            ans.append(carry);
        return ans.reverse().toString();
    }

    public String addStrings(String num1, String num2) {

        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;
        int carry = 0;
        StringBuilder res = new StringBuilder();

        while (p1 >= 0 || p2 >= 0) {
            int v1 = p1 >= 0 ? (int) (num1.charAt(p1) - '0') : 0;
            int v2 = p2 >= 0 ? (int) (num2.charAt(p2) - '0') : 0;
            int total = v1 + v2 + carry;
            res.append(total % 10);
            carry = total / 10;
            p1--;
            p2--;
        }
        if (carry != 0)
            res.append(carry);
        return res.reverse().toString();
    }

}
