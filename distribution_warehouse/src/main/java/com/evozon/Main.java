package com.evozon;

import com.evozon.model.MeasurableUnit;
import com.evozon.model.Package;
import com.evozon.model.products.Other;
import com.evozon.model.products.ProductType;
import com.evozon.repository.CSVFileRepository;
import com.evozon.repository.Repository;

import java.io.File;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        final ProductType productType = new Other();
        productType.setProduct("Crackers");
        Package pack = new Package(productType,
        new MeasurableUnit("Pack"),
        "2",
        "2022-10-03",
        "2023-12-05");
        CSVFileRepository repository = new CSVFileRepository();
        repository.setFile(new File("warehouse.csv"));
        repository.save(Set.of(pack));

        repository.read().stream().forEach(
                el -> System.out.println(el.getProductType().getProduct())
        );
        System.out.println("Hello world!");
    }
}