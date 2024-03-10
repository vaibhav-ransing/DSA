import java.util.ArrayList;
import java.util.List;

public class ArrayListCustom<T>{

    T var1;
    List<T> list;
    
    ArrayListCustom(){
        list = new ArrayList<T>();
    }
    ArrayListCustom(T var1){
        this.var1 = var1;
    }

    T getVar(){
        return var1;
    }

    void add(T val){
        list.add(val);
    }
}