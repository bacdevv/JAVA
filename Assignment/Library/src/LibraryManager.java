import java.util.ArrayList;
import java.util.List;

public class LibraryManager implements ILibrary {
    private List<Library> bookList;
    
    public LibraryManager() {
        this.bookList = new ArrayList<>();
    }

    @Override
    public int getSize() {
        return bookList.size();
    }

    @Override
    public List<Library> getBooks() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBooks'");
    }

    @Override
    public void add(Library book) {
        if (book == null)
            throw new IllegalArgumentException("Book is empty");
            bookList.add(book);

    }

}
