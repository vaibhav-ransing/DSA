import java.util.ArrayList;
import java.util.List;

public class ME2 {
    
    public boolean isGreaterThanNB3(int[] arr, int val){
        int count = 0;
        for(int temp: arr){
            count += temp==val? 1:0;
        }
        return count > arr.length/3;
    }

    public List<Integer> majorityElement(int[] nums) {
        int val1=nums[0];
        int count1 = 1;
        
        int val2 = nums[0];
        int count2 = 0;

        for(int i=1; i<nums.length; i++){
            int cv = nums[i];
            if(cv == val1){
                count1++;
            }else if(cv == val2){
                count2++;
            }else{
                if(count1==0){
                    count1 = 1;
                    val1 = cv;
                }else if(count2==0){
                    count2 = 1;
                    val2 = cv;
                }else{
                    count1--;
                    count2--;
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        if(isGreaterThanNB3(nums, val1)){
            list.add(val1);
        }
        if(isGreaterThanNB3(nums, val2) && val1!=val2){
            list.add(val2);
        }
        return list;
    }

    public static void main(String[] args) {
        
    }
}
