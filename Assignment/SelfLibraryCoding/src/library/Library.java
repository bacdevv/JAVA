package library;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Library implements ILibrarySettings {
	private List<Book> bookList;
	
	public Library() {
		this.bookList = new ArrayList<Book>();
	}

	@Override
	public int getSize() {
		return bookList.size();
	}

	@Override
	public List<Book> getBooks() {
		return new ArrayList<>(bookList);
	}

	@Override
	public Book getBook(String code) {
		if (code == null) return null;
		return bookList.stream()
			.filter(book -> code.equals(book.getCode()))
			.findFirst()
			.orElse(null);
	}

	@Override
	public void add1(Book book) {
		if (book != null) {
			bookList.add(book);
		}
	}

	@Override
	public boolean add2(Book book) {
		if (book == null || getBook(book.getCode()) != null)
			return false;
		return bookList.add(book);
	}

	@Override
	public Book add3(Book book) {
		if (book == null) return null;
		Book existingBook = getBook(book.getCode());
		if (existingBook != null) return existingBook;
		bookList.add(book);
		return book;
		}

	@Override
	public void remove1(String code) {
		Book book = getBook(code);
		if (book != null) {
			bookList.remove(book);
		}
	}

	@Override
	public boolean remove2(String code) {
		Book book = getBook(code);
		if (book != null) {
			return bookList.remove(book);
		}
		return false;
	}

	@Override
	public Book remove3(String code) {
		Book book = getBook(code);
		if (book != null) {
			bookList.remove(book);
			return book;
		}
		return null;
	}

	@Override
	public void update1(String code, double newVAT) {
		Book book = getBook(code);
		if (code != null && book instanceof ReferenceBook) {
			((ReferenceBook) book).setTax(newVAT);
		}
	}

	@Override
	public boolean update2(String code, double newVAT) {
		Book book = getBook(code);
		if (code != null && book instanceof ReferenceBook) {
			((ReferenceBook) book).setTax(newVAT);
			return true;
		}
		return false;
	}

	@Override
	public Book update3(String code, double newVAT) {
		Book book = getBook(code);
		if (code != null && book instanceof ReferenceBook) {
			((ReferenceBook) book).setTax(newVAT);
			return book;
		}
		return null;
	}

	@Override
	public List<Book> getBooksInMonth(int month) {
		return bookList.stream()
				.filter(book -> book.getEntryDate().getMonthValue() == month)
				.toList();
	}

	@Override
	public List<Book> getBooksOverOneMonth() {
		LocalDate today = LocalDate.now();
		return bookList.stream()
				.filter(book -> ChronoUnit.MONTHS.between(book.getEntryDate(), today) > 1)
				.toList();
	}

	@Override
	public List<Book> getOldBooks() {
		return bookList.stream()
				.filter(book -> book instanceof TextBook && ((TextBook) book).getStatus() == StatusTextBook.OLD)
				.toList();
	}

	@Override
	public List<Book> sortUnitPriceDesc() {
		return bookList.stream()
				.sorted(Comparator.comparing(Book::getPrice).reversed())
				.toList();
	}

	@Override
	public List<Book> sortPublisherAscThenUnitPriceDesc() {
		return bookList.stream()
				.sorted(Comparator.comparing(Book::getPublisher).thenComparing(
						Book::getPrice, Comparator.reverseOrder()
				))
				.toList();
	}

	@Override
	public List<Book> sortClassAscThenUnitPriceDesc() {
		return bookList.stream()
			.sorted(
					Comparator.comparing((Book book) -> book.getClass().getSimpleName()).thenComparing(
						Book::getPrice, Comparator.reverseOrder())
					)
			.toList();
	}

	@Override
	public double highestPrice() {
		return bookList.stream()
				.mapToDouble(Book::getPrice)
				.max()
				.orElse(0.0);
	}

	@Override
	public int getQuantityTotal(int year) {
		return bookList.stream()
				.mapToInt(Book::getQuantity)
				.sum();
	}

	@Override
	public double getUnitPriceAverage(int year) {
		return bookList.stream()
				.mapToDouble(Book::getPrice)
				.average()
				.orElse(0.0);
	}

	@Override
	public Map<String, Integer> groupByTypeAndAccounting() {
		return bookList.stream()
				.collect(Collectors.groupingBy(
						book -> book.getClass().getSimpleName(),
						Collectors.summingInt(book -> 1)
				));
	}

	@Override
	public Map<String, List<Book>> groupByUnitPriceAndSorting() {
		return bookList.stream()
				.collect(Collectors.groupingBy(
					book -> book.getPrice() > 50000 ? "High" : "Low",
					Collectors.collectingAndThen(
							Collectors.toList(),
							list -> {
								list.sort(Comparator.comparing(Book::getPrice).reversed());
								return list;
							}
					)
				));
	}

	@Override
	public double getHighestTotalPrice() {
		return bookList.stream()
			.mapToDouble(Book::totalPrice)
			.max()
			.orElse(0);
	}

	@Override
	public List<Book> getBooksWithHighestTotalPrice() {
		double maxTotalPrice = bookList.stream()
				.mapToDouble(Book::totalPrice)
				.max()
				.orElse(Double.MIN_VALUE);
		if (maxTotalPrice <= Double.MIN_VALUE) {
			return new ArrayList<>();
		}
		
		return bookList.stream()
				.filter(book -> book.totalPrice() == maxTotalPrice)
				.toList();
	}
	
	@Override
	public List<Book> getBooksWithLowestTotalPrice() {
		double lowTotalPrice = bookList.stream()
				.mapToDouble(Book::totalPrice)
				.min()
				.orElse(Double.MAX_VALUE);
		if (lowTotalPrice > Double.MAX_VALUE) {
			return new ArrayList<>();
		}
		return bookList.stream()
				.filter(book -> book.totalPrice() == lowTotalPrice)
				.toList();
	}

	@Override
	public double calculateTotalRevenueUsingReduce() {
		return bookList.stream()
				.mapToDouble(Book::totalPrice)
				.reduce(0.0, Double::sum);
	}

	@Override
	public Map<String, Book> getBooksMapSortedByTotalPriceDesc() {
		return bookList.stream()
				.collect(Collectors.toMap(
						Book::getCode,  // Key: Mã sách
						book -> book,   // Value: Chính cuốn sách
						(e1, e2) -> e1  // (Ghi chú: e1) Giữ lại e1 (cái cũ) nếu trùng Key
				))
				// 2. "Đập ra" (entrySet)
				.entrySet()
				.stream()
				// 3. "Xếp lại" (sorted)
				//    (Ghi chú: sorted(Map.Entry.comparingByValue(...)))
				.sorted(Map.Entry.comparingByValue(
						// So sánh Value (Book) bằng cách so sánh totalPrice GIẢM DẦN
						Comparator.comparing(Book::totalPrice).reversed() 
				))
				// 4. "Xây lại" (collect) vào một Map MỚI (có thứ tự)
				.collect(Collectors.toMap(
						Map.Entry::getKey,
						Map.Entry::getValue,
						(e1, e2) -> e1,
						// BẮT BUỘC: Phải dùng LinkedHashMap::new để "Bảo lưu" thứ tự đã sắp xếp
						java.util.LinkedHashMap::new 
				));
	}
}
