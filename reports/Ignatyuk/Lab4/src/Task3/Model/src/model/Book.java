package model;

public final class Book {
    private Integer m_Year = 0;
    private String m_Title = new String(), m_Author = new String();

    public Book(final Integer c_Year, final String c_Title, final String c_Author) {
        this.m_Year = c_Year;
        this.m_Title = c_Title;
        this.m_Author = c_Author;
    }

    public final void f_set_year(final Integer c_Year) {
        this.m_Year = c_Year;
    }

    public final Integer f_get_year() {
        return this.m_Year;
    }

    public final void f_set_title(final String c_Title) {
        this.m_Title = c_Title;
    }

    public final String f_get_title() {
        return this.m_Title;
    }

    public final void f_set_author(final String c_Author) {
        this.m_Author = c_Author;
    }

    public final String f_get_author() {
        return this.m_Author;
    }
}
