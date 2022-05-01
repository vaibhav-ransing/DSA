package Anuj;
public class Abstraction {
    

    abstract class car{
        int price;
        abstract void start();
    }

    class BMW extends car{
        @Override
        void start(){
            System.out.println("BMW starting");
        }
    }




    public static void main(String[] args) {
        
    }
}
