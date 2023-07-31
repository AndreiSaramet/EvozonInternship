package animals;

public enum HungerLevel {
    VERY_HUNGRY,
    HUNGRY,
    OK,
    NOT_HUNGRY,
    REFUSED_FOOD;

    public static HungerLevel improve(final HungerLevel level) {
        return switch (level) {
            case REFUSED_FOOD -> HungerLevel.VERY_HUNGRY;
            case VERY_HUNGRY -> HungerLevel.HUNGRY;
            case HUNGRY -> HungerLevel.OK;
            case OK, NOT_HUNGRY -> HungerLevel.NOT_HUNGRY;
        };
    }
}
