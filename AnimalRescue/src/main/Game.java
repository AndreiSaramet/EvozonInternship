package main;

import animals.Animal;
import people.Adopter;
import people.Vet;

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
}
