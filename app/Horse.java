package app;

public class Horse extends Pack_animal{
    public Horse(String name, String birthdate, String skill) {
        super(name, birthdate);
        this.skill = skill;
    }
    @Override
    public String toString() {
        return super.toString() + "\t\t\tHorse";
    }
}
