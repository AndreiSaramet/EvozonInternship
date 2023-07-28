package people;

import java.util.Objects;

public class Adopter extends Person {

    private Double amountOfMoney;


    public Adopter(String name, Double amountOfMoney) {
        super(name);
        this.amountOfMoney = amountOfMoney;
    }

    public Double getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(Double amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Adopter adopter = (Adopter) o;
        return Objects.equals(amountOfMoney, adopter.amountOfMoney);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), amountOfMoney);
    }
}

