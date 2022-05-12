public class Main {

    public static void main(String[] args) throws InvalidTriangleException {
        EquilateralTriangle firstTriangle = new EquilateralTriangle(13);

        System.out.println(firstTriangle.getLegLength());
        System.out.println(firstTriangle.getPerimeter());
        System.out.println(firstTriangle.getArea());
        System.out.println(firstTriangle);

        EquilateralTriangle secondTriangle = new EquilateralTriangle(13);
        EquilateralTriangle thirdTriangle = new EquilateralTriangle(14);

        System.out.println(firstTriangle.equals(secondTriangle));
        System.out.println(firstTriangle.equals(thirdTriangle));
    }
}
