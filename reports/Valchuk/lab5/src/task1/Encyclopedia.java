public class Encyclopedia extends Book {
    private Integer numberOfPages;

    public Encyclopedia() {}

    public Encyclopedia(String cipher, String author, String title, Short year, String publisher, Integer numberOfPages) {
        super(cipher, author, title, year, publisher);
        this.numberOfPages = numberOfPages;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }
}
