public class keyKeyboard {

    static void Solution(int n){
        int ans = 0;
        for(int i=2; i*i<=n;){
            System.out.println(i+" "+n);
            if(n%i==0){
                ans+=i;
                n/=i;
            }else{
                i++;
            }
        }
        System.out.println(ans);
        if(n!=1)
            ans+=n; 
        System.out.println(ans);
    }
    public static void main(String[] args) {
        Solution(9);
    }       
}
