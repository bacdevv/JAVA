import java.util.List;

public interface ILibrary {
    int getSize();

    List<Library> getBooks();

    // add
    void add(Library book);
}
