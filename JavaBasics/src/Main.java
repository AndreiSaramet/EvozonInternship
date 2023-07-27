import java.util.Scanner;

public class Main {
    /*
    Assignment 1 - Intro to Java
    In acelasi repository creat pt exercitiul de git creati o aplicatie java noua numita "JavaBasics" si rezolvati urmatoarele probleme in cadrul clasei Main si metodei main()

    1. Printati "Hello" in consola, iar pe rand nou, printati numele vostru.

    2. Printati rezultatul sumei a doua numere(orice numere)

    3. Printati rezultatul impartirii a doua numere. Atentie, daca numarul nu este intreg, sa afiseze si valorile dupa virgula.

    4. Printati rezultatul urmatoarelor operatiuni:

    a. -5 + 8 * 6

    b. (55+9) % 9

    c. 20 + -3*5 / 8

    d. 5 + 15 / 3 * 2 - 8 % 3
     */
    public static void main(String[] args) {
//         1.
        System.out.println("Hello\nAndrei");
        int a, b;
        final Scanner scanner = new Scanner(System.in);
//        2.
        System.out.println("Addition");
        System.out.print("a = ");
        a = scanner.nextInt();
        System.out.print("b = ");
        b = scanner.nextInt();
        System.out.printf("%d + %d = %d\n", a, b, a + b);
//        3.
        System.out.println("Division");
        System.out.print("a = ");
        a = scanner.nextInt();
        System.out.print("b = ");
        b = scanner.nextInt();
        System.out.printf("%d / %d = %f\n", a, b, (float) a / b);
//        4.
        final String pattern = "%s = %d\n";
        System.out.printf(pattern, "-5 + 8 * 6", -5 + 8 * 6);
        System.out.printf(pattern, "(55 + 9) % 9", (55 + 9) % 9);
        System.out.printf("%s = %f\n", "20 + -3 * 5 / 8", 20 + (float) -3 * 5 / 8);
        System.out.printf(pattern, "5 + 15 / 3 * 2 - 8 % 3", 5 + 15 / 3 * 2 - 8 % 3);
    }
}