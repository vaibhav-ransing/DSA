import java.util.ArrayList;

public class tugOfWar {
    
    static int minDiff = Integer.MAX_VALUE;
    static String ansF = "";
    static void solution(int arr[], int index, ArrayList<ArrayList<Integer>> ans, int left, int right, int sum1, int sum2){

        if(index==arr.length){
            if((left==right || left+1==right || left==right+1) ){

                int diff = sum1 - sum2;
                if(diff<0)
                    diff = -diff;

                if(minDiff> diff){
                    minDiff = diff;
                    ansF = "";
                    for( ArrayList<Integer> al: ans){
                        ansF+=al+" ";
                    }
                }
            }
            return;
        }

        ArrayList<Integer> list1 = ans.get(0);
        list1.add(arr[index]);
        solution(arr, index+1, ans, left+1, right, sum1+arr[index], sum2);
        list1.remove(list1.size()-1);

        ArrayList<Integer> list2 = ans.get(1);
        list2.add(arr[index]);
        solution(arr, index+1, ans, left, right+1, sum1 , sum2+arr[index]);
        list2.remove(list2.size()-1);
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        al.add(new ArrayList<>());
        al.add(new ArrayList<>());
        solution(arr, 0, al, 0, 0,0,0);
        System.out.println(ansF);
    }
}   
