package animals;

import food.AnimalFood;
import utils.Gender;

public class LargeDog extends Dog {
    public LargeDog(final Gender gender, final String colour, final DogBreed breed) {
        super(gender, colour, breed);
    }

    @Override
    public void eat(AnimalFood food) {
        super.eat(food);
//        System.out.println("An I am eating a lot of it");
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
