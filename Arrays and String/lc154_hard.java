public class lc154_hard {
    
    public int findMin(int[] nums) {
        
        int highIndex = nums.length-1;
        int lowIndex = 0;
        
        while(highIndex>lowIndex){
            int h = nums[highIndex];
            int l = nums[lowIndex];
            int mid = (lowIndex+highIndex)/2;
            if(highIndex==mid || lowIndex==mid){
                break;
            }
            if(h>l){
                highIndex=mid;
            }else if(h<l){
                lowIndex = mid;
            }else{
                highIndex--;
            }
        }
        return nums[lowIndex];
    }

    public static void main(String[] args) {
        
    }
}
