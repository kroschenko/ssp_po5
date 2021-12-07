using System;
using System.Drawing;
using System.Windows.Forms;

namespace Lab7_1
{
	public partial class Form1 : Form
	{
        Graphics grph;
        Bitmap map;
        Pen pen;

        double angle = Math.PI / 2; //Угол поворота на 90 градусов
        double ang1 = 0.7;
        double ang2 = 0.9;

        public Form1()
		{
			InitializeComponent();
		}
        
        private void Form1_Load(object sender, EventArgs e)
        {
            label1.Text = "Поворот левого ребенка:";
            label2.Text = "Поворот правого ребенка:";
            button1.Text = "Отобразить";
            pen = new Pen(Color.DarkSlateBlue);
        }

        private void button1_Click(object sender, EventArgs e)
		{
            map = new Bitmap(pictureBox1.Width, pictureBox1.Height);
            grph = Graphics.FromImage(map);
            grph.SmoothingMode = System.Drawing.Drawing2D.SmoothingMode.AntiAlias;  //сглаживание

            if (textBox1.Text != "")
                ang1 = Convert.ToDouble(textBox1.Text);

            if (textBox2.Text != "")
                ang2 = Convert.ToDouble(textBox2.Text);

            DrawTree(300, 450, 200, angle);

            pictureBox1.BackgroundImage = map;
		}

        //x и y - координаты родительской вершины
        //a - параметр, который фиксирует количество итераций в рекурсии
        //angle - угол поворота на каждой итерации
        public int DrawTree(double x, double y, double a, double angle)
        {
            if (a > 2)
            {
                a *= 0.7;

                double xnew = Math.Round(x + a * Math.Cos(angle)),
                       ynew = Math.Round(y - a * Math.Sin(angle));

                grph.DrawLine(pen, (float)x, (float)y, (float)xnew, (float)ynew);

                x = xnew;
                y = ynew;

                //рекурсивная функция для левого и правого ребенка
                DrawTree(x, y, a, angle + ang1);
                DrawTree(x, y, a, angle - ang2);
            }
            return 0;
        }
	}
}
