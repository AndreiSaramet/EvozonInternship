package people;

import java.util.List;

public class Vet extends MedicalStaff {
    private Nurse nurse;
    private String specialisation;

    public Vet(final String name, final String specialisation, final Nurse nurse) {
        super(name);
        this.specialisation = specialisation;
        this.nurse = nurse;
    }


    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public Nurse getNurse() {
        return nurse;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }

    public List<String> treatedDog() {
        return List.of("vaccinated", "dewormed");
    }
}
