public class Main {
    /*
        Assignment - While loop

        Rezolvati urmatoarele exercitii in proiectul de Calculator folosind bucle WHILE:

        1. Creati o metoda in clasa LogicalOp, care sa primeasca un numar ca si parametru. Metoda sa verifice numarul primit, si sa afiseze in consola o numaratoare pana la 100, pornind de la numarul primit ca si parametru. Atentie la crearea tipului metodei, deoarece metoda afiseaza, nu returneaza.

         Apelati metoda in clasa Main, metoda main() pentru a verifica daca functioneaza.

        2. Creati o metoda in clasa LogicalOp, care sa primeasca un numar ca si parametru. Metoda sa verifice numarul primit, si sa afiseze in consola o numaratoare pana la -100, pornind de la numarul primit ca si parametru. Atentie la crearea tipului metodei, deoarece metoda afiseaza, nu returneaza.

         Apelati metoda in clasa Main, metoda main() pentru a verifica daca functioneaza.

        3. Creati o metoda in clasa LogicalOp, care sa primeasca doi parametrii de tip numar. Metoda sa afiseze o numaratoare intre cele doua numere primite, pornind de la primul parametru primit, pana la cel de-al doilea(ex: daca int x e primul parametru iar int y  este cel de-al doilea, numaratoarea sa se faca de la x, la y.

        Atentie la crearea tipului metodei, deoarece metoda afiseaza, nu returneaza.

        Apelati metoda in clasa Main, metoda main() pentru a verifica daca functioneaza.

        4. Creati o metoda in clasa LogicalOp, care sa primeasca doi parametrii de tip numar. Metoda trebuie sa verifice care dintre cele doua numere este mai mare, si sa execute o numaratoare crescatoare de la cel mai mic la cel mai mare.(ex: daca int x e primul parametru iar int y  este cel de-al doilea, daca x  este mai mare decat y,  atunci numaratoarea sa fie de la y la x).

        Atentie la crearea tipului metodei, deoarece metoda afiseaza, nu returneaza.

        Apelati metoda in clasa Main, metoda main() pentru a verifica daca functioneaza.

        5. Creati o metoda in clasa LogicalOp care sa afiseze toate numerele pare de la 1 la 100.
        6. Creati o metoda in clasa LogicalOp care sa afiseze toate numerele impare de la 1 la 100.

        7. Creati o metoda care sa adune toate numerele din intervalul 111 si 8899. Sa se afiseze suma totala, iar dupa aceea sa se calculeze si afiseze media numerelor din acel interval. Introduceti o variabila int count in metoda, pentru a numara toate numerele din interval. Apelati metoda in clasa Main, metoda main() pentru a verifica daca functioneaza.

        8. Creati o metoda care sa primeasca doi parametrii de tip numar, si sa returneze media numerelor divizibile cu 7, din acel interval. Apelati metoda in clasa Main, metoda main() pentru a verifica daca functioneaza.

        9. Creati o metoda care sa afiseze primele 20 de numere din sirul lui Fibonacci.

        10. Creati o metoda numita CozaLozaWoza.

        Metoda va afisa:

        - numerele de la 1 la 110

        - 11 numere pe linie

        - se va afisa Coza pentru numerele care sunt multiplu de 3 (1 2 Coza 4)

        - se va afisa Loza pentru numerele care sunt multiplu de 5 (2 3 4 Loza 6)

        - se va afisa Woza pentru numerele care sunt multiplu de 7 (4 5 6 Woza 8)

        - se va afisa CozaLoza pentru numerele care sunt multiplu de 3 SI 5

        - se va afisa CozaWoza pentru multiplu de 3 SI 7

        - se va afisa WozaLoza pentru multiplu de 5 SI 7

        - se va afisa CozaLozaWoza pentru multiplu de 3 SI 5 SI 7

        Apelati metoda in main() pentru a verifica daca functioneaza.
     */
    public static void main(String[] args) {
        LogicalOp op = new LogicalOp();
//        1.
        op.countUp1(101);
        op.countUp1(15);
//        2.
        op.countDown1(-101);
        op.countDown1(15);
//        3.
        op.countFromTo1(3, 19);
        op.countFromTo1(100, 99);
//        4.
        op.countIncreaseFromTo1(2, 7);
        op.countIncreaseFromTo1(87, 76);

//        5.
        op.displayEven1To1001();
//        6.
        op.displayOdd1To1001();
//        7.
        op.from111to8899();
//        8.
        op.multiples7(8, 13);
        op.multiples7(1, 100);
//        9.
        op.fibonacci();
//        10.
        op.cozaLozaWoza();
    }
}