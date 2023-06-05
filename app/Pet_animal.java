package app;

/**
 * Pet animals
 */
public class Pet_animal extends Animal implements Skills_for_animals {
    protected int a_type;

    /**
     * 
     * @param name      name
     * @param birthdate date of birth
     * @
     * type of animal (1=pet 2=pack)
     */
    public Pet_animal(String name, String birthdate) {
        super(name, birthdate);
        this.a_type = 1;
    }

    @Override
    public String getSkill() {
        return this.skill;
    }

    @Override
    public void studyASkill(String tostudy) {
        this.skill = tostudy;
    }

    @Override
    public String toString() {
        return String.format("%s\t%s\t%s\t%s", this.name, this.birth_date, "Pet!", this.skill);
    }
}