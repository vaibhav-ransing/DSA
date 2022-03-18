import java.util.HashMap;

public class subarrEqual01{

    static int countSubarrWithEqualZeroAndOne(int arr[], int n)
    {
        // add your code here
        HashMap<Integer, Integer> h = new HashMap<>();

        int count = 0;
        int sum = 0;
        h.put(0, 1);
        for(int i=0;i<arr.length;i++){
            // 0, 1, 0, 1, 0, 1, 0
            sum += (arr[i]== 0 ? -1:1);
            if(h.containsKey(sum)){
                count+= h.get(sum);
                h.put(sum, h.get(sum)+1);
            }else{
                h.put(sum, 1);
            }
        }
        // System.out.println(count);
        return count;
    }

    static void soln(int arr[]){
        HashMap<Integer, Integer> h = new HashMap<>();

        int count = 0;
        int sum = 0;
        h.put(0, 0);
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                sum-=1;
                if(h.containsKey(sum)){
                    count+= 1+ h.get(sum);
                    h.put(sum, h.get(sum)+1);

                }else{
                    h.put(sum, 1);
                }
            }else if(arr[i]==1){
                sum+=1;
                if(h.containsKey(sum)){
                    count+= 1+ h.get(sum);
                    h.put(sum, h.get(sum)+1);
                }else{
                    h.put(sum, 1);
                }
            }
        }
        // System.out.println(count);
        // return count;


    }

    static class Pair{
        int a;
        int b;
        Pair(int a, int b){
            this.a = a;
            this.b = b;
        }
    }
    static void countSubarrWithEqualZeroAndOneAndTwo(int arr[]){
        HashMap<String, Integer> h = new HashMap<>();
        h.put("0#0",1);
        int c0=0;
        int c1=0;
        int c2=0;

        for(int val: arr){
            if(val==0){
                c0+=1;
            }else if(val==1){
                c1+=1;
            }else{
                c2+=1;
            }

        }
    }

    static void subarrSumK(int arr[], int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int count = 0;
        for(int val: arr){
            sum+=val;
            if(map.containsKey(sum-k)){ //k-val
                count+= map.get(sum-k);
            }
            if(map.containsKey(sum)){
                map.put(sum, map.get(sum) +1);
            }else{
                map.put(sum, 1);
            }
        }
        System.out.println(count);
    }

    static void subarrDivisiblebyK(int arr[], int k){
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count=0;
        int sum = 0;
        for(int val: arr){
            sum+=val;
            if(map.containsKey(sum%k)){
                count+=map.get(sum%k);
                map.put(sum%k, map.get(sum%k)+1);
            }
            else{
                if(sum%k>0)
                    map.put(sum%k, 1);
                else
                    map.put(sum%k +k, 1);
            }
        }
    }
    
    // check
    static void pairDivisiblebyK(int arr[], int k){
        int freq[] = new int[k];
        for(int i=0;i<arr.length;i++){
            int rem = arr[i]%k;
            freq[rem]++;
        }
        for(int i=0;i<freq.length;i++)
            System.out.print(freq[i]+" ");
        System.out.println();
        int ans = 0;
        if(freq[0]>=2){
            // n! / ((n-r)! * r!)
            int uper = factorial(arr[0]);
            int lower1 = factorial(arr[0]-2);
            int zero = uper/(lower1*2);
            System.out.println("zer "+zero);
            ans+=zero;
        }
        int s = 1;
        int end = freq.length-1;
        while(end>s){
            ans+= freq[s]*freq[end];
            System.out.println(freq[s]*freq[end]);
            s++;
            end--;
        }
        System.out.println("ans "+ans);

    }
    static int factorial(int n){
        int ans = 1;
        for(int i=n;n>0;n--)
            ans = ans*n;
        return ans;
    }

    static void splitCards(int arr[]){
        // find frequency of all elemts 
        // if GCD of freq is >=2 then return true
    }

    public static void main(String[] args) {
        int arr[] = {5 ,7};
        pairDivisiblebyK(arr , 2);
    }
}