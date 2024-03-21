public class MaxScore {
    
    public static int maxScoreWords(String[] words, char[] letters, int[] score) {
        int letterCount[] = new int[26];
        for(char ch: letters){
            letterCount[ch-'a']++;
        }
        int ans = helper(words, letterCount, score, 0, 0);
        System.out.println(ans);
        return ans;
    }

    public static int helper(String[] words, int[] letterCount, int[] score, int idx, int ans) {
        if(idx==words.length){
            return ans;
        }
        
        String word = words[idx];
        pair p = isSafe(word, letterCount, score);  
        int take = helper(words, p.letterCount, score, idx+1, ans+p.src);
        int dont = helper(words, letterCount, score, idx+1, ans);

        return Math.max(ans, Math.max(take, dont));
    }
    
    public static pair isSafe(String word, int[] letterCount, int[] score){
        int[] temp = letterCount;
        int scr = 0;
        for(char ch: word.toCharArray()){
            temp[ch-'a']--;
            if(temp[ch-'a']<0){
                return new pair(letterCount, 0);
            }
            scr += score[ch-'a'];
        }
        
        return new pair(temp, scr);
    }
    static class pair{
        int[] letterCount;
        int src;
        pair(int[] letterCount, int src){
            this.src = src;
            this.letterCount = letterCount;
        }
    }


    public static void main(String[] args) {
        String[] words = {"dog", "cat", "dad", "good"};
        char[] letters = {'a','b','c','d','d','d','g','o','o'};
        int[] score =  {1,0,9,5,0,0,3,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0};
        maxScoreWords(words, letters, score);
    }
}
