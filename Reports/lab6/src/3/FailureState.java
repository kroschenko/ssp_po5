class FailureState extends State {
    private int mNumUnprintedPapers;

    FailureState(Printer printer, int numUnprintedPapers) {
        super(printer);
        this.setNumUnprintedPapers(numUnprintedPapers);
    }

    public void setNumUnprintedPapers(int numUnprintedPapers) {
        this.mNumUnprintedPapers = numUnprintedPapers;
    }

    public int getNumUnprintedPapers() {
        return this.mNumUnprintedPapers;
    }

    @Override
    public String onPrint(int numPaper) {
        if(this.mPrinter.getPaintVolume() - 5 >= 0 
        && this.mPrinter.getNumPapers() > 0) {
            this.mPrinter.changeState(new PrintState(this.mPrinter));
            this.mPrinter.print(this.mNumUnprintedPapers + numPaper);
            return "Waiting State --> PrintState\n";
        }
        else {
            if(this.mPrinter.getPaintVolume() - 5 < 0) {
                return "Other paper cann't be printed. Not enough painter in cartridge.\nFailureState.\n";
            }
            if(this.mPrinter.getNumPapers() <= 0) {
                return "Other paper cann't be printed. Not enough papers.\nFailureState.\n";
            }
        }
        return "FailureState\n";
    }

    @Override
    public String onLoadPaper(int numPaper) {
        if(this.mPrinter.getPaintVolume() - 5 >= 0) {
            this.mPrinter.changeState(new WaitState(this.mPrinter));
            return "Paper was loaded. Enough painters in cartridge.\nFailureState --> WaitState.\n";
        }
        else {
            return "Paper was loaded. Not ehough painters in cartridge.\nFailureState.\n";
        }
    }

    @Override
    public String onExtractClampingPaper() {
        this.mPrinter.changeState(new WaitState(this.mPrinter));
        return "Paper was extracted.\nFailureState.\n";
    }

    @Override
    public String onRefilleCartridge() {
        this.mPrinter.setPaintVolume(100);
        if(this.mPrinter.getNumPapers() > 0) {
            this.mPrinter.changeState(new WaitState(this.mPrinter));
            return "Cartridge was refilled. Enough papers.\nFailureState --> WaitState.\n";
        }
        else {
            return "Cartridge was refilled. Not ehough papers.\nFailureState.\n";
        }
    }
}