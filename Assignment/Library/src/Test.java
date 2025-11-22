import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        LibraryManager bookList = new LibraryManager();

        TextBook var1 = new TextBook("TB01", LocalDate.of(2025, 7, 30), 150000.0, 10, "Kim Dong", Status.NEW);
      TextBook var2 = new TextBook("TB02", LocalDate.of(2024, 8, 28), 350000.0, 10, "Tay Do", Status.OLD);
      System.out.println(var1);
      System.out.println(var2);
      ReferenceBook var3 = new ReferenceBook("TB01", LocalDate.of(2025, 7, 30), 120000.0, 10, "Kim Dong", 10.0);
      ReferenceBook var4 = new ReferenceBook("TB02", LocalDate.of(2024, 8, 28), 50000.0, 10, "Tay Do", 8.0);
      System.out.println(var3);
      System.out.println(var4); 
      
      bookList.add(var1);
      bookList.add(var2);
      bookList.add(var3);
      bookList.add(var4);
    int size = bookList.getSize();
    System.out.println(size);
    }
}
