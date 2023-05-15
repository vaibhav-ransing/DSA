package Java;

public class testing {
    



    public static void main(String[] args) {
        // Multithreading m = new Multithreading(2);
        // Multithreading m2 = new Multithreading();
        // m.start();
        // m2.start();

        for(int i=1; i<3; i++){
            Multithreading mt = new Multithreading(i);

            Thread myThread = new Thread(mt);
            myThread.start();
            
            mt.start();
        }
    }
}
