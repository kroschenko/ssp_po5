namespace Lab6_2
{
	class Program
	{
		static void Main(string[] args)
		{
			Customer customer = new Customer("Grof");
			var component = new ConcreteLevel();
			customer.MyLevel(component);
			customer.GetData(component);

			LevelOne levelOne = new LevelOne(component);
			customer.MyLevel(levelOne);
			customer.GetData(levelOne);

			LevelTwo levelTwo = new LevelTwo(levelOne);
			customer.MyLevel(levelTwo);
			customer.GetData(levelTwo);
		}
	}
}
