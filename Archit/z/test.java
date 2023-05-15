package z;

public class test {

    public static void main(String[] args) {
        Threading thread = new Threading(1);
        Thread myThread = new Thread(thread);

        Threading thread2 = new Threading(2);
        Thread myThread2 = new Thread(thread2);
        
        myThread.start();
        myThread2.start();
    }
    
}
