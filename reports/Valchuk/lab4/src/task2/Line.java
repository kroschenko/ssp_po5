import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private final List<Word> words;

    public Line() {
        words = new ArrayList<>();
    }

    public Line(List<Word> words) {
        this.words = words;
    }

    public void addWord(Word word) {
        words.add(word);
    }

    public void removeWord() {
        if (words.size() == 0) {
            throw new IllegalStateException();
        }

        words.remove(words.size() - 1);
    }

    @Override
    public String toString() {
        return words.stream().map(Word::toString).collect(Collectors.joining(" "));
    }
}
