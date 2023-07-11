public class ShortestUnsortedContiniouesArr {

    public int findUnsortedSubarray1(int[] nums) {

        // [2,6,4,8,1,10,9,15]  2 6 8 4 15 9 10 20   (6-1)
        
        int end = -1;
        int max = nums[0];
        for(int i=1; i<nums.length; i++){
            if(max > nums[i]){
                end = i;
            }else{
                max = nums[i];  // this will also work
                // max = Math.max(max, nums[i]);
            }
        }
        int st = 0;
        int min = nums[nums.length - 1];
        for(int i = nums.length - 1; i>=0; i--){
            if(nums[i] > min){
                st = i;
            }else{
                min = nums[i];
            }
        }
        return end - st + 1;
    }

    // public int findUnsortedSubarray1(int[] nums) {

    //     // [2,6,4,8,1,10,9,15]  2 6 8 4 15 9 10 20   (6-1)

    //     int n = nums.length;
    //     int leftIdx = 0, leftVal = 0;
    //     for(int i=1; i<n; i++){
    //         if(nums[i - 1] > nums[i]){
    //             leftVal = nums[i];
    //             break;
    //         }
    //     } 
    //     for(int i=0; i<nums.length; i++){
    //         if(leftVal < nums[i]){
    //             leftIdx = i;
    //             break;
    //         }
    //     }

    //     int rigtIdx = n-1;
    //     int rigtVal = 0;
    //     for(int i=n-2; i>=0; i--){
    //         if(nums[i] > nums[i+1]){
    //             rigtVal = nums[i];
    //             break;
    //         }
    //     }
    //     for(int i=n-1; i>=0; i--){
    //         if(nums[i] < rigtVal ){
    //             rigtIdx = i;
    //             break;
    //         }
    //     }

    //     return rigtIdx - leftIdx;
    // }

    public static void main(String[] args) {

    }
}