import java.util.Objects;

public class Vet {
    private final String name;

    private final String specialisation;

    public Vet(String name, String specialisation) {
        this.name = name;
        this.specialisation = specialisation;
    }

    public String getName() {
        return name;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Vet vet = (Vet) o;
        return Objects.equals(name, vet.name) && Objects.equals(specialisation, vet.specialisation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, specialisation);
    }
}
