using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace prikol1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        //0 90 200 700

        public int h1, h2, h3, h4;

        public void Set(int a1, int a2, int a3, int a4)
        {
            this.h1 = a1;
            this.h2 = a2;
            this.h3 = a3;
            this.h4 = a4;
        }


        private void Form1_Paint(object sender, PaintEventArgs e)
        {
            int n = 10;

            List<Point> points= new List<Point>();
            Random rnd = new Random();
            int x, y;
            Point h;

            Graphics g;
            g = CreateGraphics();
            
            Line f = new Line(h1, h2, h3, h4);//получить с формы
            f.draw(g);

            for(int i = 0; i < n; i++)
            {
                x=rnd.Next(0, 811);
                y = rnd.Next(0, 484);
                h = new Point(x, y);
                points.Add(h);
            }

            foreach(var item in points)
            {
                int pointY = f.getK()*item.getX()+f.getB();
                if (pointY < item.getY())
                {
                    item.draw(g, Color.Blue);
                }
                else if(pointY > item.getY())
                {
                    item.draw(g, Color.Yellow);
                }
            }

        }
    }
}
