

public class TextRunner {
    public static void main(String[] args) {
        Word word = new Word("It");
        Text text = new Text(word);

        Word word1 = new Word("is");
        Word word2 = new Word("true");
        Word word3 = new Word("end");

        Page oun = new Page();
        oun.addWord(word1);
        oun.addWord(word2);
        System.out.println("Page " + oun.getNumPage() + ": " + oun.getValue());

        Page two = new Page();
        two.addWord(word3);
        System.out.println("Page " + two.getNumPage() + ": " + two.getValue());

        text.addText(oun);
        text.addText(two);

        System.out.println("Title: " + text.getTitle());
        System.out.println("Text: " + text.getText());

    }
}

class Text {
    private String title, value;
    private String text = "";

    Text(Word word) {
        title = word.getValue();
    }

    Text(Page numPage) {
        value = numPage.getValue();
    }

    String getTitle() {
        return title;
    }

    void addText(Word word) {
        text += word.getValue();
    }

    void addText(Page numPage) {
        text += numPage.getValue();
    }

    String getText() {
        return text;
    }
}

class Page {
    private String value = "";
    static int numPage = 0;

    Page() {
        numPage++;
    }

    void addWord(Word word) {
        value += " " + word.getValue();
    }

    int getNumPage(){
        return numPage;
    }

    String getValue() {
        return value;
    }
}

class Word {
    private String value;

    Word(String value) {
        this.value = value;
    }

    String getValue() {
        return value;
    }
}