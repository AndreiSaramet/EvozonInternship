package food;

import java.time.LocalDate;
import java.util.Objects;

public class DogFood extends AnimalFood {
    private final String type;

    private final String meatType;

    public DogFood(String name, Double price, Double quantity, LocalDate expirationDate, Integer stock, String type, String meatType) {
        super(name, price, quantity, expirationDate, stock);
        this.type = type;
        this.meatType = meatType;
    }

    public String getType() {
        return type;
    }

    public String getMeatType() {
        return meatType;
    }
}
