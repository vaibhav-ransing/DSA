import java.io.InputStream;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamObject {

    public static void main(String[] args) {

        // --------------------  Empty Stream  -----------------------------------------
        Stream<Object> empStream = Stream.empty();
        empStream.forEach(e -> {
            System.out.println(e);
        });
        

        
        // --------------------  Using Stream of  -----------------------------------------
        String names[] = { "vbr", "pp", "sky" };
        Stream<String> stream = Stream.of(names);
        stream.forEach(name -> {
            if (name.startsWith("v")) {
                System.out.println(name);
            }
        });
        Stream<String> stream2 = Stream.of(names);
        String[] arrFiltered =  stream2.filter(name -> name.startsWith("v")).toArray(String[]::new);



        // --------------------  Stream using Builder  -----------------------------------------
        Stream<Object> streamBuilder = Stream.builder().build();
        



        // --------------------  Stream using Arrays  -----------------------------------------
        IntStream streamArr = Arrays.stream(new int[]{1, 2, 3, 4});


    }
}
