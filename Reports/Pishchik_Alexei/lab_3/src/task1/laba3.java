public class laba3 {


    public static void main(String[]args) {
        try {

        IsoscelesTriangle emptyTriangle = new IsoscelesTriangle();
        System.out.println(emptyTriangle.toString());


        IsoscelesTriangle oneTriangle = new IsoscelesTriangle(5, 4);
        System.out.println(oneTriangle.toString());

        IsoscelesTriangle twoTriangle = new IsoscelesTriangle(3, 4);
        System.out.println(twoTriangle.toString());

        System.out.println(twoTriangle.equals(oneTriangle));

        IsoscelesTriangle invalidTriangle = new IsoscelesTriangle(10000, 2);
        } catch(IllegalArgumentException e) {
            System.out.println("Can't create!");
        }
        
    }
    
}


class IsoscelesTriangle {

    private int base;
    private int side;

    public IsoscelesTriangle() {
        base = side = 0;
    }

    public IsoscelesTriangle(int base, int side) {
        this.base = base;
        this.side = side;
        if(!isValid()) throw new IllegalArgumentException();
    }

    public boolean isValid() {
        return side * 2 > base && base > 0 && side > 0;
    }

    public int area() {
        if(!isValid()) throw new IllegalArgumentException();
        return (int) (base * Math.sqrt(4 * side * side - base * base) / 4);
    }

    public int perimeter() {
        if(!isValid()) throw new IllegalArgumentException();
        return base + side * 2;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false;

        IsoscelesTriangle converted = (IsoscelesTriangle) obj;
        return this.side == converted.side && this.base == converted.base;
    }

    @Override
    public String toString() {
        String area = isValid() ? String.valueOf(area()) : "No"; String perimeter = isValid() ? String.valueOf(perimeter()) : "No";
        return "Triangle: {\n" +
                "\tbase:" + base + ",\n" +
                "\tside:" + side + ",\n" +
                "\tarea:" + area + ",\n" + "\tperimeter:" + perimeter + "\n}\n";
    }
}