using System;
using System.Linq;

namespace Lab3_1
{
	class Set
	{
		public double[] set;

		public Set(int N)
		{
			this.set = new double[N];
		}

		public Set(double[] set)
		{
			this.set = new double[set.Length];
			this.set = set;
		}

		public Set CombineSet(Set addedSet)
		{
			Set combineSet = new Set(this.set);

			for(int i = 0; i < addedSet.set.Length; i++)
			{
				if (!combineSet.set.Any(x => x == addedSet.set[i]))
					combineSet.AddElement(addedSet.set[i]);
			}

			combineSet.set = Sort(combineSet.set);

			return combineSet;
		}

		public void Print()
		{
			Console.Write("Set: ");
			for(int i = 0; i < this.set.Length; i++)
			{
				Console.Write($"{this.set[i]}");
				if (i != this.set.Length - 1)
					Console.Write(", ");
			}
				
			Console.WriteLine();
		}

		public void AddElement(double element)
		{
			if(!this.IsSetElement(element))
			{
				Set changedSet = new Set(this.set.Length + 1);

				for(int i = 0; i < this.set.Length; i++)
				{
					changedSet.set[i] = this.set[i];
				}

				changedSet.set[this.set.Length] = element;

				this.set = Sort(changedSet.set);
			}
		}

		public void DeleteElement(double element)
		{
			if (this.IsSetElement(element))
			{
				Set changedSet = new Set(this.set.Length - 1);

				for (int i = 0, j = 0; i < this.set.Length; i++, j++)
				{
					if (this.set[i] == element)
					{
						j--;
					}
					else
						changedSet.set[j] = this.set[i];
				}

				this.set = changedSet.set;
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


		private bool IsSetElement(double element)
		{
			if (this.set.Any(x => x == element))
				return true;
			return false;
		}

		private double[] Sort(double[] set)
		{
			double temp;
			
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
