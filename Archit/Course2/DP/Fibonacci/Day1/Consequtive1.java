package DP.Day1;

public class Consequtive1 {
    
    long countStrings(int n) {
        long prevOne = 1;
        long prevTwo = 1;

        for(int i=2; i<=n; i++){
            long currOne = prevOne + prevTwo;
            prevTwo = prevOne;
            prevOne = currOne;
        }
        return prevOne + prevTwo;
    }

    public static void main(String[] args) {
        
    }

}
