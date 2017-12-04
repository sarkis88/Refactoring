package human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class University {

    private List<Student> students = new ArrayList<>();

    public static Comparator<Student> studentComparator = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            return Double.compare(o1.getAverageGrade(), o2.getAverageGrade());
        }
    };



    public University(List<Student> students, String name, int age) {
        this.students = students;
        this.name = name;
        this.age = age;
    }

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public University(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithMaxAverageGrade() {
        return Collections.max(students, studentComparator);
    }

    public Student getStudentWithMinAverageGrade() {
        return Collections.min(students, studentComparator);
    }

    public void expel(Student student) {
        students.remove(student);
    }

    public Student getStudentWithAverageGrade(double grade) {
        for (Student student : students) {
            if (student.getAverageGrade() == grade)
                return student;
        }
        return null;
    }
}