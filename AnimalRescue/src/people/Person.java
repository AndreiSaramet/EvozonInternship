package people;

import utils.Gender;

public interface Person {
    Integer getAge();

    void setAge(final Integer age);

    String getName();

    HairColour getHairColour();

    void setHairColour(final HairColour hairColour);

    void setHairColour(final String hairColour);

    Gender getGender();

    String getPronoun();

    String getNoun();
}
