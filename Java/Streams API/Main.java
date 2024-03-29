import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void filterMethod() {

        // Below arraylist is immutable
        List<Integer> list = List.of(1, 2, 3, 4, 5);

        List<Integer> listEven = list.stream()
                .filter(a -> a % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(listEven);

    }

    public static void main(String[] args) {
        filterMethod();
    }
}