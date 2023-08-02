package com.evozon.service;

import com.evozon.model.MeasurableUnit;
import com.evozon.model.Package;
import com.evozon.model.products.Fruit;
import com.evozon.model.products.Other;
import com.evozon.model.products.ProductType;
import com.evozon.model.products.Vegetable;
import com.evozon.repository.Repository;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.*;

@Data
@NoArgsConstructor
public class Service {
    private Repository repository;

    private List<? extends String> fruitTypes;

    private List<? extends String> vegetableTypes;

    private List<? extends String> otherTypes;

    List<? extends String> units;

    private List<? extends String> fixedUnits;

    private Map<? extends Class<?>, ? extends List<? extends String>> types;

    private void setTypes() {
        this.types = Map.of(
                Fruit.class,
                fruitTypes,
                Vegetable.class,
                vegetableTypes,
                Other.class,
                otherTypes);
    }

    private static Random randomObject = new Random();

    public void generateAndSave(final Integer count) {
        this.setTypes();
        final Set<Package> packages = new HashSet<>();
        for (int counter = 0; counter < count; counter++) {
            packages.add(this.generatePackage());
        }
        this.repository.save(packages);
    }

    private Package generatePackage() {
        final Package productPackage = new Package();
        productPackage.setProductType(this.generateProduct());
        productPackage.setMeasurableUnit(this.generateUnit());
        productPackage.setUnitPrice(randomObject.nextDouble() * 20);
        final LocalDate entryDate = this.generateEntryDate();
        productPackage.setEntryDate(entryDate);
        productPackage.setExpirationDate(this.generateExpirationDate(entryDate));
        return productPackage;
    }

    private ProductType generateProduct() {
        final ProductType type = switch (randomObject.nextInt(3)) {
            case 0 -> new Fruit();
            case 1 -> new Vegetable();
            default -> new Other();
        };
        this.generateName(type);
        this.generateNutritionalQuality(type);
        this.generateProducer(type);
        return type;
    }

    private MeasurableUnit generateUnit() {
        final String unit = this.units.get(randomObject.nextInt(this.units.size()));
        if (fixedUnits.contains(unit)) {
            return new MeasurableUnit(unit);
        }
        return new MeasurableUnit(unit, randomObject.nextDouble() * 50);
    }

    public LocalDate generateEntryDate() {
        return LocalDate.ofEpochDay(randomObject.nextLong(LocalDate.of(2020, 1, 1).toEpochDay(), LocalDate.of(2025, 12, 31).toEpochDay()));
    }

    public LocalDate generateExpirationDate(final LocalDate entryDate) {
        return LocalDate.ofEpochDay(randomObject.nextLong(entryDate.plusDays(1).toEpochDay(), entryDate.plusMonths(6).toEpochDay()));
    }

    private void generateName(final ProductType productType) {
        productType.setProduct(this.types.get(productType.getClass()).get(randomObject.nextInt(types.size())));
    }

    private void generateNutritionalQuality(final ProductType productType) {
        // TODO: 01.08.2023 implement this
    }

    private void generateProducer(final ProductType productType) {
        // TODO: 01.08.2023 implement this
    }
}
