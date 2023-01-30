package CP.Bits;

public class copySetBits {
    

    static int setSetBit(int x, int y, int l, int r){
        for(int bit = l-1; bit<r; bit++){
            int mask = (1<<bit);
            if((y&mask)!=0){
                x = (x | mask);
            }
        }
        return x;
    }

    public static void main(String[] args) {
        
    }
}
