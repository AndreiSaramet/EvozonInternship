import java.util.Objects;

public class Animal {
    private final String name;

    private final Integer age;

    private Integer healthStatus;

    private Integer hungerLevel;

    private Integer vibe;

    private String favouriteFood;

    private String favouriteActivity;


    public Animal(String name, Integer age, Integer healthStatus, Integer hungerLevel, Integer vibe, String favouriteFood, String favouriteActivity) {
        this.name = name;
        this.age = age;
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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Animal animal = (Animal) o;
        return Objects.equals(name, animal.name) && Objects.equals(age, animal.age) && Objects.equals(healthStatus, animal.healthStatus) && Objects.equals(hungerLevel, animal.hungerLevel) && Objects.equals(vibe, animal.vibe) && Objects.equals(favouriteFood, animal.favouriteFood) && Objects.equals(favouriteActivity, animal.favouriteActivity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, healthStatus, hungerLevel, vibe, favouriteFood, favouriteActivity);
    }
}
