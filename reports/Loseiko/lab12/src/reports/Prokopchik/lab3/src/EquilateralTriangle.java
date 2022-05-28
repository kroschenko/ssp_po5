public class EquilateralTriangle
{
    private double legLength;

    public EquilateralTriangle(double legLength) throws InvalidTriangleException {
        ThrowExceptionIfSideLengthIsInvalid(legLength);

        this.legLength = legLength;
    }

    public double getLegLength() {
        return legLength;
    }

    public double getPerimeter() {
        return legLength * 3;
    }

    public double getArea() {
        return ((Math.pow(legLength,2) * Math.sqrt(3))/4);
    }

    @Override
    public String toString() {
        return String.format("EquilateralTriangle{legLength=%f}", legLength);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        EquilateralTriangle equilateralTriangle = (EquilateralTriangle) obj;

        return Double.compare(equilateralTriangle.legLength, legLength) == 0;
    }

    private boolean isTriangleValid(double legLength) {
        return legLength > 0;
    }

    private void ThrowExceptionIfSideLengthIsInvalid(double sideLength) {
        if (sideLength <= 0) {
            throw new IllegalArgumentException("Side length must be greater than 0. Provided value: " + sideLength);
        }
    }

    private void ThrowExceptionIfTriangleIsInvalid(double legLength) throws InvalidTriangleException {
        if (!isTriangleValid(legLength)) {
            throw new InvalidTriangleException("Equilateral triangle is valid if length of its side its greater than 0. " +
                    String.format("Provided values: leg length: %f", legLength));
        }
    }
}