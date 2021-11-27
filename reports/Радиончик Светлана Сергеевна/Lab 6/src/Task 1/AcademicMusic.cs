using System;

namespace Lab6_1
{
	class AcademicMusic : IStrategy
	{
		public string ChooseInstrument()
		{
			Console.WriteLine("Выберите музыкальный инструмент:\n1 - блокфлейта\n2 - глокеншпиль\n3 - синтезатор\n4 - скрипка");

			while (true)
			{
				var n = Console.ReadLine();

				switch (n)
				{
					case "1":
						return "Блокфлейта. ";
					case "2":
						return "Глокеншпиль. ";
					case "3":
						return "Синтезатор. ";
					case "4":
						return "Скрипка. ";
					default:
						Console.WriteLine("Вы ввели неправильное значение. Попробуйте ещё");
						break;
				}
			}
		}
	}
}
