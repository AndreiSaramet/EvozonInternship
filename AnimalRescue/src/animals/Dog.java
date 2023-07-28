package animals;

import utils.Gender;

public abstract class Dog extends Animal {
    private final DogBreed breed;

    public Dog(final Gender gender, final String colour, final DogBreed breed) {
        super(gender, colour);
        this.breed = breed;
    }

    @Override
    public void speak() {
        System.out.println("Woof Woof");
    }

    @Override
    public String breed() {
        return String.join(" ", this.breed.toString().toLowerCase().split("_"));
    }

    @Override
    public String toString() {
        final String breed = String.join(" ", this.breed.toString().toLowerCase().split("_"));
        return String.format("%s %s", breed, super.toString());
    }
}
