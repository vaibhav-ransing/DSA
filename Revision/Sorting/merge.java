public class merge {
    


    static int[] mergeSort(int arr[], int low, int high){
        if(low==high){
            int temp[] = new int[1];
            temp[0] = arr[high];
            return temp;
        }

        int mid = (low+high)/2;
        int arrLeft[] = mergeSort(arr, low, mid);
        int arrRight[] = mergeSort(arr, mid+1, high);
        int merged[] = sortTwoSoretedArr(arrLeft, arrRight);
        return merged;
    }

    static int[] sortTwoSoretedArr(int arr1[], int arr2[]){
        int a1=0, a2=0, i=0;
        int arr[] = new int[arr1.length+ arr2.length];
        while(a1< arr1.length &&  a2< arr2.length){
            if(arr1[a1] < arr2[a2]){
                arr[i] = arr2[a2];
                a2++;
            }else{
                arr[i] = arr1[a1];
                a1++;
            }
            i++;
        }   
        while(a1< arr1.length){
            arr[i] = arr1[a1];
            a1++;
            i++;
        }
        while(a2< arr2.length){
            arr[i] = arr2[a2];
            a2++;
            i++;
        }
        return arr;
    }



    public static void main(String[] args) {
        
    }
}
