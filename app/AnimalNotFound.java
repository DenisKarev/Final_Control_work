package app;

public class AnimalNotFound extends RuntimeException{

    public AnimalNotFound(String mess) {
        super(mess);
    }
}
