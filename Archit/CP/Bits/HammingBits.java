package CP.Bits;

public class HammingBits {
    

    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x^y);
    }

}
