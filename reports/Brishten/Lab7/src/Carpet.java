
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class Carpet {

	public static Color BACKGROUNDCOLOR = new Color(0, 0, 150);
	public static Color FOREGROUNDCOLOR = new Color(255, 180, 0);

	public static int DEEP = 5;

	public Carpet(int deep) {
		JFrame frame = new JFrame();
		frame.setTitle("...: Recursive Squares with deep " + deep + " :...");
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setSize(400, 400);
		frame.setLocationRelativeTo(null);
		frame.add(new PrintArea(deep));
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				for (int i = DEEP; i >= 1; --i) {
					new Carpet(i);
				}

			}
		});
	}
}

class PrintArea extends JLabel {
	private static final long serialVersionUID = 1L;

	int deep;

	public PrintArea(int deep) {
		super();
		setBackground(Carpet.BACKGROUNDCOLOR);
		setOpaque(true);
        
		this.deep = deep;
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Carpet.FOREGROUNDCOLOR);
		int n = printSquares(g, 0, 0, getWidth(), getHeight(), this.deep);
		System.out.println("Deep = " + deep + ", squares painted: " + n);
	}

	private int printSquares(Graphics g, int xi, int yi, int width, int height, int currentDeep) {

        int newWidth = width / 3;
        int newHeight = height / 3;
        int x = (width / 3) + xi;
        int y = (height / 3) + yi;
        g.fillRect(x, y, newWidth, newHeight);
    
        int sX = 0;
        int sY = 0;
        if (currentDeep > 1) {
            int sum = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    sX = i * (width / 3) + xi;
                    sY = j * (height / 3) + yi;
                    sum += printSquares(g, sX, sY, newWidth, newHeight, currentDeep - 1);
                }
            }
            return 1 + sum;
        } else
            return 1;
	}
}