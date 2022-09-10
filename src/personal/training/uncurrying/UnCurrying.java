package personal.training.uncurrying;

import java.util.function.BiFunction;
import java.util.function.Function;

public class UnCurrying {
    public static <T, U, V> BiFunction<T, U, V> unCurrying(Function<T, Function<U, V>>  function) {
        return (t,u)->function.apply(t).apply(u);
    }


    public static void main(String[] args) {
        Function<Integer, Function<Double, Double>> salaryAfterIncTax = a->b-> a * (1 - b);
        BiFunction<Integer, Double, Double> unCurrNetSalary = unCurrying(salaryAfterIncTax);

        System.out.println(unCurrNetSalary.apply(1200, 0.1));
        System.out.println(unCurrNetSalary.apply(1200, 0.05));
    }

}
