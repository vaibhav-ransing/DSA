package z;

import java.sql.Time;

public class Threading implements Runnable {
    
    int threadNum;
    Threading(int threadNum){
        this.threadNum = threadNum;
    }
    
    @Override
    public void run(){

        for(int i=1; i<5; i++){
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }   
    }
}
