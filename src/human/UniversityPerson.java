package human;

public class UniversityPerson extends Human {
    public UniversityPerson(String name, int age, University university) {
        super(name, age);
        this.university = university;
    }

    private University university;

    public UniversityPerson(String name, int age) {
        super(name, age);
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }
}
