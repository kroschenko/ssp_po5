public class Symbol {
    private final Character value;

    public Symbol(char value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
