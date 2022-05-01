import java.util.*;

public class maxScore {

	public static int solution(String[] words, int[] farr, int[] score, int idx, int ans) {
		//write your code here
        if(idx==words.length){
            return ans;
        }
        int scoreCount= 0;
        int dont = solution(words, farr, score, idx+1, ans);
        scoreCount = Math.max(scoreCount, dont);

        String word1 = words[idx];
        if(canFit(word1, farr)){

            for(int i=0;i<word1.length();i++){
                char ch = word1.charAt(i);
                ans+= score[ch-'a'];
                farr[ch-'a']--;
            }

            scoreCount = Math.max(scoreCount, solution(words, farr, score, idx+1, ans));

            for(int i=0;i<word1.length();i++){
                char ch = word1.charAt(i);
                farr[ch-'a']++;
            }
        }
		return scoreCount;
	}
    static boolean canFit(String word1,int[] farr ){
        int temp[] = new int[26];
        for(int i=0;i<word1.length();i++){
            char ch = word1.charAt(i);
            temp[ch-'a']++;
        }
        for(int i=0;i<farr.length;i++){
            if(farr[i] < temp[i])
                return false;
        }
        return true;
    }

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int nofWords = scn.nextInt();
		String[] words = new String[nofWords];
		for(int i = 0 ; i < words.length; i++) {
			words[i] = scn.next();
		}
		int nofLetters = scn.nextInt();
		char[] letters = new char[nofLetters];
		for (int i = 0; i < letters.length; i++) {
			letters[i] = scn.next().charAt(0);
		}
		int[] score = new int[26];
		for (int i = 0; i < score.length; i++) {
			score[i] = scn.nextInt();
		}
		if (words == null || words.length == 0 || letters == null || letters.length == 0 || score == null
				|| score.length == 0) {
			System.out.println(0);
			return;
		}
		int[] farr = new int[score.length];
		for (char ch : letters) {
			farr[ch - 'a']++;
		}
		System.out.println(solution(words, farr, score, 0, 0));

	}
}