abstract class State {
    Printer mPrinter;

    State(Printer printer) {
        this.mPrinter = printer;
    }

    public abstract String onPrint(int numPaper);
    public abstract String onLoadPaper(int numPaper);
    public abstract String onExtractClampingPaper();
    public abstract String onRefilleCartridge();
}