package Java;

public class Multithreading extends Thread {  // implements Runnable
    
    private int threadNumber;
    public Multithreading(int threadNumber){
        this.threadNumber = threadNumber;
    }

    @Override
    public void run(){
        
        for(int i=1; i<10; i++){
            System.out.println(this.threadNumber +" "+ i);
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
