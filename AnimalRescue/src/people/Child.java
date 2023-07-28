package people;

import utils.Gender;

public class Child extends AbstractPerson {
    private Boolean loveAnimals;

    public Child(String name, Gender gender, Integer age) {
        super(name, gender, age);
    }

    public Child(String name, Gender gender, Integer age, HairColour hairColour) {
        super(name, gender, age, hairColour);
    }

    public Boolean getLoveAnimals() {
        return loveAnimals;
    }

    public void setLoveAnimals(final Boolean loveAnimals) {
        this.loveAnimals = loveAnimals;
    }

    @Override
    public String toString() {
        final String loveAnimals = this.loveAnimals ? "loved" : "did not love";
        return switch (this.gender) {
            case FEMALE ->
                    String.format("girl %s which %s dogs", super.toString(), loveAnimals);
            case MALE ->
                    String.format("boy %s which %s dogs", super.toString(), loveAnimals);
        };
    }
}
