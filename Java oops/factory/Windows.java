package factory;

public class Windows implements OS {
    public int version;
    Windows(int version){
        this.version = version;
    }
    @Override
    public void show(){
        System.out.println("This is Windows "+version );
    }
}
