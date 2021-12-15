interface IPrinter{
    String print(int numPaper);
    void loadPaper(int numPaper);
    void extractClampingPaper();
    void refilleCartridge();
    void changeState(State state);
}
