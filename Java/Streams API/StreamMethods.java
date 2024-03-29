import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class StreamMethods {

    public static void mapMethod() {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 5, 6);
        List<Integer> mappedList = list.stream().map(a -> {
            return a * a;
        }).collect(Collectors.toList());
        System.out.println(mappedList);
    }

    public static void FilterMethod() {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 5, 6);
        // List<Integer> mappedList = list.stream().filter(a -> {
        list.stream().filter(a -> {
            if (a % 2 == 1) {
                return true;
            } else {
                return false;
            }
        }).collect(Collectors.toList()).forEach(a ->{
            System.out.println(a);
        }); ;

        // System.out.println(mappedList);
    }

    public static void main(String[] args) {
        mapMethod();
        FilterMethod();
    }
}
