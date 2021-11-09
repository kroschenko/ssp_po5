public class Triangle {
    Float cathet_1;
    Float cathet_2;
    Float hypotenuse;

    public Triangle(Float cathet_1, Float cathet_2, Float hypotenuse) {
        this.cathet_1 = cathet_1;
        this.cathet_2 = cathet_2;
        this.hypotenuse = hypotenuse;
    }

    public void setTriangle(Float cathet_1, Float cathet_2, Float hypotenuse) {
        this.cathet_1 = cathet_1;
        this.cathet_2 = cathet_2;
        this.hypotenuse = hypotenuse;
    }

    public Triangle() {
        this.cathet_1 = null;
        this.cathet_2 = null;
        this.hypotenuse = null;
    }

    public double Square()
    {

        return Math.sqrt(Perimeter()*(Perimeter()-cathet_1)*(Perimeter()-cathet_2)*(Perimeter()-hypotenuse));
    }

    public Float Perimeter()
    {
        return cathet_1 + cathet_2 + hypotenuse;
    }

    public boolean isRectangular()
    {
        return Math.pow(cathet_1, 2) + Math.pow(cathet_2, 2)
                        == Math.pow(hypotenuse, 2);
    }

    public Float getCathet_1() {
        return cathet_1;
    }

    public void setCathet_1(Float cathet_1) {
        this.cathet_1 = cathet_1;
    }

    public Float getCathet_2() {
        return cathet_2;
    }

    public void setCathet_2(Float cathet_2) {
        this.cathet_2 = cathet_2;
    }

    public Float getHypotenuse() {
        return hypotenuse;
    }

    public void setHypotenuse(Float hypotenuse) {
        this.hypotenuse = hypotenuse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return cathet_1.equals(triangle.cathet_1) && cathet_2.equals(triangle.cathet_2) && hypotenuse.equals(triangle.hypotenuse);
    }

    @Override
    public String toString() {

        return "Катет №1 = " + cathet_1 +
                ", Катет №2 = " + cathet_2 +
                ", Гипотенуза = " + hypotenuse;
    }
}
