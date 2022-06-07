package lab;
import java.util.Vector;
public class Main {

    public static void main(String[] args) {
	    Symbol symb1 = new Symbol('m');
        Symbol symb2 = new Symbol('a');
        Symbol symb3 = new Symbol('m');
        Symbol symb4 = new Symbol('a');

        Symbol symb5 = new Symbol('p');
        Symbol symb6 = new Symbol('a');
        Symbol symb7 = new Symbol('p');
        Symbol symb8 = new Symbol('a');

        Word word1 = new Word();
        word1.AddSymbol(symb1);
        word1.AddSymbol(symb2);
        word1.AddSymbol(symb3);
        word1.AddSymbol(symb4);

        Word word2 = new Word();
        word2.AddSymbol(symb5);
        word2.AddSymbol(symb6);
        word2.AddSymbol(symb7);
        word2.AddSymbol(symb8);

        MyString str = new MyString();
        str.AddWord(word1);
        str.AddWord(word2);

        System.out.println(str.toString());
    }
}

class Symbol {
    private char symbol;

    public Symbol (char c) {
        this.symbol = c;
    }

    public char getSymbol() {
        return symbol;
    }
}

class Word {
    private Vector<Symbol> word = new Vector<>();

    void AddSymbol (Symbol symbol) {
        word.add(symbol);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Symbol symb: word)
            str.append(symb.getSymbol());
        return str.toString();
    }
}

class MyString {
    private  Vector<Word> mystr = new Vector<>();

    void AddWord(Word word) {
        mystr.add(word);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Word word: mystr) {
            str.append(word.toString());
            str.append(' ');
        }
        return str.toString();
    }
}