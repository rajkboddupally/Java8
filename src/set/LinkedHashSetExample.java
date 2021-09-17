package set;

/* Raj Kumar Boddupally created on 9/17/2021 inside the package - streams */
/*
Maintain the order of elements inserted to set. Internally uses LinkedHashMap to store elements
It uses Doubly Linked List
 */

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetExample {
    public static void main(String[] args) {
        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("130");
        linkedHashSet.add("134");
        linkedHashSet.add("1323");
        linkedHashSet.add("131");
        linkedHashSet.add("13232");

        linkedHashSet.forEach(System.out::println);
    }
}
