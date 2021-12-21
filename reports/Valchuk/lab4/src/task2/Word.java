import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Word {
    private final List<Symbol> symbols;

    public Word() {
        symbols = new ArrayList<>();
    }

    public Word(List<Symbol> symbols) {
        this.symbols = symbols;
    }

    public void addSymbol(Symbol symbol) {
        symbols.add(symbol);
    }

    public void removeSymbol() {
        if (symbols.size() == 0) {
            throw new IllegalStateException();
        }

        symbols.remove(symbols.size() - 1);
    }

    @Override
    public String toString() {
        return symbols.stream().map(Symbol::toString).collect(Collectors.joining());
    }
}
