namespace Lab6_3
{
	class Program
	{
		static void Main(string[] args)
		{
			Printer printer = new Printer("XM-43", 10, 60, 20);
			printer.GetName();
			printer.Print();

			Printer printer1 = new Printer("JG-21", 0, 10, 20);
			printer1.GetName();
			printer1.Print();

			Printer printer2 = new Printer("FH-58", 10, 50, 60);
			printer2.GetName();
			printer2.Print();
		}
	}
}
