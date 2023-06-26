package Archit.Course2.BinarySearc.Day4;

public class SquareRoot {
    // lc 69

    public int mySqrtBinarySearch(int x) {
        long ans = 0;
        long left = 0, right = x;
        while(left<=right){
            long mid = (left+right)/2;
            if(mid*mid==x){
                return (int) mid;
            }else if(mid*mid<x){
                ans = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return (int) ans;
    }

    public boolean isPerfectSquare(int x) {
        long left = 0, right = x;
        while(left<=right){
            long mid = (left+right)/2;
            if(mid*mid==x){
                return true;
            }else if(mid*mid<x){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return false;
    }

    public int mySqrt(int x) {
        
        long ans = 0;
        for(long idx=1; idx<=x; idx++){
            if(idx*idx <=x)
                ans = idx;
            else
                break;
        }
        return (int) ans;
    }
}
