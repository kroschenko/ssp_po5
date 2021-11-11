using System;

namespace Lab5_1
{
	class Model: SamsungMobile
	{
		private string description;

		public Model(string model, int price, string description) : base(model, price)
		{
			this.description = description;
		}

		public void SetDescription(string description)
		{
			this.description = description;
		}

		public string GetDescription()
		{
			return this.description;
		}

		public new void Print()
		{
			Console.WriteLine($"Model: {this.GetTitle()}\nPrice: {this.GetPrice()}\nDesription: {this.description}\n\n");
		}
	}
}
