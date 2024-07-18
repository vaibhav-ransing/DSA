public class MinLenAfterDDeelSimilarEnds {

    public int minimumLength(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if(s.charAt(i) != s.charAt(j)){
                break;
            }
            
        }
        return j - i + 1;
    }
}

// 1 3 6 6