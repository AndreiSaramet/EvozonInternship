package animals;

import food.AnimalFood;
import utils.Gender;

public class SmallDog extends Dog {
    public SmallDog(Gender gender, String colour, DogBreed breed) {
        super(gender, colour, breed);
    }

    @Override
    public void speak() {
        super.speak();
        System.out.println("Yip Yip");
    }

    @Override
    public void eat(AnimalFood food) {
        super.eat(food);
    }

}
