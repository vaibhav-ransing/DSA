import java.util.*;

public class Test {
    


    public static void main(String[] args) {
        // List temp = new LinkedList<>();
        // temp.add(10);
        // temp.add("hello");
        // System.out.println(temp);

        // List<Integer> typeSpecificList = new ArrayList<Integer>();
        // typeSpecificList.add(1);


        // ArrayListDefaultType defList = new ArrayListDefaultType();
        // defList.add("vaibahv");
        // defList.add(10);

        // System.out.println(defList.getList());


        // ArrayListCustom<Integer> cusType = new ArrayListCustom<Integer>();
        // cusType.add(10);


        MultiTypeList<String, Integer> multiList = new MultiTypeList<>();
        multiList.addList1("Hello");
        multiList.addList2(20);

        System.out.println(multiList.list1);
        System.out.println(multiList.list2);

    }
}
