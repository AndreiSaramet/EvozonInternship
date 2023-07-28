package people;

import java.util.Objects;

public class Vet extends MedicalStaff {

    private String specialisation;

    public Vet(String name, Integer workExperience, String specialisation) {
        super(name, workExperience);
        this.specialisation = specialisation;
    }


    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Vet vet = (Vet) o;
        return Objects.equals(specialisation, vet.specialisation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), specialisation);
    }
}
