package aggreg;

import java.util.Vector;

public final class Main {
    public final static void main(final String[] c_Args) {
        Vector<Word> v_Words = new Vector<Word>();
        v_Words.add(new Word(new String("Hello")));
        v_Words.add(new Word(new String("world")));

        Paragraph v_Paragraph = new Paragraph(v_Words);

        for (final Word c_Word : v_Paragraph.f_get_words()) {
            System.out.print(c_Word.f_get_data() + new String(" "));
        }

        v_Paragraph.f_add_word(new Word(new String("we")));
        v_Paragraph.f_add_word(new Word(new String("are")));
        v_Paragraph.f_add_word(new Word(new String("here")));

        System.out.println();

        for (final Word c_Word : v_Paragraph.f_get_words()) {
            System.out.print(c_Word.f_get_data() + new String(" "));
        }
    }
}
