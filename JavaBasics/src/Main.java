import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    /*
    Assignment - Lists

    Rezolvati urmatoarele exercitii:

    Scrieti o metoda Java, care sa primeasca parametru o Lista, si sa afiseze, pe rand, toate valorile din lista, fiecare pe rand nou.
    Scrieti o metoda Java, care sa primeasca doi parametrii: un parametru sa fie o lista de numere, si celalalt un numar (real sau intreg). Metoda sa adauge numarul primit ca si parametru la final de lista.
    Scrieti o metoda Java, care sa primeasca doi parametrii: un parametru de tip Lista, iar celalalt un numar intreg. Sa se parcurga lista si sa afiseze, pe rand, toate valorile din lista, fiecare pe rand nou, pornind de la numarul intreg primit ca si parametru.
    Scrieti o metoda Java, care sa primeasca parametru o Lista, si sa afiseze, pe rand, toate valorile din lista, dar invers(de la capat la inceput).
    Scrieti o metoda Java, care sa primeasca trei parametrii: unul de tip Lista de String-uri, unul de tip intreg, si unul de tip String. Metoda sa adauge parametrul de tip String in lista primita, iar parametrul de tip intreg reprezinta pozitia la care sa fie pus acel String.
    Scrieti o metoda Java, care sa primeasca doi parametrii. Primul dintre ei va fi o Lista, iar metoda sa ia al doilea parametru si sa il adauge pe prima pozitie din lista.
    Scrieti o metoda Java care sa primeasca parametru o Lista, si sa afiseze ce valori are lista, si ce pe ce pozitie. (Ex: “Pe pozitia 1 valoare este 4”).
    Scrieti o metoda Java care sa primeasca o Lista si sa returneze cel mai mare numar din ea.
     */
    public static void main(String[] args) {
        LogicalOp op = new LogicalOp();
//        Lists 1
        final List<? extends String> strings = List.of("New York", "London", "Beijing", "Rome");
        op.displayList(strings);
//        Lists 2
        final List<Integer> integers = new ArrayList<>(List.of(1, 3, 5, 2, 9, 7, 4));
        op.append(integers, 72);
        System.out.println(integers.stream().map(Object::toString).collect(Collectors.joining(", ")));
//        List 3
        op.displayFrom(integers, 2);
        op.displayFrom(integers, 55);
//        List 4
        op.displayReverse(new ArrayList<>(strings));
//        List 5
        List<String> cities = new ArrayList<>(strings);
        op.insertAt(cities, 3, "Cluj-Napoca");
        System.out.println(String.join(", ", cities));
//        List 6
        op.addAtBeginning(cities, "Bucharest");
        System.out.println(String.join(", ", cities));
//        List 7
        op.detailedDisplay(cities);
        op.detailedDisplay(integers);
//        List 8
        System.out.println(op.max(integers));
    }
}