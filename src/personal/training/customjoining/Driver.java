package personal.training.customjoining;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Driver {
    public static void main(String[] args) {
        String[] inputString = new String[]{"this","is","survival","of", "the","fittest"};

        System.out.println(Stream.of(inputString)
                .collect(Collectors.joining(",","[","]")));

        System.out.println(Stream.of(inputString)
                .collect(CustomJoining.CustomJoining(",","[","]")));
    }
}
