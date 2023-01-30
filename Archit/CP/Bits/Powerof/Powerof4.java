package CP.Bits.Powerof;

public class Powerof4 {

    public boolean isPowerOfFour(int n) {
        if((n&(n-1))!=0){
            return false;
        }
        for(int i=0; i<32; i++){
            int mask = (1<<i);
            if((mask&i) != 0){
                if((i&1)==0){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isPowerOfFweour(int n) {
        if ((n&(n-1))==0 && (n%3)==1 ) return true;
        return false;
     }
}
