package app;

/**
 * Cats
 */
public class Cat extends Pet_animal {
    public Cat(String name, String birthdate, String skill) {
        super(name, birthdate);
        this.skill = skill;
    }
}