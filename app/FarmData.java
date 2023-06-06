package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FarmData implements Iterable<Animal> {
    protected List<Animal> farmAnimals;
    protected Dbfileio fio = new Dbfileio();

    // protected int lastId;

    public FarmData(File fdb) throws IOException, FileNotFoundException {
        this.farmAnimals = new ArrayList<Animal>();
        this.fio.readFile(fdb, farmAnimals);
        // this.lastId = 0;
    }

    protected Animal findAnimal(String an) throws AnimalNotFound {
        for (Animal a : this.farmAnimals) {
            if (a.name.equals(an)) {
                return a;
            }
        }
        throw new AnimalNotFound("Animal not found");
    }

    @Override
    public Iterator<Animal> iterator() {
        return this.farmAnimals.iterator();
    }

    public int getSize() {
        return this.farmAnimals.size();
    }
}
