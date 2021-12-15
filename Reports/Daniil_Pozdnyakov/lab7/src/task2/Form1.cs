using System;
using System.Drawing;
using System.Windows.Forms;

namespace PythagorasTree
{
    public partial class Form1 : Form
    {
        public Graphics g;
        public Bitmap map;
        public Pen p;
        public double angle = Math.PI / 2; //Угол поворота на 90 градусов
        public double ang1 = Math.PI / 4;  //Угол поворота на 45 градусов
        public double ang2 = Math.PI / 6;  //Угол поворота на 30 градусов


        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            map = new Bitmap(pictureBox1.Width, pictureBox1.Height);
            g = Graphics.FromImage(map);
            g.SmoothingMode = System.Drawing.Drawing2D.SmoothingMode.AntiAlias;
            p = new Pen(Color.Black);

            DrawTree(300, 450, 200, angle);

            pictureBox1.BackgroundImage = map;
        }

        //Рекурсивная функция отрисовки дерева
        //x и y - координаты родительской вершины
        //a - кол-во итераций
        //angle - угол поворота на каждой итерации
        public int DrawTree(double x, double y, double a, double angle)
        {

            if (a > 2)
            {
                a *= 0.7;

                double xnew = Math.Round(x + a * Math.Cos(angle)),
                       ynew = Math.Round(y - a * Math.Sin(angle));

                g.DrawLine(p, (float)x, (float)y, (float)xnew, (float)ynew);

                x = xnew;
                y = ynew;
                
                DrawTree(x, y, a, angle + ang1);
                DrawTree(x, y, a, angle - ang2);
            }
            return 0;
        }
    }
}