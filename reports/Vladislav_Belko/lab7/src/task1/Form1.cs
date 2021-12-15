using System;
using System.Collections.Generic;
using System.Drawing;
using System.Windows.Forms;

namespace spp_lab7
{
    namespace myGraph {
        class Point
        {
            public Point(int x, int y)
            {
                X = x;
                Y = y;
            }
            public readonly int X;

            public readonly int Y;
        }

        class Rectangle
        {
            public Rectangle(Point point, int height, int width)
            {
                Point = point;
                Height = height;
                Width = width;
            }

            public readonly myGraph.Point Point;

            public readonly int Height;

            public readonly int Width;

            public bool IsInside(Point elem)
            {
                bool param = false;

                if (elem.X >= Point.X && elem.X <= Point.X + Height && 
                    elem.Y >= Point.Y && elem.Y <= Point.Y + Width)
                {
                    param = true;
                }
                    
                return param;
            }
        }
    }

    public partial class Task1 : Form
    {
        myGraph.Rectangle rectangle_;

        List<myGraph.Point> points_ = new List<myGraph.Point>();

        Pen pen_ = new Pen(Color.Blue, 3);

        public Task1()
        {
            InitializeComponent();
        }

        private void PointAdd_Click(object sender, EventArgs e)
        {
            int X = 0;
            int Y = 0;

            int.TryParse(MyPointX.Text, out X);
            int.TryParse(MyPointY.Text, out Y);

            myGraph.Point Point = new myGraph.Point(X, Y);

            if (rectangle_?.IsInside(Point)??false)
            {
                points_.Add(Point);
                pen_.Color = Color.Red;
                using (Graphics Graph = PictB.CreateGraphics())
                {
                    Graph.DrawRectangle(pen_, Point.X, Point.Y, 1, 1);
                }
                Message.Text = "All right";
            }
            else
            {
                Message.Text = "Point is not in Rectangle!";
            }
        }

        private void RectAdd_Click(object sender, EventArgs e)
        {
            ClearAll();

            int X = 0;
            int Y = 0;
            int Height = 0;
            int Width = 0;

            int.TryParse(RectPointX.Text, out X);
            int.TryParse(RectPointY.Text, out Y);
            int.TryParse(RectHeight.Text, out Height);
            int.TryParse(RectWidth.Text, out Width);

            myGraph.Point TLPoint = new myGraph.Point(X, Y);

            pen_.Color = Color.Blue;

            rectangle_ = new myGraph.Rectangle(TLPoint, Height, Width);

            using (Graphics Graph = PictB.CreateGraphics())
            {
                Graph.DrawRectangle(pen_, rectangle_.Point.X, rectangle_.Point.Y, rectangle_.Width, rectangle_.Height);
            }
        }

        private void Clear_Click(object sender, EventArgs e)
        {
            ClearAll();
        }

        private void ClearAll()
        {
            using (Graphics Graph = PictB.CreateGraphics())
            {
                Graph.Clear(Color.LightGray);
                points_.Clear();
                rectangle_ = null;
            }
        }
    }
}
