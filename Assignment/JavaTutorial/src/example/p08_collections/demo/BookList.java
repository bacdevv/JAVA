package example.p08_collections.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class BookList {
	
	private List<Book> list;
	
	public BookList() {
		this.list = new ArrayList<>();
	}

	//1. Danh sách đối tượng Book có số lượng lớn nhất
	public List<Book> getList() {
		@SuppressWarnings("unused")
		int maxQuantity = list.stream()
				.map(book -> book.getQuantity())
				.max((n1, n2) -> n1 - n2)
				.get();
		int maxQuantity2 = list.stream()
				.mapToInt(Book::getQuantity).max().getAsInt();
		
		return list.stream()
				.filter(book -> book.getQuantity() >= maxQuantity2)
				.collect(Collectors.toCollection(
						() -> new ArrayList<>()
						));
	}

	//2. Gom nhóm các đối tượng Book với:
	// - Khoá là tên lớp thực thể
	// - Giá trị là danh sách ArrayList chứa đối tượng Book
	public Map<String, List<Book>> getGroups() {
		return list.stream()
				.collect(Collectors.groupingBy(
						book -> book.getClass().getSimpleName()
						));
	}
	
	public Map<String, Set<Book>> getGroups2() {
		return list.stream()
				.collect(Collectors.groupingBy(
						book -> book.getClass().getSimpleName(),
						Collectors.toSet()
						));
	}
	

	//3. Gom nhóm các đối tượng Book với:
	// - Khoá là tên lớp thực thể 
	// - Giá trị là danh sách ArrayList chứa mã sách
	
	public Map<String, List<Book>> getGroups3() {
		return list.stream()
				.collect(Collectors.groupingBy(
						book -> book.getClass().getSimpleName(),
						Collectors.toCollection(ArrayList::new)
						));
	}


	//4. Gom nhóm các đối tượng Book với:
	// - Khoá là tên lớp thực thể 
	// - Giá trị là giá trị thành tiền trung bình

	public Map<String, Double> getGroups4() {
		return list.stream()
				.collect(Collectors.groupingBy(
						book -> book.getClass().getSimpleName(),
						Collectors.averagingDouble(Book::salePrice)
						));
	}
	
	public Map<String, Integer> getGroups5() {
		return list.stream()
				.collect(Collectors.groupingBy(
						book -> book.getClass().getSimpleName(),
						Collectors.collectingAndThen(
								Collectors.counting(),
								Long::intValue
						)));
	}
	
	public Map<String, Integer> getGroups6() {
		return list.stream()
				.collect(Collectors.groupingBy(
						book -> book.getClass().getSimpleName(),
						Collectors.summingInt(Book::getQuantity)
						));
	}
	
	

	//6. Sắp xếp và trả về danh sách
	// - Theo số lượng tăng dần
	// - Nếu số lượng bằng nhau thì theo đơn giá giảm dần
	
	public List<Book> sort1() {
		Comparator<Book> comp1 = Comparator.comparing(Book::getQuantity);
		Comparator<Book> comp2 = Comparator.comparing(Book::getPrice).reversed();
		return list.stream()
				.sorted(comp1.thenComparing(comp2))
				.toList();
	}


	//7. Sắp xếp theo từng nhóm với tên lớp thực thể giảm dần
	// Trong từng nhóm, sắp xếp tập TreeSet giảm dần các đối tượng Book (triển khai interface Comparable)

	public Map<String, Set<Book>> sort2(){
		return list.stream()
				.collect(Collectors.groupingBy(
						book -> book.getClass().getSimpleName(),
						Collectors.toCollection(
								() -> new TreeSet<>(Comparator.reverseOrder())
								)
						));
		
	}

	//8. Chuyển danh sách các đối tượng Book thành ánh xạ với khoá là mã sách và giá trị là đối tượng Book
	// Sắp xếp ánh xạ theo số lượng sách tăng dần
	public Map<String, Book> mapping(){
		
		return list.stream()
				.collect(Collectors.toMap(
						Book::getCode,
						book -> book
						))
				.entrySet()
				.stream()
				.sorted((b1, b2) -> b1.getValue().getQuantity() - b2.getValue().getQuantity())
				.collect(Collectors.toMap(
						Map.Entry::getKey,
						Map.Entry::getValue,
						(e1, e2) -> e1,
						LinkedHashMap::new
						));
		
	}

	
}
