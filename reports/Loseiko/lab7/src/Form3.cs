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
    public partial class Form3 : Form
    {
        public Form3()
        {
            InitializeComponent();
        }

        private void Form3_Paint(object sender, PaintEventArgs e)
        {
            void drawMinkowski(int xa, int ya, int xi, int yi, int i)
            {
                if (i == 0)
                {
                    Graphics g;
                    g = CreateGraphics();
                    
                    Pen p = new Pen(Color.Black, 3);
                    g.DrawLine(p, xa, ya, xi, yi);
                }
                else
                {
                    double xb = xa + (xi - xa) * 1 / 4;
                    double yb = ya + (yi - ya) * 1 / 4;

                    double xe = xa + (xi - xa) * 2 / 4;
                    double ye = ya + (yi - ya) * 2 / 4;

                    double xh = xa + (xi - xa) * 3 / 4;
                    double yh = ya + (yi - ya) * 3 / 4;

                    int cos90 = 0;//0
                    int sin90 = -1;//-1
                    double xc = xb + (xe - xb) * cos90 - sin90 * (ye - yb);
                    double yc = yb + (xe - xb) * sin90 + cos90 * (ye - yb);

                    double xd = xc + (xe - xb);
                    double yd = yc + (ye - yb);

                    int sin0 = 1;//1
                    double xf = xe + (xh - xe) * cos90 - sin0 * (yh - ye);
                    double yf = ye + (xh - xe) * sin0 + cos90 * (yh - ye);

                    double xg = xf + (xh - xe);
                    double yg = yf + (yh - ye);

                    
                    drawMinkowski(xa, ya, (int)xb, (int)yb, i - 1);
                    drawMinkowski((int)xb, (int)yb, (int)xc, (int)yc, i - 1);
                    drawMinkowski((int)xc, (int)yc, (int)xd, (int)yd, i - 1);
                    drawMinkowski((int)xd, (int)yd, (int)xe, (int)ye, i - 1);
                    drawMinkowski((int)xe, (int)ye, (int)xf, (int)yf, i - 1);
                    drawMinkowski((int)xf, (int)yf, (int)xg, (int)yg, i - 1);
                    drawMinkowski((int)xg, (int)yg, (int)xh, (int)yh, i - 1);
                    drawMinkowski((int)xh, (int)yh, xi, yi, i - 1);
                      
                    /*
                     drawMinkowski(xa, ya, (int)xb, (int)yb, i - 1);
                   drawMinkowski((int)xb, (int)yb, (int)xc, (int)yc, i - 1);
                   drawMinkowski((int)xc, (int)yc, (int)xd, (int)yd, i - 1);
                   drawMinkowski((int)xd, (int)yd, (int)xe, (int)ye, i - 1);
                   drawMinkowski((int)xe, (int)ye, (int)xf, (int)yf, i - 1);
                   drawMinkowski((int)xf, (int)yf, (int)xg, (int)yg, i - 1);
                   drawMinkowski((int)xg, (int)yg, (int)xh, (int)yh, i - 1);
                   drawMinkowski((int)xh, (int)yh, xi, yi, i - 1);
                     */
                }
            }
            drawMinkowski(0, 0, 400, 600, 3);
        }

      
    }
}
