package Archit.Course2.BinarySearc.Day1;

public class FirstBadVersion {

    boolean isBadVersion(int version) {
        return true;
    }

    public int firstBadVersion(int n) {
        long left = 1, right = n;
        while (left <= right) {
            long mid = (left+right)/2;
            if(isBadVersion( (int) mid)){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return (int) left;
    }
}