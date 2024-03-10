import java.util.ArrayList;
import java.util.List;

public class ArrayListDefaultType {

    List<Object> list;
    
    ArrayListDefaultType(){
        list = new ArrayList<>();
    }

    Object getList(){
        return list;
    }

    void add(Object o){
        list.add(o);
    }
}
