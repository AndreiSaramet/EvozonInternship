package food;

import java.time.LocalDate;
import java.util.Objects;

public abstract class AnimalFood {
    private final String name;

    private Double price;

    private Double quantity;

    private LocalDate expirationDate;

    private Integer stock;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnimalFood that = (AnimalFood) o;
        return Objects.equals(name, that.name) && Objects.equals(price, that.price) && Objects.equals(quantity, that.quantity) && Objects.equals(expirationDate, that.expirationDate) && Objects.equals(stock, that.stock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, quantity, expirationDate, stock);
    }
}

