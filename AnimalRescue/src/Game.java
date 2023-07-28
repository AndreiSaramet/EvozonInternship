import animals.Animal;
import people.Adopter;
import people.Vet;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Game game = (Game) o;
        return Objects.equals(adopter, game.adopter) && Objects.equals(dog, game.dog) && Objects.equals(vet, game.vet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adopter, dog, vet);
    }
}
