package Anuj;
public class finalKey{

    static class base{
        int b;
        base(int b){
            this.b = b;
        }
        void fun(int x){
            System.out.println("base fun");
        }

    }
    static class drvie extends base{
        public drvie(int b){
            super(b);
        }
        private int p = 10;
        void fun(){
            System.out.println("drive fun");
        }
    }

    public static void main(String[] args) {
        drvie d = new drvie(10);
        d.fun(12);
        System.out.println(d.p);
    }
}