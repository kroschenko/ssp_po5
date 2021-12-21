import java.util.List;

public class Task2 {

    public static void main(String[] args) {
	    Word word1 = new Word();
        Word word2 = new Word();

        word1.addSymbol(new Symbol('a'));
        word1.addSymbol(new Symbol('b'));
        word1.addSymbol(new Symbol('c'));

        word2.addSymbol(new Symbol('d'));
        word2.addSymbol(new Symbol('e'));
        word2.addSymbol(new Symbol('f'));

        System.out.println(new Line(List.of(word1, word2)));

        word2.removeSymbol();

        System.out.println(word2);
    }
}
