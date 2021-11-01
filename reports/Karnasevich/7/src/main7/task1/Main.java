package main7.task1;

import javax.swing.*;


public final class Main {

    public static void main(String[] args) {
        var frame = new JFrame("Test");
        var canvas = new TestCanvas();
        canvas.setSize(450, 450);
        frame.add(canvas);
        frame.setSize(450, 450);
        frame.setVisible(true);
    }
}
