package app;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        Menu m = new Menu();
        File fdb = new File("./app/farmdb.csv");        // db file path
        Farm farm = new Farm(m, fdb);

        System.out.println("ts.execute returns: " + farm.run());
    }
}