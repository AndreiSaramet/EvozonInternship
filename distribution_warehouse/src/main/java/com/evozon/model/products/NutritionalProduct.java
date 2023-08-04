package com.evozon.model.products;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public abstract class NutritionalProduct extends ProductType {
    private String nutritionalQuality;
}
