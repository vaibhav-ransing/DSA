public class TwoStringsAreSame {

    public boolean arrayStringsAreEqual2(String[] word1, String[] word2) {

        int i = 0, j = 0;
        int idx1 = 0, idx2 = 0;

        while (idx1 < word1.length && idx2 < word2.length) {

            String w1 = word1[idx1];
            String w2 = word2[idx2];

            if (w1.charAt(i) != w2.charAt(j))
                return false;
                
            i++;
            j++;

            if(i == w1.length()){
                i = 0;
                idx1++;
            }
            if(j == w2.length()){
                j = 0;
                idx2++;
            }
        }
        return idx1 == word1.length && idx2 == word2.length;
    }
}
