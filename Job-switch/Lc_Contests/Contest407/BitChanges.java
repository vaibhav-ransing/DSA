package Lc_Contests.Contest407;

public class BitChanges {
    public static int minChanges(int n, int k) {
        int count = 0;
        for(int i = 31; i>=0; i--){
            int nBit = n & (1 << i);
            int kBit = k & (1 << i);
            if(nBit != kBit){
                if(nBit == 0) return -1;
                count++;
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        // minChanges(14, 13);
        minChanges(13, 4);
    }
}
