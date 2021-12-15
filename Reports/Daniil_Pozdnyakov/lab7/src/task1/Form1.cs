using System;
using System.Drawing;
using System.Windows.Forms;

namespace spp.lab7
{
    public partial class Form1 : Form
    {
        private Segment segment;

        public Form1()
        {
            InitializeComponent();
            segment = new Segment(100, 100, 160, 180);
            var bt = new Button() { Parent = this, Text = "Rotate" };
            bt.Click += bt_Click;
        }

        void bt_Click(object sender, EventArgs e)
        {
            double Angle = 15 * Math.PI / 180f;
            segment.Rotate(Angle);
            Invalidate();
        }

        protected override void OnPaint(PaintEventArgs e)
        {
            Pen red = new Pen(Color.Red, 5);
            Pen orange = new Pen(Color.Orange, 5);
            Pen yellow = new Pen(Color.Yellow, 5);
            Pen green = new Pen(Color.Green, 5);
            Pen lightBlue = new Pen(Color.LightBlue, 5);
            Pen blue = new Pen(Color.Blue, 5);
            Pen magenta = new Pen(Color.Magenta, 5);

            if(segment.End.X > 0 && segment.End.X < 10)
                e.Graphics.DrawLine(red, segment.Start, segment.End);
            if (segment.End.X > 10 && segment.End.X < 45)
                e.Graphics.DrawLine(orange, segment.Start, segment.End);
            if (segment.End.X > 45 && segment.End.X < 80)
                e.Graphics.DrawLine(yellow, segment.Start, segment.End);
            if (segment.End.X > 80 && segment.End.X < 115)
                e.Graphics.DrawLine(green, segment.Start, segment.End);
            if (segment.End.X > 115 && segment.End.X < 150)
                e.Graphics.DrawLine(lightBlue, segment.Start, segment.End);
            if (segment.End.X > 150 && segment.End.X < 190)
                e.Graphics.DrawLine(blue, segment.Start, segment.End);
            if (segment.End.X > 190 && segment.End.X < 200)
                e.Graphics.DrawLine(magenta, segment.Start, segment.End);
        }
    }

    class Segment
    {
        public PointF Start;
        public PointF End;

        public Segment(float x1, float y1, float x2, float y2)
        {
            Start = new PointF(x1, y1);
            End = new PointF(x2, y2);
        }

        public void Rotate(double angle)
        {
            var pp = new PointF(End.X - Start.X, End.Y - Start.Y);
            var x = pp.X * Math.Cos(angle) - pp.Y * Math.Sin(angle);
            var y = pp.X * Math.Sin(angle) + pp.Y * Math.Cos(angle);

            End = new PointF((float)x + Start.X, (float)y + Start.Y);
        }
    }
}