package human;

public class Soldier extends Human {

    public Soldier(String name, int age) {
        super(name, age);
    }

    public Soldier() {
    }

    public void fight() {
    }

    @Override
    public void live() {
        fight();
    }
}
