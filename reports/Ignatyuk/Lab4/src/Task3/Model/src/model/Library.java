package model;

import java.util.HashSet;
import java.util.Set;

public final class Library {
    private Catalog m_Catalog = new Catalog();
    private Set<Administrator> m_Administrators = new HashSet<Administrator>();
    private Set<Librarian> m_Librarians = new HashSet<Librarian>();
    private Set<Reader> m_Readers = new HashSet<Reader>(), m_BlackList = new HashSet<Reader>();
    private Set<Order> m_Orders = new HashSet<Order>();

    private String c_Deadline = new String("11/10/2021");

    public Library() {
    }

    public Library(final Catalog c_Catalog) {
        this.m_Catalog = c_Catalog;
    }

    public Library(final Catalog c_Catalog, final Set<Administrator> c_Administrators) {
        this.m_Catalog = c_Catalog;
        this.m_Administrators = c_Administrators;
    }

    public Library(final Catalog c_Catalog, final Set<Administrator> c_Administrators,
            final Set<Librarian> c_Librarians) {
        this.m_Catalog = c_Catalog;
        this.m_Administrators = c_Administrators;
        this.m_Librarians = c_Librarians;
    }

    public Library(final Catalog c_Catalog, final Set<Administrator> c_Administrators,
            final Set<Librarian> c_Librarians, final Set<Reader> c_Readers) {
        this.m_Catalog = c_Catalog;
        this.m_Administrators = c_Administrators;
        this.m_Librarians = c_Librarians;
        this.m_Readers = c_Readers;
    }

    public Library(final Catalog c_Catalog, final Set<Administrator> c_Administrators,
            final Set<Librarian> c_Librarians, final Set<Reader> c_Readers, final Set<Reader> c_BlackList) {
        this.m_Catalog = c_Catalog;
        this.m_Administrators = c_Administrators;
        this.m_Librarians = c_Librarians;
        this.m_Readers = c_Readers;
        this.m_BlackList = c_BlackList;
    }

    public Library(final Catalog c_Catalog, final Set<Administrator> c_Administrators,
            final Set<Librarian> c_Librarians, final Set<Reader> c_Readers, final Set<Reader> c_BlackList,
            final Set<Order> c_Orders) {
        this.m_Catalog = c_Catalog;
        this.m_Administrators = c_Administrators;
        this.m_Librarians = c_Librarians;
        this.m_Readers = c_Readers;
        this.m_BlackList = c_BlackList;
        this.m_Orders = c_Orders;
    }

    public final void f_set_catalog(final Catalog c_Catalog) {
        this.m_Catalog = c_Catalog;
    }

    public final Catalog f_get_catalog() {
        return this.m_Catalog;
    }

    public final void f_set_administrators(final Set<Administrator> c_Administrators) {
        this.m_Administrators = c_Administrators;
    }

    public final Set<Administrator> f_get_administrators() {
        return this.m_Administrators;
    }

    public final void f_set_librarians(final Set<Librarian> c_Librarians) {
        this.m_Librarians = c_Librarians;
    }

    public final Set<Librarian> f_get_librarians() {
        return this.m_Librarians;
    }

    public final void f_set_readers(final Set<Reader> c_Readers) {
        this.m_Readers = c_Readers;
    }

    public final Set<Reader> f_get_readers() {
        return this.m_Readers;
    }

    public final void f_set_black_list(final Set<Reader> c_BlackList) {
        this.m_BlackList = c_BlackList;
    }

    public final Set<Reader> f_get_black_list() {
        return this.m_BlackList;
    }

    public final void f_set_orders(final Set<Order> c_Orders) {
        this.m_Orders = c_Orders;
    }

    public final Set<Order> f_get_orders() {
        return this.m_Orders;
    }

    public final void f_add_book(final Book c_Book) {
        this.m_Catalog.f_add_book(c_Book);
    }

    public final void f_remove_book(final Book c_Book) {
        this.m_Catalog.f_remove_book(c_Book);
    }

    public final void f_add_administrator(final Administrator c_Administrator) {
        this.m_Administrators.add(c_Administrator);
    }

    public final void f_remove_administrator(final Administrator c_Administrator) {
        this.m_Administrators.remove(c_Administrator);
    }

    public final void f_add_librarian(final Librarian c_Librarian) {
        this.m_Librarians.add(c_Librarian);
    }

    public final void f_remove_librarian(final Librarian c_Librarian) {
        this.m_Librarians.remove(c_Librarian);
    }

    public final void f_add_reader(final Reader c_Reader) {
        this.m_Readers.add(c_Reader);
    }

    public final void f_remove_reader(final Reader c_Reader) {
        this.m_Readers.remove(c_Reader);
    }

    public final void f_add_to_black_list(final Reader c_Reader) {
        this.m_BlackList.add(c_Reader);
    }

    public final void f_remove_from_black_list(final Reader c_Reader) {
        this.m_BlackList.remove(c_Reader);
    }

    public final void f_add_order(final Order c_Order) {
        this.m_Orders.add(c_Order);
    }

    public final void f_remove_order(final Order c_Order) {
        this.m_Orders.remove(c_Order);
    }

    public final Boolean f_book_search(final Book c_Book) {
        return this.m_Catalog.f_book_search(c_Book);
    }

    public final String f_generate_deadline() {
        return c_Deadline;
    }

    public final Boolean f_check_deadline(final Order c_Order) {
        return c_Deadline.equals(c_Order.f_get_deadline());
    }

    public final Order f_process_order(final Reader c_Reader, final Book c_Book) {
        final Book c_OrderedBook = this.m_Catalog.f_give_book(c_Book);

        if (c_OrderedBook == null) {
            return null;
        }

        final String c_Deadline = this.f_generate_deadline();
        final Order c_Order = new Order(c_OrderedBook, c_Reader, c_Deadline);

        Boolean v_Processed = Boolean.FALSE;

        while (!v_Processed) {
            for (final Librarian c_Librarian : m_Librarians) {
                if (c_Librarian.f_is_working()) {
                    c_Librarian.f_add_order(c_Order);
                    v_Processed = Boolean.TRUE;
                    break;
                }
            }
        }

        this.m_Orders.add(c_Order);
        return c_Order;
    }

    public final void f_update() {
        Boolean v_Updated = Boolean.FALSE;

        while (!v_Updated) {
            for (final Administrator c_Administrator : m_Administrators) {
                if (c_Administrator.f_is_working()) {
                    c_Administrator.f_update();
                    v_Updated = Boolean.TRUE;
                    break;
                }
            }
        }
    }
}
