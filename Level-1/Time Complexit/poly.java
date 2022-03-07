class poly{


    static void pol(int x, int n){
        int sum=0;
        for(int i=1,j=n; i<=n;i++,j-- ){
            System.out.println(i* Math.pow(x, j));
            sum+= i* Math.pow(x, j);
            
        }
    }

    public static void main(String[] args) {
        // pol(10, 3);
        String s1 = "abc";
        String s2 = "546";
        
        System.out.println(s1.charAt(2)-'a');
        System.out.println((char)(s1.charAt(2)-'a'));
        System.out.println(s2.charAt(0)-'0');
        System.out.println((char)99);
    }
}