using System.Drawing;

namespace prikol1
{
    class Point
    {
        private int x, y;
        private static int width = 10, height = 10;

        public Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

        public void draw(Graphics g, Color color)
        {
            g.FillEllipse(new SolidBrush(color), x, y, width, height);
        }
        public void setX(int x)
        {
            this.x = x;
        }

        public void setY(int y)
        {
            this.y = y;
        }
        public int getX()
        {
            return x;
        }

        public int getY()
        {
            return y;
        }
    }
}