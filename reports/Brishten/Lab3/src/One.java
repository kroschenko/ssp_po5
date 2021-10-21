
public class One{
    public static void main(String[] args){
        Rectangle object = new Rectangle(3, 4);
        System.out.println("Test? - " + object.Test());
        Rectangle rect = new Rectangle(4, 4);
        System.out.println(rect.toString());
        System.out.println("Area: " + rect.Area());
        System.out.println("Perimeter: " + rect.Perimeter());
        System.out.println("Square? - " + rect.Square()); 

        Rectangle rect2 = new Rectangle(3, 4);
        System.out.println(rect2.toString());
        System.out.println("rect = rect2? - " + rect.Equals(rect2));
    }
}

class Rectangle{
    private Integer a, b;

    Rectangle(){
        this.a = 0;
        this.b = 0;
    }

    Rectangle(int A, int B){
        this.a = A;
        this.b = B;
    }

    int Area(){
        return this.a * this.b;
    }

    int Perimeter(){
        return (this.a + this.b) * 2;
    }

    boolean Square(){
        return this.a == this.b;
    }

    boolean Test(){
        return this.a != 0 && this.b != 0;
    }

    boolean Equals(Object obj){
        return this.equals(obj);
    }

    public boolean equals(Object obj){
        if (this == obj) 
            return true;
        if (obj == null || getClass() != obj.getClass()) 
            return false;

        Rectangle rectangle = (Rectangle) obj;

        if (a != null ? !a.equals(rectangle.a) : rectangle.a != null)
            return false;
        if (b != null ? !b.equals(rectangle.b) : rectangle.b != null)
            return false;
    
        return true;
    }

    public String toString(){
        return "\nRectangle with a = " + this.a + " and b = " + this.b;
        
    }
    
}

