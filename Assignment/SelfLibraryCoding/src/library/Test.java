package library;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.text.NumberFormat;
import java.time.LocalDate;

public class Test {
	public static void main(String[] args) {
		
		Library lib = new Library();
		
		// Text Book
		TextBook tb1 = new TextBook("TB01", LocalDate.of(2025, 7, 30), 150000, 100, "Kim Dong", StatusTextBook.NEW);
		TextBook tb2 = new TextBook("TB02", LocalDate.of(2025, 11, 12), 350000, 50, "Hoa Binh", StatusTextBook.NEW);
		ReferenceBook rb1 = new ReferenceBook("RB01", LocalDate.of(2025, 1, 25), 150000, 100, "Kim Dong", 5);
		ReferenceBook rb3 = new ReferenceBook("RB03", LocalDate.of(2025, 3, 19), 180000, 50, "Hoa Binh", 10);
		TextBook tb3 = new TextBook("TB03", LocalDate.of(2025, 11, 12), 210000, 50, "Hoa Binh", StatusTextBook.OLD);
		ReferenceBook rb2 = new ReferenceBook("RB02", LocalDate.of(2025, 9, 2), 90000, 50, "Hoa Binh", 8);
		ReferenceBook rb4 = new ReferenceBook("RB04", LocalDate.of(2025, 9, 2), 5000, 50, "Hoa Binh", 8);

		// Add to a list
		System.out.println("Test add");
		System.out.println("Textbook 1: " + lib.add3(tb1));
		System.out.println("Textbook 2: " + lib.add3(tb2));
		System.out.println("Textbook 3: " + lib.add3(tb3));
		System.out.println("Referencebook 1: " + lib.add3(rb1));
		System.out.println("Referencebook 2: " + lib.add3(rb2));
		System.out.println("Referencebook 3: " + lib.add3(rb3));
		System.out.println("Referencebook 3: " + lib.add3(rb4));
		
		// The number of books
		System.out.println("The number of books: " + lib.getSize());
		
		// Remove a book
		System.out.println("Before");
		System.out.println("Check book in list: " + lib.getBook("TB01"));
		System.out.println("Remove Textbook 1: " + lib.remove2("TB01"));
		
		System.out.println("After");
		System.out.println("Check book in list: " + lib.getBook("TB01"));
		
		// Update vat
		System.out.println("VAT before");
		System.out.println(((ReferenceBook) lib.getBook("RB01")).getTax());
		
		// Update vat
		System.out.println("VAT after");
		System.out.println(lib.update2("RB01", 10.0));
		
		// List all of books
		printBookList("List all of books", lib.getBooks());
		
		// Get all of books in a month
		printBookList("Book in a month", lib.getBooksInMonth(11));
		
		// Get all of books over a month
		printBookList("Book over a month", lib.getBooksOverOneMonth());
		
		// Get old books
		printBookList("Old books", lib.getOldBooks());
		
		// Sort descending unit price
		printBookList("Sort Unit Price Descending",  lib.sortUnitPriceDesc());
		
		printBookList("Sort Publisher Ascending & Unit Price Descending", lib.sortPublisherAscThenUnitPriceDesc());
		
		printBookList("Sort Class Name and Unit Price Desc", lib.sortClassAscThenUnitPriceDesc());
		
		System.out.println("Highest Price is: " + formatMoney(lib.highestPrice()));
		
		System.out.println("Total quantity is: " + lib.getQuantityTotal(2025));
		
		System.out.println("Average Price in year: " + formatMoney(lib.getUnitPriceAverage(2025)));
		
		System.out.println("Group by book types and count: " + lib.groupByTypeAndAccounting());
		
		Map<String, Integer> report = lib.groupByTypeAndAccounting();

		// "Hỡi Cuốn Sổ, hãy tự đọc chính mình!"
		report.forEach((key, value) -> {
			System.out.println((key.equalsIgnoreCase("referencebook") ? "STK" : "TB") + ": " + value + " cuon");
		});
		
		Map<String, List<Book>> group = lib.groupByUnitPriceAndSorting();
		
		group.forEach((groupName, books) -> {
			System.out.println(" + Nhom " + groupName + ":");
			for (Book book : books) {
				System.out.println("\t" + book);
			}
		});
		
		System.out.println("Highest Total Price: " + formatMoney(lib.getHighestTotalPrice()));
		
		printBookList("Book with highest total price: ", lib.getBooksWithHighestTotalPrice());
		
		System.out.println("Total Reduce " + formatMoney(lib.calculateTotalRevenueUsingReduce()));
		printBookList("Book with lowest total price: ", lib.getBooksWithLowestTotalPrice());

		
		System.out.println("\n--- 12. Test Get Map Sorted By Total Price Desc ---");
		Map<String, Book> sortedMap = lib.getBooksMapSortedByTotalPriceDesc();
		// In Map đã sắp xếp (phải theo thứ tự 550k, 550k, 360k, 150k, 126k, 72k)
		sortedMap.forEach((code, book) -> {
			System.out.printf("  + %s: %s (Thanh tien: %.0f)\n", code, book.getPublisher(), book.totalPrice());
		});
		
		
	}
	
	public static void printBookList(String text, List<Book> bookList) {
		System.out.println("\n========== " + text.toUpperCase() + " ==========");
			
		if (bookList == null || bookList.isEmpty()) return;
		
		for (Book book : bookList) {
			System.out.println(book);
		}
	}
	
	public static String formatMoney(double money) {
		NumberFormat nb = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("vi-VN"));
		return nb.format(money);
	}
	
}
