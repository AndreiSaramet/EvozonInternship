package animals;

public enum HealthStatus {
    VERY_HEALTHY,
    HEALTHY,
    OK,
    IN_POOR_HEALTH,
    ILL;

    public static HealthStatus improve(final HealthStatus status) {
        return switch (status) {
            case ILL -> HealthStatus.IN_POOR_HEALTH;
            case IN_POOR_HEALTH -> HealthStatus.OK;
            case OK -> HealthStatus.HEALTHY;
            case HEALTHY, VERY_HEALTHY -> HealthStatus.VERY_HEALTHY;
        };
    }
}
