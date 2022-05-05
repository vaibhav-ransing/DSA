import java.util.ArrayList;

public class kSubsetEqualSum {
    
    static void solution(int arr[], int k, int index, ArrayList<ArrayList<Integer>> ans){
        if(index==arr.length){
            if(k==0 && isSumEqual(ans)){
                String ansF = "";
                for(ArrayList<Integer> temp: ans){
                    ansF+=temp+" ";
                }
                System.out.println(ansF);
            }
            return;
        }

        for(int i=0; i<ans.size(); i++){
            ArrayList<Integer> temp = ans.get(i);
            if(temp.size()>0){
                temp.add(arr[index]);
                solution(arr, k, index+1, ans);
                temp.remove(temp.size()-1);
            }else{
                temp.add(arr[index]);
                solution(arr, k-1, index+1, ans);
                temp.remove(temp.size()-1);
                break;
            }
        }
    }
    static boolean isSumEqual(ArrayList<ArrayList<Integer>> ans){
        int prevSum = -1;
        for(ArrayList<Integer> list: ans){
            int sum=0;
            for(int val: list){
                sum+=val;
            }
            if(prevSum==-1){
                prevSum = sum;
            }else{
                if(prevSum!=sum)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};
        int k = 3;  
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        solution(arr, k, 0, ans);

    }
}
