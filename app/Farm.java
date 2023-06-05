package app;

import java.io.File;

public class Farm {
    File fdb;
    FarmData fd;
    Menu m;

    public Farm(Menu m, File fdb) {
        this.fd = new FarmData(fdb);
        this.m = m;
    }
    public int run() {
        boolean running = true;
        int choice = 0;
        int menu = 0; // to know what menu we are at 

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
                    // menu = 1;
                    this.m.showAllAnimals(fd);
                    break;
                case 2:
                    menu = 2;   //  add animal
                    this.m.addAnimal(fd);
                    break;
                case 3:
                    // menu = 3;    // add skill
                    this.m.skillForAnimal(fd);
                    break;
                case 4:
                    // menu = 4;
                    // choice = this.fromFile(menu);
                    // this.sc.fio.writeToysToFile(shopst, this.sc.fileIn);
                    ;
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
}
