import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        final Activity activity = new Activity("Walking");
        final Adopter adopter = new Adopter("George", 2983.31);
        final Animal dog = new Animal("Maya", 2, 10, 6, 8, "food1", "walking");
        final DogFood dogFood = new DogFood("food1", 111.12, 10.5, LocalDate.of(2025, 11, 28), 17);
        final Vet vet = new Vet("Mr. McAllister", "Pets");
        final Game game = new Game(adopter, dog, vet);

    }
}