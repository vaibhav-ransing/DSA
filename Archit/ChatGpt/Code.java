import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class UniqueRandomNumberGenerator {
    private Set<Integer> numbersSeen;
    private Random random;

    public UniqueRandomNumberGenerator() {
        numbersSeen = new HashSet<>();
        random = new Random();
    }

    public int generateUniqueRandomNumber() {
        int randomNumber;
        do {
            randomNumber = random.nextInt(9999) + 1;
        } while (numbersSeen.contains(randomNumber));

        numbersSeen.add(randomNumber);
        return randomNumber;
    }

    public static void main(String[] args) {
        UniqueRandomNumberGenerator generator = new UniqueRandomNumberGenerator();

        // Generate 10 unique random numbers
        for (int i = 0; i < 10; i++) {
            int uniqueRandomNumber = generator.generateUniqueRandomNumber();
            System.out.println(uniqueRandomNumber);
        }
    }
}
