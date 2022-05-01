package factory;

import javax.sql.rowset.spi.SyncResolver;

public class FactoryMain {
    
    public static void main(String[] args) {
        OSFactory of = new OSFactory();
        OS os = of.getInstance("Android");
        os.show();
    }
}
