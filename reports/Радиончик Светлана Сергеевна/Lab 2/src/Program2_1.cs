using System;
using System.IO;

namespace Lab2_1
{
	class Program
	{
		public void fileСomparison()
		{
			try
			{
				StreamReader sr1 = new StreamReader("D:\\spp\\file1.txt");
				var lineFile1 = sr1.ReadLine();

				StreamReader sr2 = new StreamReader("D:\\spp\\file2.txt");
				var lineFile2 = sr2.ReadLine();

				bool filesEquals = true;

				while (lineFile1 != null || lineFile2 != null)
				{
					bool nullLineEquals;

					if (lineFile1 != null)
						nullLineEquals = lineFile1.Equals(lineFile2);
					else
						nullLineEquals = lineFile2.Equals(lineFile1);

					if (!nullLineEquals)
					{
						filesEquals = false;
						Console.WriteLine("Раздичающиеся строки: ");
						Console.WriteLine($"{lineFile1}");
						Console.WriteLine($"{lineFile2}");
						int N = 0;
							
						if (lineFile1 != null && lineFile2 != null)
						{
							if (lineFile1.ToCharArray().Length > lineFile2.ToCharArray().Length)
								N = lineFile1.ToCharArray().Length;
							else
								N = lineFile2.ToCharArray().Length;
						}
						else if (lineFile1 != null)
							N = lineFile1.ToCharArray().Length;
						else
							N = lineFile2.ToCharArray().Length;

						for (int i = 0; i < N; i++)
						{
							if (lineFile1 != null && lineFile2 != null)
							{
								if (i >= lineFile1.ToCharArray().Length || i >= lineFile2.ToCharArray().Length)
								{
									Console.WriteLine($"Позиция различающегося символа в строке: {++i}");
									break;
								}
								else if (lineFile1.ToCharArray()[i] != lineFile2.ToCharArray()[i])
								{
									Console.WriteLine($"Позиция различающегося символа в строке: {++i}");
									break;
								}
							}
							else
							{
								Console.WriteLine($"Позиция различающегося символа в строке: {i}");
								break;
							}
						}
					} 

					lineFile1 = sr1.ReadLine();
					lineFile2 = sr2.ReadLine();
				}

				sr1.Close();
				sr2.Close();
				if (filesEquals)
					Console.WriteLine("Файлы идентичны");
			}
			catch (Exception e)
			{
				Console.WriteLine("Exception: " + e.Message);
			}
		}

		static void Main(string[] args)
		{
			Program lab = new Program();
			lab.fileСomparison();
		}
	}
}
