import java.util.ArrayList;
import java.util.List;

public class MultiTypeList<T, U> {
    
    List<T> list1;
    List<U> list2;

    MultiTypeList(){
        list1 = new ArrayList<>();
        list2 = new ArrayList<>(); 
    }
    void addList1(T val){
        list1.add(val);
    }

    void addList2(U val){
        list2.add(val);
    }

    public List<U> getlist2() {
        return list2;
    }

    public List<T> getlist1() {
        return list1;
    }
}
