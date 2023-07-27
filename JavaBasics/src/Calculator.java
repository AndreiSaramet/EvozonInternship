public final class Calculator {

    public float add(final float a, final float b) {
        return a + b;
    }

    public int add(final int a, final int b) {
        return a + b;
    }

    public int add(final int a, final int b, final int c) {
        return a + b + c;
    }

    public float subtract(final float a, final float b) {
        return a - b;
    }

    public int subtract(final int a, final int b) {
        return a - b;
    }

    public int subtract(final int a, final int b, final int c) {
        return a - b - c;
    }

    public int multiply(final int a, final int b) {
        return a * b;
    }

    public float multiply(final float a, final float b) {
        return a * b;
    }

    public int multiply(final int a, final int b, final int c) {
        return a * b * c;
    }

    public double divide(final int a, final int b) {
        return (double) a / b;
    }

    public double divide(final float a, final float b) {
        return a / b;
    }

    public double divide(final int a, final int b, final int c) {
        return (double) a / b / c;
    }

    public double mean(final int a, final int b) {
        return (double) (a + b) / 2;
    }

    public double mean(final int a, final int b, final int c) {
        return (double) (a + b + c) / 3;
    }

    public double mean(final float a, final float b) {
        return (a + b) / 2;
    }

    public int remainder(final int a, final int b) {
        return a % b;
    }

    public int remainder(final int a, final int b, final int c) {
        return a % b % c;
    }
}
