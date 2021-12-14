import java.util.Vector;
public class Zadanie2 {
    public static void main(String[] args) {
        Word wordb1 = new Word("I");
        Word wordb2 = new Word("am");
        Word wordb3 = new Word("a");
        Word wordb4 = new Word("student");

        Word wordb5 = new Word("and");
        Word wordb6 = new Word("I");
        Word wordb7 = new Word("love");
        Word wordb8 = new Word("sleeping");

        Str str = new Str();
        str.AddWord(wordb1);
        str.AddWord(wordb2);
        str.AddWord(wordb3);
        str.AddWord(wordb4);

        Str Str2 = new Str();
        Str2.AddWord(wordb5);
        Str2.AddWord(wordb6);
        Str2.AddWord(wordb7);
        Str2.AddWord(wordb8);

        MyPage page = new MyPage();
        page.AddStr(str);
        page.AddStr(Str2);

        System.out.println(page.toString());
    }
}
class Word {
    private String Word;
    public Word (String c) {
        this.Word = c;
    }
    public String getStr() {
        return Word;
    }
}
class Str {
    private Vector<Word> Str = new Vector<Word>();
    void AddWord (Word word) {
        Str.add(word);
    }
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Word wordb: Str) {
			str.append(wordb.getStr());
            str.append(' ');
		}
        return str.toString();
    }
}
class MyPage {
    private  Vector<Str> mypage = new Vector<Str>();
    void AddStr(Str str) {
        mypage.add(str);
    }
	@Override
    public String toString() {
        StringBuilder page = new StringBuilder();
        for (Str str: mypage) {
            page.append(str.toString());
            page.append('\n');
        }
        return page.toString();
    }

}
