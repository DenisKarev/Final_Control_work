package app;

public class Donkey extends Pack_animal {
    public Donkey(String name, String birthdate, String skill) {
        super(name, birthdate);
        this.skill = skill;
    }

    @Override
    public String toString() {
        return super.toString() + "\t\t\tDonkey";
    }
}
