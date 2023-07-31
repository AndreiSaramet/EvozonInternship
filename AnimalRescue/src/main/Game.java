package main;

import animals.Animal;
import food.AnimalFood;
import food.DogFood;
import food.SpecialFood;
import people.Adopter;
import people.Vet;

import java.time.LocalDate;

public class Game {
    private final Adopter adopter;

    private final Animal dog;

    private final Vet vet;

    public Game(final Adopter adopter, final Animal dog, final Vet vet) {
        this.adopter = adopter;
        this.dog = dog;
        this.vet = vet;
    }

    public Adopter getAdopter() {
        return adopter;
    }

    public Animal getDog() {
        return dog;
    }

    public Vet getVet() {
        return vet;
    }

    public void background() {
        System.out.printf("Once upon a time a %s named %s, aged %d, with %s hair who loved animals, entered an Animal Shelter with her father in order to adopt an animal.\n", this.adopter.getNoun(), adopter.getName(), adopter.getAge(), adopter.getHairColour().toString().toLowerCase());
    }


    public void run() {
        final String animalType = dog.getClass().getSimpleName();
        final DogFood food = new DogFood("pedigree", 10.0, 650.0, LocalDate.of(2025, 11, 29), 10, "wet", "beef");

        background();
        fellInLove(animalType);
        dogState(animalType);
        adopt();
        feed(food);
        getBetter(animalType);
        play();
        visitVet();
        changeFood(food);
        dailyRoutine(animalType);
    }

    private void dailyRoutine(String animalType) {
        System.out.printf("To make him slimmer, the %s had, almost daily, the following routine:\n%s\n", this.adopter.getNoun(), String.join("\n", this.adopter.getRoutine(animalType)));
    }

    private void changeFood(DogFood food) {
        final SpecialFood specialFood = new SpecialFood("purina", 98.23, 412.31, LocalDate.of(2024, 12, 14), 3, "dry", "fish");
        System.out.printf("After the %s fed the dog with %s food for some time, he got %s, so she changed to %s for dogs which was %s in calories.\n", this.adopter.getNoun(), food.getType(), dog.getWeight() >= 26 ? "fat" : "ok", specialFood.getClass().getSimpleName().toLowerCase(), specialFood.getCaloriesLevel());
    }

    private void visitVet() {
        System.out.printf("One day, the %s got him to the %s, which has %s him.\n", this.adopter.getNoun(), vet.getClass().getSimpleName().toLowerCase(), String.join(" and ", vet.treatedDog()));
        System.out.printf("The dog was very scared by the %s, and after the treatment, he was even more scared. Fortunately, the %s was %s him all this time.\n", vet.getClass().getSimpleName().toLowerCase(), vet.getNurse().getClass().getSimpleName().toLowerCase(), String.join(" and ", vet.getNurse().nurseDog().stream().map(el -> String.format("%sing", el)).toList()));
    }

    private void play() {
        dog.play();
        dog.play();
        dog.play();
        dog.play();
        System.out.printf("The %s started to play with the dog, and as she was doing it more often, the dog started to feel very %s.\n", this.adopter.getNoun(), dog.getHealthStatus());
    }

    private void getBetter(String animalType) {
        System.out.printf("In time, the %s, aged %d, has gained in weight, and started to feel %s.\n", animalType, dog.getAge(), dog.getVibe());
    }

    private void feed(AnimalFood food) {
        System.out.printf("As the dog was %s, the %s fed it with %s.\n", dog.getVibe(), this.adopter.getNoun(), food.getClass().getSimpleName());
        dog.eat(food);
    }

    private void adopt() {
        System.out.printf(" The %s adopted it and named it %s.\n", this.adopter.getNoun(), dog.getName());
    }

    private void dogState(String animalType) {
        System.out.printf("The %s was %s, %s, and %s.", animalType, dog.getVibe(), dog.getHealthStatus(), dog.getHungerLevel());
    }

    private void fellInLove(String animalType) {
        System.out.printf("%s fell in love with a %s which was a %s.\n", this.adopter.getPronoun(), animalType, dog.breed());
    }
}
