package CP.Bits;

public class ReverseBits {
    
    public int swap(int n, int left, int right){
        int leftMask = (1<<left);
        int rightMask = (1<<right);

        boolean isLeftBitSet = (n&leftMask)!=0 ;
        boolean isRightBitSet = (n&rightMask)!=0;

        if(isLeftBitSet != isRightBitSet){
            n = n^leftMask;
            n = n^rightMask;
        }
        return n;
    }
    public int reverseBits(int n) {
        int left = 0; 
        int right = 31;
        while(left<=right){
            n = swap(n, left, right);
            left++; right--;
        }
        return n;
    }

    public static int swapBits(int n) 
    {
        for(int i=0; i<32; i+=2){
            
        }
        return 1;
	}


    public static void main(String[] args) {
        
    }
}
