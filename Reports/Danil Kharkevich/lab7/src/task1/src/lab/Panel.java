package lab;

        import javax.swing.*;
        import java.awt.*;
        import java.util.ArrayList;

public class Panel extends JPanel{
    ArrayList<Line> lines;
    public Panel(ArrayList<Line> lines) {
        super();
        this.lines = lines;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.white);
        for (Line l: lines)
            g.drawLine(l.x1, l.y1, l.x2, l.y2);
    }
}
