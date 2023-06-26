package Arrays.Day2;

public class test {
    
    public static  int nextGreaterElement2(int n) {
        String tempN = n+"";
        char[] arr = tempN.toCharArray();
        int firstMinIdx = -1;
        for(int i=arr.length-2; i>=0; i--){
            if(arr[i] <= arr[i+1]){
                firstMinIdx = i;
                break;
            }
        }
        if(firstMinIdx == -1) return -1;
        
        for(int i=arr.length-1; i>=firstMinIdx; i--){
            if(arr[i] > arr[firstMinIdx]){
                swap(arr, firstMinIdx, i);
                break;
            }
        }
        
        int start = firstMinIdx+1, end = arr.length-1;
        while(start<end){
            swap(arr, start, end);
            start++;
            end--;
        }
        for(char v : arr){
            System.out.print(v+" ");
        }
        long numb = Long.parseLong(new String(arr));
        return (int) numb;
    }
    public static  void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        nextGreaterElement2(230241);
    }
}
