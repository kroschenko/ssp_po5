using System;

namespace Lab5_2
{
	class Cat : Pet
	{
		private bool IsHousehold;

		public Cat(string name, string color, bool isHousehold) : base(name, color)
		{
			this.IsHousehold = isHousehold;
		}

		public void SetIsHousehold(bool isHousehold)
		{
			this.IsHousehold = isHousehold;
		}

		private bool GetIsHousehold()
		{
			return this.IsHousehold;
		}

		public override void DetData()
		{
			Console.WriteLine($"--Cat--\nName: {this.GetName()}\nColor: {this.GetColor()}\nHousehold: {this.GetIsHousehold()}");
		}
	}
}
