package people;

import utils.Gender;

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
}

