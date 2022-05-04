package model;

import java.util.HashSet;
import java.util.Set;

public final class Reader extends Person {
    private Set<Order> m_Orders = new HashSet<Order>();

    public Reader(final Integer c_Age, final String c_Name) {
        super(c_Age, c_Name);
    }

    public Reader(final Integer c_Age, final String c_Name, final Set<Order> c_Orders) {
        super(c_Age, c_Name);
        this.m_Orders = c_Orders;
    }

    public final void f_set_orders(final Set<Order> c_Orders) {
        this.m_Orders = c_Orders;
    }

    public final Set<Order> f_get_orders() {
        return this.m_Orders;
    }

    public final void f_add_order(final Order c_Order) {
        this.m_Orders.add(c_Order);
    }

    public final void f_remove_order(final Order c_Order) {
        this.m_Orders.remove(c_Order);
    }

    public final Boolean f_request_book(final Library c_Library, final Book c_Book) {
        if (c_Library.f_book_search(c_Book)) {
            final Order c_Order = c_Library.f_process_order(this, c_Book);

            if (c_Order == null) {
                return Boolean.FALSE;
            }

            this.f_add_order(c_Order);
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }
}
