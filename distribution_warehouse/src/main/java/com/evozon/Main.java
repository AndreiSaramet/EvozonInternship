package com.evozon;

import com.evozon.repository.CSVFileRepository;
import com.evozon.service.Service;

import java.io.File;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CSVFileRepository repository = new CSVFileRepository();
        repository.setFile(new File("warehouse.csv"));
        final Service service = new Service();
        service.setRepository(repository);
        service.setUnits(List.of("Kg", "Bag", "Box", "Pack"));
        service.setFixedUnits(List.of("Kg", "Pack"));
        service.setFruitTypes(List.of("Apple", "Apricot", "Banana", "Blackberry", "Blueberry", "Cherry", "Clementine", "Cranberry", "Date", "Dragon fruit", "Durian", "Elderberry", "Fig", "Grape", "Grapefruit", "Guava", "Kiwi", "Lemon", "Lime", "Lychee", "Mango", "Melon", "Nectarine", "Orange", "Papaya", "Passion fruit", "Peach", "Pear", "Pineapple", "Plum", "Pomegranate", "Raspberry", "Strawberry", "Tangerine", "Watermelon", "Avocado", "Persimmon", "Plantain", "Quince", "Jackfruit", "Ackee", "Rambutan", "Kiwifruit", "Jabuticaba", "Blackcurrant", "Gooseberry", "Cranberry", "Loganberry", "Black Mulberry", "Pitahaya", "Persimmon", "Black sapote", "Boysenberry", "Longan", "White sapote", "Star fruit", "Soursop", "Custard apple", "Mangosteen", "Pomegranate", "Pomelo", "Ugli fruit", "Salak", "Noni", "Olive", "Passion fruit", "Feijoa", "Cape Gooseberry", "Prickly pear", "Kumquat", "Soursop", "Sapote", "Cherimoya", "Breadfruit", "Goji berry", "Acerola", "Chayote", "Elderberry", "Gooseberry", "Redcurrant", "Bignay", "Breadnut", "Carob", "Mulberry", "Sloe", "Olive", "Guava", "Marula", "Gac fruit", "Miracle fruit", "Acerola", "Yuzu", "Ylang-ylang fruit", "Lucuma", "Canistel", "Abiu", "Cempedak", "Kiwifruit", "Ackee", "Bael fruit"));
        service.setVegetableTypes(List.of("Artichoke", "Asparagus", "Avocado", "Beetroot", "Bell Pepper", "Bok Choy", "Broccoli", "Brussels Sprouts", "Cabbage", "Carrot", "Cauliflower", "Celery", "Chard", "Collard Greens", "Corn", "Cucumber", "Eggplant", "Green Beans", "Kale", "Kohlrabi", "Leek", "Lettuce", "Mushroom", "Okra", "Onion", "Parsnip", "Peas", "Potato", "Pumpkin", "Radicchio", "Radish", "Spinach", "Spring Onion", "Squash", "Sweet Potato", "Tomato", "Turnip", "Watercress", "Yam", "Zucchini"));
        service.setOtherTypes(List.of("Beef Meat", "Pork Meat", "Chicken Meat", "Turkey Meat", "Lamb Meat", "Fish Meat", "Milk ", "Cheese ", "Yogurt", "Butter", "Eggs", "Bread", "Pasta ", "Rice ", "Cereal", "Flour", "Ketchup", "Mustard", "Mayonnaise", "Soy Sauce", "Vinegar", "Salt", "Pepper", "Water", "Juice"));
        service.generateAndSave(200);
        service.readAndDisplay(LocalDate.now());
//        repository.read().forEach(
//                el -> System.out.println(el.getProductType().getProduct())
//        );
    }
}