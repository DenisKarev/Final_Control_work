package app;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FarmData implements Iterable<Animal>{
        protected List<Animal> farmAnimals;
        // protected int lastId;
    
        public FarmData(File fdb) {
            this.farmAnimals = new ArrayList<Animal>();
            // this.lastId = 0;
        }
    
        // public Animal getFromStorage(int i) {
        //     if (i >= 0 && i < this.lastId) {
        //         for (Animal a : this.farmAnimals) {
        //             if (a.id == i) {
        //                 return new Animal(a);
        //             }
        //         }
        //     }
        //     return null;
        // }
    
        public void addToFarm(Animal an) {

            if (this.isPresent(an)) {
                int idx = this.findAnimal(an);
            } else {
                // an.setId(lastId++);
                this.farmAnimals.add(an);
            }
            // System.out.println(this.storage + " " + this.lastId);
        }
    
        /**
         * @param an Animal
         * @return int : index of a toy found
         * or -1 if not found
         */
        private int findAnimal(Animal an) {
            if (this.isPresent(an)) {
                int ssize = this.farmAnimals.size();
                for (int i = 0; i < ssize; i++) {
                    if (this.farmAnimals.get(i).name.equals(an.name)) {
                        return i;
                    }
                }
            }
            return -1;
        }
    
        @Override
        public Iterator<Animal> iterator() {
            return this.farmAnimals.iterator();
        }
    
        public boolean isPresent(Animal item) {
            for (Animal an : this.farmAnimals) {
                if (an.name.equals(item.name)) {
                    return true;
                }
            }
            return false;
        }
    
        public int getSize() {
            return this.farmAnimals.size();
        }
}
