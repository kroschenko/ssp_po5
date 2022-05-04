public class task3lab6 {
    public static void main(String[] args) {
        Keyboard keyboardButton1 = new Keyboard(new Digital("2"));
        Keyboard keyboardButton2 = new Keyboard(new Arithmetic("-"));
        Keyboard keyboardButton3 = new Keyboard(new Customize("3"));
        System.out.println(keyboardButton1.getSymbol());
        System.out.println(keyboardButton2.getSymbol());
        System.out.println(keyboardButton3.getSymbol());
        System.out.println();
        keyboardButton1 = customize(keyboardButton1);
        keyboardButton2 = customize(keyboardButton2);
        keyboardButton3 = customize(keyboardButton3);
        System.out.println(keyboardButton1.getSymbol());
        System.out.println(keyboardButton2.getSymbol());
        System.out.println(keyboardButton3.getSymbol());
    }
    private static Keyboard customize(Keyboard keyboardButton) {
        if (keyboardButton.isCustomized()) {
            keyboardButton = new Keyboard(new Customize("*"));
        }
        return keyboardButton;
    }
}

interface Button {
    String getSymbol();
    boolean isCustomized();
}

class Keyboard {
    Button button;

    Keyboard(Button button) {
        this.button = button;
    }

    String getSymbol() {
        return button.getSymbol();
    }

    boolean isCustomized() {
        return button.isCustomized();
    }
}

class Digital implements Button {
    private String symbol;

    Digital(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String getSymbol() {
        return "Digital button " + symbol;
    }

    @Override
    public boolean isCustomized() {
        return false;
    }
}

class Arithmetic implements Button {
    private String symbol;

    Arithmetic(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String getSymbol() {
        return "Arithmetic button " + symbol;
    }

    @Override
    public boolean isCustomized() {
        return false;
    }
}

class Customize implements Button {
    private String symbol;

    Customize(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String getSymbol() {
        return "Custom button " + symbol;
    }

    @Override
    public boolean isCustomized() {
        return true;
    }
}

