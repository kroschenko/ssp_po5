public class ReferenceBook extends Book {
    private Double price;

    public ReferenceBook() {}

    public ReferenceBook(String cipher, String author, String title, Short year, String publisher, Double price) {
        super(cipher, author, title, year, publisher);
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
