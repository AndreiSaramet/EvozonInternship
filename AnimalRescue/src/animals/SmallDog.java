package animals;

import food.AnimalFood;

public class SmallDog extends Dog {
    public SmallDog(String name, Integer age, Double weight, String gender, String colour, String breed) {
        super(name, age, weight, gender, colour, breed);
    }

    @Override
    public void speak() {
        super.speak();
        System.out.println("Yip Yip");
    }

    @Override
    public void eat(AnimalFood food) {
        super.eat(food);
        System.out.println("But I am eating just a bit...");
    }


}
