 class MergeSort {
    static void approach2(int arr1[], int arr2[]) {
        int num=0;
        int merge[]=new int[arr1.length+arr2.length];
        for(int i=0,j=0;;){
            if(i==arr1.length){
                for(int k=j;k<arr2.length;k++){
                    merge[num]=arr2[j];
                }
                break;
            }
            if(j==arr2.length){
                for(int k=i;k<arr1.length;k++){
                    merge[num]=arr1[i];
                }
                break;
            }
            if(i<arr1.length){
                if(arr1[i]<arr2[j]){
                    merge[num]=arr1[i];
                    i++;
                }
                else{
                    merge[num]=arr2[j];
                    j++;
                }
            }
            num++;
        }
        for (int i : merge) {
            System.out.println(i);
        }

    }
    static void mer(int a1[], int a2[]){

        int merger[] = new int[a1.length+a2.length];
        int i=0;
        int j=0;
        int k=0;
        while(i!=a1.length && j!=a2.length){
            if(a1[i]>a2[j]){
                merger[k++]=a2[j++];
            }else{
                merger[k++]=a1[i++];
            }
        }
        if(i==a1.length){
            while(j!=a2.length)
                merger[k++]= a2[j++];
        }else{
            while(i!=a1.length)
                merger[k++]= a1[i++];
        }
        for(int m:merger)
            System.out.print(m+" ");
    }

    public static void main(String[] args) {
        int arr1[] = { 1,6 };
        int arr2[] = { 2,3,5 };
        
        approach2(arr1, arr2);
    }
}