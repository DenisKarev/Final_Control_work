package app;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

public class Dbfileio {
    public void readFile(File fr, List<Animal> farm) throws FileNotFoundException, IOException {
        String str = "";
        // boolean result = false;
        if (fr.exists() && !fr.isDirectory()) {
            try {
                FileReader f = new FileReader(fr, Charset.forName("UTF-8"));
                BufferedReader bufR = new BufferedReader(f);
                if (bufR.ready()) {
                    String l = bufR.readLine();
                    if (l != null && l.equals("FarmDb")) {
                        Animal a = Animal.empty();
                        while ((str = bufR.readLine()) != null) {
                            String s[] = str.split(";");
                            s[0].toLowerCase();
                            switch (s[0].toLowerCase()) {
                                case "dog":
                                    a = new Dog(s[1], s[2], s[3]);
                                    break;
                                case "cat":
                                    a = new Cat(s[1], s[2], s[3]);
                                    break;
                                case "hamster":
                                    a = new Hamster(s[1], s[2], s[3]);
                                    break;
                                case "donkey":
                                    a = new Donkey(s[1], s[2], s[3]);
                                    break;
                                case "horse":
                                    a = new Horse(s[1], s[2], s[3]);
                                    break;
                                default:
                                    break;
                            }
                            farm.add(a);
                        }
                        // result = true;
                    }
                }
                bufR.close();
            } catch (FileNotFoundException e) {
                System.out.println(e);
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        // return result;
    }

    public void writeToFile(List<Animal> anli, File f) throws IOException{
        // boolean result = false;

        try (FileWriter bufW = new FileWriter(f, false)) {
            bufW.append("FarmDb" + System.lineSeparator());
            for (Animal a : anli) {
                this.writeAnimal(a, bufW);
            }
            bufW.flush();
            // bufW.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private void writeAnimal(Animal an, FileWriter bw) throws IOException {
        // String strToy = String.format("%s;%s;%s;%s",     // for debug 
        //         an.getClass().getSimpleName(),
        //         an.name,
        //         an.birth_date,
        //         an.skill);
        // System.out.println(strToy);
        bw.append(String.format("%s;%s;%s;%s",
                                        an.getClass().getSimpleName(),
                                        an.name,
                                        an.birth_date,
                                        an.skill));
        bw.append(System.lineSeparator());
    }

}
