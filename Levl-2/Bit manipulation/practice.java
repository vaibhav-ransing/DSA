import java.util.*;
 
public class practice {
    
    static int setBitCount(int n){
        int res=0;
        while(n!=0){
            n-= (n & -n);
            res++;
        }
        return res;
    }
    static int ncr(int n, int r){
        if(r>n)
            return 0;
        int quo = 1;
        for(int i=n; i>(n-r);i--){
            quo*=i;
        }
        int rem=1;
        for(int i=1;i<=r;i++){
            rem*=i;
        }
        return quo/rem;
    }
    static int pepcoderBits(int n, int setBitCount, int bits){
        if(bits==0 ){
            return 0;
        }
        int temp = 1<<bits;
        int res=0;
        if((temp&n)==0){
            pepcoderBits(n, setBitCount, bits-1);
        }else{
            int res1 = pepcoderBits(n, setBitCount-1, bits-1);
            int res0 = ncr(bits, setBitCount);
            res += res1+res0;
        }
        return res;
    }

    static void lis(int arr[]){
        int dp[] = new int[arr.length];
        dp[0]=1;
        for(int i=1;i<arr.length;i++){
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i])
                    dp[i] = Math.max(dp[i], dp[j]);
            }
            dp[i]++;
        }
        for(int val: dp)
            System.out.print(val);
    }

  
 
     public static ArrayList<String> grayCode(int n) {
 	 //Write your code here
        if(n==1){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("0");
            bres.add("1");
            return bres;
        }
        ArrayList<String> rres = grayCode(n-1);
        ArrayList<String> myres = new ArrayList<>();
        for(int i=0;i<rres.size(); i++){
            String s = rres.get(i);
            myres.add(("0"+s));
        }
        for(int i=rres.size()-1; i>=0;i--){
            String s = rres.get(i);
            myres.add(("1"+s));
        }
        return myres;
      
     }
 

    public static void main(String[] args) {
        // int n=10;
        // int setBits = setBitCount(n);
        // System.out.println(pepcoderBits(n, setBits, 31));
        System.out.println(grayCode(2));
        ArrayList<String> ans = grayCode(3);
        int n = ans.size();
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i=0;i<n;i++){
            temp.add(i+1);
        }
        System.out.println(temp);
    }
}
