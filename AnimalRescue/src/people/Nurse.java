package people;

import java.util.Objects;

public class Nurse extends MedicalStaff {

    private Vet vet;

    public Nurse(String name, Vet vet) {
        super(name);
        this.vet = vet;
    }

    public Vet getVet() {
        return vet;
    }

    public void setVet(Vet vet) {
        this.vet = vet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Nurse nurse = (Nurse) o;
        return Objects.equals(vet, nurse.vet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), vet);
    }
}
