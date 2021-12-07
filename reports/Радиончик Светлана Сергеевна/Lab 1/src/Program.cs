using System;
using System.Linq;

namespace Lab1
{
	class Program
	{
		static void Task1 (string[] args)
		{
			int[] arr = new int[args.Length];

			for (int i = 0; i < args.Length; i++)
			{
				int.TryParse(args[i], out arr[i]);
			}

			OutputNumbers(arr);
		}

		static void OutputNumbers(int[] arr)
		{
			Random rand = new Random();

			arr = arr.OrderBy(x => rand.Next()).ToArray();

			Console.WriteLine(string.Join(" ", arr));
		}
		
		/// ___________________________________________________________________
		
		static void Task2 (string[] args)
		{
			int rowsCount, columnsCount;
			int.TryParse(args[0], out rowsCount);
			int.TryParse(args[1], out columnsCount);

			double[,] arr = new double[rowsCount, columnsCount];
			int k = 2;

			for (int i = 0; i < rowsCount; i++)
			{
				for (int j = 0; j < columnsCount; j++)
				{
					double.TryParse(args[k], out arr[i, j]);
					k++;
				}
			}

			PrintMatrix(rowsCount, columnsCount, arr);

			double[,] transposedMatrix;
			transposedMatrix = Transpose(arr);

			PrintMatrix(columnsCount, rowsCount, transposedMatrix);
		}

		static double[,] Transpose(double[,] matrix)
		{
			int columnsCount = matrix.GetLength(1);
			int rowsCount = matrix.GetLength(0);

			double[,] transposedMatrix = new double[columnsCount, rowsCount];

			for (int i = 0; i < rowsCount; i++)
			{
				for (int j = 0; j < columnsCount; j++)
				{
					transposedMatrix[j, i] = matrix[i, j];
				}
			}

			return transposedMatrix;
		}
		
		static void PrintMatrix (int rowsCount, int columnsCount, double[,] arr)
		{
			for (int i = 0; i < rowsCount; i++)
			{
				for (int j = 0; j < columnsCount; j++)
				{
					Console.Write($"{arr[i,j]} ");
				}
				Console.Write("\n");
			}

			Console.Write("\n");
		}

		/// ___________________________________________________________________

		static void Task3(string[] args)
		{
			string str = "";

			foreach (string item in args)
			{
				str += $"{item} ";
			}
			str = str.Remove(str.Length-1);
			
			Console.WriteLine( Abbreviate(str));
		}

		static string Abbreviate(string str)
		{
			string helpStr = "";
			string[] strArr = str.Split(" ");
			str = "";

			foreach(string item in strArr)
			{
				helpStr = item.ToUpper();
				str += String.Join("", helpStr[0]);
			}

			return str;
		}

		static void Main(string[] args)
		{
			//Task1(args);
			Task2(args);
			//Task3(args);
		}
	}
}
