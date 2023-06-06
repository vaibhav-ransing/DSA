package Course2.Strings.Day2;

public class StringCompression {

    String encode(String str) {
        int left = 0;
        int right = 0;
        int count=0;
        StringBuilder ans = new StringBuilder();

        while(left<str.length() && right<str.length()){
            while(right<str.length() && str.charAt(left)==str.charAt(right)){
                right++;
                count++;
            }
            ans.append((str.charAt(left)+(count+"")));
            left = right;
            count=0;
        }
        return ans.toString();
	}
}
