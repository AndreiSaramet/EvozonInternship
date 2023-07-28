package animals;

import animals.Dog;
import food.AnimalFood;

public class LargeDog extends Dog {
    public LargeDog(String name, Integer age, Double weight, String gender, String colour, String breed) {
        super(name, age, weight, gender, colour, breed);
    }

    @Override
    public void eat(AnimalFood food) {
        super.eat(food);
        System.out.println("An I am eating a lot of it");
    }

    @Override
    public void speak() {
        super.speak();
        System.out.println("Arf arf");
    }

    @Override
    public void sleep() {
        super.sleep();
        System.out.println("And I am snoring very loudly");
    }
}
