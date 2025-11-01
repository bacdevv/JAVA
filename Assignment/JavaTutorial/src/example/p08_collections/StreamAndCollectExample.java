package example.p08_collections;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

import example.p08_collections.demo_pet.*;

public class StreamAndCollectExample {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		/*
		 * collect(Collectors.toList()) // List<T>
		 * collect(Collectors.toCollection(ArrayList::new)) // ArrayList<T>
		 * collect(Collectors.toCollection(() -> new ArrayList<>()) // ArrayList<T>
		 * collect(Collectors.toMap(Demo::getKey, Demo::getValue, (e1, e2) -> e1, LinkedHashMap::new)) // LinkedHashMap<K, V>
		 * collect(Collectors.groupingBy(o -> //return K)) // HashMap<K, List<T>>
		 * collect(Collectors.groupingBy(Demo::getCommon)) // HashMap<K, List<T>>
		 * collect(Collectors.groupingBy(Demo::getCommon, Collectors.toSet())) // HashMap<K, Set<T>>
		 * collect(Collectors.groupingBy(Demo::getCommon, TreeMap::new, Collectors.toSet())) // TreeMap<K, Set<T>>
		 * collect(Collectors.groupingBy(Demo::getCommon, Collectors.mapping(Demo::getElement, Collectors.toSet()))) // Map<K, Set<E>>
		 * collect(Collectors.groupingBy(Demo::getCommon, Collectors.counting()) // Map<K, Long>
		 * collect(Collectors.groupingBy(Demo::getCommon, Collectors.summingDouble(...)) // Map<K, ...>
		 * 
		 */
		
		List<Pet> petList = generateSamplePets();
//		petList.forEach(System.out::println);
				
		//
		
		List<Pet> container1 = petList.stream()
				.collect(Collectors.toList());
		
		ArrayList<Pet> container2 = petList.stream()
				.collect(Collectors.toCollection(ArrayList::new));
		
		LinkedHashSet<Pet> container3 = petList.stream()
				.sorted(Comparator.comparing(Pet::getBirthDate).reversed())
				.collect(Collectors.toCollection(LinkedHashSet::new));
		
		TreeSet<Pet> container4 = petList.stream()
				.collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Pet::getName))));
		
		//
		
		Map<String, Pet> container5 = petList.stream()
				.collect(Collectors.toMap(Pet::getId, pet -> pet, (p1, p2) -> p1));
		
		LinkedHashMap<String, Pet> container6 = petList.stream()
				.collect(Collectors.toMap(
						Pet::getId,
						pet -> pet,
						(p1, p2) -> p1,
						LinkedHashMap::new
						));
		
		TreeMap<String, Pet> container7 = petList.stream()
				.collect(Collectors.toMap(
						Pet::getId,
						pet -> pet,
						(p1, p2) -> p1,
						() -> new TreeMap<>(Comparator.reverseOrder())
						));
		
		//
		
		Map<Species, List<Pet>> container8 = petList.stream()
				.collect(Collectors.groupingBy(pet -> pet.getSpecies()));
		
		Map<Species, Set<Pet>> container9 = petList.stream()
				.collect(Collectors.groupingBy(
						Pet::getSpecies,
						Collectors.toSet()
						));
		
		TreeMap<Species, Set<Pet>> container10 = petList.stream()
				.collect(Collectors.groupingBy(
						Pet::getSpecies,
						TreeMap::new,
						Collectors.toSet()
						));
		
		Map<String, List<Pet>> container11 = petList.stream()
				.collect(Collectors.groupingBy(pet -> {
					int month = pet.getBirthDate().getMonthValue();
					String season = null;
					switch(month) {
						case 1, 2, 3 -> season = "Spring"; 
						case 4, 5, 6 -> season = "Summer"; 
						case 7, 8, 9 -> season = "Autumn"; 
						case 10, 11, 12 -> season = "Winter"; 
					}
					return season;
				}));

		//
		
		Map<Species, Long> container12 = petList.stream()
				.collect(Collectors.groupingBy(
						pet -> pet.getSpecies(),
						Collectors.counting()
						));
		
		Map<Species, Double> container13 = petList.stream()
				.collect(Collectors.groupingBy(
						Pet::getSpecies,
						Collectors.summingDouble(Pet::getWeight)
						));
		
		Map<Species, Set<String>> container14 = petList.stream()
				.collect(Collectors.groupingBy(
						Pet::getSpecies,
						Collectors.mapping(Pet::getName, Collectors.toSet())
						));
		
		Map<Species, Set<FurColor>> container15 = petList.stream()
				.collect(Collectors.groupingBy(
						Pet::getSpecies,
						Collectors.flatMapping(pet -> pet.getFurColors().stream(), Collectors.toSet())
						));
		
		container15.forEach((k, v) -> System.out.println(k + "=" + v));
		
		sorting(petList);

	}
	
	
	@SuppressWarnings("unused")
	private static void sorting(List<Pet> list) {
		System.out.println("\nOriginal Size:" + list.size());
		Map<String, Pet> map = list.stream().collect(Collectors.toMap(Pet::getId, pet -> pet));

		// Sort by key
		Map<String, Pet> map1 = map.entrySet().stream()
				.collect(Collectors.toMap(Map.Entry::getKey,
						Map.Entry::getValue,
						(e1, e2) -> e1,
						TreeMap::new));
		Map<String, Pet> map2 = map.entrySet().stream()
				.sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toMap(Map.Entry::getKey,
						Map.Entry::getValue,
						(e1, e2) -> e1,
						LinkedHashMap::new));
		Map<String, Pet> map3 = map.entrySet().stream()
				.collect(Collectors.toMap(Map.Entry::getKey,
						Map.Entry::getValue,
						(e1, e2) -> e1,
						() -> new TreeMap<>(Comparator.reverseOrder())));
		
		// Sort by value: Object fields
		Map<String, Pet> map4 = map.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.comparing(Pet::getName)))
				.collect(Collectors.toMap(Map.Entry::getKey,
						Map.Entry::getValue,
						(e1, e2) -> e1,
						LinkedHashMap::new));
		
		// Sort by value: List<Object>
		Map<Species, List<Pet>> map5 = list.stream()
				.collect(Collectors.groupingBy(Pet::getSpecies))
				.entrySet().stream()
				.collect(Collectors.toMap(Map.Entry::getKey,
						entry -> entry.getValue().stream()
							.sorted(Comparator.comparing(Pet::getBirthDate))
							.toList(),
						(e1, e2) -> e1,
						LinkedHashMap::new));
		
		map5.forEach((k, v) -> {
			System.out.println(k + " -> ");
			for (Pet p : v) {
				System.out.println("\t" + p);
			}
		});

	}
	
	private static List<Pet> generateSamplePets() {
        List<Pet> pets = new ArrayList<>();
        pets.add(new Pet(generateRandomId(),"Miu",Species.CAT,Gender.FEMALE,
                LocalDate.of(2021,5,12), Arrays.asList(FurColor.WHITE),3.2));
        pets.add(new Pet(generateRandomId(),"Tôm",Species.CAT,Gender.MALE,
                LocalDate.of(2020,9,23), Arrays.asList(FurColor.BLACK,FurColor.WHITE),4.1));
        pets.add(new Pet(generateRandomId(),"Vàng",Species.DOG,Gender.MALE,
                LocalDate.of(2019,7,15), Arrays.asList(FurColor.ORANGE),12.5));
        pets.add(new Pet(generateRandomId(),"Bống",Species.FISH,Gender.FEMALE,
                LocalDate.of(2022,2,1), Arrays.asList(FurColor.NONE),0.2));
        pets.add(new Pet(generateRandomId(),"Bạch",Species.CAT,Gender.MALE,
                LocalDate.of(2021,12,10), Arrays.asList(FurColor.GRAY,FurColor.WHITE),3.8));
        pets.add(new Pet(generateRandomId(),"Mực",Species.CAT,Gender.MALE,
                LocalDate.of(2020,3,5), Arrays.asList(FurColor.BLACK),4.4));
        pets.add(new Pet(generateRandomId(),"Chíp",Species.BIRD,Gender.FEMALE,
                LocalDate.of(2023,1,1), Arrays.asList(FurColor.BROWN,FurColor.WHITE),0.3));
        pets.add(new Pet(generateRandomId(),"Bún",Species.OTHER,Gender.FEMALE,
                LocalDate.of(2022,6,8), Arrays.asList(FurColor.CREAM),2.1));
        pets.add(new Pet(generateRandomId(),"Bé Đốm",Species.DOG,Gender.FEMALE,
                LocalDate.of(2020,8,14), Arrays.asList(FurColor.BLACK,FurColor.WHITE),10.7));
        pets.add(new Pet(generateRandomId(),"Xám",Species.CAT,Gender.FEMALE,
                LocalDate.of(2021,11,11), Arrays.asList(FurColor.GRAY),3.0));
        pets.add(new Pet(generateRandomId(),"Na",Species.CAT,Gender.FEMALE,
                LocalDate.of(2022,4,20), Arrays.asList(FurColor.ORANGE,FurColor.WHITE,FurColor.BLACK),2.9));
        pets.add(new Pet(generateRandomId(),"Đen",Species.CAT,Gender.MALE,
                LocalDate.of(2021,3,9), Arrays.asList(FurColor.BLACK),4.0));
        pets.add(new Pet(generateRandomId(),"Milo",Species.DOG,Gender.MALE,
                LocalDate.of(2019,12,1), Arrays.asList(FurColor.BROWN),15.3));
        pets.add(new Pet(generateRandomId(),"Bông",Species.OTHER,Gender.FEMALE,
                LocalDate.of(2022,9,18), Arrays.asList(FurColor.WHITE,FurColor.GRAY),1.8));
        pets.add(new Pet(generateRandomId(),"Chíp Xanh",Species.BIRD,Gender.MALE,
                LocalDate.of(2023,2,25), Arrays.asList(FurColor.GRAY,FurColor.WHITE),0.25));
        pets.add(new Pet(generateRandomId(),"Ginger",Species.CAT,Gender.MALE,
                LocalDate.of(2021,8,8), Arrays.asList(FurColor.ORANGE),3.6));
        pets.add(new Pet(generateRandomId(),"Snow",Species.CAT,Gender.FEMALE,
                LocalDate.of(2020,12,25), Arrays.asList(FurColor.WHITE),3.5));
        pets.add(new Pet(generateRandomId(),"Smoky",Species.CAT,Gender.MALE,
                LocalDate.of(2019,4,4), Arrays.asList(FurColor.NONE),4.7));
        pets.add(new Pet(generateRandomId(),"Mochi",Species.CAT,Gender.FEMALE,
                LocalDate.of(2021,7,2), Arrays.asList(FurColor.CREAM,FurColor.WHITE),2.8));
        pets.add(new Pet(generateRandomId(),"Leo",Species.DOG,Gender.MALE,
                LocalDate.of(2018,6,6), Arrays.asList(FurColor.BLACK,FurColor.BROWN, FurColor.WHITE),18.9));

        return pets;
    }
	
	private static String generateRandomId() {
        StringBuilder sb = new StringBuilder(15);
        for (int i = 0; i < 15; i++) {
            sb.append((int)(Math.random()*10));
        }
        return sb.toString();
    }

}
