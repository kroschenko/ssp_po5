class Printer implements IPrinter{
    private String mModel;
    private int mNumPapers;
    private double mPaintVolume;
    private double mPinchingProbability;
    private State mState;

    public Printer(String model, int numPapers, double paintVolume, double pinchingProbability) {
        this.setModel(model);
        this.setNumPapers(numPapers);
        this.setPaintVolume(paintVolume);
        this.setPinchingProbability(pinchingProbability);
        this.changeState(new WaitState(this));
    }

    @Override
    public void changeState(State state) {
        this.mState = state;
    }

    public State getSatate() {
        return this.mState;
    }

    public void setModel(String model) {
        this.mModel = model;
    }

    public String getModel() {
        return this.mModel;
    }
    
    public void setNumPapers(int numPapers) {
        this.mNumPapers = numPapers;
    }

    public int getNumPapers() {
        return this.mNumPapers;
    }
    
    public void setPaintVolume(double paintVolume) {
        this.mPaintVolume = paintVolume;
    }

    public double getPaintVolume() {
        return this.mPaintVolume;
    }
    
    public void setPinchingProbability(double pinchingProbability) {
        this.mPinchingProbability = pinchingProbability;
    }

    public double getPinchingProbability() {
        return this.mPinchingProbability;
    }

    @Override
    public String print(int numPaper) {
        String resultOfPrint = this.mState.onPrint(numPaper);
        System.out.println(resultOfPrint);
        return resultOfPrint;
    }

    @Override
    public void loadPaper(int numPaper) {
        System.out.println(this.mState.loadPaper(numPaper));
    }

    @Override
    public void extractClampingPaper() {
        System.out.println(this.mState.onExtractClampingPaper());
    }

    @Override
    public void refilleCartridge() {
        System.out.println(this.mState.onRefilleCartridge());
    }

}
