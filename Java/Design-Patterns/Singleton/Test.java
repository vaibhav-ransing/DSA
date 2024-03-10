import java.lang.reflect.Constructor;

public class Test {


    public static void main(String[] args) throws Exception {

        Samosa s1 = Samosa.getSamosa();
        System.out.println(s1.hashCode());

        Constructor<Samosa> constructor =  Samosa.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Samosa s2 = constructor.newInstance();
        System.out.println(s2.hashCode());

    }
}

