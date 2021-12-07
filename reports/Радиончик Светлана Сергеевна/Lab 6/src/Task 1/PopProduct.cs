using System;
using System.Threading;

namespace Lab6_1_1
{
	class PopProduct : IProduct
	{
		public void ChooseInstrument(string name)
		{
			Thread.Sleep(8000);
			Console.WriteLine(name);

			Console.WriteLine("Выберите музыкальный инструмент:\n1 - гитара\n2 - барабан\n3 - мелодика\n4 - MIDI-клавиатура");
			bool choice = true;

			while (choice)
			{
				var n = Console.ReadLine();

				switch (n)
				{
					case "1":
						Console.WriteLine("Гитара. ");
						choice = false;
						break;
					case "2":
						Console.WriteLine("Барабан. ");
						choice = false;
						break;
					case "3":
						Console.WriteLine("Мелодика. ");
						choice = false;
						break;
					case "4":
						Console.WriteLine("MIDI-клавиатура. ");
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
