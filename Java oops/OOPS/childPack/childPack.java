package OOPS.childPack;
import OOPS.ComplexNum;
public class childPack {
    
    class cc extends ComplexNum{
        cc(String test){
            super(test);
        }
    }

    public static void main(String[] args) {
        ComplexNum c = new ComplexNum("test");
        System.out.println(c);
    }
}
