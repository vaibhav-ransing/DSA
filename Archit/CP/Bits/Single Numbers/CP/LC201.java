
public class LC201 {
    public int rangeBitwiseAnd(int left, int right) {
        int lsb = Integer.highestOneBit(left^right);
        int res = left;
        while(lsb!=0){
            res = res& ~lsb;
            lsb = lsb >>1;
        }
        return res;
    }
}
