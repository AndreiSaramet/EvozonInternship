public class Main {
/*
    Assignment - if-else

    Rezolvati urmatoarele exercitii in aceiasi solutie "JavaBasics":

    1. Creati o clasa Calculator, in care sa mutati din main toate metodele care tin de aceasta clasa (adunare, scadere, etc...). Dupa ce toate metodele au fost mutate, testati ca inca functioneaza, apelandu-le in clasa Main, si metoda main().

    Pentru asta, va trebui sa va creati un obiect de clasa Calculator, in metoda main(), si de pe obiect sa apelati fiecare metoda.

    Tineti minte, doar metoda main() are drept de rulare, deci doar ce punem in ea se va excecuta. Ea apeleaza restul metodelor.

    Atentie: Dupa ce ati mutat metodele, sa scoateti cuvantul static din definitia metodelor. Doar metodele din clasa Main ce metoda main() le apeleaza direct vor ramane statice.

    2. Creati o clasa LogicalOp, in care sa rezolvati exercitiile de mai jos.

    3. In clasa LogicalOp, creati o metoda de tip int, care sa se numeasca checkBiggerNumber(), si sa primeasca doua int-uri ca si parametrii. Folosind if - else, verificati in interiorul metode care numar este mai mare, dintre cele doua valori care va vin ca si parametrii, si returnati numarul mai mare.

    Pentru a testa aceasta metoda, mergeti in metoda main(), din clasa Main, si construiti un obiect de tip LogicalOp, si apelati metoda cu valori. Fiind o metoda de tip int, ea va returna o valoare, pe care noi trebuie sa o prindem si ca sa o vedem, trebuie sa o afisam in consola.

    4. Creati o metoda de tip String, care sa primeasca un parametru de tip String. Verificati daca textul ce vine ca si parametru este egal cu “Evozon”. Daca da, atunci metoda sa returneze “Learning text comparison”. Daca nu, atunci metoda sa returneze “Got to try some more”.

    Indiciu 1: Textul nu se compara cu ==,  ci cu .equals().

    Indiciu 2: .equals() compara si literele mici si cele mari, si le vede diferite. (adica “test” nu este egal cu “Test”).

    Apelati metoda in metoda main() pentru a vedea daca functioneaza.

    Atentie: se va folosi obiectul de LogicalOp creat pentru exercitiul de mai sus. Pentru a apela mai multe metode din aceeasi clasa e suficient sa se construiasca un singur obiect de clasa respectiva.

    5. Creati o metoda de tip String, care sa primeasca un parametru de tip String, si un parametru de tip int. Daca textul primit ca si parametru este egal cu “Evozon”, si numarul primit ca si parametru este mai mic sau egal cu 3, returnati textul si numarul, in ordinea asta. Daca textul nu este “Evozon” si numarul este mai mare sau egal cu 4, returnati numarul si textul, in ordinea asta. Apelati metoda in main() pentru a verifica daca functioneaza.

    6. Creati o metoda de tip String, care sa primeasca un parametru de tip int. Daca numarul primit este mai mare de 8, SAU egal cu 6, atunci sa se returneze “The amount of snow this winter was(cm): “ si numarul. Daca nu, sa returneze “The forecast snow is(cm):” si numarul. Apelati metoda in main() pentru a verifica daca functioneaza.

    7. Creati o metoda de tip String, care sa primeasca un parametru de tip numar. Daca numarul e mai mare decat 3, SI nu egal cu 4, returnati “The number is greater than 3 and not equal to 4”. Daca numarul este egal cu 4, returnati “The number is equal to 4”, iar daca numarul este mai mic de 3 returnati “The number is lower than 3”. Apelati metoda in main() pentru a verifica daca functioneaza.

    8. Creati o metoda care primeste un numar ca si parametru si sa afiseze ce numar a primit. Folosind constructia Switch-Case, verificati ce numar s-a primit si afisati textul "The number is:  x !" unde x trebuie sa reprezinte numarul apasat. Pentru exemplul de fata sa nu se foloseasca concatenarea stringului "The number is:" cu numarul de la parametru, ci sa se scrie intreg textul cu tot cu numar pentru fiecare caz din Switch-Case. Apelati metoda in main() pentru a verifica daca functioneaza.

    9. Creati o metoda care sa se numeasca isNumberEven. Metoda trebuie sa primeasca ca parametru un numar, si sa returneze adevarat sau fals. Daca numarul e par sa returneze true iar daca e impar sa returnese false. Apelati metoda in main() pentru a verifica daca functioneaza.

    10. Creati o metoda care sa se numeasca isEligibleToVote. Metoda sa primeasca ca si parametru un numar, care sa reprezinte varsta, iar metoda sa iti zica daca daca persoana are drept de vot. Daca varsta e peste 18, sa se returneze true iar daca nu, sa returneze false. Apelati metoda in main() pentru a verifica daca functioneaza.

    11. Creati o metoda care sa primeasca 3 numere ca si parametrii si sa returneze cel mai mare numar. Apelati metoda in main() pentru a verifica daca functioneaza.
     */
    public static void main(String[] args) {
//         1.
        int a, b;
        final Calculator calculator = new Calculator();
        a = 5;
        b = 7;
        System.out.printf("%d + %d = %d\n", a, b, calculator.add(a, b));
        a = 129;
        b = 319;
        System.out.printf("%d - %d = %d\n", a, b, calculator.subtract(a, b));
        a = 2;
        b = 8;
        System.out.printf("%d * %d = %d\n", a, b, calculator.multiply(a, b));
        a = 81;
        b = 9;
        System.out.printf("%d / %d = %f\n", a, b, calculator.divide(a, b));
        System.out.println(calculator.mean(4, 7, 12));
        System.out.println(calculator.remainder(5, 3));
//        3.
        LogicalOp op = new LogicalOp();
        System.out.printf("The bigger number is: %d\n", op.checkBiggerNumber(8, 1));
//        4.
        System.out.println(op.compare("evoZon"));
        System.out.println(op.compare("Evozon"));
//        5.
        System.out.println(op.compare("Evozon", 1));
        System.out.println(op.compare("Evozon", 4));
        System.out.println(op.compare("evozon", 4));
        System.out.println(op.compare("evozon", 1));
//        6.
        System.out.println(op.snowLevel(15));
        System.out.println(op.snowLevel(7));
        System.out.println(op.snowLevel(6));
//        7.
        System.out.println(op.checkCondition(1));
        System.out.println(op.checkCondition(4));
        System.out.println(op.checkCondition(Math.PI));
//        8.
        op.checkNumber(4);
        op.checkNumber(0);
        op.checkNumber(10);
        op.checkNumber(1);
        op.checkNumber(11);
//        9.
        System.out.println(op.isNumberEven(5));
        System.out.println(op.isNumberEven(12));
//        10.
        System.out.println(op.isEligibleToVote(18));
//        11.
        System.out.println(op.max(1, 2, 3));
        System.out.println(op.max(1, 3, 2));
        System.out.println(op.max(2, 1, 3));
        System.out.println(op.max(2, 3, 1));
        System.out.println(op.max(3, 1, 2));
        System.out.println(op.max(3, 2, 1));
    }


}