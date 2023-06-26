package Archit.Course2.BinarySearc.Day1;


public class TransitionPoint {

    public static int soln(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right)/2;
            if(arr[mid]==0){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        
    }
}
