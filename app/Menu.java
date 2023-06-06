package app;

import java.io.Console;

public class Menu {
    protected String title0;
    protected String title1;
    protected String title2;
    protected String menu0;
    protected String menu1;
    protected String menu2;
    protected Console con = System.console();

    public Menu() {
        this.initMenus();
    }

    private void initMenus() {
        this.title0 = "Animal farm -- contains pet and pack animals!\n"; // i don't like word nursery for this project !
        this.title1 = "Adding an animal\nAnimals supported - hamster, cat, dog, horse and donkey\n" +
                        "Other types of animals can't be held at this farm!\n\n";
        this.title2 = "Add a skill to an animal:";
        this.menu0 = "1.\tShow all animals\n" +
                "2.\tAdd a new animal.\n" +
                "3.\tNew skill to an animal\n" +
                "0.\tExit\nEnter your choice";

        this.menu1 = "Please type a type of the animal to add: ";    // if interesting the google translate this correctly to russian ))

        this.menu2 = "Please enter the name of animal to add a new skill\n" +
                "Enter your choice:";
    }

    public void menu(int menu) {
        switch (menu) {
            case 0:
                System.out.println(this.title0 + this.menu0);
                break;
            case 1:
                System.out.println(this.title1 + this.menu1);
                break;
            case 2:
                System.out.println(this.title2 + this.menu2);
                break;
            default:
                break;
        }
    }

    public void errInput(int menu) {
        System.out.println("Invalid input. Back to menu.");
    }

    public void strOut(String string) {
        System.out.println(string);
    }

    public int inputMenu(String check) {
        String inp = con.readLine();
        if (inp.isEmpty() || !check.contains(inp)) {
            return -1;
        } else {
            return Integer.parseInt(inp);
        }
    }

    public int inputInt() {
        String inp = con.readLine();
        try {
            int id = Integer.parseInt(inp);
            return id;
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e);
            return -1;
        }
    }

    public String inputString() {
        return con.readLine();
    }

}
