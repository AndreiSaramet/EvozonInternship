import java.util.ArrayList;
import java.util.List;

public class Main {
    /*
    Rezolvati urmatoarele exercitii:

    Scrieti o metoda Java care sa schimbe pozitia a doua elemente intr-o Lista,
    Scrieti o metoda Java care sa primeasca o Lista si sa returneze o alta lista, care sa contina doar numerele pare din lista primita.
    Scrieti o metoda Java care sa primeasca parametru o Lista nesortata, si sa returneze Lista sortata crescator. Atentie, sortarea sa se faca programatic(adica logica sa fie scrisa de voi), si nu folosit librarie externa, precum Collection.sort().
     */
    public static void main(String[] args) {
        LogicalOp op = new LogicalOp();
//        Optional Lists 1
        final List<String> strings = new ArrayList<>(List.of("New York", "London", "Beijing", "Rome"));
        op.swap(strings, "London", "Rome");
        System.out.println(String.join(", ", strings));
//        Optional Lists 2
        final List<? extends Integer> integers = List.of(2, 3, 1, 4, 6, 8, 9, 7, 5, 2);
        System.out.println(String.join(", ", op.onlyEvens(integers).stream().map(Object::toString).toList()));
//        Optional Lists 3
        System.out.println(String.join(", ", op.mergeSort(integers).stream().map(Object::toString).toList()));
    }
}