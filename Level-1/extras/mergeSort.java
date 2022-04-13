public class mergeSort {
    
    static int[] mergeSortRec(int arr[], int low, int high){
        if(low==high){
            int base[] = new int[1];
            base[0] = arr[low];
            // System.out.println("low "+ low+" "+ "high "+ high);
            return base;
        }

        int mid = (low+high)/2;
        int leftSort[] = mergeSortRec(arr, low, mid);
        int rightSort[] = mergeSortRec(arr, mid+1, high);
        int ans[] = merge2SortedArray(leftSort, rightSort);
        return ans;
    }
    
    static int[] merge2SortedArray(int a[], int b[]){
        int arr[] = new int[a.length+b.length];
            int k= 0;
            int i= 0;
            int j =0;
            while(i<a.length && j<b.length){
                if(a[i]<b[j]){
                    arr[k++]=a[i++];
                }else
                    arr[k++]=b[j++];
            }
            if(i==a.length){
                while(k<arr.length){
                    arr[k++]=b[j++];
                }
            }else{
                while(k<arr.length){
                    arr[k++]=a[i++];
                }
            }
        // for(int x=0;x<arr.length;x++)
        //     System.out.print(arr[x]+" ");
        return arr;
    }
    public static void main(String[] args) {
        // int a[] = {1,3,5,7};
        // int b[]= {2,4,5};
        // merge2SortedArray(a, b);
        int arr[] = {5,2,6,1,9};
        arr = mergeSortRec(arr, 0, arr.length -1);
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
    }
    
}
