import java.util.Arrays;

public class StreamOnArray {
    
    public static void filterMethod() {

        int arr[] = {1,2,3,4,5};
        int sum = Arrays.stream(arr).filter(a -> a%2==0).sum();
        int[] newArr = Arrays.stream(arr).filter(a -> a%2==0).toArray();
        
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(newArr));
    }
}
