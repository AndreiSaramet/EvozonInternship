import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    /*
    Assignment - Arrays
    
    1. In proiectul de Calculator, in clasa Calculator, supraincarcati toate metodele conform principiului polimorfismului. Creati cel putin cate doua metode polimorfe pentru fiecare metoda pe care o aveti in clasa.

    Apelati metodele in Main pentru a testa daca functioneaza.

    2.  In clasa LogicalOp, creati o metoda care sa scrie pe un array de 100 de pozitii, valorile de la 1 la 100. Sa se afiseze progresul in consola pe tot parcursul. Apelati metoda in main() pentru a verifica daca functioneaza.

    3. Creati o metoda care primeasca un parametru de tip array de numere intregi gol, si sa il returneze populat cu toate valorile pare de la 1 la 100. Apelati metoda in main() pentru a verifica daca functioneaza. Atentie, metoda returneaza un array, deci acesta va trebui surprins si afisat folosind o bucla.

    4. Creati o metoda care sa primeasca un parametru de tip array de numere, si sa fie populat cu valori. Metoda sa calculeze si sa returneze media numerelor din array. Apelati metoda in main() pentru a verifica daca functioneaza.

    5. Creati o metoda care sa primeasca un parametru de tip array de string-uri, populat cu valori, si un parametru de tip String. Metoda sa verifice daca valoarea string-ului primit se regaseste in array-ul primit, iar daca da sa returneze true iar daca nu, sa returneze false.  Apelati metoda in main() pentru a verifica daca functioneaza.

    6. Creati o metoda care sa primeasca un parametru de tip array de numere, populat cu valori, si un parametru de tip numar. Metoda sa verifice daca numarul primit se afla in array-ul primit, si daca da, atunci sa returneze pozitia pe care se afla numarul.  Apelati metoda in main() pentru a verifica daca functioneaza.

    7. Creati o metoda care sa afiseze urmatoarea grila, folosind un array:

    - - - - - - - - - -

    - - - - - - - - - -

    - - - - - - - - - -

    - - - - - - - - - -

    - - - - - - - - - -

    - - - - - - - - - -

    - - - - - - - - - -

    - - - - - - - - - -

    - - - - - - - - - -

    - - - - - - - - - -

    8. Creati o metoda care sa primeasca un parametru de tip array de numere, populat cu valori, si un parametru de tip numar. Metoda sa verifice daca numarul exista in array, si daca da, sa returneze array-ul primit, fara acel numar. Apelati metoda in main() pentru a verifica daca functioneaza.

    9. Creati o metoda care sa primeasca un array, si sa returneze al doilea cel mai mic numar din array. Apelati metoda in main() pentru a verifica daca functioneaza.

    10. Creati o metoda care sa primeasca doi parametrii: un array populat cu valori, si un array gol. Metoda sa copieze toate valorile din primul array, parcurgandu-l, in cel de-al doilea. Apelati metoda in main() pentru a verifica daca functioneaza.
     */
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
//        1.
        System.out.println(calculator.add(2, 3));
        System.out.println(calculator.add(3, 4, 5));
        System.out.println(calculator.subtract(10, 8));
        System.out.println(calculator.subtract(14, 21, -7));
        System.out.println(calculator.multiply(2, 3));
        System.out.println(calculator.multiply(3, 4, 5));
        System.out.println(calculator.divide(10, 8));
        System.out.println(calculator.divide(14, 21, -7));
        System.out.println(calculator.mean(10, 8));
        System.out.println(calculator.mean(14, 21, -7));
        System.out.println(calculator.remainder(2, 3));
        System.out.println(calculator.remainder(3, 4, 5));
//        2.
        LogicalOp op = new LogicalOp();
        op.initialiseArray();
//        3.
        int[] array = new int[50];
        array = op.initialiseEvenArray(array);
        Arrays.stream(array).forEach(el -> System.out.printf("%d ", el));
        System.out.println();
//        4.
        double[] doubles = new double[42894];
        System.out.println(op.initialiseRandom(doubles));
//        5.
        String[] strings = {"hello", "world", "bye", "!"};
        System.out.println(op.isInArray(strings, "world"));
        System.out.println(op.isInArray(strings, "bey"));
//        6.
        doubles = new double[]{0, -1, 5.4, 8.2};
        System.out.println(op.positionOf(doubles, 5.4));
        System.out.println(op.positionOf(doubles, 8.20001));
//        7.
        op.displayDashPattern();
//        8.
        doubles = new double[]{1, 2, 4.32, 42.3, 423.13};
        System.out.println(Arrays.stream(op.remove(doubles, 4.32)).mapToObj(Double::toString).collect(Collectors.joining(", ")));

        doubles = new double[]{212.321, 31.942, 457, 503};
        System.out.println(Arrays.toString(op.remove(doubles, 54)));
//        9.
        doubles = new double[]{212.321, 31.942, 457, 503};
        System.out.println(op.secondSmallest(doubles));

        doubles = new double[]{};
        System.out.println(op.secondSmallest(doubles));

        doubles = new double[]{1, 1, 1, 1, 1, 1, 1};
        System.out.println(op.secondSmallest(doubles));

//        10.
        doubles = new double[]{212.321, 31.942, 457, 503};
        double[] doubles1 = new double[doubles.length];
        System.out.println(Arrays.stream(op.copy(doubles, doubles1)).mapToObj(Double::toString).collect(Collectors.joining(", ")));
    }
}