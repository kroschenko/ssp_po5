package model;

public final class Order {
    private Book m_Book = null;
    private Reader m_Reader = null;
    private String m_Deadline = new String();

    public Order(final Book c_Book, final Reader c_Reader, final String c_Deadline) {
        this.m_Book = c_Book;
        this.m_Reader = c_Reader;
        this.m_Deadline = c_Deadline;
    }

    public final void f_set_book(final Book c_Book) {
        this.m_Book = c_Book;
    }

    public final Book f_get_book() {
        return this.m_Book;
    }

    public final void f_set_reader(final Reader c_Reader) {
        this.m_Reader = c_Reader;
    }

    public final Reader f_get_reader() {
        return this.m_Reader;
    }

    public final void f_set_deadline(final String c_Deadline) {
        this.m_Deadline = c_Deadline;
    }

    public final String f_get_deadline() {
        return this.m_Deadline;
    }
}
