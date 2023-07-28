import java.util.Objects;

public class Adopter {
    private final String name;

    private Double amountOfMoney;

    public Adopter(String name, Double amountOfMoney) {
        this.name = name;
        this.amountOfMoney = amountOfMoney;
    }

    public String getName() {
        return name;
    }

    public Double getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(Double amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Adopter adopter = (Adopter) o;
        return Objects.equals(name, adopter.name) && Objects.equals(amountOfMoney, adopter.amountOfMoney);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, amountOfMoney);
    }
}

