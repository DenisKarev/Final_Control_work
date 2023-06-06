package app;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        Menu m = new Menu();
        File fdb = new File("./app/farmdb.csv");

        // db file path in dependency from where executed ))
        // but it's not working (((((

        // String wd = System.getProperty("user.dir");
        // System.out.println("CWD = " + System.getProperty("user.dir"));
        // if (wd.endsWith("app")) {
        //     fdb = new File("./farmdb.csv");     
        // } else {
        //     fdb = new File("./app/farmdb.csv");
        // }
        Farm farm = new Farm(m, fdb);

        System.out.println("Exited with code: " + farm.run());
    }
}