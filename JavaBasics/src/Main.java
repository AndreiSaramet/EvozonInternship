import java.util.Scanner;

public class Main {
    /*
    Assignment 2 - Intro to Java

    Rezolvati urmatoarele probleme in cadrul clasei Main:

    1. Pentru exercitiile din clasa main() de data trecuta, creati metode separate pentru fiecare, tot in clasa Main.java, si apoi apelati-le in metoda main().

    2. Scrieti care o metoda java pentru fiecare din urmatoarele operatii matematice: adunare, scadere, inmultire, impartire.

    Fiecare metoda ar trebui sa primeasca doi parametrii de tip numar, sa execute operatia, si sa returneze rezultatul. Apoi apelati metoda in main cu valorile cu care doriti sa executati operatia.

    3.Scrieti o metoda java, care sa afiseze urmatorul model:

     +"""""+
    [| o o |]
     |  ^  |
     | '-' |
     +-----+

    4.Scrieti o metoda java, care sa primeasca 3 parametrii de tip numar, si sa returneze media numerelor.

    5.Scrieti o metoda java, care sa returneze restul impartirii a doua numere

    6.Scrieti o metoda java, care sa primeasca ca si parametru un numar, care sa reprezinte temperatura in Fahrenheit, si sa returneze temperatura in Celsius. Formula de calcul este: C = 5/9 * (F -32)

    7.Scrieti o metoda java, care sa primeasca ca si parametru un numar real, care sa reprezinte distanta in inch, si sa returneze distanta in metrii

    8.Scrieti o metoda java, care primeste distanta (in metrii) si timpul (ca si 3 numere: ore, minute, secunde), si afiseaza viteza, in metrii pe secunda, kilometrii pe ora si mile pe ora. (Indiciu: 1 mila = 1609 metrii)

    9.Scrieti un program care primeste ca input raza unui cerc si printeaza perimetrul si aria acelui cerc:
     */
    public static void main(String[] args) {
//         1.
        printMyName();
        final Scanner scanner = new Scanner(System.in);
        addition(scanner);
        division(scanner);
        evaluateExpressions();
//        2.
        int a, b;
        a = 5;
        b = 7;
        System.out.printf("%d + %d = %d\n", a, b, add(a, b));
        a = 129;
        b = 319;
        System.out.printf("%d - %d = %d\n", a, b, subtract(a, b));
        a = 2;
        b = 8;
        System.out.printf("%d * %d = %d\n", a, b, multiply(a, b));
        a = 81;
        b = 9;
        System.out.printf("%d / %d = %f\n", a, b, divide(a, b));
//        3.
        printPattern();
//        4.
        System.out.println(mean(4, 7, 12));
//        5.
        System.out.println(remainder(5, 3));
//        6.
        System.out.println(ftoc(33.4));
//        7.
        System.out.println(inchtom(132));
//        8.
        printSpeed(315000, 5, 37, 41);
//        9.
        printMeasurements(5);
    }

    private static void printPattern() {
        System.out.printf("%s\n%s\n%s\n%s\n%s\n",
                " +\"\"\"\"\"+",
                "[| o o |]",
                " |  ^  |",
                " | '-' |",
                " +-----+"
        );
    }

    private static void evaluateExpressions() {
        final String pattern = "%s = %d\n";
        System.out.printf(pattern, "-5 + 8 * 6", -5 + 8 * 6);
        System.out.printf(pattern, "(55 + 9) % 9", (55 + 9) % 9);
        System.out.printf("%s = %f\n", "20 + -3 * 5 / 8", 20 + (float) -3 * 5 / 8);
        System.out.printf(pattern, "5 + 15 / 3 * 2 - 8 % 3", 5 + 15 / 3 * 2 - 8 % 3);
    }

    private static void division(final Scanner scanner) {
        int b;
        int a;
        System.out.println("Division");
        System.out.print("a = ");
        a = scanner.nextInt();
        System.out.print("b = ");
        b = scanner.nextInt();
        System.out.printf("%d / %d = %f\n", a, b, (float) a / b);
    }

    private static void addition(final Scanner scanner) {
        int a, b;
        System.out.println("Addition");
        System.out.print("a = ");
        a = scanner.nextInt();
        System.out.print("b = ");
        b = scanner.nextInt();
        System.out.printf("%d + %d = %d\n", a, b, a + b);
    }

    private static void printMyName() {
        System.out.println("Hello\nAndrei");
    }

    private static int add(final int a, final int b) {
        return a + b;
    }

    private static int subtract(final int a, final int b) {
        return a - b;
    }

    private static int multiply(final int a, final int b) {
        return a * b;
    }

    private static double divide(final int a, final int b) {
        return (double) a / b;
    }

    private static double mean(final int a, final int b, final int c) {
        return (double) (a + b + c) / 3;
    }

    private static int remainder(final int a, final int b) {
        return a % b;
    }

    private static double ftoc(final double degrees) {
        return 5 * (degrees - 32) / 9;
    }

    private static double inchtom(final double length) {
        return length * 0.0254;
    }

    private static void printSpeed(final double distance, final int hours, final int minutes, final int seconds) {
        final int sTime = hours * 3600 + minutes * 60 + seconds;
        final double speed = distance / sTime;
        System.out.printf("v = %f m/s\n", speed);
        System.out.printf("v = %f km/h\n", speed * 3.6);
        System.out.printf("v = %f mile/h\n", speed * 2.23);
    }

    private static void printMeasurements(final double radius) {
        System.out.printf("Perimeter = %f\n", 2 * Math.PI * radius);
        System.out.printf("Surface = %f\n", Math.PI * Math.pow(radius, 2));
    }
}