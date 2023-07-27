public class Main {
    /*
    Assignment - For loops

    Rezolvati urmatoarele exercitii in proiectul de Calculator folosind bucle FOR:

    1. Creati o metoda in clasa LogicalOp, care sa primeasca un numar ca si parametru. Metoda sa verifice numarul primit, si sa afiseze in consola o numaratoare pana la 100, pornind de la numarul primit ca si parametru. Atentie la crearea tipului metodei, deoarece metoda afiseaza, nu returneaza.

     Apelati metoda in clasa Main, metoda main() pentru a verifica daca functioneaza.

    2. Creati o metoda in clasa LogicalOp, care sa primeasca un numar ca si parametru. Metoda sa verifice numrul primit, si sa afiseze in consola o numaratoare pana la -100, pornind de la numarul primit ca si parametru. Atentie la crearea tipului metodei, deoarece metoda afiseaza, nu returneaza.

     Apelati metoda in clasa Main, metoda main() pentru a verifica daca functioneaza.

    3. Creati o metoda in clasa LogicalOp, care sa primeasca doi parametrii de tip numar. Metoda sa afiseze o numaratoare intre cele doua numere primite, pornind de la primul parametru primit, pana la cel de-al doilea(ex: daca int xe primul parametru iar int y  este cel de-al doilea, numaratoarea sa se faca de la x, la y.

    Atentie la crearea tipului metodei, deoarece metoda afiseaza, nu returneaza.

    Apelati metoda in clasa Main, metoda main() pentru a verifica daca functioneaza.

    4. Creati o metoda in clasa LogicalOp, care sa primeasca doi parametrii de tip numar. Metoda trebuie sa verifice care dintre cele doua numere este mai mare, si sa execute o numaratoare crescatoare de la cel mai mic la cel mai mare.(ex: daca int x e primul parametru iar int y  este cel de-al doilea, daca x  este mai mare decat y,  atunci numaratoarea sa fie de la y la x).

    Atentie la crearea tipului metodei, deoarece metoda afiseaza, nu returneaza.

    Apelati metoda in clasa Main, metoda main() pentru a verifica daca functioneaza.

    5. Creati o metoda in clasa LogicalOp care sa afiseze toate numerele pare de la 1 la 100.
    6. Creati o metoda in clasa LogicalOp care sa afiseze toate numerele impare de la 1 la 100.

    7. Creati o metoda in clasa LogicalOp care sa primeasca un parametru de tip numar. Metoda sa adune toate numerele pana la 100, pornind de la numarul primit ca si parametru, iar la final sa returneze rezultatul. Apelati metoda in clasa Main, metoda main() pentru a verifica daca functioneaza.


    8. Creati o metoda in clasa LogicalOp care sa primeasca un parametru de tip numar. Metoda sa adune toate numerele pana la 100, pornind de la numarul primit ca si parametru, si sa calculeze media numerelor. La final, metoda sa returneze media. Apelati metoda in clasa Main, metoda main() pentru a verifica daca functioneaza.

    9. Creat o metoda in clasa LogicalOp care sa afiseze urmatorul tipar:

    *******

    ******

    *****

    ****

    ***

    **

    *

    Cateva mentiuni:
    - pentru a putea rezolva problema, trebuie folosite doua bucle for. O bucla se va construi in alta bucla.

    - prima bucla for se va ocupa de afisarea pe orizontala, si cealalta pe verticala

    - semnul asterisk (*) se poate afisa sub forma de string

    Apelati metoda in clasa Main, metoda main() pentru a verifica daca functioneaza
     */
    public static void main(String[] args) {
//        1.
        LogicalOp op = new LogicalOp();
        op.countUp(101);
        op.countUp(15);
//        2.
        op.countDown(-101);
        op.countDown(15);
//        3.
        op.countFromTo(3, 19);
        op.countFromTo(100, 99);
//        4.
        op.countIncreseFromTo(2, 7);
        op.countIncreseFromTo(87, 76);
//        5.
        op.displayEven1To100();
//        6.
        op.displayOdd1To100();
//        7.
        System.out.println(op.sumTo100(47));
        System.out.println(op.sumTo100(101));
//        8.
        System.out.println(op.meanTo100(47));
        System.out.println(op.meanTo100(101));
//        9.
        op.displayPattern();
    }


}