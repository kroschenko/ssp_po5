class WaitState extends State {

    WaitState(Printer printer) {
        super(printer);
    }

    @Override
    public String onPrint(int numPaper) {
        this.mPrinter.changeState(new PrintState(this.mPrinter));
        return "WaitState --> PrintState.\n";
    }

    @Override
    public String onLoadPaper(int numPaper) {
        return "Paper was loaded.\nWaitState.\n";
    }

    @Override
    public String onExtractClampingPaper() {
        return "Paper was extracted.\nWaitState.\n";
    }

    @Override
    public String onRefilleCartridge() {
        this.mPrinter.setPaintVolume(100);
        return "Cartridge was refilled.\nWaitState.\n";
    }
}