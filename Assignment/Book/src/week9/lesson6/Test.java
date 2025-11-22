package week9.lesson6;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		// Khởi tạo BookList
		BookList bookManager = new BookList();

		// === 1. KHỞI TẠO DỮ LIỆU ===
		// Giả sử hôm nay là ngày 06/11/2025 (theo đồng hồ hệ thống khi chạy)
		// Sách nhập > 1 tháng (VD: 01/09/2025)
		// Sách nhập < 1 tháng (VD: 30/10/2025)
		TextBook tb1 = new TextBook("TB01", LocalDate.of(2025, 10, 30), 55000, 10, "Kim Dong", Status.NEW);
		TextBook tb2 = new TextBook("TB02", LocalDate.of(2025, 9, 1), 60000, 5, "Giao Duc", Status.OLD);
		TextBook tb3 = new TextBook("TB03", LocalDate.of(2024, 5, 15), 45000, 8, "Kim Dong", Status.NEW);

		ReferenceBook rb1 = new ReferenceBook("RB01", LocalDate.of(2025, 10, 20), 120000, 7, "Tay Do", 0.1); // 10%
		ReferenceBook rb2 = new ReferenceBook("RB02", LocalDate.of(2025, 9, 5), 75000, 12, "Giao Duc", 0.08); // 8%
		ReferenceBook rb3 = new ReferenceBook("RB03", LocalDate.of(2024, 8, 28), 52000, 9, "Tay Do", 0.05); // 5%

		// === 2. TEST THÊM SÁCH (add2) ===
		System.out.println("--- 2. Test Add ---");
		System.out.println("Them TB01: " + bookManager.add2(tb1));
		System.out.println("Them TB02: " + bookManager.add2(tb2));
		System.out.println("Them TB03: " + bookManager.add2(tb3));
		System.out.println("Them RB01: " + bookManager.add2(rb1));
		System.out.println("Them RB02: " + bookManager.add2(rb2));
		System.out.println("Them RB03: " + bookManager.add2(rb3));
		// Thử thêm sách trùng mã
		System.out.println("Them TB01 lan 2: " + bookManager.add2(tb1));
		// Thử thêm sách null
		System.out.println("Them sach null: " + bookManager.add2(null));

		System.out.println("\nSo luong sach: " + bookManager.getSize());
		printList(bookManager.getBooks());

		// === 3. TEST TÌM SÁCH (getBook) ===
		System.out.println("\n--- 3. Test Get Book ---");
		System.out.println("Tim RB01: \n" + bookManager.getBook("RB01"));
		System.out.println("Tim XX00 (Khong co): " + bookManager.getBook("XX00"));

		// === 4. TEST CẬP NHẬT (update2) ===
		System.out.println("\n--- 4. Test Update ---");
		System.out.println("Cap nhat thue RB01 (10% -> 15%): " + bookManager.update2("RB01", 0.15));
		System.out.println("Sach RB01 sau khi cap nhat:\n" + bookManager.getBook("RB01"));
		// Thử cập nhật sách giáo khoa (sẽ thất bại)
		System.out.println("Cap nhat thue TB01 (That bai): " + bookManager.update2("TB01", 0.15));

		// === 5. TEST XÓA SÁCH (remove2) ===
		System.out.println("\n--- 5. Test Remove ---");
		System.out.println("Xoa sach RB03: " + bookManager.remove2("RB03"));
		System.out.println("So luong sach con lai: " + bookManager.getSize());
		printList(bookManager.getBooks());

		// === 6. TEST LỌC (FILTER) ===
		System.out.println("\n--- 6. Test Filter ---");
		System.out.println("Sach nhap trong thang 10 (nam 2025):");
		printList(bookManager.getBooksInMonth(10));

		System.out.println("Sach nhap hon 1 thang (Gia su hom nay la 06/11/2025):");
		printList(bookManager.getImportedBooksForOverOneMonth());

		System.out.println("Sach Giao Khoa Cu:");
		printList(bookManager.getOldBooks());

		// === 7. TEST SẮP XẾP (SORT) ===
		System.out.println("\n--- 7. Test Sort ---");
		System.out.println("Sap xep theo Don Gia Giam Dan:");
		printList(bookManager.sortUnitPriceDesc());

		System.out.println("Sap xep theo NXB Tang Dan (Kim Dong -> Giao Duc -> Tay Do), sau do Don Gia Giam Dan:");
		printList(bookManager.sortPublisherAscThenUnitPriceDesc());

		System.out.println("Sap xep theo Loai Sach Tang Dan (ReferenceBook -> TextBook), sau do Don Gia Giam Dan:");
		printList(bookManager.sortTypeAscThenUnitPriceDesc()); // Dòng 79 - Giờ sẽ chạy đúng

		// === 8. TEST THỐNG KÊ (STATISTICS) ===
		System.out.println("\n--- 8. Test Statistics ---");
		System.out.println("Tong so luong sach nhap trong nam 2025: " + bookManager.getQuantityTotal(2025));
		System.out.println("Tong so luong sach nhap trong nam 2024: " + bookManager.getQuantityTotal(2024));
		System.out.println("Don gia trung binh nam 2025: " + bookManager.getUnitPriceAverage(2025));

		// === 9. TEST GOM NHÓM (GROUPING) ===
		System.out.println("\n--- 9. Test Grouping ---");
		System.out.println("Gom nhom theo Loai va Dem so luong:");
		Map<String, Integer> group1 = bookManager.groupByTypeAndCounting();
		// In Map
		group1.forEach((type, count) -> System.out.printf("  + %s: %d cuon\n", type, count));

		System.out.println("\nGom nhom theo Don Gia (Cao > 50k, Thap <= 50k) va sap xep theo Ma Giam Dan:");
		Map<String, List<Book>> group2 = bookManager.groupByUnitPriceAndSorting();
		// In Map
		group2.forEach((groupName, books) -> {
			System.out.println("  + Nhom " + groupName + ":");
			for (Book b : books) {
				System.out.println("\t" + b);
			}
		});
	}

	/**
	 * Hàm trợ giúp (helper) để in danh sách sách cho đẹp
	 */
	public static void printList(List<Book> list) {
		if (list == null || list.isEmpty()) {
			System.out.println("  (Khong co sach nao)");
			return;
		}
		for (Book b : list) {
			System.out.println("  " + b);
		}
	}
}