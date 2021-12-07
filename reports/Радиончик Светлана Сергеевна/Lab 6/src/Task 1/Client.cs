using System;

namespace Lab6_1_1
{
	class Client
	{
		public void Main(string name)
		{
			Console.WriteLine(name);
			Choice(name);
			
		}

		public void Choice(string name)
		{
			Console.WriteLine("Выберите музыкальное направление:\n1 - народная музыка\n2 - духовная музыка\n3 - академическая музыка\n4 - популярная музыка");
			bool choice = true;

			while (choice)
			{
				var n = Console.ReadLine();

				switch (n)
				{
					case "1":
						choice = false;
						ClientCode(new FolkSelector(), name);
						break;
					case "2":
						choice = false;
						ClientCode(new ScaredSelector(), name);
						break;
					case "3":
						choice = false;
						ClientCode(new AcademicSelector(), name);
						break;
					case "4":
						choice = false;
						ClientCode(new PopSelector(), name);
						break;
					default:
						Console.WriteLine("Вы ввели неправильное значение. Попробуйте ещё");
						break;
				}
			}
		}

		public void ClientCode(Selector selector, string name)
		{
			selector.FactoryMethod(name);
			selector.Buy(name);
		}
	}
}
