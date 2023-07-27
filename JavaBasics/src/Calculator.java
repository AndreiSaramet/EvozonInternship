public final class Calculator {

    public int add(final int a, final int b) {
        return a + b;
    }

    public int subtract(final int a, final int b) {
        return a - b;
    }

    public int multiply(final int a, final int b) {
        return a * b;
    }

    public double divide(final int a, final int b) {
        return (double) a / b;
    }

    public double mean(final int a, final int b, final int c) {
        return (double) (a + b + c) / 3;
    }

    public int remainder(final int a, final int b) {
        return a % b;
    }
}
