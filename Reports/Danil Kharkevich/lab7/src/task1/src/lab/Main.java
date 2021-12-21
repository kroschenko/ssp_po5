package lab;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Line> lines = new ArrayList<Line>();
        ArrayList<Line> intersecting_lines = new ArrayList<Line>();


        lines.add(new Line(25,25,275,275));
        lines.add(new Line(50, 100, 200, 250));
        lines.add(new Line(75, 100, 150, 25));
        lines.add(new Line(100,25,300,225));
        lines.add(new Line(250,25,200,110));
        lines.add(new Line(200,225,300,175));

        for (Line i: lines) {
            for (Line j : lines) {
                if (i.checkIntersection(j)) {
                    intersecting_lines.add(i);
                    intersecting_lines.add(j);
                }
            }
        }

        for (Line i: lines) {
            for (Line j : lines) {
                if (i.equals(j)) intersecting_lines.remove(j);
            }
        }

        JFrame window = new JFrame();
        window.setSize(350, 350);

        Panel panel = new Panel(intersecting_lines);
        panel.setBackground(Color.black);

        window.add(panel);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
