import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class day7 {
    
    static void PairsWithGivenSumInTwoSortedMatrices(int[][] num1, int[][] num2, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<num1.length;i++){
            for(int j=0;j<num1[0].length;j++){
                int key = num1[i][j];
                map.put(key, map.getOrDefault(key, 0)+1);
            }
        }
        int count= 0 ;
        for(int i=0;i<num2.length;i++){
            for(int j=0;j<num2[0].length;j++){
                int key = k-num2[i][j];
                count+= map.getOrDefault(key, 0);
            }
        }
    }
    static void matrixPairBetterSoln(int[][] num1, int[][] num2, int k){
        // if there are no repitions in 
        int i1 = 0;
        int i2 = num2.length-1;
        int j1=0;
        int j2 = num2[0].length-1;

        while(j2>=j1){
            if(i1==num1.length){
                i1=0;
                j1=j1+1;
            }
        }
    }

    static void quadrupletSum(int arr[], int k){
        // 1,0,-1,0,-2,2   k=0
        HashSet<ArrayList> set = new HashSet<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                int sum = arr[i]+arr[j];
                int findSum = k - sum;
                int start = j+1;
                int end = arr.length-1;

                while(end>start){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(arr[i]);
                    temp.add(arr[j]);
                    if(arr[start]+arr[end]==findSum){
                        temp.add(arr[start]);
                        temp.add(arr[end]);
                        if(set.contains(temp)==false){
                            set.add(temp);
                            ans.add(temp);
                        }
                        start++;
                        end--;
                    }else if(arr[start]+arr[end]>findSum){
                        end--;
                    }else if(arr[start]+arr[end]<findSum){
                        start++;
                    }
                }
            }
        }
    }

    static void quadrupletSum2(int[] A, int[] B, int[] C, int[] D){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<A.length;i++){
            for(int j=0;j<B.length;j++){
                int sum = A[i]+B[j];
                map.put(sum, map.getOrDefault(sum, 0)+1);
            }
        }
        int count = 0;
        for(int i=0;i<C.length;i++){
            for(int j=0;j<D.length;j++){
                int sum = -(C[i]+D[j]);
                count+= map.getOrDefault(sum, 0);
            }
        }
    }

    static void largestSubarrayContigiousElemt(int arr[]){
        // 
        HashSet<Integer> set  = new HashSet<>();
        HashSet<Integer> set2  = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }
        for(int i=0;i<arr.length;i++){
            int key = arr[i];
            if(set.contains(key-1)==false){
                System.out.println(key);
                set2.add(key);
            }
        }
        int len=0;
        for(int key: set2){
            int temp = 0;
            while(set.contains(key)){
                temp+=1;
                key+=1;
            }
            len = Math.max(len, temp);
        }
        System.out.println( "len "+len);
        
    }

    static void largestSubarrayContigiousElemtSubarray(int arr[]){
        // subarray
    }
    static void powerfullNumber(int x, int y, int bound){
        int xc = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        
        while(true){
            if(Math.pow(x, xc)<=bound){
                xc++;
            }else
                break;
        }
        int yc = 0;
        while(true){
            if(Math.pow(y, yc)<=bound){
                yc++;
            }else
                break;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<xc;i++){
            for(int j=0;j<yc;j++){
                int temp = (int)(Math.pow(x, i)+ Math.pow(y, j));
                if(set.contains(temp)==false && temp<=bound){
                    set.add(temp);
                    ans.add(temp);
                }
            }
        }
    }




    public static void main(String[] args) {
        int arr[]  ={10 ,12, 11, 4,5,1,6,7};
        largestSubarrayContigiousElemt(arr);
    }
}