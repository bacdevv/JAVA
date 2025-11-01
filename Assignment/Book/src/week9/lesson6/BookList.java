package week9.lesson6;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookList implements IBookSetting {

	private List<Book> bookList;
	
	public BookList() {
		this.bookList = new ArrayList<>();
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
	public void add1(Book book) {
		if (book != null) {
			this.bookList.add(book);
		}
	}

	@Override
	public boolean add2(Book book) {
		if (book == null || getBook(book.getCode()) != null) {
			return false;
		}
		return this.bookList.add(book);
	}

	@Override
	public Book add3(Book book) {
		if (book == null) {
			return null;
		}
		Book existingBook = getBook(book.getCode());
		if (existingBook != null) {
			return existingBook;
		}
		this.bookList.add(book);
		return null;
	}

	@Override
	public void remove1(String code) {
		Book book = getBook(code);
		if (book != null) {
			this.bookList.remove(book);
		}
	}

	@Override
	public boolean remove2(String code) {
		Book book = getBook(code);
		if (book != null) {
			return this.bookList.remove(book);
		}
		return false;
	}

	@Override
	public Book remove3(String code) {
		Book book = getBook(code);
		if (book != null) {
			this.bookList.remove(book);
			return book;
		}
		return null;
	}

	@Override
	public void update1(String code, double newVAT) {
		Book book = getBook(code);
		if (book instanceof ReferenceBook) {
			((ReferenceBook) book).setTax(newVAT);
		}
	}

	@Override
	public boolean update2(String code, double newVAT) {
		Book book = getBook(code);
		if (book instanceof ReferenceBook) {
			((ReferenceBook) book).setTax(newVAT);
			return true;
		}
		return false;
	}

	@Override
	public Book update3(String code, double newVAT) {
		Book book = getBook(code);
		if (book instanceof ReferenceBook) {
			((ReferenceBook) book).setTax(newVAT);
			return book;
		}
		return null;
	}

	@Override
	public Book getBook(String code) {
		if (code == null) {
			return null;
		}
		for (Book book : bookList) {
			if (code.equals(book.getCode())) {
				return book;
			}
		}
		return null;
	}

	@Override
	public List<Book> getBooksInMonth(int month) {
		return bookList.stream()
				.filter(book -> book.getDayImport().getMonthValue() == month)
				.collect(Collectors.toList());
	}

	@Override
	public List<Book> getImportedBooksForOverOneMonth() {
		LocalDate today = LocalDate.now();
		return bookList.stream()
				.filter(book -> ChronoUnit.MONTHS.between(book.getDayImport(), today) > 1)
				.collect(Collectors.toList());
	}

	@Override
	public List<Book> getOldBooks() {
		return bookList.stream()
				.filter(book -> book instanceof TextBook && ((TextBook) book).getBookStatus() == Status.OLD)
				.collect(Collectors.toList());
	}

	@Override
	public List<Book> sortUnitPriceDesc() {
		List<Book> sortedList = new ArrayList<>(bookList);
		sortedList.sort(Comparator.comparing(Book::getPrice).reversed());
		return sortedList;
	}

	@Override
	public List<Book> sortPublisherAscThenUnitPriceDesc() {
		List<Book> sortedList = new ArrayList<>(bookList);
		sortedList.sort(Comparator.comparing(Book::getPublisher)
								  .thenComparing(Book::getPrice, Comparator.reverseOrder()));
		return sortedList;
	}

	@Override
	public List<Book> sortTypeAscThenUnitPriceDesc() {
		List<Book> sortedList = new ArrayList<>(bookList);
		sortedList.sort(Comparator.comparing(book -> book.getClass().getSimpleName())
								  .thenComparing(Book::getPrice, Comparator.reverseOrder()));
		return sortedList;
	}

	@Override
	public int getQuantityTotal(int year) {
		return bookList.stream()
				.filter(book -> book.getDayImport().getYear() == year)
				.mapToInt(Book::getQuantity)
				.sum();
	}

	@Override
	public int getUnitPriceAverage(int year) {
		return (int) bookList.stream()
				.filter(book -> book.getDayImport().getYear() == year)
				.mapToDouble(Book::getPrice)
				.average()
				.orElse(0.0);
	}

	@Override
	public Map<String, Integer> groupByTypeAndCounting() {
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
						book -> book.getPrice() > 50000 ? "Cao" : "Thấp",
						Collectors.collectingAndThen(
								Collectors.toList(),
								list -> {
									list.sort(Comparator.comparing(Book::getCode).reversed());
									return list;
								}
						)
				));
	}
}
