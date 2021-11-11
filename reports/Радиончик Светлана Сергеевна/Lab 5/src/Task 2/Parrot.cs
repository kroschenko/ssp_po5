using System;

namespace Lab5_2
{
	class Parrot : Pet
	{
		private bool IsTalking;

		public Parrot(string name, string color, bool isTalking) : base(name, color)
		{
			this.IsTalking = isTalking;
		}

		public void SetIsTalking(bool isTalking)
		{
			this.IsTalking = isTalking;
		}

		private bool GetIsTalking()
		{
			return this.IsTalking;
		}

		public override void DetData()
		{
			Console.WriteLine($"--Parrot--\nName: {this.GetName()}\nColor: {this.GetColor()}\nHousehold: {this.GetIsTalking()}");
		}
	}
}
