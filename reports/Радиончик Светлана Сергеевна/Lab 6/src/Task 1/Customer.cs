namespace Lab6_1
{
	class Customer
	{
		private string Name;
		public Customer(string name)
		{
			Name = name;
		}

		public void Serve()
		{
			Handling handling = new Handling();
			handling.Serve(this.Name);
		}
	}
}
