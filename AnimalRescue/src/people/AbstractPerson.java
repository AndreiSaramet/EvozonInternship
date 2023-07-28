package people;

import utils.Gender;

public abstract class AbstractPerson implements Person {
    private final String name;

    private Integer age;

    private HairColour hairColour = HairColour.BROWN;

    protected final Gender gender;

    public AbstractPerson(final String name, final Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public AbstractPerson(final String name, final Gender gender, final Integer age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public AbstractPerson(final String name, final Gender gender, final Integer age, final HairColour hairColour) {
        this.name = name;
        this.age = age;
        this.hairColour = hairColour;
        this.gender = gender;
    }

    @Override
    public Integer getAge() {
        return age;
    }

    @Override
    public void setAge(final Integer age) {
        this.age = age;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public HairColour getHairColour() {
        return hairColour;
    }

    @Override
    public void setHairColour(final HairColour hairColour) {
        this.hairColour = hairColour;
    }

    @Override
    public void setHairColour(final String hairColour) {
        this.hairColour = HairColour.valueOf(hairColour.toUpperCase());
    }

    @Override
    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return String.format("named %s, aged %d, with %s hair", this.name, this.age, this.hairColour.toString().toLowerCase());
    }
}
