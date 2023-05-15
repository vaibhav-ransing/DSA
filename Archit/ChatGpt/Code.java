import java.util.HashSet;
import java.util.Random;
import java.util.Set;

class UniqueRandomNumberGenerator {
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
}

class RandomStudent {
    private UniqueRandomNumberGenerator numberGenerator;

    public RandomStudent() {
        numberGenerator = new UniqueRandomNumberGenerator();
    }

    public void generateRandomNumber() {
        int randomNumber = numberGenerator.generateUniqueRandomNumber();
        System.out.println("Random student number: " + randomNumber);
        // Do something with the random number for students
    }
}

class RandomTeacher {
    private UniqueRandomNumberGenerator numberGenerator;

    public RandomTeacher() {
        numberGenerator = new UniqueRandomNumberGenerator();
    }

    public void generateRandomNumber() {
        int randomNumber = numberGenerator.generateUniqueRandomNumber();
        System.out.println("Random teacher number: " + randomNumber);
        // Do something with the random number for teachers
    }
}

public class Main {
    public static void main(String[] args) {
        RandomStudent student = new RandomStudent();
        student.generateRandomNumber();

        RandomTeacher teacher = new RandomTeacher();
        teacher.generateRandomNumber();
    }
}
