package lab;

public class Line {
    public int x1, y1, x2, y2;

    public Line(int x1, int y1, int x2, int y2) {
        if (x2 < x1) {
            this.x1 = x2;
            this.y1 = y2;
            this.x2 = x1;
            this.y2 = y1;
        } else {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }

    public boolean checkIntersection(Line line) {
        if (this.x2 < line.x1) {
            return false;
        }
        //оба отрезка невертикальные
        double A1 = (this.y1 - this.y2) / (this.x1 - this.x2);
        System.out.println(A1);

        double A2 = (line.y1 - line.y2) / (line.x1 - line.x2);
        System.out.println(A2);
        double b1 = this.y1 - A1 * this.x1;
        double b2 = line.y1 - A2 * line.x1;

        if (A1 == A2) {
            return false; //отрезки параллельны
        }

        //Xa - абсцисса точки пересечения двух прямых
        double Xa = (b2 - b1) / (A1 - A2);

        if ((Xa < Math.max(this.x1, line.x1)) || (Xa > Math.min( this.x2, line.x2))) {
            return false; //точка Xa находится вне пересечения проекций отрезков на ось X
        }
        else {
            return true;
        }

    }

    public boolean equals(Line line) {
        if (this.x1 == line.x1 && this.x2 == line.x2 && this.y2 == line.y2 && this.y1 == line.y1)
            return true;
        else
            return false;
    }
}
