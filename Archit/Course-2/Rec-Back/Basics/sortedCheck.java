public class sortedCheck {

    boolean arraySortedOrNot(int[] arr, int n) {
        return helper(arr, 1);
    }
    boolean helper(int[] arr, int i){
        if(i==arr.length){
            return true;
        }
        if(arr[i]<arr[i-1]){
            return false;
        }else{
            return helper(arr, i+1);
        }
    }

    public void reverseString(char[] s) {
        int i=0, j=s.length ;
        while(i<j){
            char temp = s[i];
            s[i] = s[j];
            s[j]=temp;
            i++;
            j--;
        }
    }
}
