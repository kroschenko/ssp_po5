package com.company;
public class MultiThread {
    private CalculRow calcul, rundNum, n;
    private Thread thread;
    public void start() {
        if(calcul != null) {
            thread.start();
        }
    }
    public void stop() {
        if(calcul != null) {
            calcul.stopping = true;
        }
    }
    public void resume() {
        if(calcul != null) {
            calcul.stopping = false;
        }
    }
    public void interrupt() {
        if(calcul != null) {
            thread.interrupt();
        }
    }
    public void setCalculator(CalculRow calcul) {
        if (this.calcul != null) {
            interrupt();
        }
        this.calcul = calcul;
        thread = new Thread(calcul);
    }
}