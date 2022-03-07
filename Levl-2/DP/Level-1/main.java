class main{

    static void toh(String a, String b, String c, int n){
        if(n==0)
            return;
        toh(a, b, c, n-1);
        System.out.println("Move "+n+ " from "+a+" to "+c);
        toh(b, c, a, n-1);
    }
    public static void main(String[] args) {
        
        toh("a", "b", "c", 3);
    }
}