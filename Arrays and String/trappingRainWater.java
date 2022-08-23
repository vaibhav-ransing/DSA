import java.util.Scanner;

public class trappingRainWater {
    


    static void solution(int arr[]){
        int i=0, j=arr.length-1;
        int area = 0;
        while(i<j){
            int h = Math.min(arr[i], arr[j]);
            int temp = h*(j-i);
            area = Math.max(area, temp);
            if(arr[i]>arr[j]){
                j--;
            }else{
                i++;
            }
        }
        System.out.println(area);
    }



    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        solution(arr);
    }
}
