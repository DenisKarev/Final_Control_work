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
    public boolean readFile(File fr, List<Animal> farm) throws FileNotFoundException, IOException {
        String str = "";
        boolean result = false;
        if (fr.exists() && !fr.isDirectory()) {
            try {
                FileReader f = new FileReader(fr, Charset.forName("UTF-8"));
                BufferedReader bufR = new BufferedReader(f);
                if (bufR.ready()) {
                    String l = bufR.readLine();
                    if (l != null && l.equals("FarmDb")) {
                        while ((str = bufR.readLine()) != null) {
                            String s[] = str.split(";");
                            farm.addToStorage(new Animal(s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2])));
                        }
                        result = true;
                    }
                }
                bufR.close();
            } catch (FileNotFoundException e) {
                System.out.println(e);
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        return result;
    }

    public void writeToFile(String st, File f) throws IOException{
        // boolean result = false;

        try (FileWriter bufW = new FileWriter(f, false)) {
            bufW.append("FarmDb;" + System.lineSeparator());
            // for (Toy toy : st) {
            //     this.writeToy(toy, bufW);
            // }
            bufW.flush();
            bufW.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private void writeAnimal(String toy, FileWriter bw) throws IOException {
        String strToy = String.format("%s;%s;%s;"
                // toy.getId(),
                );
        // System.out.println(strToy);
        bw.append(strToy);
        bw.append(System.lineSeparator());
    }

}
