package Arrays.Day2;


public class JustGreater {

    public static void justGreaterNumber(String num) {
        int n = num.length() - 2;
        String ans = "";
        while (n >= 0) {
            if ((int) (num.charAt(n) - '0') < (int) (num.charAt(n + 1) - '0')) {
                break;
            }else{
                n--;
            }
        }
        System.out.println("n = "+ n);
        for(int i=n+1; i<num.length()-1; i++){
            if( (int) (num.charAt(n) ) < (int) (num.charAt(i) ) && 
            (int) (num.charAt(n) ) > (int) (num.charAt(i+1)) )  {
                // 6537421  654 7321
                Character temp = num.charAt(i);
                StringBuilder rem = new StringBuilder(num);
                rem.setCharAt(i, rem.charAt(n));
                rem.setCharAt(n, temp);
                StringBuilder toRev = new StringBuilder(rem.substring(n));
                toRev = toRev.reverse();
                ans = rem.substring(0, n+1) + toRev.toString();
                break;
            }
        }
        System.out.println(ans);
    }

    public static int nextGreaterElement2(int n) {
        String tempN = n+"";
        char[] arr = tempN.toCharArray();
        int firstMinIdx = -1;
        for(int i=arr.length-2; i>=0; i--){
            if(arr[i] < arr[i+1]){
                firstMinIdx = i;
                break;
            }
        }
        if(firstMinIdx == -1) return -1;
        for(int i=firstMinIdx+1; i<arr.length-2; i++){
            if(arr[i+1] > arr[firstMinIdx])
                continue;
            swap(arr, firstMinIdx, i);
        }
        int start = firstMinIdx+1, end = arr.length-1;
        while(start<end){
            swap(arr, start, end);
        }
        for(char val : arr){
            System.out.print(val+" ");
        }
        int number = Integer.parseInt(new String(arr));
        return number;
    }
    public static void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        justGreaterNumber("6537421");
        // 654 7321  -. 6541237
        nextGreaterElement2(6541237);
    }
}
