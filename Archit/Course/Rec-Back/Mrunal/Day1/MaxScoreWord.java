import java.util.HashMap;

public class MaxScoreWord {
    

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int freqLetter[] = new int[26];
        for(char ch: letters){
            freqLetter[(int)(ch-'a')]++;
        } 
        return solution(words, freqLetter, score, 0, 0);
    }
    public int helper(String[] words, int[] letters, int[] score, int idx, int ans) {
        
        if(idx==words.length){
            return ans;
        }
        int take = 0;
        if(isSafe(words[idx], letters)){
            for(char ch: words[idx].toCharArray()){
                letters[(int)(ch-'a')]--;
            }
            int s = getScoreWord(words[idx], score);
            take = helper(words, letters, score, idx, ans+s);
            for(char ch: words[idx].toCharArray()){
                letters[(int)(ch-'a')]++;
            }
        }
        int dont = helper(words, letters, score, idx+1, ans);
        return Math.max(take, dont);
    }

    public boolean isSafe(String word, int[] letters){
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch: word.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        for(char ch: map.keySet()){
            int freq = map.get(ch);
            if(letters[(int)(ch-'a')]<freq){
                return false;
            }
        }
        return true;
    }

    public int getScoreWord(String word, int[] score){
        int val = 0;
        for(char ch: word.toCharArray()){
            val+= score[(int)(ch-'a')];
        }
        return val;
    }


    public  int solution(String[] words, int[] farr, int[] score, int idx, int ans) {
		//write your code here
        if(idx==words.length){
            return ans;
        }

        int scoreAns= 0;
        int dont = solution(words, farr, score, idx+1, ans);
        scoreAns = Math.max(scoreAns, dont);


        String word1 = words[idx];
        if(canFit(word1, farr)){

            for(int i=0;i<word1.length();i++){
                char ch = word1.charAt(i);
                ans+= score[ch-'a'];
                farr[ch-'a']--;
            }

            scoreAns = Math.max(scoreAns, solution(words, farr, score, idx+1, ans));

            for(int i=0;i<word1.length();i++){
                char ch = word1.charAt(i);
                farr[ch-'a']++;
            }
        }
		return scoreAns;
	}
     boolean canFit(String word1,int[] farr ){
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
        char ch = 'c';
        System.out.println((int)(ch-'a'));
    }
}
