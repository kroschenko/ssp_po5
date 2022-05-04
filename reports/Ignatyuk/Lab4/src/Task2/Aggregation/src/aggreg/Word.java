package aggreg;

public final class Word {
    private String m_Data = new String();

    public Word(final String c_Data) {
        this.m_Data = c_Data;
    }

    public final void f_set_data(final String c_Data) {
        this.m_Data = c_Data;
    }

    public final String f_get_data() {
        return this.m_Data;
    }
}
