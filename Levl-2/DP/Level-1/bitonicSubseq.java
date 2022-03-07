public class bitonicSubseq {
    
    static int[] lisNlogn(int arr[]){
        int n = arr.length;
        int tail[] = new int[n];
        tail[0] = arr[0];
        // {8,100,150,10,12,14,110};
        int index=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>tail[index]){
                tail[index+1] = arr[i];
                index+=1;
            }else{
                
                append(tail, arr[i], index);
            }
        }
        return tail;
        // System.out.println(index+1);
        // for(int x=0;x<tail.length;x++)
        //     System.out.print(tail[x]+" ");
    }
    static void append(int tail[], int val, int index){
        int i=0;
        int j = index;
        while(j>=i){
            int mid = (i+j)/2; 
            if(tail[mid]>val){
                j=mid-1;
            }else if(tail[mid]==val){
                i=mid;
                break;
            }
            else{
                i=mid+1;
            }
        }
        tail[i] = val;
        // for(int x=0;x<tail.length;x++)
        //     System.out.print(tail[x]+" ");
        // System.out.println();
    }

    static int[] lds(int arr[], int index){
        int n = arr.length;
        int tail[] = new int[n];
        tail[0] = arr[0];
        // int index=0;

        for(int i=1;i<arr.length;i++){
            if(arr[i]<tail[index]){
                tail[index+1] = arr[i];
                index+=1;
            }
            else
                appendLDS(tail, arr[i], index);
        }
        return tail;
    }
    static void appendLDS(int tail[], int val, int index){
        int i=0;
        int j=index;
        while(i<=j){
            int mid = (i+j)/2; 
            if(tail[mid]<val){
                j=mid-1;
            }else{
                i=mid+1;
            }
        }
        tail[i] = val;
    }
    public static void main(String[] args) {
        int arr[]  ={1,11,2,10,4,5,2,1};
        
        // lisNlogn(arr);


        int incIndex = 3;
        int inc[] = lisNlogn(arr);

        int decIndex=4;
        int dec[] = lds(arr, decIndex);

        for(int x=0;x<arr.length;x++)
            System.out.print(inc[x]+" ");
        System.out.println();
        for(int x=0;x<arr.length;x++)
            System.out.print(dec[x]+" ");
        
        int largest = Math.max(incIndex, decIndex);
        

    }
}
