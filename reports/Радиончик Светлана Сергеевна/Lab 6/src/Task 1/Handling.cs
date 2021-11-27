using System;
using System.Threading;

namespace Lab6_1
{
	class Handling
	{
		private IStrategy _strategy;
		public void Serve(string name)
		{
			this.ChooseDirection(name);
			var instrument = this.ChooseInstrument(name);
			this.Buy(name, instrument);
		}

		protected void ChooseDirection(string name)
		{
			Console.WriteLine(name);
			Console.WriteLine("Выберите музыкальное направление:\n1 - народная музыка\n2 - духовная музыка\n3 - академическая музыка\n4 - популярная музыка");
			bool choice = true;

			while (choice)
			{
				var n = Console.ReadLine();
				
				switch (n)
				{
					case "1":
						choice = false;
						this._strategy = new FolkMusic();
						break;
					case "2":
						choice = false;
						this._strategy = new SacredMusic();
						break;
					case "3":
						choice = false;
						this._strategy = new AcademicMusic();
						break;
					case "4":
						choice = false;
						this._strategy = new PopMusic();
						break;
					default:
						Console.WriteLine("Вы ввели неправильное значение. Попробуйте ещё");
						break;
				}
			}
		}

		protected string ChooseInstrument(string name)
		{
			Thread.Sleep(8000);
			Console.WriteLine(name);

			return this._strategy.ChooseInstrument();
		}

		protected void Buy(string name, string instrument)
		{
			Thread.Sleep(10000);
			Console.WriteLine(name);
			Console.WriteLine($"{instrument}Купить?\n 1 - Да\n 2 - Нет");
			bool choice = true;

			while (choice)
			{
				var n = Console.ReadLine();
				
				switch (n)
				{
					case "1":
						choice = false;
						Console.WriteLine("Спасибо за покупку!");
						break;
					case "2":
						choice = false;
						Console.WriteLine("Ждём в следующий раз");
						break;
					default:
						Console.WriteLine("Вы ввели неправильное значение. Попробуйте ещё");
						break;
				}
			}
		}
	}
}
