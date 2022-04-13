import java.util.Arrays;

class  fp{

    static void printPair(int arr[], int givenSum){

        Arrays.sort(arr);
        for(int i=0, j=arr.length-1; i<j; ){
            int sum = arr[i]+arr[j];
            if(sum==givenSum){
                System.out.println("i "+arr[i]+" j "+arr[j]);
                i++; j--;
            }
               
            else if(sum<givenSum)
                i++;
            else
                j--;
        }
    }

    public static void main(String[] args) {
        int arr[] = {6,2,8,4,3,5};
        printPair(arr, 8);
    }
}