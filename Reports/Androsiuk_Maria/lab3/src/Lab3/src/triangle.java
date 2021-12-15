import java.util.Objects;

public class triangle 
{
	private double a,b,c;
	
	public triangle(double a1, double b1, double c1)
	{
		this.a = a1;
		this.b = b1;
		this.c = c1;
	}
	
	public boolean isExist()
	{
		if (a+b>c && a+c>b && b+c>a) return true;
		else return false;
	}
	
	public double perimeter()
	{
		return a+b+c;
	}
	
	public double square()
	{
		return (a*b)/2*Math.sin(Math.toRadians(90));
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		triangle Triangle = (triangle) obj; 
		return Objects.equals(a, Triangle.a) && Objects.equals(b, Triangle.b) && Objects.equals(c, Triangle.c);
	}
	
	@Override
	public String toString()
	{
		String str = new StringBuilder().append(a+" ").append(b+" ").append(c).toString();
		return str;
	}
}
