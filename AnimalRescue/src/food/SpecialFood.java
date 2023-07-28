package food;

import java.time.LocalDate;

public class SpecialFood extends DogFood{
    public SpecialFood(String name, Double price, Double quantity, LocalDate expirationDate, Integer stock, String type, String meatType) {
        super(name, price, quantity, expirationDate, stock, type, meatType);
        this.setCaloriesLevel(NutrientLevel.LOW);
    }
}
