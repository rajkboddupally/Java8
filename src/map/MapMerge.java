package map;

import java.util.*;

public class MapMerge {


    public static void main(String[] args) {
        String[] arr = {"hello", "welcome", "to", "the", "the", "welcome", "world"};
        List<String> list = List.of(arr);
        Map<String, Integer> map = new HashMap<>();

        list.forEach(word -> {
            /*
            map.putIfAbsent(s, 0);
            map.computeIfPresent(s, (k, v) -> v + 1);
            */

            //map.compute(word, (k, v) -> v != null ? v + 1 : 1);

            //if new value is null remove from the Map.
            map.merge(word, 1, (k, v) -> null);

            //set to 1 if key is not present, else add 1 to the existing value v
            map.merge(word, 1, (k, v) -> v + 1);

        });

        for (String key : map.keySet()) {
            System.out.println("key -" + key + " :Value -" + map.get(key));
        }
    }

}
