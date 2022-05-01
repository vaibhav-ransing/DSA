package Builder;

public class BuilderMain {
    
    public static void main(String[] args) {
        PhoneBuilder p = new PhoneBuilder();
        p.setOS("Android");
        // p.setPrice(10000);
        p.setRam(4);
        System.out.println(p.getPrice());
    }
}
