using System;

namespace Lab6_2
{
	public class Customer
	{
		protected string _nickName;

		public Customer(string nickName)
		{
			_nickName = nickName;
		}

		public void MyLevel(Level level)
		{
			Console.WriteLine($"{_nickName}, you have {level.GetLevel()}");
		}

		public void GetData(Level level)
		{
			Console.WriteLine(level.AddToFavourites());
			Console.WriteLine(level.GetDiscont());
			Console.WriteLine();
		}
	}
}
