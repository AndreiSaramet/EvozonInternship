package com.evozon.repository;

import com.evozon.model.Headers;
import com.evozon.model.MeasurableUnit;
import com.evozon.model.Package;
import com.evozon.model.products.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class CSVFileRepository extends FileRepository {
    private final static CSVFormat csvFormat = CSVFormat.DEFAULT
            .builder()
            .setHeader(Headers.class)
            .build();

    @Override
    public void save(Collection<? extends Package> packages) {
        try (final Writer out = new FileWriter(this.file)) {
            csvFormat.print(out);
            packages.forEach(pack -> {
                try {
                    csvFormat.printRecord(out, Stream.concat(this.printPackage(pack).stream(), this.printAdditionalFields(pack).stream()).toArray());
                } catch (final Exception ex) {
                    throw new RuntimeException(ex);
                }
            });
        } catch (final Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public Collection<? extends Package> read() {
        try (final Reader in = new FileReader(this.file)) {
            return csvFormat.builder()
                    .setSkipHeaderRecord(true)
                    .build()
                    .parse(in)
                    .stream().map(this::parsePackage)
                    .collect(Collectors.toSet());
        } catch (final Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private Package parsePackage(final CSVRecord record) {
        final Map<? extends String, ? extends Function<CSVRecord, ? extends ProductType>> productsParsers = Map.of(
                "fruit", this::parseFruit,
                "vegetable", this::parseVegetable,
                "other", this::parseOther
        );
        return this.parsePackage(record, productsParsers.get(record.get(Headers.product_type)));
    }

    private ProductType parseFruit(final CSVRecord record) {
        final Fruit fruit = new Fruit();
        this.parseProductType(record, fruit);
        this.parseNutritionalQuality(record, fruit);
        return fruit;
    }

    private ProductType parseVegetable(final CSVRecord record) {
        final Vegetable vegetable = new Vegetable();
        this.parseProductType(record, vegetable);
        this.parseNutritionalQuality(record, vegetable);
        vegetable.setProducer(record.get(Headers.producer));
        return vegetable;
    }

    private ProductType parseOther(final CSVRecord record) {
        final Other other = new Other();
        this.parseProductType(record, other);
        return other;
    }

    private void parseProductType(final CSVRecord record, final ProductType productType) {
        productType.setProduct(record.get(Headers.product));
    }

    private void parseNutritionalQuality(final CSVRecord record, final NutritionalProduct nutritionalProduct) {
        nutritionalProduct.setNutritionalQuality(record.get(Headers.nutritional_quality));
    }

    private Package parsePackage(final CSVRecord record, final Function<CSVRecord, ? extends ProductType> productConverter) {
        final Package productPackage = new Package();
        productPackage.setProductType(productConverter.apply(record));
        productPackage.setMeasurableUnit(new MeasurableUnit(record.get(Headers.measurable_unit_1), record.get(Headers.measurable_unit_2)));
        productPackage.setUnitPrice(Double.valueOf(record.get(Headers.unit_price)));
        productPackage.setEntryDate(LocalDate.parse(record.get(Headers.entry_date)));
        productPackage.setExpirationDate(LocalDate.parse(record.get(Headers.expiration_date)));
        return productPackage;
    }

    private List<?> printPackage(final Package productPackage) {
        return List.of(
                productPackage.getProductType().getClass().getSimpleName().toLowerCase(),
                productPackage.getProductType().getProduct(),
                productPackage.getMeasurableUnit().getUnit(),
                productPackage.getMeasurableUnit().getMass().toString(),
                productPackage.getUnitPrice().toString(),
                productPackage.getEntryDate().toString(),
                productPackage.getExpirationDate().toString()
        );
    }

    private List<?> printAdditionalFields(final Package productPackage) {
        final List<String> additionalFields = new ArrayList<>();
        final ProductType productType = productPackage.getProductType();
        if (productType instanceof NutritionalProduct) {
            additionalFields.add(((NutritionalProduct) productType).getNutritionalQuality());
        }
        if (productType instanceof Vegetable) {
            additionalFields.add(((Vegetable) productType).getProducer());
        }
        return additionalFields;
    }
}

