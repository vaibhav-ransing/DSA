import java.util.Scanner;

public class span {
    
    public static void span1(int arr[]){
        int max = Math.max(arr[0], arr[1]);
        int min = Math.max(arr[0], arr[1]);

        for(int i=2; i<arr.length;i++){
            if(arr[i]>max)
                max = arr[i];
            if(arr[i]<min)
                min = arr[i];
        }
        System.out.println(max-min);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];

        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();
        // int arr[] = {15,30,40,4,11,9};
        span1(arr);

       

    }
}
