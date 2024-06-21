public class CountAndSay {

    public static String countAndSay(int n) {
        return helper("1", n - 1);
    }

    public static String helper(String str, int n) {
        if (n == 0)
            return str;

        int i = 0, j = 0, count = 0;
        StringBuilder sb = new StringBuilder();

        while (j < str.length()) {
            while (j < str.length() && str.charAt(j) == str.charAt(i)) {
                j++;
                count++;
            }
            sb.append(count + "" + str.charAt(i));
            i = j;
            count = 0;
        }
        return helper(sb.toString(), n - 1);
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }

}