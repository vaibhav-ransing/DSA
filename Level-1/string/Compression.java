public class Compression {
    
    static void printSingles(String s){
        int n = s.length();
        String ans= "";
        for(int i=0;i<n-1;i++){
            if(s.charAt(i)!=s.charAt(i+1)){
                ans+= s.charAt(i);
            }
        }
        ans+= s.charAt(n-1);
        System.out.println(ans);
    }
    static void printSingles2(String s){
        int n = s.length();
        String ans= "";
        int count = 1;
        for(int i=0;i<n-1;i++){
            if(s.charAt(i)!=s.charAt(i+1)){
                ans+= s.charAt(i);
                if(count>1){
                    ans+=count;
                    count=1;
                }
                    
            }else{
                count++;
            }
        }
        ans+= s.charAt(n-1);
        if(count>1){
            ans+= count;
        }
        System.out.println(ans);
    }


    public static void main(String[] args) {
        String s ="aaabbbcccdaafff";
        printSingles(s);
        printSingles2(s);
    }
}   
