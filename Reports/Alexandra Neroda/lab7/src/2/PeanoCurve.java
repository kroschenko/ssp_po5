import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

public class PeanoCurve {
	private static boolean debug = false;
	private static int xi = 100; // initial x, for border space
	private static int yi = 100; // initial y, for border space

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out
				.println("Enter the iteration of the Peano Curve you want to generate (n >= 1)");
		if (scanner.hasNextInt()) {
			UserInterface ui = new UserInterface();
			while (scanner.hasNextInt()) {
				int iteration = scanner.nextInt();
				if (iteration < 0)
					break;
				DrawPeanoCurve(ui, iteration);
			}
		}

		scanner.close();

		System.exit(0);

	}

	public static void DrawPeanoCurve(UserInterface ui, int iteration) {
		// initialize canvas
		int width = ui.getWidth(); // canvas x size
		int height = ui.getHeight(); // canvas y size
		int hsl = getPeanoSize(iteration); // hilbert curve side length in line units
		
		// if iteration is larger than support canvas size
		if (iteration > 5) {
			width = hsl * 2 + 2 * xi;
			height = hsl * 2 + 2*yi;
			System.out.println("Generating image at size "+width+"x"+height);
		}
		
		// set up  image
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_BINARY);
		Graphics g = img.getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		g.setColor(Color.BLACK);
		
		// prepare for drawing
		int state = 0;
		int x = xi; // x coordinate
		int y = height - yi; // y coordinate
		int d = (width < height) ? (width - 2*xi) / hsl : (height - 2*yi) / hsl; // length of a hilbert line unit on our canvas
		int dx = x; // destination x for line
		int dy = y; // destination y for line
		
		// prepare curve
		String curve = generateHilbertCurve(iteration);
		for (int i = 0; i < curve.length(); i++) {
			switch (curve.charAt(i)) {
			case '+':
				// turn right
				state -= 90;
				if (state < 0) state += 360;
				break;
			case '-':
				// turn left
				state += 90;
				state %= 360;
				break;
			case 'F':
				// draw forward
				if (debug) System.out.println("state = "+state);
				switch(state) {
				case 0:
					dx = x + d;
					dy = y;
					break;
				case 90:
					dx = x;
					dy = y - d;
					break;
				case 180:
					dx = x - d;
					dy = y;
					break;
				case 270:
					dx = x;
					dy = y + d;
					break;
				}
				if (debug) System.out.println("drawing line from ("+x+","+y+") to ("+dx+","+dy+")");
				g.drawLine(x, y, dx, dy);
				x = dx;
				y = dy;
				break;
			}
		}
//		ui.setImage(img);
		File outputfile = new File("peano-"+iteration+".png");
		try {
			ImageIO.write(img, "png", outputfile);
			System.out.println("Finished writing image.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (iteration <= 5) {
			ui.setImage(img);
			ui.repaint();
			ui.setVisible(true);
		} else {
			ui.setVisible(false);
		}
	}

	public static String generateHilbertCurve(int iteration) {
		String curve = "-A";
		String axiomA = "CFDFC+F+DFCFD-F-CFDFC";
		String axiomB = "DFCFD-F-CFDFC+F+DFCFD";
		for (int i = 0; i < iteration; i++) {
			curve = curve.replace("A", axiomA);
			curve = curve.replace("B", axiomB);
			curve = curve.replace("C", "A");
			curve = curve.replace("D", "B");
			if (debug)
				System.out.println("curve at iteration #" + (i + 1) + " = "
						+ curve);
		}
		System.out.println("Generated curve is "+curve.length()+" characters long.");
		return curve;
	}

	private static int getPeanoSize(int iteration) {
		int result = 2;
		for (int i = 1; i < iteration; i++) {
			result *= 3;
			result += 2;
		}
		return result;
	}

}

class UserInterface extends JFrame {
	private static final long serialVersionUID = 5051321847886284731L;
	private final static String title = "Space Filling Curves";
	private final int width = 1000;
	private final int height = 1000;
	private BufferedImage img;
	
	public UserInterface() {
		// initialize the frame
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(width, height));
		setVisible(true);
	}
	
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}
	
	public void setImage(BufferedImage img) {
		this.img = img;
	}
}