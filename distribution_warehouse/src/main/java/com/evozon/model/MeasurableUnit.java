package com.evozon.model;

import lombok.Data;

@Data
public class MeasurableUnit {
    private final String unit;
    private final Double mass;

    public MeasurableUnit(String unit, String mass) {
        this.unit = unit;
        this.mass = Double.valueOf(mass);
    }

    public MeasurableUnit(String unit) {
        this.unit = unit;
        this.mass = 1.00;
    }
}
