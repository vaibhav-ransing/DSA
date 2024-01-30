package First20;

public class MaxNumberAfterKSwaps {

    public static void maxNumber(int n, int swaps) {
        String ans = helper(Integer.toString(n), swaps);
        System.out.println(ans);
    }

    public static String helper(String str, int swaps) {
        if (swaps == 0) {
            return str;
        }
        String maxStr = swapForMax(str);
        String remStr = helper(maxStr.substring(1), swaps - 1);

        return maxStr.substring(0, 1) + remStr;
    }

    public static String swapForMax(String str) {
        int maxIdx = 0;
        for (int i = 0; i < str.length(); i++) {
            int ch = str.charAt(i) - '0';
            if (ch > (int) (str.charAt(maxIdx) - '0')) {
                maxIdx = i;
            }
        }
        StringBuilder sb = new StringBuilder(str);
        int val = (int) (str.charAt(maxIdx) - '0');
        sb.deleteCharAt(maxIdx);
        return val + sb.toString();
    }

    public static void main(String[] args) {
        // swapForMax("65827");
        maxNumber(123456, 4);
    }
}
