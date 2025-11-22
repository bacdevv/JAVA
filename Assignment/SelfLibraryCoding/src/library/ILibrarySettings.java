package library;

import java.util.List;
import java.util.Map;

public interface ILibrarySettings {
	// Dem so luong sach
	int getSize();
	
	// Trả về danh sách mới (bản sao)
	List<Book> getBooks();
	
	// Tìm và trả về đối tượng sách khi biết mã sách
	Book getBook(String code);
	
	// Adding
	void add1(Book book);
	boolean add2(Book book);
	Book add3(Book book);
	
	// Remove
	void remove1(String code);
	boolean remove2(String code);
	Book remove3(String code);
	
	// Update
	void update1(String code, double newVAT);
	boolean update2(String code, double newVAT);
	Book update3(String code, double newVAT);
	
	// Tìm và trả về danh sách của các đối tượng sách nhập vào trong tháng month
	List<Book> getBooksInMonth(int month);
	
	// Tìm và trả về danh sách khi sách đã nhập kho được hơn 1 tháng
	List<Book> getBooksOverOneMonth();
	
	// Tìm và trả về danh sách khi sách có tình trạng là sách cũ
	List<Book> getOldBooks();
	
	// Sắp xếp và trả về danh sách theo đơn giá giảm dần
	List<Book> sortUnitPriceDesc();
	
	// Sắp xếp và trả về danh sách theo nhà xuất bản tăng dần, đơn giá giảm dần
	List<Book> sortPublisherAscThenUnitPriceDesc();
	
	// Sắp xếp và trả về danh sách theo kiểu tăng dần (tên lớp kiểu String), đơn giá giảm dần
	List<Book> sortClassAscThenUnitPriceDesc();
	
	// Tìm thành tiền cao nhất
	double highestPrice();

	//Thống kê theo điều kiện
	// Tổng số lượng sách theo năm
	int getQuantityTotal(int year);
	
	// Tổng trung bình giá sách theo năm
	double getUnitPriceAverage(int year);
	
	// Gom nhóm theo kiểu và đếm số lượng trong từng nhóm
	Map<String, Integer> groupByTypeAndAccounting();
	
	// Gom nhóm tuỳ chỉnh: Đơn giá trên 50_000 thuộc nhóm "Cao", còn lại thuộc nhóm "Thấp" Và sắp xếp giảm dần theo tên các đối tượng trong nhóm
	Map<String, List<Book>> groupByUnitPriceAndSorting();
	

	// === PHƯƠNG THỨC MỚI MÀ GIÁO SƯ YÊU CẦU ===
	/**
	 * Tính và trả về giá trị "Thành Tiền" (totalPrice) cao nhất 
	 * trong tất cả các sách (Bao gồm cả TextBook và ReferenceBook).
	 * @return Giá trị thành tiền cao nhất, hoặc 0.0 nếu danh sách rỗng.
	 */
	double getHighestTotalPrice();

	// === 3 CÂU HỎI MỚI DỰA TRÊN "TAKE NOTES" ===

	/**
	 * [CÂU KHÓ NHẤT - Ghi chú "PhòngHoc"]
	 * Lấy ra danh sách TẤT CẢ các sách có "Thành Tiền" (totalPrice) cao nhất.
	 * (Có thể có nhiều sách cùng có thành tiền cao nhất).
	 * @return List<Book> các sách có thành tiền cao nhất, hoặc List rỗng nếu không có sách.
	 */
	List<Book> getBooksWithHighestTotalPrice();
	
	List<Book> getBooksWithLowestTotalPrice();

	/**
	 * [Ghi chú "reduce"]
	 * Tính tổng "Thành Tiền" (doanh thu) của TẤT CẢ các sách trong danh sách
	 * SỬ DỤNG phương thức "reduce" (không dùng "sum").
	 * @return Tổng doanh thu, hoặc 0.0 nếu danh sách rỗng.
	 */
	double calculateTotalRevenueUsingReduce();

	/**
	 * [Ghi chú "gomnhom5" - Sắp xếp Map]
	 * Trả về một Map<String, Book> (Key: code, Value: Book).
	 * Map này phải được SẮP XẾP GIẢM DẦN dựa trên "Thành Tiền" (totalPrice) của Book (Value).
	 * (Lưu ý: Phải trả về một Map giữ được thứ tự, ví dụ LinkedHashMap).
	 * @return Map<String, Book> đã được sắp xếp theo Value (totalPrice giảm dần).
	 */
	Map<String, Book> getBooksMapSortedByTotalPriceDesc();
}










































