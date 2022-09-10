package personal.training.currying;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Currying {
    public static  <T,U,V> Function<T, Function<U,V>> convertBiToCurrying (BiFunction<T,U,V> biFunction){
        return t->u->biFunction.apply(t,u);
    }



    public static void main(String[] args) {
        BiFunction<Integer,Double,Double> salaryAfterIncTax = (a,b)-> a*(1-b);
        Function<Integer, Function<Double, Double>> currNetSalary = convertBiToCurrying(salaryAfterIncTax);
        Function<Double, Double> baseSalary = currNetSalary.apply(1200);
        System.out.println(baseSalary.apply(0.1));
        System.out.println(baseSalary.apply(0.05));
    }
}
