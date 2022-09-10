package personal.training.reduceoperation;


import personal.training.models.Course;
import personal.training.models.Gender;
import personal.training.models.Student;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupUsingReduce {
    static Student[] students = new Student[]{
            new Student("Ahmad", 20, Gender.MALE, true, Arrays.asList(Course.JAVA, Course.CS)),
            new Student("Leen", 15, Gender.FEMALE, false, Arrays.asList(Course.PHYSICS, Course.CALCULUS)),
            new Student("Reem", 21, Gender.FEMALE, true, Arrays.asList(Course.JAVA, Course.PHYSICS, Course.CS)),
            new Student("Mahmoud", 24, Gender.MALE, false, Arrays.asList(Course.JAVA, Course.CALCULUS))
    };

    public static void main(String[] args) {

        System.out.println(Stream.of(students)
                .collect(Collectors.groupingBy(Student::getGender)));

        Map<Gender, List<Student>> reducedOutput = Stream
                .of(students)
                .reduce(new HashMap<>(),
                        (acc, student) -> {
                            List<Student> temp = acc.get(student.getGender());
                            if (temp != null) {
                                temp.add(student);
                                acc.put(student.getGender(), temp);
                            } else {
                                ArrayList<Student> newList = new ArrayList<>();
                                newList.add(student);
                                acc.put(student.getGender(), newList);
                            }
                            return acc;
                        },
                        (acc1, acc2) -> {
                            acc1.putAll(acc2);
                            return acc1;
                        });
        for (Map.Entry<Gender, List<Student>> genderListEntry : reducedOutput.entrySet()) {
            System.out.println(genderListEntry);
        }
    }
}
