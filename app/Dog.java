package app;

/**
 * dogs
 */
public class Dog extends Pet_animal {
    public Dog(String name, String birthdate, String skill) {
        super(name, birthdate);
        this.skill = skill;
    }
}
