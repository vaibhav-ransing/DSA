package First20;

import java.util.ArrayList;

public class PartiionInkSubsetEqualSum {

    public static void printPartition(int[] arr, int k) {
        ArrayList<ArrayList<Integer>> kPartionList = new ArrayList<>();
        for(int i=0; i<k; i++){
            kPartionList.add(new ArrayList<>());
        }
        helper(arr, k, 0, kPartionList);
    }

    public static void helper(int[] arr, int k, int idx, ArrayList<ArrayList<Integer>> kPartionList) {
        if (idx >= arr.length) {
            if(isValid(kPartionList) && k==0){
                System.out.println(kPartionList);
            }
            return;
        }

        for (int i = 0; i < kPartionList.size(); i++) {
            ArrayList<Integer> currList = kPartionList.get(i);
            if (currList.size() > 0) {
                currList.add(arr[idx]);
                helper(arr, k, idx + 1, kPartionList);
                currList.remove(currList.size()-1);
            } else {
                currList.add(arr[idx]);
                helper(arr, k - 1, idx + 1, kPartionList);
                currList.remove(currList.size()-1);
                break;
            }
        }
    }

    public static boolean isValid(ArrayList<ArrayList<Integer>> list) {
        int v1 = 0;
        for(int i=0; i<list.size(); i++){
            ArrayList<Integer> tempList = list.get(i);
            int currVal = 0;
            for(int val : tempList){
                if(i==0){
                    v1+=val;
                }
                currVal += val;
            }
            if(currVal != v1){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {9,5,4,9};
        printPartition(arr, 3);
    }
}