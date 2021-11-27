using System;

namespace Lab6_1
{
	class SacredMusic : IStrategy
	{
		public string ChooseInstrument()
		{
			Console.WriteLine("Выберите музыкальный инструмент:\n1 - флейта\n2 - кларнет\n3 - труба\n4 - тромбон");
			
			while (true)
			{
				var n = Console.ReadLine();

				switch (n)
				{
					case "1":
						return "Флейта. ";
					case "2":
						return "Кларнет. ";
					case "3":
						return "Труба. ";
					case "4":
						return "Тромбон. ";
					default:
						Console.WriteLine("Вы ввели неправильное значение. Попробуйте ещё");
						break;
				}
			}
		}
	}
}
