package personal.training.grouping;
import personal.training.models.Student;
import personal.training.models.Course;
import personal.training.models.Gender;

import java.util.*;
import java.util.function.Function;

public class GeneralGrouping {
    static Student[] students = new Student[]{
            new Student("Ahmad", 20, Gender.MALE, true, Arrays.asList(Course.JAVA, Course.CS)),
            new Student("Leen", 15, Gender.FEMALE, false, Arrays.asList(Course.PHYSICS, Course.CALCULUS)),
            new Student("Reem", 21, Gender.FEMALE, true, Arrays.asList(Course.JAVA, Course.PHYSICS, Course.CS)),
            new Student("Mahmoud", 24, Gender.MALE, false, Arrays.asList(Course.JAVA, Course.CALCULUS))
    };

    public static void main(String[] args) {
        System.out.println(grouping(Student::getGender, Student::getName, students));
    }

    @SafeVarargs
    public static <T, U> U reduceL(Function<U, Function<T, U>> accFunction, U initial, T... array) {
        U result = initial;
        if (array == null) {
            return result;
        }
        for (T element : array) {
            result = accFunction.apply(result).apply(element);
        }
        return result;
    }


    @SafeVarargs
    public static <K, V, E> Map<K, List<V>> grouping(Function<E, K> keyMapper, Function<E, V> valueMapper, E... array) {


        return reduceL(acc -> e -> {
            if (!acc.containsKey(keyMapper.apply(e))) {
                List<V> temp = new ArrayList<>();
                temp.add(valueMapper.apply(e));
                acc.put(keyMapper.apply(e), temp);
            } else {
                List<V> temp = acc.get(keyMapper.apply(e));
                temp.add(valueMapper.apply(e));
                acc.put(keyMapper.apply(e), temp);
            }
            return acc;

        }, new HashMap<>(), array);


    }
}
