class Main{


    public static void main(String[] args) {
        int x = 994543234;
        int n = 4;
        int count=0;
        while(x!=0){
            int z = x%10;
            if(z==n)
                count++;
            x = x/10;
        }
        System.out.println(count);
    }
}