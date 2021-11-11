using System;

namespace Lab5_2
{
	class Dog : Pet
	{
		private bool IsTrained;

		public Dog(string name, string color, bool isTrained) : base(name, color)
		{
			this.IsTrained = isTrained;
		}

		public void SetIsTrained(bool isTrained)
		{
			this.IsTrained = isTrained;
		}

		private bool GetIsTrained()
		{
			return this.IsTrained;
		}

		public override void DetData()
		{
			Console.WriteLine($"--Dog--\nName: {this.GetName()}\nColor: {this.GetColor()}\nHousehold: {this.GetIsTrained()}");
		}
	}
}
