import java.io.Serializable;

public class Samosa implements Serializable, Cloneable {

    private static Samosa samosa;

    private Samosa() {
        if(this.samosa != null){
            throw new RuntimeException("Your are breaking the singleton pattern");
        }
    }

    // Block Synchronizaiton
    public static Samosa getSamosa() {
        if (samosa == null) {
           
            synchronized (Samosa.class) {
                 /* We need two checks of samosa == null
                    so that threads wont create different objects.
                    if t1 executes new Samosa() then t2 should not go again and do it.
                 */
                if (samosa == null) {
                    samosa = new Samosa();
                }
            }
        }

        return samosa;
    }

    public Object readResolve(){
        return samosa;
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        return samosa;
    }

/*
    * // Method Synchronization
    * 
    * public static synchronized Samosa getSamosa() {
    * if (samosa == null) {
    * samosa = new Samosa();
    * }
    * return samosa;
    * }
    * 
*/

}