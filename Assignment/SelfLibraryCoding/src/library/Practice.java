package library;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * CLASS LUYỆN TẬP
 * Hướng dẫn: Hãy viết logic cho các phương thức bên dưới để thỏa mãn Interface.
 * Gợi ý: Sử dụng List<Book> bookList để lưu trữ dữ liệu.
 */
public class Practice implements ILibrarySettings {
	
	private List<Book> bookList;

	public Practice() {
		this.bookList = new ArrayList<>();
	}

	@Override
	public int getSize() {
		// TODO: Trả về kích thước của danh sách
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
		// TODO: Thêm sách vào danh sách (không cần kiểm tra trùng)
		if (book != null) {
			bookList.add(book);
		}
	}

	@Override
	public boolean add2(Book book) {
		if (book == null || getBook(book.getCode()) != null) {
			return false;
		}
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
		// TODO: Tìm và xóa sách theo mã
		Book book = getBook(code);
		if (book != null) {
			bookList.remove(book);
		}
	}

	@Override
	public boolean remove2(String code) {
		Book book = getBook(code);
		if (book == null) {
			return false;
		}
		return bookList.remove(book);
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
		// TODO: Tìm sách, nếu là ReferenceBook thì setTax = newVAT
		Book book = getBook(code);
		if (book != null && book instanceof ReferenceBook) {
			((ReferenceBook) book).setTax(newVAT);
		}
	}

	@Override
	public boolean update2(String code, double newVAT) {
		// TODO: Tương tự update1, trả về true nếu update thành công
		Book book = getBook(code);
		if (book != null && book instanceof ReferenceBook) {
			((ReferenceBook) book).setTax(newVAT);
			return true;
		}
		return false;
	}

	@Override
	public Book update3(String code, double newVAT) {
		Book book = getBook(code);
		if (book != null && book instanceof ReferenceBook) {
			((ReferenceBook) book).setTax(newVAT);
			return book;
		}
		return null;
	}

	@Override
	public List<Book> getBooksInMonth(int month) {
		// TODO: Dùng Stream lọc các sách có entryDate trong tháng month
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
		// TODO: Lọc các sách là TextBook VÀ có status là OLD
		return bookList.stream()
				.filter(book -> book instanceof TextBook && ((TextBook) book).getStatus() == StatusTextBook.OLD)
				.toList();
	}

	@Override
	public List<Book> sortUnitPriceDesc() {
		// TODO: Trả về danh sách sắp xếp theo đơn giá giảm dần
		return bookList.stream()
				.sorted(
						Comparator.comparing(Book::getPrice).reversed()
				)
				.toList();
	}

	@Override
	public List<Book> sortPublisherAscThenUnitPriceDesc() {
		// TODO: Sắp xếp theo NXB tăng dần, nếu trùng thì theo đơn giá giảm dần
		return bookList.stream()
				.sorted(
						Comparator.comparing(Book::getPublisher).thenComparing(
									Book::getPrice, Comparator.reverseOrder()
								)
						)
				.toList();
	}

	@Override
	public List<Book> sortClassAscThenUnitPriceDesc() {
		// TODO: Sắp xếp theo tên Class (TextBook/ReferenceBook) tăng dần, sau đó đơn giá giảm
		return bookList.stream()
				.sorted(Comparator.comparing((Book book) -> book.getClass().getSimpleName()).thenComparing(
						Book::getPrice, Comparator.reverseOrder()
						))
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
		// TODO: Tính tổng số lượng (quantity) của các sách (có thể lọc theo năm nếu muốn)
		return bookList.stream()
				.mapToInt(Book::getQuantity)
				.sum();
	}

	@Override
	public double getUnitPriceAverage(int year) {
		// TODO: Tính trung bình cộng đơn giá
		return bookList.stream()
				.mapToDouble(Book::getPrice)
				.average()
				.orElse(0.0);
	}

	@Override
	public Map<String, Integer> groupByTypeAndAccounting() {
		return bookList.stream()
				.collect(Collectors.groupingBy(book -> book.getClass().getSimpleName(), Collectors.summingInt(book -> 1)));
	}

	@Override
	public Map<String, List<Book>> groupByUnitPriceAndSorting() {
		// TODO: Group theo điều kiện giá > 50000 ("High", "Low"). 
		// Value của Map là List đã được sắp xếp giảm dần theo giá.
		return null;
	}

	@Override
	public double getHighestTotalPrice() {
		// TODO: Tìm thành tiền (totalPrice) lớn nhất
		return 0;
	}

	@Override
	public List<Book> getBooksWithHighestTotalPrice() {
		// TODO: Tìm tất cả sách có thành tiền bằng với mức cao nhất
		return null;
	}

	@Override
	public List<Book> getBooksWithLowestTotalPrice() {
		// TODO: Tìm tất cả sách có thành tiền bằng với mức thấp nhất
		return null;
	}

	@Override
	public double calculateTotalRevenueUsingReduce() {
		// TODO: Tính tổng doanh thu dùng .reduce() (không dùng sum())
		return bookList.stream()
				.mapToDouble(Book::totalPrice)
				.reduce(0.0, Double::sum);
	}

	@Override
	public Map<String, Book> getBooksMapSortedByTotalPriceDesc() {
		// TODO: Trả về Map<Code, Book> đã sắp xếp theo totalPrice giảm dần
		// Gợi ý: Cần dùng LinkedHashMap để giữ thứ tự
		return null;
	}
}