package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Farm {
    final ACounter ac = new ACounter();

    File fdb;
    FarmData fdata;
    Menu m;

    public Farm(Menu m, File fdb) {
        this.m = m;
        this.fdb = fdb;
        try {
            this.fdata = new FarmData(fdb);
        } catch (FileNotFoundException e) {
            this.m.strOut(e.getMessage()); // exception
        } catch (IOException e) {
            this.m.strOut(e.getMessage()); // exception
        }
    }

    public int run() {
        boolean running = true;
        int choice = 0;
        int menu = 0; // to know what menu we are at
        // this.initData();     // i don't know what is a good (not even the best) way to read a database here o as it is

        while (running) {
            this.m.menu(menu);
            choice = this.m.inputMenu("1230");
            switch (choice) {
                case 0:
                    if (menu == 0) {
                        running = false;
                    } else {
                        menu = 0;
                    }
                    break;
                case 1:
                    this.showAllAnimals();
                    menu = 0;
                    break;
                case 2:                                                 // add animal
                    try (ac) {
                        this.addAnimal(this.addAnimalGetType(),
                                this.addAnimalGetName(),
                                this.addAnimalGetBDate(),
                                this.addAnimalGetSkill());
                        this.ac.add();
                        this.fdata.fio.writeToFile(this.fdata.farmAnimals, this.fdb);
                    } catch (IllegalArgumentException e) {
                        this.m.strOut(e.getCause().getMessage());
                    } catch (Exception e) {
                        // TODO: handle exception
                    } finally {
                        menu = 0;
                    }
                    break;
                case 3:                                                 // add skill
                    // menu = 2;
                    try {
                        this.newSkillForAnimal();
                        this.fdata.fio.writeToFile(this.fdata.farmAnimals, this.fdb);
                    } catch (IllegalArgumentException e) {
                        this.m.strOut(e.getMessage());
                        // e.printStackTrace();
                    } catch (Exception e) {
                        // TODO: handle exception
                    } finally {
                        menu = 0;
                    }
                    break;
                case -1:
                    this.m.errInput(menu);
                    break;
                default:
                    break;
            }
        }
        return 0;
    }

    private void newSkillForAnimal() throws IllegalArgumentException{
        this.m.strOut("Enter the name of the animal to add a new skill: ");
        try {
            Animal ann = this.fdata.findAnimal(m.inputString());
            this.m.strOut("Enter the name of the a new skill: ");
            ann.skill = m.inputString(); // Animal name
        } catch (AnimalNotFound ea) {
            // System.out.println(ea.getMessage());
            throw new IllegalArgumentException("No animal with given name found! returning to menu");
        }
    }

    private String addAnimalGetType()  throws IllegalArgumentException{
        this.m.strOut("Type a type of the animal to add: ");
        String newat = m.inputString().toLowerCase(); // animal type
        if (newat.equals("dog") ||
                newat.equals("cat") ||
                newat.equals("hamster") ||
                newat.equals("donkey") ||
                newat.equals("horse")) {
            return newat;
        }
        throw new IllegalArgumentException("Wrong animal type entered! returning to menu");
    }

    private String addAnimalGetName() {
        this.m.strOut("Type the name of the new animal: ");
        return m.inputString(); // animal name
    }

    private String addAnimalGetBDate() {
        this.m.strOut("And the bith date on the new animal is (format dd/mm/yyyy): ");
        String abdate = m.inputString(); // animal birth date
        try {
            new SimpleDateFormat("dd/MM/yyyy").parse(abdate);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Cannot parse the date you've entered! returning to menu");
        }
        return abdate;
    }

    private String addAnimalGetSkill() {
        this.m.strOut("Type the skill name: ");
        String newas = m.inputString(); // animal skill name
        return newas.equals("") ? " " : newas;
    }

    private void addAnimal(String newat, String newan, String newab, String newas) {
        Animal a = Animal.empty();

        switch (newat.toLowerCase()) {
            case "dog":
                a = new Dog(newan, newab, newas);
                break;
            case "cat":
                a = new Cat(newan, newab, newas);
                break;
            case "hamster":
                a = new Hamster(newan, newab, newas);
                break;
            case "donkey":
                a = new Donkey(newan, newab, newas);
                break;
            case "horse":
                a = new Horse(newan, newab, newas);
                break;
            default:
                break;
        }
        this.fdata.farmAnimals.add(a);
    }

    private void showAllAnimals() {
        for (Animal a : fdata.farmAnimals) {
            this.m.strOut(a.toString());
        }
    }
}
