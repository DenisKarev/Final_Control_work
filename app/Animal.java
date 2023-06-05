package app;


/**
 * Animals base class
 */
public class Animal {
    protected String name;
    protected String birth_date;
    protected String skill;
    
    /**
     * 
     * @param name     name
     * @param birthdate date of birth
     */
    public Animal(String name, String birthdate) {
        this.name = name;
        this.birth_date = birthdate;
        this.skill = "";
    }
}