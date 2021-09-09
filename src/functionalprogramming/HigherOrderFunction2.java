package functionalprogramming;

/* Raj Kumar Boddupally created on 8/16/2021 inside the package - functionalprogramming */

import java.util.Comparator;

public class HigherOrderFunction2 {
    public static void main(String[] args) {
        String[] input = {"cat", "dog", "ball", "apple"};
        System.out.println("Input");
        print(input);
        sort(input, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("Anonymous Innerclass");
        print(input);
        //Java 8 - Lambda expression
        sort(input, (o1, o2) -> o1.compareTo(o2));
        System.out.println("Lambda expression");
        print(input);
        System.out.println("Comparator.naturalOrder()");
        sort(input, Comparator.naturalOrder());
        print(input);
        System.out.println("Anonymous reverse order");
        sort(input, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        print(input);
        sort(input, Comparator.reverseOrder());
        System.out.println("Comparator.reverseOrder()");
        print(input);
        sort(input, String::compareTo);
        System.out.println("Method reference String::compareTo");
        print(input);


    }

    private static void sort(String[] input, Comparator<String> tComparator) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 1; j < input.length - i; j++) {
                if (tComparator.compare(input[j], input[j - 1]) < 0) {
                    swap(input, j, j - 1);
                }
            }
        }
    }

    private static void swap(String[] input, int x, int y) {
        String temp = input[x];
        input[x] = input[y];
        input[y] = temp;
    }

    private static <T> void print(T[] input) {
        for (T t : input) {
            System.out.print(t + " ");
        }
        System.out.println();
    }
}
