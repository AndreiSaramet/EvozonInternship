package main;

import java.time.LocalDate;
import java.util.Objects;

public class Vaccine {
    private final String name;

    private Double price;

    private final String producer;

    private LocalDate expirationDate;

    public Vaccine(String name, Double price, String producer, LocalDate expirationDate) {
        this.name = name;
        this.price = price;
        this.producer = producer;
        this.expirationDate = expirationDate;
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

    public String getProducer() {
        return producer;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vaccine vaccine = (Vaccine) o;
        return Objects.equals(name, vaccine.name) && Objects.equals(price, vaccine.price) && Objects.equals(producer, vaccine.producer) && Objects.equals(expirationDate, vaccine.expirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, producer, expirationDate);
    }
}
