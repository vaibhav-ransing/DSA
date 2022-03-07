public class stockOneTran {
    
    static void pairSoln(int arr[]){
        int pair[] = new int[arr.length];
        pair[0] = arr[0];
        for(int i=1;i<arr.length;i++){
            int min= arr[0];
            for(int j=1;j<i;j++){
                if(arr[j]<min)
                    min = Math.min(min, arr[j]);
            }
            pair[i] = min;
        }
        for(int i=0;i<arr.length;i++)
            System.out.print(pair[i]+" ");
        System.out.println();
        int max=0;
        for(int i=0;i<arr.length;i++)
            max = Math.max(max, arr[i]-pair[i]);
        System.out.println(max);
    }
    
    static void infiniteTransactions(int arr[], int fee){
        int min = arr[0];
        int max = arr[0];
        int val=0;
        for(int i=1;i<arr.length;i++){
            if(min>=arr[i] || max>=arr[i]){
                System.out.println("min "+min + " max "+max+" ");
                if(max-min-fee>=0)
                    val += max-min-fee;
                System.out.println("Pval "+val);
                min = arr[i];
                max = arr[i];
            }else{
                max = Math.max(max, arr[i]); 
            }
        }
        System.out.println("min "+min + " max "+max+" ");
        System.out.println();
        if(max-min-fee>0)
            val += max-min-fee;
        System.out.println(val);
    }
    public static void main(String[] args) {
        
        // int arr[] = {8,5,2,0,2,1,2,0,7};
        int arr[] = {10,15,17,20,16,18,22,20,22,20,23,25};
        // 10
        
        infiniteTransactions(arr,3);
    }
}
