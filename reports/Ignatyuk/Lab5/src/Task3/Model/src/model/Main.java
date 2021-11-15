package model;

public final class Main {
    public final static void main(final String[] c_Args) throws Exception {
        Catalog v_Catalog = new Catalog();
        v_Catalog.f_add_book(new Book(2006, "The Road", "Cormac McCarthy"));
        v_Catalog.f_add_book(new Book(1985, "Perfume: The Story of a Murderer", "Patrick Süskind"));
        v_Catalog.f_add_book(new Book(2003, "We Need to Talk About Kevin", "Lionel Shriver"));
        v_Catalog.f_add_book(new Book(2005, "Haunted", "Chuck Palahniuk"));
        v_Catalog.f_add_book(new Book(2002, "The Lovely Bones", "Alice Sebold"));

        Library v_Library = new Library(new String("Alpha Park District"),
                new String("Alpha Park Public Library District"), 350, 12.33, new String("08:00 - 17:00"));
        v_Library.f_set_catalog(v_Catalog);

        final Librarian c_Librarian = new Librarian(32, "Mayson Falconer", v_Library);
        final Administrator c_Administrator = new Administrator(38, "Janette Trueman", v_Library);
        final Reader v_Reader = new Reader(19, "Conner Thacker");

        v_Library.f_add_librarian(c_Librarian);
        v_Library.f_add_administrator(c_Administrator);
        v_Library.f_add_reader(v_Reader);

        c_Librarian.f_work();
        c_Administrator.f_work();

        System.out.println(new String("Name: ") + v_Library.f_get_name());
        System.out.println(new String("Address: ") + v_Library.f_get_address());
        System.out.println(new String("Visitors count: ") + v_Library.f_get_visitors_count());
        System.out.println(new String("Visit price: ") + v_Library.f_get_visit_price());
        System.out.println(new String("Work time: ") + v_Library.f_get_work_time());
        System.out.println();

        if (v_Reader.f_request_book(v_Library, new Book(2005, "Haunted", "Chuck Palahniuk"))) {
            System.out.println("Book successfully taken");
        } else {
            System.out.println("Can not take a book");
        }

        v_Library.f_update();
    }
}
