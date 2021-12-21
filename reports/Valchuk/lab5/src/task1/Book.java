public abstract class Book {
    protected String cipher;
    protected String author;
    protected String title;
    protected Short year;
    protected String publisher;

    public Book() {}

    public Book(String cipher, String author, String title, Short year, String publisher) {
        this.cipher = cipher;
        this.author = author;
        this.title = title;
        this.year = year;
        this.publisher = publisher;
    }

    public String getCipher() {
        return cipher;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public Short getYear() {
        return year;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setCipher(String cipher) {
        this.cipher = cipher;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(Short year) {
        this.year = year;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
