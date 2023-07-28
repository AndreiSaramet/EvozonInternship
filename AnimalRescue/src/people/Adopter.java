package people;

import animals.Animal;
import utils.Gender;

import java.util.List;

public class Adopter implements Person {

    private final Person person;
    private Double amountOfMoney;


    public Adopter(Person person) {
        this.person = person;
    }

    public Double getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(Double amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    @Override
    public Integer getAge() {
        return person.getAge();
    }

    @Override
    public void setAge(Integer age) {
        person.setAge(age);
    }

    @Override
    public String getName() {
        return person.getName();
    }

    @Override
    public HairColour getHairColour() {
        return person.getHairColour();
    }

    @Override
    public void setHairColour(HairColour hairColour) {
        person.setHairColour(hairColour);
    }

    @Override
    public void setHairColour(String hairColour) {
        person.setHairColour(hairColour);
    }

    @Override
    public Gender getGender() {
        return this.person.getGender();
    }

    @Override
    public String toString() {
        return String.format("%s and wanted to adopt an animal", this.person.toString());
    }

    public List<? extends String> getRoutine(final String animalType) {
        final String childType = switch (this.person.getGender()) {
            case FEMALE -> "girl";
            case MALE -> "boy";
        };
        return List.of(
                String.format("After wake up, the %s fed the %s with special food.", childType, animalType),
                String.format("Then the %s walked %s around the block.", childType, animalType),
                String.format("Back home, the %s was sleeping, while the %s was doing homework.", animalType, childType),
                String.format("After %s had woken up, the %s was playing with %s with a ball.", animalType, childType, animalType),
                String.format("In the evening, %s was walking %s outside.", childType, animalType),
                "After a long day, they both went to sleep.");
    }
}

