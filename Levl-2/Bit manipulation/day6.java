public class day6 {
    
    static void sumOfBitDifference(int arr[]){
        int val=0;
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length; j++){
                if(i==j)
                    continue;
                int num = (arr[i] ^ arr[j]);
                int k = kernighans(num);
                System.out.println(Integer.toBinaryString(arr[i]) +" "+ Integer.toBinaryString(arr[j])+" "+k +" "+Integer.toBinaryString(num));
                val+= kernighans(num);
            }
        }
        System.out.println(val);
    }
    static int kernighans(int n){
        int count=0;
        while(n!=0){
            n= n- (n&-n);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3};
        sumOfBitDifference(arr);
    }
}
