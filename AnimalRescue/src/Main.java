import animals.Animal;
import animals.LargeDog;
import food.AnimalFood;
import food.DogFood;
import people.Adopter;
import people.Vet;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        final Activity activity = new Activity("Walking");
        final Adopter adopter = new Adopter("George", 2983.31);
        final Animal dog = new LargeDog("Maya", 2, 20.7, "girl", "white", "husky");
        final AnimalFood dogFood = new DogFood("food1", 111.12, 10.5, LocalDate.of(2025, 11, 28), 17, "dry", "beef");
        dog.eat(dogFood);
        dog.sleep();
        final Vet vet = new Vet("Mr. McAllister", 4, "Pets");
        final Game game = new Game(adopter, dog, vet);
    }
}