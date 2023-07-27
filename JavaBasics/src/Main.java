import java.util.Arrays;
import java.util.Objects;

public class Main {
    /*
    Assignment - Arrays (Optional)
    a
    Rezolvati urmatoarele exercitii in LogicalOp:

    1. Creati o metoda care sa returneze al doilea cel mai mic numar dintr-un array.

    2. Creati o metoda care insereze un element pe o pozitie specifica intr-un array.

    3. Creati o metoda care sa gaseasca cel mai mare si cel mai mic numar dintr-un array.

    4. Creati o metoda care sa inverseze valorile unui array de int-uri.

    5. Creati o metoda care sa gaseasca toate valorile duplicate dintr-un array.

    6. Creati o metoda care sa gaseasca toate elementele comune intre doua array-uri (array de String).

    7. Creati o metoda care sa primeasca un array de numere ne-ordonat, si sa il returneze ordonat crescator.
     */
    public static void main(String[] args) {
        final LogicalOp op = new LogicalOp();
//        2.
        final String[] strings = new String[]{"Rome", "Brussels", "Madrid", "Stockholm", "Athens", null};
        op.insertAt(strings, 2, "Iasi");
        System.out.println(String.join(", ", Arrays.asList(strings)));
//        3.
        final double[] doubles = new double[100];
        op.initialiseRandom(doubles);
        op.findMinMax(doubles);
//        4.
        op.reverse(strings);
        System.out.println(String.join(", ", Arrays.asList(strings)));
//        5.
        final String[] cities = new String[]{"Rome", "Brussels", "Madrid", "Athens", "Stockholm", "Brussels", "Madrid", "Stockholm", "Brussels", "Madrid", "Madrid"};
        System.out.println(String.join(", ", Arrays.asList(op.findDuplicates(cities))));
//        6.
        final String[] cities1 = new String[]{"Rome", "Brussels", "Madrid", "Athens", "Stockholm"};
        final String[] cities2 = new String[]{"Washington D.C.", "Rome", "London", "Bucharest", "Athens", "Budapest"};
        System.out.println(String.join(", ", Arrays.asList(op.intersection(cities1, cities2))));
//        7.
        final int[] ints = new int[]{2, 3, 1, 4, 6, 8, 9, 7, 5, 2};
        System.out.println(String.join(", ", Arrays.stream(op.mergeSort(ints)).mapToObj(Objects::toString).toList()));
    }
}