package app;

/**
 * Pack animals
 */
public class Pack_animal extends Animal implements Skills_for_animals {
    protected int a_type;

    /**
     * 
     * @param name      name
     * @param birthdate date of birth
     * @
     * type of animal (1=pet 2=pack)
     */
    public Pack_animal(String name, String birthdate) {
        super(name, birthdate);
        this.a_type = 2;
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
        return super.toString() +   "Pack\t" + this.skill;
    }
}