using System;

namespace Lab6_3
{
	class State
	{
		public void Expectation()
		{
			Console.WriteLine("Ожидание..");
		}

		public void Print()
		{
			Console.WriteLine("Печатаем..");
		}

		public void Clamping()
		{
			Console.WriteLine("Зажатие бумаги..");
		}

		public void Refusal()
		{
			Console.Write("Отказ..\nПополните ресурсы: ");
		}
	}
}
