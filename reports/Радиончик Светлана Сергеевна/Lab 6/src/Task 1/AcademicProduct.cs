using System;
using System.Threading;

namespace Lab6_1_1
{
	class AcademicProduct : IProduct
	{
		public void ChooseInstrument(string name)
		{
			Thread.Sleep(8000);
			Console.WriteLine(name);

			Console.WriteLine("Выберите музыкальный инструмент:\n1 - блокфлейта\n2 - глокеншпиль\n3 - синтезатор\n4 - скрипка");
			bool choice = true;

			while (choice)
			{
				var n = Console.ReadLine();

				switch (n)
				{
					case "1":
						Console.WriteLine("Блокфлейта. ");
						choice = false;
						break;
					case "2":
						Console.WriteLine("Глокеншпиль. ");
						choice = false;
						break;
					case "3":
						Console.WriteLine("Синтезатор. ");
						choice = false;
						break;
					case "4":
						Console.WriteLine("Скрипка. ");
						choice = false;
						break;
					default:
						Console.WriteLine("Вы ввели неправильное значение. Попробуйте ещё");
						break;
				}
			}
		}
	}
}
\