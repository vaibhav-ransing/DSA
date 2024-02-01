import java.util.Arrays;

public class Combination {

    public static void printCombinations(int n, int boxes){
        int[] boxArr = new int[boxes];
        int lastUsedNum = 1;
        int idx = 0;
        boxChooses(n, boxArr, lastUsedNum, idx);
    }


    public static void boxChooses(int n, int[] boxArr, int lastUsedNum, int idx){
        if(idx == boxArr.length){
            System.out.println(Arrays.toString(boxArr));
            return;
        }
        for(int i = lastUsedNum; i<=n; i++){
            boxArr[idx] = i;
            boxChooses(n, boxArr, i+1, idx+1);
        }
        
    }

    public static void main(String[] args) {
        printCombinations(4, 2);
    }
}