import java.util.ArrayList;

public class PartitionKSubset {

    public static void partion(int n, int k){
        boolean[] used = new boolean[n];
        soln(n, k+1, 0, "", used);
    }

    public static void soln(int n, int k, int idx, String ans, boolean[] used){
        if(idx==n ){
            if(k==1)
                System.out.println(ans);
            return;
        }
        if(used[idx]){
            soln(n, k, idx+1, ans, used);
        }else{
            used[idx] = true;
            if(k>1){
                soln(n, k-1, idx+1, ans+"-"+(idx+1), used);
            }
            for(int j=idx+1; j<n; j++){
                if(!used[j]){
                    used[j] = true;
                    soln(n, k-1, idx+1, ans+(idx+1)+""+(j+1), used);
                    used[j] = false;
                }
            }
            used[idx] = false;
        }
    }

    static  boolean finalAns;
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        finalAns = false;
		for(int i  = 0; i < k; i++) {
			ans.add(new ArrayList<>());
		}
        solution(1, nums.length, k, ans, nums);
        return finalAns;
    }
    public static void solution(int idx, int n, int k, ArrayList<ArrayList<Integer>> ans, int[] nums) {
        if(idx>n){
            if(k==0){
                int sum = 0;
                boolean isPossible = true;
                for(int j=0;j<ans.size(); j++){
                    ArrayList<Integer> currList = ans.get(j);
                    int cs = 0;
                    for(int val: currList){
                        cs+=val;
                    }
                    if(sum==0){
                        sum=cs;
                    }else{
                        if(sum!=cs){
                            isPossible = false;
                            break;
                        }
                    }
                }
                if(isPossible){
                    System.out.println(ans);
                    finalAns = true;
                }
            }
            return;
        }
        for(int j=0; j<ans.size(); j++){
            ArrayList<Integer> list = ans.get(j);
            if(list.size()==0){
                list.add(nums[idx-1]);
                solution(idx+1, n, k-1, ans, nums);
                list.remove(list.size()-1);
            }else{
                list.add(nums[idx-1]);
                solution(idx+1, n, k, ans, nums);
                list.remove(list.size()-1);
            }
        }
	}

    public static void main(String[] args) {
        int k=5;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		for(int i  = 0; i < k; i++) {
			ans.add(new ArrayList<>());
		}
        int[] nums = {3522,181,521,515,304,123,2512,312,922,407,146,1932,4037,2646,3871,269};
        canPartitionKSubsets(nums, k);
    }
}
