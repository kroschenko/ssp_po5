package model;

public final class Main {
    public final static void main(final String[] c_Args) throws Exception {
        Catalog v_Catalog = new Catalog();
        v_Catalog.f_add_book(new Book(2006, "The Road", "Cormac McCarthy"));
        v_Catalog.f_add_book(new Book(1985, "Perfume: The Story of a Murderer", "Patrick Süskind"));
        v_Catalog.f_add_book(new Book(2003, "We Need to Talk About Kevin", "Lionel Shriver"));
        v_Catalog.f_add_book(new Book(2005, "Haunted", "Chuck Palahniuk"));
        v_Catalog.f_add_book(new Book(2002, "The Lovely Bones", "Alice Sebold"));

        Library v_Library = new Library();
        v_Library.f_set_catalog(v_Catalog);

        final Librarian c_Librarian = new Librarian(32, "Mayson Falconer", v_Library);
        final Administrator c_Administrator = new Administrator(38, "Janette Trueman", v_Library);
        final Reader v_Reader = new Reader(19, "Conner Thacker");

        v_Library.f_add_librarian(c_Librarian);
        v_Library.f_add_administrator(c_Administrator);
        v_Library.f_add_reader(v_Reader);

        c_Librarian.f_work();
        c_Administrator.f_work();

        if (v_Reader.f_request_book(v_Library, new Book(2005, "Haunted", "Chuck Palahniuk"))) {
            System.out.println("Book successfully taken");
        } else {
            System.out.println("Can not take a book");
        }

        v_Library.f_update();
    }
}
