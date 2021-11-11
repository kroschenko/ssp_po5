using System;

namespace Lab5_1
{
	abstract class SamsungMobile: IMobile
	{
		private string model;
		private int price;

		protected SamsungMobile(string model, int price)
		{
			this.model = model;
			this.price = price;
		}

		protected void SetPrice(int price)
		{
			this.price = price;
		}

		public int GetPrice()
		{
			return this.price;
		}

		public string GetTitle()
		{
			return $"Samsung { this.model}";
		}

		public void Print()
		{
			Console.WriteLine($"Model: Samsung {this.model}\nPrice: {this.price}\n\n");
		}
	}
}
