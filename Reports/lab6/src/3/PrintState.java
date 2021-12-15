import java.util.Random;

class PrintState extends State {

    PrintState(Printer printer) {
        super(printer);
    }

    @Override
    public String onPrint(int numPaper) {
        Random r = new Random();
        double probality = 0 + (100 - 0) * r.nextDouble();

        if(probality <= this.mPrinter.getPinchingProbability() + 20 &&
        probality >= this.mPrinter.getPinchingProbability() - 20) {
            this.mPrinter.changeState(new ClampingState(this.mPrinter));
            return "Paper cann't be printed. It's claimed.\nPrintState --> ClampingState.\n";
        }
        
        for(int i = 0; i < numPaper; ++i) {
            //5% = 1 page
            int numPapersInPrinter = this.mPrinter.getNumPapers();
            double paintVolume = this.mPrinter.getPaintVolume();
            if(paintVolume - 5 >= 0 && numPapersInPrinter > 0) {
                this.mPrinter.setPaintVolume(paintVolume - 5);
                this.mPrinter.setNumPapers(numPapersInPrinter - 1);
            }
            else {
                this.mPrinter.changeState(new FailureState(this.mPrinter, numPaper - i));
                if(paintVolume - 5 < 0) {
                    return "Other paper cann't be printed. Not enough painter in cartridge.\nPrintState --> FailureState.\n";
                }
                if(numPapersInPrinter <= 0) {
                    return "Other paper cann't be printed. Not enough papers.\nPrintState --> FailureState.\n";
                }
            }
        }

        this.mPrinter.changeState(new WaitState(this.mPrinter));
        return "Paper was printed.\nPrintState --> WaitState.\n";
    }

    @Override
    public String onLoadPaper(int numPaper) {
        return "Paper cann't be loaded.\nPrintState.\n";
    }

    @Override
    public String onExtractClampingPaper() {
        return "Paper cann't be clamped\nPrintState.\n";
    }

    @Override
    public String onRefilleCartridge() {
        return "Cartridge cann't be refilled.\nPrintState.\n";
    }
}