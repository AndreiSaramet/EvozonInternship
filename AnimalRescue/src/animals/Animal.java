package animals;

import food.AnimalFood;

import java.util.Objects;

public abstract class Animal {
    private final String name;

    private Integer age;

    private Double weight;

    private final String gender;

    private final String colour;

    private Integer healthStatus;

    private Integer hungerLevel;

    private Integer vibe;

    private String favouriteFood;

    private String favouriteActivity;

    public Animal(String name, Integer age, Double weight, String gender, String colour) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.gender = gender;
        this.colour = colour;
    }

    public Animal(String name, Integer age, Double weight, String gender, String colour, Integer healthStatus, Integer hungerLevel, Integer vibe, String favouriteFood, String favouriteActivity) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.gender = gender;
        this.colour = colour;
        this.healthStatus = healthStatus;
        this.hungerLevel = hungerLevel;
        this.vibe = vibe;
        this.favouriteFood = favouriteFood;
        this.favouriteActivity = favouriteActivity;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getGender() {
        return gender;
    }

    public String getColour() {
        return colour;
    }

    public Integer getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(Integer healthStatus) {
        this.healthStatus = healthStatus;
    }

    public Integer getHungerLevel() {
        return hungerLevel;
    }

    public void setHungerLevel(Integer hungerLevel) {
        this.hungerLevel = hungerLevel;
    }

    public Integer getVibe() {
        return vibe;
    }

    public void setVibe(Integer vibe) {
        this.vibe = vibe;
    }

    public String getFavouriteFood() {
        return favouriteFood;
    }

    public void setFavouriteFood(String favouriteFood) {
        this.favouriteFood = favouriteFood;
    }

    public String getFavouriteActivity() {
        return favouriteActivity;
    }

    public void setFavouriteActivity(String favouriteActivity) {
        this.favouriteActivity = favouriteActivity;
    }

    public abstract void speak();

    public void sleep() {
        System.out.println("I am sleeping...zzz");
    }

    public void eat(final AnimalFood food) {
        System.out.printf("I am eating %s.\n", food.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(name, animal.name) && Objects.equals(age, animal.age) && Objects.equals(weight, animal.weight) && Objects.equals(gender, animal.gender) && Objects.equals(colour, animal.colour) && Objects.equals(healthStatus, animal.healthStatus) && Objects.equals(hungerLevel, animal.hungerLevel) && Objects.equals(vibe, animal.vibe) && Objects.equals(favouriteFood, animal.favouriteFood) && Objects.equals(favouriteActivity, animal.favouriteActivity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, weight, gender, colour, healthStatus, hungerLevel, vibe, favouriteFood, favouriteActivity);
    }
}
