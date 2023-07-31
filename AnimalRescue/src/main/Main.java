package main;

import animals.*;
import people.*;
import utils.Gender;

import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        final Child girl = new Child("Marie", Gender.FEMALE, 7, HairColour.RED);
//        final Child girl = Child.readChild(System.out, System.in);
        final Adopter adopter = new Adopter(girl);

        final Animal dog = new LargeDog(Gender.MALE, "yellow", DogBreed.LABRADOR_RETRIEVER);
        dog.setAge(5);
        dog.setWeight(25.0);
        dog.setName("Bailey");
        dog.setVibe(2);
        dog.setHealthStatus(HealthStatus.IN_POOR_HEALTH);
        dog.setHungerLevel(HungerLevel.VERY_HUNGRY);
//        final Animal dog = LargeDog.readDog(System.out, System.in);

        final Nurse nurse = new Nurse("Georgia");
        nurse.setKindLevel(KindLevel.VERY_KIND);
        nurse.setWorkExperience(12);

        final Vet vet = new Vet("Max", "Pets", nurse);
        vet.setWorkExperience(5);

        final Game game = Game.adopt(adopter, dog, vet);
        game.tellStory();
    }
}