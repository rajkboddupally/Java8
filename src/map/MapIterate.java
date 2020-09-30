package map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;

public class MapIterate {

	public static void main(String[] args) {
		Map<Integer, String> m = new HashMap<>();
		List<String> arr = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			m.put(i, "" + i);
			arr.add("-"+i);
		}

		// 1. Using Iterator
		Iterator<Entry<Integer, String>> i = m.entrySet().iterator();

		while (i.hasNext()) {

			Entry<Integer, String> e = i.next();
			//System.out.println(e.getKey() + " - " + e.getValue());
		}
		
		//2. Java 8 forEach
		//m.forEach((k,v) -> System.out.println(k + " ** " + v));
		
		//3. Java 8 streams
		//m.entrySet().stream().forEach((e) -> System.out.println(e.getKey() + " ## "+e.getValue()));
		//arr.stream().forEach((s) -> System.out.println(s.toUpperCase()));
		
		//4. Using for
		for(int k:m.keySet()) {
			System.out.println(k + "+" +m.get(k));
		}
		
		
	}

}
