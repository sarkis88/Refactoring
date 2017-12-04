package human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentsDataBase {
    public static List<Student> students = new ArrayList<>();

    public static void addInfoAboutStudent(Student student) {
        students.add(student);
        printInfoAboutStudent(student);

    }

    public static void printInfoAboutStudent(Student student) {
        System.out.println("Имя: " + student.getName() + " Возраст: " + student.getAge());
    }

    public static void removeStudent(int index) {
        try {
            students.remove(index);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void findDimaOrSasha() {
        for (Student student : students) {
            if (student.getName().equals("Dima")) {
                System.out.println("Студент Dima есть в базе.");
                break;
            }
            if (student.getName().equals("Sasha")) {
                System.out.println("Студент Sasha есть в базе.");
                break;
            }
        }
    }
}