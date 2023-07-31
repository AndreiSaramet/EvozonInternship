package animals;

import food.AnimalFood;
import utils.Gender;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class LargeDog extends Dog {

    private Integer vibe;

    public static LargeDog readDog(final OutputStream outputStream, final InputStream inputStream) {
        final PrintStream output = new PrintStream(outputStream);
        final Scanner input = new Scanner(inputStream);
        final String name, colour;
        final Integer age, vibe;
        final Double weight;
        final Gender gender;
        final HealthStatus healthStatus;
        final HungerLevel hungerLevel;
        final DogBreed breed;
        output.println("Introduce a dog");
        output.print("Name: ");
        name = input.nextLine();
        output.print("Colour: ");
        colour = input.nextLine();
        output.print("Age: ");
        age = Integer.parseInt(input.nextLine());
        output.print("Vibe: ");
        vibe = Integer.parseInt(input.nextLine());
        output.print("Weight: ");
        weight = Double.parseDouble(input.nextLine());
        output.print("Gender: ");
        gender = Gender.valueOf(input.nextLine().toUpperCase());
        output.print("Health status: ");
        healthStatus = HealthStatus.valueOf(input.nextLine().toUpperCase());
        output.print("Hunger level: ");
        hungerLevel = HungerLevel.valueOf(input.nextLine().toUpperCase());
        output.print("Breed: ");
        breed = DogBreed.valueOf(input.nextLine().toUpperCase());
        final var largeDog = new LargeDog(gender, colour, breed);
        largeDog.setWeight(weight);
        largeDog.setName(name);
        largeDog.setAge(age);
        largeDog.setVibe(vibe);
        largeDog.setHealthStatus(healthStatus);
        largeDog.setHungerLevel(hungerLevel);
        return largeDog;
    }

    public LargeDog(final Gender gender, final String colour, final DogBreed breed) {
        super(gender, colour, breed);
    }

    @Override
    public void eat(AnimalFood food) {
        super.eat(food);
    }

    @Override
    public void speak() {
        super.speak();
        System.out.println("Arf arf");
    }

    @Override
    public void sleep() {
        super.sleep();
        System.out.println("And I am snoring very loudly");
    }
}
