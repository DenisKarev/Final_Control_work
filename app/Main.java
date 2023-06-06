package app;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        Menu m = new Menu();
        String wd = System.getProperty("user.dir");
        // System.out.println("CWD = " + System.getProperty("user.dir"));
        File fdb;
        if (wd.endsWith("app")) {
            fdb = new File("./farmdb.csv");        // db file path in dependency from where executed ))
        } else {
            fdb = new File("./app/farmdb.csv");        // db file path in dependency from where executed ))
        }
        Farm farm = new Farm(m, fdb);

        System.out.println("Exited with code: " + farm.run());
    }
}