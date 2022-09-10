package personal.training.flipargs;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FlipParams {

    public static final int SALARY = 1200;
    public static final double TAX = 0.1;

    public static <U,T,V> Function<U,Function<T,V>> flipParameters(Function<T,Function<U,V>> function){

        return t->u->function.apply(u).apply(t);

    }
    public static void main(String[] args) {
        Function<Integer, Function<Double, Double>> salaryAfterIncTax = salary->tax-> salary * (1 - tax);
        Function<Double, Function<Integer, Double>> flipped = flipParameters(salaryAfterIncTax);

        System.out.println(salaryAfterIncTax.apply(SALARY).apply(TAX));
        System.out.println(flipped.apply(TAX).apply(SALARY));


    }
}
