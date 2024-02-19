import java.util.Arrays;

public class PrintPermutation {
    
    public static void printPermutation(int n, int boxes){
        int[] boxArr = new int[boxes];
        boolean[] used = new boolean[n];
        // numberChooses(n, used, boxArr, 0);
        numberChooses(boxArr, 1, n);
    }

    public static void numberChooses(int n, boolean[] used, int[] boxArr, int count){
        if(count == boxArr.length){
            System.out.println(Arrays.toString(boxArr));
            return;
        }
        for(int i=1; i<=n; i++){
            if(!used[i-1]){
                used[i-1] = true;
                boxArr[count] = i;
                numberChooses(n, used, boxArr, count+1);
                used[i-1] = false;
            }
        }
    }
    
    public static void numberChooses(int[] boxArr, int ci, int n){
        
        if(ci == n ){
            System.out.println(Arrays.toString(boxArr));
            return;
        }
        
        for(int i=0; i<boxArr.length; i++){
            if(boxArr[i] == 0){
                boxArr[i] = ci;
                numberChooses(boxArr, ci + 1, n);
                boxArr[i] = 0;
            }
        }

    }

    public static void boxChooses(int[] boxArr, int idx, int count){
        if(idx == boxArr.length && count == boxArr.length){
            System.out.println(Arrays.toString(boxArr));
            return;
        }
        if(idx == boxArr.length && count != boxArr.length){
            return;
        }

        boxChooses(boxArr, idx, count);
        
    }
    

    public static void main(String[] args) {
        printPermutation(4, 2);
    }
}