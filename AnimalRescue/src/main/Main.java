package main;

import animals.*;
import food.AnimalFood;
import food.DogFood;
import people.*;
import utils.Gender;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        final Child girl = new Child("Marie", Gender.FEMALE, 7);
        girl.setHairColour("red");
        girl.setLoveAnimals(true);
        final Adopter adopter = new Adopter(girl);

        final Animal dog = new LargeDog(Gender.MALE, "yellow", DogBreed.LABRADOR_RETRIEVER);
        dog.setAge(5);
        dog.setWeight(25.0);
        dog.setName("Bailey");
        dog.setVibe(2);
        dog.setHealthStatus(HealthStatus.IN_POOR_HEALTH);
        dog.setHungerLevel(HungerLevel.REFUSED_FOOD);

        final Nurse nurse = new Nurse("Georgia");
        nurse.setKindLevel(KindLevel.VERY_KIND);
        nurse.setWorkExperience(12);

        final Vet vet = new Vet("Max", "Pets", nurse);
        vet.setWorkExperience(5);

        final Game game = new Game(adopter, dog, vet);

        final String childType = switch (girl.getGender()) {
            case FEMALE -> "girl";
            case MALE -> "boy";
        };
        final String pronoun = switch (girl.getGender()) {
            case FEMALE -> "she";
            case MALE -> "he";
        };
        final String animalType = dog.getClass().getSimpleName();
        final AnimalFood food = new DogFood("pedigree", 10.0, 650.0, LocalDate.of(2025, 11, 29), 10, "dry", "beef");
        System.out.printf("Once upon a time a %s named %s, aged %d, with %s hair who %s animals, entered an Animal Shelter with her father in order to adopt an animal.\n",
                childType, girl.getName(), girl.getAge(), girl.getHairColour().toString().toLowerCase(), girl.getLoveAnimals() ? "loved" : "did not love");
        System.out.printf("%s fell in love with a %s which was a %s.\n", pronoun, animalType, dog.breed());
        System.out.printf("The %s was %s, %s, and %s.", animalType, dog.getVibe(), dog.getHealthStatus(), dog.getHungerLevel());
        System.out.printf(" The %s adopted it and named it %s.\n", childType, dog.getName());
        dog.setHungerLevel(HungerLevel.VERY_HUNGRY);
        System.out.printf("As the dog was %s, the girl fed it with %s.\n", dog.getVibe(), food.getClass().getSimpleName());
        dog.eat(food);
        System.out.printf("In time, the %s, aged %d, has gained in weight, and started to feel %s.\n", animalType, dog.getAge(), dog.getVibe());
        dog.play();
        dog.play();
        dog.play();
        dog.play();
        System.out.printf("The %s started to play with the dog, and as she was doing it more often, the dog started to feel very %s.\n", childType, dog.getHealthStatus());
        System.out.printf("One day, %s got him to the %s, which has %s him.", childType, vet.getClass().getSimpleName().toLowerCase(), String.join(" and ", vet.treatedDog()));
        System.out.printf("The dog was very scared by the %s, and after the treatment, he was even more scared. Fortunately, the %s was %s him all this time.\n", vet.getClass().getSimpleName().toLowerCase(), vet.getNurse().getClass().getSimpleName().toLowerCase(), String.join(" and ", vet.getNurse().nurseDog().stream().map(el -> String.format("%sing", el)).toList()));

    }
}