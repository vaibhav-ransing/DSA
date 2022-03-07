import java.util.Scanner;

public class sumSubset {
     
    static void print(int[] arr, int index, String ans, int sum, int tar, boolean visited[], String printAns){

        if(sum==tar){
            System.out.println(ans);
            System.out.println(printAns.substring(0,printAns.length()-1));
            return;
        }

        for(int i=index; i<arr.length;i++){
            if(visited[i])
                return;
            int val;
            val = arr[i];   
            visited[i]=true;
            if(sum+val<=tar){
                print(arr, index+1, ans+i, sum+val, tar, visited, printAns+arr[i]+",");
            }
            visited[i] = false;
        }
    }


    static void print2(int[] arr, int index, String ans, int sum, int target, String printAns){

        // if(equalSum(arr, ans, target)){
        //     System.out.println(printAns.substring(0,printAns.length()-1));
        //     return;
        // }
        if(sum>target)
            return;
        if(sum==target){
            System.out.println(ans);
            return;
        }
        if(index==arr.length)
            return;

        print2(arr, index+1, ans+index, sum+arr[index], target, printAns+arr[index]+",");
        print2(arr, index+1, ans, sum, target, printAns);
    }

    static boolean equalSum(int arr[], String ans, int tar){
        int sum = 0;
        for(int i=0;i<ans.length();i++){
            int ind = ans.charAt(i)-'0';
            sum+=arr[ind];
        }
        if(sum==tar)
            return true;
        return false;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // int arr[] = new int[n];
        // for(int i=0;i<arr.length;i++){
        //     arr[i] = sc.nextInt();
        // }
        int arr[] = {10,20,30,40,50};
        int target =60;
        boolean visited[] = new boolean[arr.length];
        // print(arr, 0,"", 0, target,visited, "");
        print2(arr, 0, "", 0, target,"");
    }
}


// class sub{

//     static void printSUb(String str, String s, int Index){

//         if(Index==str.length()){
//             System.out.println(s);
//             return;
//         }
//         printSUb(str, s+str.substring(Index, Index+1), Index+1);
  
//         printSUb(str, s, Index+1);

//     }

//     public static void main(String[] args) {
//         printSUb("abc", "", 0);
//     }
// }


