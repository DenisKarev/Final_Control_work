package app;


/**
 * Animals base class
 */
public class Animal {
    // protected int id;
    protected String name;
    protected String birth_date;
    protected String skill;
    // private static int numberOfA;
    
    /**
     * 
     * @param name     name
     * @param birthdate date of birth
     */
    public Animal(String name, String birthdate) {
        // this.id = numberOfA;
        this.name = name;
        this.birth_date = birthdate;
        this.skill = " ";
        // Animal.numberOfA++;
    }
    protected static Animal empty(){
        return new Animal(" "," ");
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.name + "\t" + this.birth_date + "\t";
    }
}