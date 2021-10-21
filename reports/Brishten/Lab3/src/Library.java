import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Library {
    private Book[] books;

    Map<String, Integer> data = Map.of(
            "author", 0,
            "title", 1,
            "publishYear", 2,
            "copies", 3,
            "pages", 4,
            "volumes", 5, 
            "number", 6,
            "fio", 7,
            "period", 8
        ); 

    public Library(int size) {
        books = new Book[size];
    }
    public static void main(String[] args) {
        List<String> sentences = Input_File("file.txt");
        int numberOfBooks = sentences.size();
        String[][] array = new String[numberOfBooks][];
 
        int i = 0;
        for (String str : sentences) {
            array[i++] = str.split("\\s");
        }

        Library lb = new Library(numberOfBooks);
        lb.testLibrary(array);
    }

    void ListOfBooks(Book[] Books) {
        for (Book book : Books) {
            System.out.print(book.getTitle() + " | ");
        }
    }

    void OlderBooks(Book[] Books, int year) {
        for (Book book : Books) {
            int pubYear = book.getYear();
            if (pubYear > year) {
                System.out.print(book.getTitle() + " | ");
            }
        }
    }

    void TakeBooks(Book[] Books) {
        for (Book book : Books) {
            String Read = book.getRead();
            if (!Read.equals("null")) {
                System.out.print(book.getTitle() + " | ");
            }
        }
    }

    void TakeBooks_WithFIO(Book[] Books) {
        for (Book book : Books) {
            String Read = book.getRead();
            String FIO = book.getFIO();
            if (!Read.equals("null")) {
                System.out.print(book.getTitle() + ": " + FIO + " | ");
            }
        }
    }

    void Delay(Book[] Books, int BookWithReader) {
        for (Book book : Books) {
            String Read = book.getRead();
            if (!Read.equals("null") && Integer.parseInt(Read) > BookWithReader) {
                System.out.print(book.getTitle() + " | ");
            }
        }
    }


    void testLibrary(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            books[i] = new Book(arr[i][data.get("author")], arr[i][data.get("title")], 
            arr[i][data.get("publishYear")], arr[i][data.get("copies")], arr[i][data.get("pages")], 
            arr[i][data.get("volumes")], arr[i][data.get("number")], arr[i][data.get("fio")], 
            arr[i][data.get("period")]);
            System.out.println(books[i].toString());
        }

        System.out.println("\n======== List of books ========");
        ListOfBooks(books);

        System.out.println("\n======== Old books(2<) ========");
        OlderBooks(books, 2);

        System.out.println("\n======== Taken books ========");
        TakeBooks(books);

        System.out.println("\n======== Taken books[FIO] ========");
        TakeBooks_WithFIO(books);

        System.out.println("\n======== Seized books ========");
        Delay(books, 2);
    }

    @Override
    public String toString() {
        return "LibraryManager [books=" + Arrays.toString(books) + "]";
    }

    public static List<String> Input_File(String fileName) {
        List<String> sentences = new ArrayList<>();
    
        try(Scanner file = new Scanner(new File(fileName)))
        {
            while (file.hasNextLine()) {
                sentences.add(file.nextLine());
            }
            file.close();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        } 
        return sentences.stream().map(String::trim).collect(Collectors.toList());
    }
}

class Book {
    private String author, title, publishYear, copies, pages, volumes, number, fio, period;
 
    Book() {
        this("Braun", "Point", "2001", "2", "103", "3", "323.32", "Brishten", "23");
    }
 
    Book(String bookAuthor, String bookName, String year, String numcopy, 
        String numpage, String numvol, String UDK, String FIO, String Period) {
        this.author = bookAuthor;
        this.title = bookName;
        this.publishYear = year;
        this.copies = numcopy;
        this.pages = numpage;
        this.volumes = numvol;
        this.number = UDK;
        this.fio = FIO;
        this.period = Period;
    }
 
    @Override
    public String toString() {
        return "Book [[author=" + this.author + ", title=" + this.title + ", publishYear=" + this.publishYear + 
        "]\n      [copies=" + this.copies + ", pages=" + this.pages  + ", volumes=" + this.volumes +
        "]\n      [number=" + this.number + ", fio=" + this.fio + ", period=" + this.period + "]]";
    }

    public String getTitle() {
        return this.title;
    }

    public Integer getYear() {
        return Integer.parseInt(this.publishYear);
    }

    public String getRead() {
        return this.period;
    }

    public String getFIO() {
        return this.fio;
    }
}


