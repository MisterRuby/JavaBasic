package defaultMethod;

interface Instrument {

    void accelerando();

    default void makeSound() {

    }
}
