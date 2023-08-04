package com.evozon.model;

import com.evozon.model.products.ProductType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Package {
    private ProductType productType;

    private MeasurableUnit measurableUnit;

    private Double unitPrice;

    private LocalDate entryDate;

    private LocalDate expirationDate;

    public Package(ProductType productType, MeasurableUnit measurableUnit, String unitPrice, String entryDate, String expirationDate) {
        this.productType = productType;
        this.measurableUnit = measurableUnit;
        this.unitPrice = Double.valueOf(unitPrice);
        this.entryDate = LocalDate.parse(entryDate);
        this.expirationDate = LocalDate.parse(expirationDate);
    }
}
