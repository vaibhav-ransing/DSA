package First10;

public class MaxScore {

    public static int ans;

    public static int solution(String[] words, int[] farr, int[] score) {
        // write your code here
        ans = 0;
        helper(words, farr, score, 0, 0);
        System.out.println(ans);
        return 0;
    }

    public static void helper(String[] words, int[] farr, int[] score, int idx, int count) {

        if (idx == words.length) {
            ans = Math.max(ans, count);
            return;
        }

        for (int i = idx; i < words.length; i++) {
            String word = words[i];
            int currCount = fitWord(word, farr, score);
            helper(words, farr, score, idx + 1, count + currCount);
            if (currCount != 0) {
                for (char ch : word.toCharArray()) {
                    farr[ch - 'a']++;
                }
            }
        }
    }

    public static int fitWord(String word, int[] freqArr, int[] score) {
        int count = 0;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int idx = (int) (ch - 'a');
            if (freqArr[idx] > 0) {
                freqArr[idx] -= 1;
                count += score[idx];
            } else {
                for (int j = i - 1; j >= 0; j--) {
                    ch = word.charAt(j);
                    idx = (int) (ch - 'a');
                    freqArr[idx] += 1;
                    count -= score[idx];
                }
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // dog cat dad good
        // a b c d d d g o o
        // 1 1 1 3 0 0 1 0 0 0 0 0 0 0 2 0 .....
        // 1 0 9 5 0 0 3 0 0 0 0 0 0 0 2 0 0 0 0 0 0 0 0 0 0 0

        String words[] = { "dog", "cat", "dad", "good" };
        int[] freAerr = { 1, 1, 1, 3, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        int score[] =   { 1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        solution(words, freAerr, score);
    }
}
