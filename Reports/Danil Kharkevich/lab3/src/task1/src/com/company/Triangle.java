package com.company;

public class Triangle {
    int a, b, c;
    double S, P;

    Triangle() {
        a = 0;
        b = 0;
        c = 0;
    }
    Triangle (int _a, int _b, int _c) {
        a = _a;
        b = _b;
        c = _c;
    }
    boolean IsExist() {
        if (a*a + b*b == c*c && a > 0 && b > 0 && c > 0) {
            return  true;
        } else return  false;
    }
    double GetPerimeter() {
        P = a + b + c;
        return P;
    }
    double GetSquare() {
        double p, x;
        p = ((GetPerimeter())/2);
        x = p*(p-a)*(p-b)*(p-c);
        S = Math.sqrt(x);
        return S;
    }
    boolean equals(Triangle tri) {
        if (tri.a == a && tri.b == b && tri.c == c) {
            return true;
        } else return false;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
