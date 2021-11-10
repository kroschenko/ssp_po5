package aggreg;

import java.util.Vector;

public final class Paragraph {
    private Vector<Word> m_Words = new Vector<Word>();

    public Paragraph() {
    }

    public Paragraph(final Vector<Word> c_Words) {
        this.m_Words = c_Words;
    }

    public final void f_set_words(final Vector<Word> c_Words) {
        this.m_Words = c_Words;
    }

    public final Vector<Word> f_get_words() {
        return this.m_Words;
    }

    public final void f_add_word(final Word c_Word) {
        this.m_Words.add(c_Word);
    }
}
