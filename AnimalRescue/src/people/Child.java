package people;

import utils.Gender;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Child extends AbstractPerson {
    public static Child readChild(final OutputStream outputStream, final InputStream inputStream) {
        final PrintStream output = new PrintStream(outputStream);
        final Scanner input = new Scanner(inputStream);
        final String name;
        final Integer age;
        final HairColour hairColour;
        final Gender gender;
        final Boolean loveAnimals;
        output.println("Introduce a child");
        output.print("Name: ");
        name = input.nextLine();
        output.print("Age: ");
        age = Integer.parseInt(input.nextLine());
        output.print("Hair colour: ");
        hairColour = HairColour.valueOf(input.nextLine().toUpperCase());
        output.print("Gender: ");
        gender = Gender.valueOf(input.nextLine().toUpperCase());
        return new Child(name, gender, age, hairColour);
    }

    public Child(String name, Gender gender, Integer age, HairColour hairColour) {
        super(name, gender, age, hairColour);
    }

    @Override
    public String getNoun() {
        return switch (this.gender) {
            case MALE -> "boy";
            case FEMALE -> "girl";
        };
    }
}
