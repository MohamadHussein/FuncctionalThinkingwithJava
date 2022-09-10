package personal.training.composition;

import personal.training.greeter.Greet;
import personal.training.upperCase.UpperCase;

import java.util.function.Function;

public class Composition {
    public static void main(String[] args) {
        Function<String, String> upperCase = UpperCase::convertToUpper;
        Function<String, String> greet = Greet::appendToMsg;

        System.out.println(upperCase.compose(greet).apply("Ahmad"));

    }

}
