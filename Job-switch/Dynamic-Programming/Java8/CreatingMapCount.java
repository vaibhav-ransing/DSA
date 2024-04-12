package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CreatingMapCount {
    

    public static void test() {
        List<String> words = Arrays.asList("apple", "dd");

        Map<Character, Long> charCount = words.stream().flatMap(word -> word.chars().mapToObj(ch -> (char) ch))
                // word.chars() return IntStream so we need to use flatMapToInt
                .collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));

    }
    
}
