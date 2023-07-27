public class LogicalOp {
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

    public String compare(final String string) {
        if ("Evozon".equals(string)) {
            return "Learning text comparison";
        }
        return "Got to try some more";
    }

    public String compare(final String string, final int number) {
        if ("Evozon".equals(string) && number <= 3) {
            return String.format("%s, %d", string, number);
        }
        if (!"Evozon".equals(string) && number >= 4) {
            return String.format("%d, %s", number, string);
        }
        return "No condition matched";
    }

    public String snowLevel(final int amount) {
        if (amount > 8 || amount == 6) {
            return String.format("The amount of snow this winter was(cm): %d", amount);
        }
        return String.format("The forecast snow is(cm): %d", amount);
    }

    public String checkCondition(final double number) {
        if (number > 3 && number != 4) {
            return "The number is greater than 3 and not equal to 4";
        }
        if (number == 4) {
            return "The number is equal to 4";
        }
        return "The number is lower than 3";
    }

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

    public boolean isNumberEven(final int number) {
        if (number % 2 == 0) {
            return true;
        }
        return false;
//        variant without if
//        return number % 2 == 0;
    }

    public boolean isEligibleToVote(final double age) {
        if (age >= 18) {
            return true;
        }
        return false;
//        variant without if
//        return age >= 18;
    }

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
}
