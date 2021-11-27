using System;

namespace Lab6_1
{
	class PopMusic : IStrategy
	{
		public string ChooseInstrument()
		{
			Console.WriteLine("Выберите музыкальный инструмент:\n1 - гитара\n2 - барабан\n3 - мелодика\n4 - MIDI-клавиатура");

			while (true)
			{
				var n = Console.ReadLine();
				
				switch (n)
				{
					case "1":
						return "Гитара. ";
					case "2":
						return "Барабан. ";
					case "3":
						return "Мелодика. ";
					case "4":
						return "MIDI-клавиатура. ";
					default:
						Console.WriteLine("Вы ввели неправильное значение. Попробуйте ещё");
						break;
				}
			}
		}
	}
}
