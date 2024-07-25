public class maxConfusionExams {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int v1 = helper(answerKey, k, 'T');
        int v2 = helper(answerKey, k, 'F');
        return Math.max(v1, v2);
    }

    public int helper(String str, int k, char ch) {
        int i = 0, j = 0;
        int ans = 0;
        while (j < str.length()) {
            char curr = str.charAt(j);
            if (curr != ch)
                k--;
            while (k < 0) {
                if (str.charAt(i) != ch)
                    k++;
                i++;
            }
            ans = Math.max(ans, j - i + 1);
            j++;
        }
        return ans;
    }
}
