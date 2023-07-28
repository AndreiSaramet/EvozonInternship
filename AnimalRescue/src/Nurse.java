import java.util.Objects;

public class Nurse {
    private final String name;

    private Vet vet;

    public Nurse(String name, Vet vet) {
        this.name = name;
        this.vet = vet;
    }

    public String getName() {
        return name;
    }

    public Vet getVet() {
        return vet;
    }

    public void setVet(Vet vet) {
        this.vet = vet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Nurse nurse = (Nurse) o;
        return Objects.equals(name, nurse.name) && Objects.equals(vet, nurse.vet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, vet);
    }
}
