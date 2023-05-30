package Encapsulation;

public class PetOriginator extends Originator {

    @Override
    protected Pet createNewPet(PetType type) {

        return switch (type) {
            case Dog -> new Dog();
            case Cat -> new Cat();
            case Hamster -> new Hamster();
        };
    }
}
