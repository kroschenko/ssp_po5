package com.company;

public class Main {

    public static void main(String[] args) {
        Triangle triangle1 = new Triangle(2,3,4);
        if (triangle1.IsExist()) {
            System.out.println(triangle1.toString() +" exist P = " + triangle1.GetPerimeter() + " S = " + triangle1.GetSquare());
        } else System.out.println(triangle1.toString() + " doesn't exist");

        Triangle triangle2 = new Triangle(3,4,5);
        if (triangle2.IsExist()) {
            System.out.println(triangle2.toString() +" exist P = " + triangle2.GetPerimeter() + " S = " + triangle2.GetSquare());
        } else System.out.println(triangle2.toString() +" doesn't exist");

        Triangle triangle3 = new Triangle(3, 4, 5);
        if (triangle3.IsExist() && triangle2.equals(triangle3)) {
            System.out.println("Triangles " + triangle2.toString() + " and " + triangle3.toString() + " are equals");
        }
    }

}

