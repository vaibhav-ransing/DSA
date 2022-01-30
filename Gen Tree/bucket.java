public class bucket {

    public static void removeMinBucket(int arr[]){
        int min  = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            min = Math.min(min, ifIgnored(arr, i));
        }
        System.out.println(min);

    }
    public static int ifIgnored(int arr[], int index){
        
        int removedWater = 0;
        for(int i=0;i<arr.length;i++){
            if(i==index)
                continue;
            else{
                if(arr[i]<arr[index])
                    removedWater+=arr[i];
                else
                    removedWater+=arr[i]-arr[index];
            }
        }
        return removedWater;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3};
        removeMinBucket(arr);
    }
}
