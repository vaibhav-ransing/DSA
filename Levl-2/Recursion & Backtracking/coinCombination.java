public class coinCombination {
    
    static void ccCombination(int arr[], int i, int sum, String asf){
        if(i==arr.length){
            if(sum==0){
                System.out.println(asf+".");
            }
            return;
        }

        ccCombination(arr, i+1, sum-arr[i], asf+arr[i]+"-");
        ccCombination(arr, i+1, sum, asf);
    }

    static void ccPermutation(int arr[], int sum, int used[], String asf){
        if(sum==0){
            System.out.println(asf+".");
            return;
        }
        for(int i=0; i<arr.length; i++){
            if(used[i]==0){
                used[i] =1;
                ccPermutation(arr, sum-arr[i], used, asf+arr[i]+"-");
                used[i] =0;
            }
        }
    }
    

    static void ccCombination_2(int arr[], int amt, int i, String asf){
        // 2,3,5,6,7      12
        if(amt<0 || i==arr.length){
            if(amt==0){
                System.out.println(asf+" .");
            }
            return;
        }
        ccCombination_2(arr, amt-arr[i], i, asf+arr[i]+"-");
        ccCombination_2(arr, amt, i+1, asf);

    }

    static void ccPermutation_2(int arr[], int amt, String asf){

        if(amt<0)   return;
        if(amt==0){
            System.out.println(asf+".");
            return;
        }

        for(int i=0; i<arr.length; i++){
            ccPermutation_2(arr, amt-arr[i], asf+arr[i]+"-");
        }
    }


    public static void main(String[] args) {
        int arr[] = {2,3,5,6,7};
        // cc1(arr, 0, 12, "");
        // ccPermutation(arr, 12, new int[arr.length], "");
        ccCombination_2(arr, 12, 0, "");
       
    }
}
