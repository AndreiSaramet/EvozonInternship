package food;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.stream.Collectors;

public abstract class AnimalFood {
    private final String name;

    private Double price;

    private Double quantity;

    private LocalDate expirationDate;

    private Integer stock;

    private NutrientLevel caloriesLevel;

    public AnimalFood(String name, Double price, Double quantity, LocalDate expirationDate, Integer stock) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.expirationDate = expirationDate;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getCaloriesLevel() {
        return String.join(" ", Arrays.asList(caloriesLevel.toString().toLowerCase().split("_")));
    }

    public void setCaloriesLevel(NutrientLevel caloriesLevel) {
        this.caloriesLevel = caloriesLevel;
    }
}

