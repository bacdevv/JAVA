package example.p08_collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

@SuppressWarnings("unused")
public class MapExample {
	
	public static void main(String[] args) {
		/* interface Map<K, V>
		 * HashMap<K, V>: unordered, unsynchronized, 1 null key
		 * Hashtable<K, V>: unordered, synchronized, 0 null key/value
		 * LinkedHashMap<K, V>: ordered (insertion order), unsynchronized, 1 null key
		 * 
		 * interface SortedMap<K, V>
		 * TreeMap<K, V>: ordered (natural order or Comparator) of Keys, unsynchronized, 0 null key
		 * 
		 * Map.Entry<K, V>
		 */
		
		/* HashMap, Hashtable, LinkedHashMap class */
		
		HashMap<String, Integer> map1 = new HashMap<>();
		HashMap<String, Integer> map2 = new HashMap<>(15);
		HashMap<String, Integer> map3 = new HashMap<>(15, 0.5f);
		HashMap<String, Integer> map4 = new HashMap<>(Map.of(
				"Python", 1991, "Go", 2009, "C#", 2000, "Scala", 2004,
				"Java", 1995, "C++", 1985, "JavaScript", 1995, "C", 1972
//				, null, null, "Kotlin", null
		));
		HashMap<String, Integer> map5 = new HashMap<>() {
			{
				put("Python",1991);
				put("Go",2009);
				put("C#",2000);
				put("Scala",2004);
				put("Java",1995);
				put("C++",1985);
				put("JavaScript",1995);
				put("C",1972);
				put(null,null);
				put("Kotlin",null);
			}
		};
		
		System.out.println(map5);
		String key = "Scala";
		System.out.println(key + " : " + map5.get(key));
		System.out.println("Get Default value = " + map5.getOrDefault("Key", 0));
		String newKey = "Rust";
		System.out.println(newKey + " : " + map5.put(newKey, 2015)); // Returns null if the key is absent
		System.out.println(newKey + " : " + map5.put(newKey, 2010)); // Replace the new value and returns the old value if the key is present 
		newKey = "Swift";
		System.out.println(newKey + " : " + map5.putIfAbsent(newKey, 2004)); // Returns null if the key is absent
		System.out.println(newKey + " : " + map5.putIfAbsent(newKey, 2014)); // Returns the new value if the key is present 
		System.out.println(newKey + " : " + map5.replace(newKey, 2014));
		System.out.println(map5);
		
		System.out.println(map5.containsKey(newKey));
		System.out.println(map5.containsValue(2010));
		
		System.out.println(map5.computeIfAbsent("Kotlin", v -> 2014));
		System.out.println(map5.computeIfAbsent("Kotlin", v -> 2016));
		System.out.println(map5.computeIfPresent("Kotlin", (k, v) -> 2016 ));
		System.out.println(map5.remove(null));
		
		map5.replaceAll((k, v) -> v + 1000);
		System.out.println(map5);
		
		System.out.println(map5.compute("Java", (k, v) -> v - 1000));
		System.out.println(map5);
		
		System.out.println(map5.merge("Java", 5, (oldValue, newValue) ->  oldValue + newValue));
		System.out.println(map5);
		
		System.out.println("-".repeat(30));
		
		Set<String> keySet = map5.keySet();
		System.out.println("Key Set: " + keySet);
		
		Collection<Integer> valueCollection = map5.values();
		System.out.println("Value Collection: " + valueCollection);
		System.out.println(valueCollection.toArray(Integer[]::new));
		
		Set<Entry<String, Integer>> entrySet = map5.entrySet();
		System.out.println("Entry Set: " + entrySet);
		for (Entry<String, Integer> entry : entrySet) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		/* TreeMap class
		 *
		 * descendingMap()		 
		 * descendingKeySet()
		 */
		TreeMap<String, Integer> treeMap1 = new TreeMap<>();
		TreeMap<String, Integer> treeMap2 = new TreeMap<>(Map.of(
				"Python", 1991, "Go", 2009, "C#", 2000, "Scala", 2004,
				"Java", 1995, "C++", 1985, "JavaScript", 1995, "C", 1972,
				"Kotlin", 2016
		));
		TreeMap<String, Integer> treeMap3 = new TreeMap<>(Comparator.reverseOrder());
		
		System.out.println(treeMap2);
		System.out.println(treeMap2.descendingMap());
		System.out.println(treeMap2.descendingKeySet());		
		
	}

}
