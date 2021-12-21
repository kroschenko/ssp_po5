import java.util.List;

public class Task1 {

    public static void main(String[] args) {
	    ReferenceBook referenceBook = new ReferenceBook();
        referenceBook.setTitle("Reference book");

        Encyclopedia encyclopedia = new Encyclopedia();
        encyclopedia.setTitle("Encyclopedia");

        List<Book> books = List.of(referenceBook, encyclopedia);

        for (Book book: books) {
            System.out.println(book.getTitle());
        }
    }
}
