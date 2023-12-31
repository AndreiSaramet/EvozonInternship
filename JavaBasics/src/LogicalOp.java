import java.util.*;

public class LogicalOp {
    //    If-else 3
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

    //    If-else 4
    public String compare(final String string) {
        if ("Evozon".equals(string)) {
            return "Learning text comparison";
        }
        return "Got to try some more";
    }

    //    If-else 5
    public String compare(final String string, final int number) {
        if ("Evozon".equals(string) && number <= 3) {
            return String.format("%s, %d", string, number);
        }
        if (!"Evozon".equals(string) && number >= 4) {
            return String.format("%d, %s", number, string);
        }
        return "No condition matched";
    }

    //    If-else 6
    public String snowLevel(final int amount) {
        if (amount > 8 || amount == 6) {
            return String.format("The amount of snow this winter was(cm): %d", amount);
        }
        return String.format("The forecast snow is(cm): %d", amount);
    }

    //    If-else 7
    public String checkCondition(final double number) {
        if (number > 3 && number != 4) {
            return "The number is greater than 3 and not equal to 4";
        }
        if (number == 4) {
            return "The number is equal to 4";
        }
        return "The number is lower than 3";
    }

    //    If-else 8
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

    //    If-else 9
    public boolean isNumberEven(final int number) {
        if (number % 2 == 0) {
            return true;
        }
        return false;
//        variant without if
//        return number % 2 == 0;
    }

    //    If-else 10
    public boolean isEligibleToVote(final double age) {
        if (age >= 18) {
            return true;
        }
        return false;
//        variant without if
//        return age >= 18;
    }

    //    If-else 11
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

    //    For-loops 1.
    public void countUp(int number) {
        if (number <= 100) {
            for (; number <= 100; number++) {
                System.out.printf("%d ", number);
            }
        } else {
            for (; number >= 100; number--) {
                System.out.printf("%d ", number);
            }
        }
        System.out.println();
    }

    //    For-loops 2
    public void countDown(int number) {
        if (number >= -100) {
            for (; number >= -100; number--) {
                System.out.printf("%d ", number);
            }
        } else {
            for (; number <= -100; number++) {
                System.out.printf("%d ", number);
            }
        }
        System.out.println();
    }

    //    For-loops 3
    public void countFromTo(int start, int end) {
        if (start <= end) {
            for (; start <= end; start++) {
                System.out.printf("%d ", start);
            }
        } else {
            for (; start >= end; start--) {
                System.out.printf("%d ", start);
            }
        }
        System.out.println();
    }

    //    For-loops 4
    public void countIncreaseFromTo(int start, int end) {
        if (end < start) {
            final int cpy = start;
            start = end;
            end = cpy;
        }
        for (; start <= end; start++) {
            System.out.printf("%d ", start);
        }
        System.out.println();
    }

    //    For-loops 5
    public void displayEven1To100() {
//        As 1 is not an even number, we start displaying from 2
        int start = 2;
        for (; start <= 100; start += 2) {
            System.out.printf("%d ", start);
        }
        System.out.println();
    }

    //    For-loops 6
    public void displayOdd1To100() {
        int start = 1;
        for (; start <= 100; start += 2) {
            System.out.printf("%d ", start);
        }
        System.out.println();
    }

    //    For-loops 7
    public int sumTo100(int number) {
        if (number > 100) {
            System.out.printf("No sum can be computed from %d to 100\n", number);
            return -1;
        }
        int sum = 0;
        for (; number <= 100; number++) {
            sum += number;
        }
        return sum;
//        a shorter alternative using sum of consecutive numbers from 1 to 100 and from 1 to number
//        return (100 * 101 - (number - 1) * number) / 2;
    }

    //    For-loops 8
    public double meanTo100(int number) {
        if (number > 100) {
            System.out.printf("No mean can be computed from %d to 100\n", number);
            return -1;
        }
        return (double) this.sumTo100(number) / (100 - number + 1);
    }

    //    For-loops 9
    public void displayPattern() {
        int start = 7;
        for (; start > 0; start--) {
            int length = start;
            final StringBuilder line = new StringBuilder();
            for (; length > 0; length--) {
                line.append("*");
            }
            System.out.println(line);
        }
    }

    //    While loops 1
    public void countUp1(int number) {
        if (number <= 100) {
            while (number <= 100) {
                System.out.printf("%d ", number);
                number++;
            }
        } else {
            while (number >= 100) {
                System.out.printf("%d ", number);
                number--;
            }
        }
        System.out.println();
    }

    //   While loops 2
    public void countDown1(int number) {
        if (number >= -100) {
            while (number >= -100) {
                System.out.printf("%d ", number);
                number--;
            }
        } else {
            while (number <= -100) {
                System.out.printf("%d ", number);
                number++;
            }
        }
        System.out.println();
    }

    //    While loops 3
    public void countFromTo1(int start, int end) {
        if (start <= end) {
            while (start <= end) {
                System.out.printf("%d ", start);
                start++;
            }
        } else {
            while (start >= end) {
                System.out.printf("%d ", start);
                start--;
            }
        }
        System.out.println();
    }

    //    While loops 4
    public void countIncreaseFromTo1(int start, int end) {
        if (end < start) {
            final int cpy = start;
            start = end;
            end = cpy;
        }
        while (start <= end) {
            System.out.printf("%d ", start);
            start++;
        }
        System.out.println();
    }

    //    While loops 5
    public void displayEven1To1001() {
        int start = 2;
        while (start <= 100) {
            System.out.printf("%d ", start);
            start += 2;
        }
        System.out.println();
    }

    //    While loops 6
    public void displayOdd1To1001() {
        int start = 1;
        while (start <= 100) {
            System.out.printf("%d ", start);
            start += 2;
        }
        System.out.println();
    }

    //    While loops 7
    public void from111to8899() {
        int start = 111;
        int end = 8899;
        int count = 0;
        int sum = 0;
        for (; start <= end; start++) {
            sum += start;
            count++;
        }
        System.out.printf("Sum of numbers from 111 to 8899 is %d\n", sum);
        System.out.printf("Mean of numbers from 111 to 8899 is %f\n", (double) sum / count);
    }

    //    While loops 8
    public void multiples7(final int start, final int end) {
        int sum = 0;
        int count = 0;
        int startC = start;
        while (startC <= end && startC % 7 != 0) {
            startC++;
        }
        while (startC <= end) {
            sum += startC;
            count++;
            startC += 7;
        }
        System.out.printf("The mean of multiples of 7 from %d to %d is %f\n", start, end, count != 0 ? (double) sum / count : 0);
    }

    //    While loops 9
    public void fibonacci() {
        int f1 = 0;
        int f2 = 1;
        System.out.printf("%d, %d", f1, f2);
        int f3;
        int count = 18;
        while (count > 0) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
            System.out.printf(", %d", f3);
            count--;
        }
        System.out.println();
    }

//    While loops 10

    public void cozaLozaWoza() {
        int start = 1;
        int end = 110;
        int count = 0;
        while (start <= end) {
            String toPrint;
            if (start % 105 == 0) {
                toPrint = "CozaLozaWoza";
            } else if (start % 15 == 0) {
                toPrint = "CozaLoza";
            } else if (start % 21 == 0) {
                toPrint = "CozaWoza";
            } else if (start % 35 == 0) {
                toPrint = "WozaLoza";
            } else if (start % 3 == 0) {
                toPrint = "Coza";
            } else if (start % 5 == 0) {
                toPrint = "Loza";
            } else if (start % 7 == 0) {
                toPrint = "Woza";
            } else {
                toPrint = Integer.toString(start);
            }
            System.out.printf("%s ", toPrint);
            count++;
            if (count == 11) {
                System.out.println();
                count = 0;
            }
            start++;
        }
    }

    //    Arrays 2
    public void initialiseArray() {
        final int[] array = new int[100];
        for (int i = 1; i <= 100; i++) {
            System.out.printf("At position %d is written %d\n", i - 1, i);
            array[i - 1] = i;
        }
    }

    //    Arrays 3
    public int[] initialiseEvenArray(final int[] array) {
        for (int i = 2; i <= 100; i++) {
            array[i / 2 - 1] = i;
        }
        return array;
    }

    //    Arrays 4
    public double initialiseRandom(final double[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (Math.random() * 100000) % 1000;
        }
        double mean = 0;
        for (final double el : array) {
            mean += el;
        }
        return mean / array.length;
    }

    //    Arrays 5
    public boolean isInArray(final String[] strings, final String string) {
        for (final String el : strings) {
            if (string.equals(el)) {
                return true;
            }
        }
        return false;
    }

    //    Arrays 6
    public Integer positionOf(final double[] doubles, final double number) {
        for (int index = 0; index < doubles.length; index++) {
            if (number == doubles[index]) {
                return index;
            }
        }
        System.out.println("The element was not found!");
        return null;
    }

    //    Arrays 7
    public void displayDashPattern() {
        int size = 10;
        final char[] line = new char[size];
        Arrays.fill(line, '-');
        for (; size > 0; size--) {
            System.out.println(line);
        }
    }

    //    Arrays 8
    public double[] remove(final double[] doubles, final double number) {
        int index;
        for (index = 0; index < doubles.length; index++) {
            if (doubles[index] == number) {
                break;
            }
        }
        if (index == doubles.length) {
            System.out.println("The element was not found, therefore, not removed");
            return null;
        }
        return Arrays.stream(doubles)
                .dropWhile(el -> el == number)
                .toArray();

    }

    //    Array 9
    public Double secondSmallest(final double[] doubles) {
        if (doubles.length == 0) {
            System.out.println("The array is empty");
            return null;
        }
        double min, min1;
        min = min1 = doubles[0];
        for (final double el : doubles) {
            if (el < min) {
                min1 = min;
                min = el;
            }
        }
        if (min == min1) {
            System.out.println("There is only one element in the whole array");
            return null;
        }
        return min1;
    }

    //    Array 10
    public double[] copy(final double[] array1, final double[] array2) {
        for (int index = 0; index < array1.length; index++) {
            array2[index] = array1[index];
        }
        return array2;
    }

//    Optional Arrays 1
//    Identical with Arrays 9

    //    Optional Arrays 2
    public void insertAt(final String[] strings, final int position, final String string) {
        for (int index = strings.length - 1; index > position; index--) {
            strings[index] = strings[index - 1];
        }
        strings[position] = string;
    }

    //    Optional Arrays 3
    public void findMinMax(final double[] doubles) {
        if (doubles.length == 0) {
            System.out.println("The array is empty");
        }
        double min, max;
        min = max = doubles[0];
        for (final double el : doubles) {
            if (min > el) {
                min = el;
            }
            if (max < el) {
                max = el;
            }
        }
        System.out.printf("The minimum of the array is %f and the maximum is %f\n", min, max);
    }

    //    Optional Arrays 4
    public void reverse(final String[] strings) {
        for (int index = 0; index <= strings.length / 2; index++) {
            final String copy = strings[index];
            strings[index] = strings[strings.length - index - 1];
            strings[strings.length - index - 1] = copy;
        }
    }

    //    Optional Arrays 5
    public String[] findDuplicates(final String[] strings) {
//        these two arrays would simulate a map used for storing the frequency of each element of the array
        final String[] elements = new String[strings.length];
        final int[] frequencies = new int[strings.length];
        int size = 0;
        for (final String el : strings) {
            int index;
            for (index = 0; index < size; index++) {
                if (el.equals(elements[index])) {
                    frequencies[index]++;
                    break;
                }
            }
            if (index == size) {
                elements[size] = el;
                frequencies[size]++;
                size++;
            }
        }
        final String[] duplicates = new String[size];
        int position = 0;
        for (int index = 0; index < size; index++) {
            if (frequencies[index] > 1) {
                duplicates[position++] = elements[index];
            }
        }
        return duplicates;
    }

    //    Optional Arrays 6
    public String[] intersection(final String[] strings1, final String[] strings2) {
        final String[] common = new String[Math.min(strings1.length, strings2.length)];
        int size = 0;
        for (final String el1 : strings1) {
            for (final String el2 : strings2) {
                if (el2.equals(el1)) {
                    common[size++] = el1;
                    break;
                }
            }
        }
        return common;
    }

    //    Optional Arrays 7
    public int[] merge(final int[] ints1, final int[] ints2) {
        final int[] result = new int[ints1.length + ints2.length];
        int size = 0;
        int index1, index2;
        index1 = index2 = 0;
        while (index1 < ints1.length && index2 < ints2.length) {
            if (ints1[index1] < ints2[index2]) {
                result[size++] = ints1[index1++];
            } else {
                result[size++] = ints2[index2++];
            }
        }
        while (index1 < ints1.length) {
            result[size++] = ints1[index1++];
        }
        while (index2 < ints2.length) {
            result[size++] = ints2[index2++];
        }
        return result;
    }

    public int[] mergeSort(final int[] ints) {
        if (ints.length == 1) {
            return ints;
        }
        int[] left = Arrays.copyOf(ints, ints.length / 2);
        int[] right = Arrays.copyOfRange(ints, ints.length / 2, ints.length);
        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }

    //    Lists 1
    public void displayList(final List<?> list) {
        list.forEach(System.out::println);
    }

    //    Lists 2
    public void append(final List<Integer> list, final Integer number) {
        list.add(number);
    }

    //    Lists 3
    public void displayFrom(final List<? extends Integer> integers, Integer number) {
        int position = integers.indexOf(number);
        if (position == -1) {
            System.out.println("The number is not in the given list");
            return;
        }
        integers.stream()
                .skip(position)
                .forEach(System.out::println);
    }

    //    Lists 4
    public void displayReverse(final List<?> list) {
        Collections.reverse(list);
        list.forEach(System.out::println);
    }

    //    Lists 5
    public void insertAt(final List<String> strings, final int position, final String string) {
        strings.add(position, string);
    }

    //    Lists 6
    public void addAtBeginning(final List<String> list, String obj) {
        list.add(0, obj);
    }

    //    Lists 7
    public void detailedDisplay(final List<?> list) {
        for (int index = 0; index < list.size(); index++) {
            System.out.printf("On position %d there is the value %s\n", index, list.get(index).toString());
        }
    }

    //    Lists 8
    public Number max(final List<? extends Integer> numbers) {
        return numbers.stream().max(Comparator.<Integer>naturalOrder()).orElseThrow(() -> new RuntimeException("The list is empty"));
    }

    //    Optional Lists 1
    public void swap(final List<String> strings, String string1, String string2) {
        Collections.swap(strings, strings.indexOf(string1), strings.indexOf(string2));
    }

    //    Optional Lists 2
    public List<? extends Integer> onlyEvens(final List<? extends Integer> integers) {
        return integers.stream().filter(el -> el % 2 == 0).toList();
    }

    public List<? extends Integer> merge(final List<? extends Integer> list1, final List<? extends Integer> list2) {
        final List<Integer> result = new ArrayList<>();
        int index1, index2;
        index1 = index2 = 0;
        while (index1 < list1.size() && index2 < list2.size()) {
            if (list1.get(index1) < list2.get(index2)) {
                result.add(list1.get(index1));
                index1++;
            } else {
                result.add(list2.get(index2));
                index2++;
            }
        }
        while (index1 < list1.size()) {
            result.add(list1.get(index1));
            index1++;
        }
        while (index2 < list2.size()) {
            result.add(list2.get(index2));
            index2++;
        }
        return result;
    }

    //    Optional Lists 3
    public List<? extends Integer> mergeSort(final List<? extends Integer> list) {
        if (list.size() == 1) {
            return list;
        }
        List<? extends Integer> left = list.subList(0, list.size() / 2);
        List<? extends Integer> right = list.subList(list.size() / 2, list.size());
        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }
}
