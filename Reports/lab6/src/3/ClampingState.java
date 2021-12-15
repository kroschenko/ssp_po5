class ClampingState extends State {

    ClampingState(Printer printer) {
        super(printer);
    }

    @Override
    public String onPrint(int numPaper) {
        return "Paper cann't be printed.\nClamping State.\n";
    }

    @Override
    public String onLoadPaper(int numPaper) {
        return "Paper cann't be loaded.\nClampingState.\n";
    }

    @Override
    public String onExtractClampingPaper() {
        this.mPrinter.changeState(new WaitState(this.mPrinter));
        return "Paper was extracted.\nClampingState --> WaitState.\n";
    }

    @Override
    public String onRefilleCartridge() {
        this.mPrinter.setPaintVolume(100);
        return "Cartridge was refilled.\nClampingState.\n";
    }
}