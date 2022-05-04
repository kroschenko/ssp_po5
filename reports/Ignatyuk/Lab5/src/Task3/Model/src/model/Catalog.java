package model;

import java.util.Vector;

public final class Catalog {
    private Vector<Book> m_Books = new Vector<Book>();

    public Catalog() {
    }

    public Catalog(final Vector<Book> c_Books) {
        this.m_Books = c_Books;
    }

    public final void f_set_books(final Vector<Book> c_Books) {
        this.m_Books = c_Books;
    }

    public final Vector<Book> f_get_books() {
        return this.m_Books;
    }

    public final void f_add_book(final Book c_Book) {
        this.m_Books.add(c_Book);
    }

    public final void f_remove_book(final Book c_Book) {
        this.m_Books.removeElement(c_Book);
    }

    public final Boolean f_book_search(final Book c_Book) {
        if (this.m_Books.indexOf(c_Book) != -1) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    public final Book f_give_book(final Book c_Book) {
        final Integer c_Index = this.m_Books.indexOf(c_Book);

        if (c_Index == -1) {
            return null;
        }

        final Book c_Result = this.m_Books.get(c_Index);
        this.f_remove_book(c_Book);

        return c_Result;
    }
}
