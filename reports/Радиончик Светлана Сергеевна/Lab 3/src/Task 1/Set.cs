using System;
using System.Linq;

namespace Lab3_1
{
	class Set
	{
		public double?[] set;

		public Set(int N)
		{
			this.set = new double?[N];
			for (int i = 0; i < N; i++)
				this.set[i] = null;
		}

		public Set(double?[] set)
		{
			this.set = new double?[set.Length];
			for (int i = 0; i < set.Length; i++)
				this.set[i] = set[i];
		}

		public Set CombineSet(Set addedSet)
		{
			int size = this.set.Count(i => i != null);
			size += addedSet.set.Count(i => i != null);

			Set combineSet = new Set(size);

			for(int i = 0; i < this.set.Length; i++)
			{
				if (this.set[i] != null)
				{
					combineSet.AddElement(this.set[i]);
				}
			}

			for (int i = 0; i < addedSet.set.Length; i++)
			{
				if (addedSet.set[i] != null)
				{
					if(!combineSet.set.Any(c => c == addedSet.set[i]))
						combineSet.AddElement(addedSet.set[i]);
				}
			}

			combineSet.set = Sort(combineSet.set);

			return combineSet;
		}

		public void Print()
		{
			Console.Write("Set: ");
			for(int i = 0; i < this.set.Length; i++)
			{
				if (this.set[i] != null)
				{
					Console.Write($"{this.set[i]}, ");
				}
			}
				
			Console.WriteLine();
		}

		public void AddElement(double? element)
		{
			if(!this.IsSetElement(element))
			{
				for(int i = 0; i < this.set.Length; i++)
				{
					if(this.set[i] == null)
					{
						this.set[i] = element;
						this.set = Sort(this.set);
						return;
					}
				}

				Console.WriteLine("Множество заполнено. Невозможно добавить элемент");
			}
		}

		public void DeleteElement(double? element)
		{
			if(this.IsSetElement(element))
			{
				for(int i = 0; i < this.set.Length; i++)
				{
					if (this.set[i] == element)
					{
						this.set[i] = null;
						break;
					}
						
				}

				this.set = Sort(this.set);
			}
			else
				Console.WriteLine("Нет такого элемента");
		}

		public bool Equals(Set comparableSet)
		{
			if (this.set.Length != comparableSet.set.Length)
				return false;

			for (int i = 0; i < this.set.Length; i++)
				if (this.set[i] != comparableSet.set[i])
					return false;

			return true;
		}

		public override string ToString()
		{
			string result = "";

			foreach (double x in this.set)
				result += $"{x.ToString()} ";

			return result;
		}

		private bool IsSetElement(double? element)
		{
			if (this.set.Any(x => x == element))
				return true;
			return false;
		}

		private double?[] Sort(double?[] set)
		{
			double? temp;
			
			for(int i = 0; i < set.Length - 1; i++)
			{
				for (int j = i + 1; j < set.Length; j++)
				{
					if(set[i] > set[j])
					{
						temp = set[i];
						set[i] = set[j];
						set[j] = temp;
					}
				}
			}

			return set;
		}
	}
}
