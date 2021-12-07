using System;
using System.Drawing;
using System.Windows.Forms;

namespace Lab7
{
	public partial class Form1 : Form
	{
		int diameter;
		int index;
		Graphics grph;

		int x = 10, y = 15;
		int dx = 10, dy = 10;

		public Form1()
		{
			InitializeComponent();
		}

		void DrawCircle(int x, int y)
		{
			int xc, yc;
			xc = x - diameter/2;
			yc = y - diameter /2;

			grph.FillEllipse(Brushes.Aqua, xc, yc, diameter/2, diameter/2);
			grph.DrawEllipse(Pens.Aqua, xc, yc, diameter/2, diameter/2);
		}

		public void Next()
		{
			if (x >= pictureBox1.Width - 2 * (diameter/2 + dx))
				dx = -dx;
			if (x < 0)
				dx = -dx;

			if (y >= pictureBox1.Height - SystemInformation.CaptionHeight - 2 * (diameter/2 + dy))
				dy = -dy;
			if (y < 0)
				dy = -dy;
			
			x += dx;
			y += dy;
		}

		public void Move(Graphics g)
		{
			g.Clear(pictureBox1.BackColor);
			Next();
			g.FillEllipse(Brushes.Aqua, x, y, diameter, diameter);
		}

		private void Form1_Load(object sender, EventArgs e)
		{
			button1.Text = "Отобразить";
		}

		private void button1_Click(object sender, EventArgs e)
		{
			index = 1;

			if(textBox1.Text != "")
				diameter = Convert.ToInt32(textBox1.Text);

			pictureBox1.Refresh();
		}

		private void pictureBox1_Paint(object sender, PaintEventArgs e)
		{
			if (index == 1)
			{
				grph = pictureBox1.CreateGraphics();
				DrawCircle(x, y);
				timer1.Enabled = true;
			}
		}

		private void timer1_Tick(object sender, EventArgs e)
		{
			Move(grph);
		}
	}
}
