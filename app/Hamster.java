package app;

public class Hamster extends Pet_animal {
    public Hamster(String name, String birthdate, String skill) {
        super(name, birthdate);
        this.skill = "Eat-Sleep-Breed";     // it's a hamsters ))) they only can do this
    }
}
