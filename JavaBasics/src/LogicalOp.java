public class LogicalOp {
    //    If-else 3
    public int checkBiggerNumber(final int a, final int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
//        shorter variant without else branch
//        if (a > b) {
//            return a;
//        }
//        return b;
//        yet, a simpler variant
//        return a > b ? a : b;
    }

    //    If-else 4
    public String compare(final String string) {
        if ("Evozon".equals(string)) {
            return "Learning text comparison";
        }
        return "Got to try some more";
    }

    //    If-else 5
    public String compare(final String string, final int number) {
        if ("Evozon".equals(string) && number <= 3) {
            return String.format("%s, %d", string, number);
        }
        if (!"Evozon".equals(string) && number >= 4) {
            return String.format("%d, %s", number, string);
        }
        return "No condition matched";
    }

    //    If-else 6
    public String snowLevel(final int amount) {
        if (amount > 8 || amount == 6) {
            return String.format("The amount of snow this winter was(cm): %d", amount);
        }
        return String.format("The forecast snow is(cm): %d", amount);
    }

    //    If-else 7
    public String checkCondition(final double number) {
        if (number > 3 && number != 4) {
            return "The number is greater than 3 and not equal to 4";
        }
        if (number == 4) {
            return "The number is equal to 4";
        }
        return "The number is lower than 3";
    }

    //    If-else 8
    public void checkNumber(final int number) {
        switch (number) {
            case 1:
                System.out.println("The number is 1!");
                break;
            case 2:
                System.out.println("The number is 2!");
                break;
            case 3:
                System.out.println("The number is 3!");
                break;
            case 4:
                System.out.println("The number is 4!");
                break;
            case 5:
                System.out.println("The number is 5!");
                break;
            case 6:
                System.out.println("The number is 6!");
                break;
            case 7:
                System.out.println("The number is 7!");
                break;
            case 8:
                System.out.println("The number is 8!");
                break;
            case 9:
                System.out.println("The number is 9!");
                break;
            case 10:
                System.out.println("The number is 10!");
                break;
            default:
                System.out.println("The number is not between 1 and 10");
        }
//        a shorter variant
//        System.out.println(switch (number) {
//            case 1 -> "The number is 1!";
//            case 2 -> "The number is 2!";
//            case 3 -> "The number is 3!";
//            case 4 -> "The number is 4!";
//            case 5 -> "The number is 5!";
//            case 6 -> "The number is 6!";
//            case 7 -> "The number is 7!";
//            case 8 -> "The number is 8!";
//            case 9 -> "The number is 9!";
//            case 10 -> "The number is 10!";
//            default -> "The number is not between 1 and 10";
//        });
    }

    //    If-else 9
    public boolean isNumberEven(final int number) {
        if (number % 2 == 0) {
            return true;
        }
        return false;
//        variant without if
//        return number % 2 == 0;
    }

    //    If-else 10
    public boolean isEligibleToVote(final double age) {
        if (age >= 18) {
            return true;
        }
        return false;
//        variant without if
//        return age >= 18;
    }

    //    If-else 11
    public double max(final double a, final double b, final double c) {
        if (a > b) {
            if (a > c) {
                return a;
            }
            return c;
        }
        if (b > c) {
            return b;
        }
        return c;
    }

    //    For-loops 1.
    public void countUp(int number) {
        if (number <= 100) {
            for (; number <= 100; number++) {
                System.out.printf("%d ", number);
            }
        } else {
            for (; number >= 100; number--) {
                System.out.printf("%d ", number);
            }
        }
        System.out.println();
    }

    //    For-loops 2
    public void countDown(int number) {
        if (number >= -100) {
            for (; number >= -100; number--) {
                System.out.printf("%d ", number);
            }
        } else {
            for (; number <= -100; number++) {
                System.out.printf("%d ", number);
            }
        }
        System.out.println();
    }

    //    For-loops 3
    public void countFromTo(int start, int end) {
        if (start <= end) {
            for (; start <= end; start++) {
                System.out.printf("%d ", start);
            }
        } else {
            for (; start >= end; start--) {
                System.out.printf("%d ", start);
            }
        }
        System.out.println();
    }

    //    For-loops 4
    public void countIncreseFromTo(int start, int end) {
        if (end < start) {
            final int cpy = start;
            start = end;
            end = cpy;
        }
        for (; start <= end; start++) {
            System.out.printf("%d ", start);
        }
        System.out.println();
    }

    //    For-loops 5
    public void displayEven1To100() {
//        As 1 is not an even number, we start displaying from 2
        int start = 2;
        for (; start <= 100; start += 2) {
            System.out.printf("%d ", start);
        }
        System.out.println();
    }

    //    For-loops 6
    public void displayOdd1To100() {
        int start = 1;
        for (; start <= 100; start += 2) {
            System.out.printf("%d ", start);
        }
        System.out.println();
    }

    //    For-loops 7
    public int sumTo100(int number) {
        if (number > 100) {
            System.out.printf("No sum can be computed from %d to 100\n", number);
            return -1;
        }
        int sum = 0;
        for (; number <= 100; number++) {
            sum += number;
        }
        return sum;
//        a shorter alternative using sum of consecutive numbers from 1 to 100 and from 1 to number
//        return (100 * 101 - (number - 1) * number) / 2;
    }

    //    For-loops 8
    public double meanTo100(int number) {
        if (number > 100) {
            System.out.printf("No mean can be computed from %d to 100\n", number);
            return -1;
        }
        return (double) this.sumTo100(number) / (100 - number + 1);
    }

    //    For-loops 9
    public void displayPattern() {
        int start = 7;
        for (; start > 0; start--) {
            int length = start;
            final StringBuilder line = new StringBuilder();
            for (; length > 0; length--) {
                line.append("*");
            }
            System.out.println(line);
        }
    }
}
