using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Drawing;

namespace prikol1
{
    class Line
    {
        private int k, b;
        private int x1, x2, y1, y2;
        private static Pen p = new Pen(Color.Black, 5);

        public Line(int k, int b, int x1, int x2)
        {
            this.k = k;
            this.b = b;
            this.x1 = x1;
            this.y1 = k * x1 + b;
            this.x2 = x2;
            this.y2 = k * x2 + b;
        }

        public void draw(Graphics g)
        {
            g.DrawLine(p, x1, y1, x2, y2);
        }

        public int getK()
        {
            return k;
        }
        public void setK(int k)
        {
            this.k = k;
        }
        public int getB()
        {
            return b;
        }
        public void setB(int b)
        {
            this.b = b;
        }

        public void setX1(int x1)
        {
            this.x1 = x1;
        }

        public void setX2(int x2)
        {
            this.x2 = x2;
        }
    }
}
