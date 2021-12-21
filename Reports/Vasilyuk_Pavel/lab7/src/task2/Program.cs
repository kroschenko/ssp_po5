using System;
using System.Drawing;
using System.Windows.Forms;

namespace task2
{
    public partial class Task2 : Form
    {
        private int height_;
        private int width_;

        public Task2()
        {
            InitializeComponent();
            height_ = PictBoxTask2.Height;
            width_ = PictBoxTask2.Width;
        }
        
        private void DrawH(int x, int y, int size)
        {
            Pen myPen = new Pen(Color.Black, 1);

            using (Graphics Graph = PictBoxTask2.CreateGraphics())
            {
                Graph.DrawLine(myPen, x - size, y - size, x - size, y + size);
                Graph.DrawLine(myPen, x - size, y, x + size, y);
                Graph.DrawLine(myPen, x + size, y - size, x + size, y + size);
            }
        }

        private void DrawFractal(int x, int y, int size, int minSize)
        {
            int x1 = x - size; 
            int y1 = y - size;

            int x2 = x - size;
            int y2 = y + size;

            int x3 = x + size;
            int y3 = y - size;

            int x4 = x + size;
            int y4 = y + size;

            DrawH(x, y, size);
            size = size / 2;
                         
            if (size >= minSize)
            {
                DrawFractal(x1, y1, size, minSize);
                DrawFractal(x2, y2, size, minSize);
                DrawFractal(x3, y3, size, minSize);
                DrawFractal(x4, y4, size, minSize);
            }
        }

        private void Generate_Click(object sender, EventArgs e)
        {
            int precision = 1;
            int size = 1;

            int.TryParse(FractPerc.Text, out precision);
            int.TryParse(FractSize.Text, out size);

            if (size < 1)
                size = 1;
            if (precision < 1)
                precision = 1;

            DrawFractal(width_ / 2, height_ / 2, size, precision);
        }

        private void Clear_Click(object sender, EventArgs e)
        {
            using (Graphics Graph = PictBoxTask2.CreateGraphics())
            {
                Graph.Clear(Color.LightGray);
            }
        }
    }
}