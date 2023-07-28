package animals;

import food.AnimalFood;
import food.DogFood;

import java.util.Objects;

public abstract class Dog extends Animal {
    private final String breed;

    public Dog(String name, Integer age, Double weight, String gender, String colour, Integer healthStatus, Integer hungerLevel, Integer vibe, String favouriteFood, String favouriteActivity, String breed) {
        super(name, age, weight, gender, colour, healthStatus, hungerLevel, vibe, favouriteFood, favouriteActivity);
        this.breed = breed;
    }

    public Dog(String name, Integer age, Double weight, String gender, String colour, String breed) {
        super(name, age, weight, gender, colour);
        this.breed = breed;
    }

    @Override
    public void speak() {
        System.out.println("Woof Woof");
    }

    @Override
    public void eat(AnimalFood food) {
        if (food instanceof DogFood) {
            System.out.printf("I am eating the dog food %s\n", food.getName());
        } else {
            System.out.printf("I am not eating this food %s\n", food.getName());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Dog dog = (Dog) o;
        return Objects.equals(breed, dog.breed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), breed);
    }
}
