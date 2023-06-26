package Archit.Course2.BinarySearc.Day2;

public class GuessNoHigherOrLower {
    
    public int guess(int num){
        return -1;
    }

    public int guessNumber(int n) {
        long left = 1, right=n;

        while(left <= right){
            long mid = (left+right)/2;
            int guess = guess( (int) mid);
            if(guess==-1){
                right = mid-1;
            }else if(guess==1){
                left = mid+1;
            }else{
                return (int) mid;
            }
        }
        return -1;
    }
}
