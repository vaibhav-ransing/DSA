public class CoinCombination {
    

    public static void solution(int sum, int[] arr){
        helper(sum, 0, arr, 0, "");
    }

    public static void helper(int sum, int idx, int arr[], int currSum, String pattern){
        if(currSum == sum){
            System.out.println(pattern);
            return;
        }
        if(idx >= arr.length)
            return;

        helper(sum, idx+1, arr, currSum, pattern); // dont take
        helper(sum, idx+1, arr, (currSum + arr[idx]), pattern+arr[idx]+"-");
    }


    public static void main(String[] args) {
        int arr[] = {5,2,3,5,6,7};
        int sum = 12;
        solution(sum, arr);
    }
}
