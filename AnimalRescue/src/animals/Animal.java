package animals;

import food.AnimalFood;
import main.Activity;
import utils.Gender;


import java.util.Objects;

public abstract class Animal {
    private String name;

    private Integer age;

    private Double weight;

    private final Gender gender;

    private final String colour;

    private HealthStatus healthStatus;

    private HungerLevel hungerLevel;

    private Integer vibe;

    private AnimalFood favouriteFood;

    private Activity favouriteActivity;

    public Animal(final Gender gender, final String colour) {
        this.gender = gender;
        this.colour = colour;
    }

    public Animal(String name, Integer age, Double weight, String gender, String colour) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.gender = Gender.valueOf(gender);
        this.colour = colour;
    }

    public Animal(String name, Integer age, Double weight, String gender, String colour, String healthStatus, String hungerLevel, Integer vibe, AnimalFood favouriteFood, Activity favouriteActivity) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.gender = Gender.valueOf(gender);
        this.colour = colour;
        this.healthStatus = HealthStatus.valueOf(healthStatus);
        this.hungerLevel = HungerLevel.valueOf(hungerLevel);
        this.vibe = vibe;
        this.favouriteFood = favouriteFood;
        this.favouriteActivity = favouriteActivity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AnimalFood getFavouriteFood() {
        return favouriteFood;
    }

    public Activity getFavouriteActivity() {
        return favouriteActivity;
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

    public Gender getGender() {
        return gender;
    }

    public String getColour() {
        return colour;
    }

    public String getHealthStatus() {
        return String.join(" ", this.healthStatus.toString().toLowerCase().split("_"));
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = HealthStatus.valueOf(healthStatus);
    }

    public void setHealthStatus(HealthStatus healthStatus) {
        this.healthStatus = healthStatus;
    }

    public void setHungerLevel(HungerLevel hungerLevel) {
        this.hungerLevel = hungerLevel;
    }

    public String getHungerLevel() {
        return String.join(" ", this.hungerLevel.toString().toLowerCase().split("_"));
    }

    public void setHungerLevel(String hungerLevel) {
        this.hungerLevel = HungerLevel.valueOf(hungerLevel);
    }

    public void setFavouriteFood(AnimalFood favouriteFood) {
        this.favouriteFood = favouriteFood;
    }

    public void setFavouriteActivity(Activity favouriteActivity) {
        this.favouriteActivity = favouriteActivity;
    }

    public String getVibe() {
        return switch (this.vibe) {
            case 0, 1 -> "very unhappy";
            case 2, 3, 4 -> "unhappy";
            case 5 -> "ok";
            case 6, 7, 8 -> "happy";
            case 9, 10 -> "very happy";
            default -> "";
        };
    }

    public void setVibe(Integer vibe) {
        this.vibe = vibe;
    }

    public abstract void speak();

    public abstract String breed();

    public void sleep() {
        System.out.println("I am sleeping...zzz");
    }

    public void play() {
        this.healthStatus = switch (this.healthStatus) {
            case ILL -> HealthStatus.IN_POOR_HEALTH;
            case IN_POOR_HEALTH -> HealthStatus.OK;
            case OK -> HealthStatus.HEALTHY;
            case HEALTHY, VERY_HEALTHY -> HealthStatus.VERY_HEALTHY;
        };
    }

    public void eat(final AnimalFood food) {
        switch (this.hungerLevel) {
            case NOT_HUNGRY -> {
                System.out.printf("%s: I am not hungry\n", this.name);
            }
            case OK -> {
                if (food.getQuantity() > 0.250) {
                    System.out.printf("%s: I am not hungry enough to eat %f of %s\n", this.name, food.getQuantity(), food.getName());
                } else {
                    this.hungerLevel = HungerLevel.NOT_HUNGRY;
                    this.vibe = 9;
                    this.digest(food);
                }
            }
            case HUNGRY -> {
                if (food.getQuantity() <= 0.250) {
                    this.hungerLevel = HungerLevel.OK;
                    this.vibe = 7;
                    this.digest(food);
                } else if (food.getQuantity() <= 0.500) {
                    this.hungerLevel = HungerLevel.NOT_HUNGRY;
                    this.vibe = 9;
                    this.digest(food);
                } else {
                    System.out.printf("%s: I am not very hungry so I cannot eat %f of %s\n", this.name, food.getQuantity(), food.getName());
                }
            }
            case VERY_HUNGRY -> {
                if (food.getQuantity() <= 0.250) {
                    this.hungerLevel = HungerLevel.HUNGRY;
                    this.vibe = 6;
                } else if (food.getQuantity() <= 0.500) {
                    this.hungerLevel = HungerLevel.OK;
                    this.vibe = 8;
                } else {
                    this.vibe = 10;
                    this.hungerLevel = HungerLevel.NOT_HUNGRY;
                }
                this.digest(food);
            }
            default -> {
                System.out.printf("%s: I don't know if I am hungry or not\n", this.name);
            }
        }
    }

    private void digest(AnimalFood food) {
        this.weight += food.getQuantity();
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

    @Override
    public String toString() {
        final String name = this.name != null ? String.format(" named %s ", this.name) : "";
        final String age = this.age != null ? String.format(" %d years old ", this.age) : "";
        final String weight = this.weight != null ? String.format(" weighing %.1f kilos", this.weight) : "";
        final String colour = this.colour != null ? String.format("with %s fur ", this.colour) : "";
        return String.format("%s%s%s%s%s", colour, switch (this.gender) {
            case MALE -> "boy";
            case FEMALE -> "girl";
        }, name, age, weight);
    }
}
