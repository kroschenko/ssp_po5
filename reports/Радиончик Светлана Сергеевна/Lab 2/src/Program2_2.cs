using System;
using System.IO;
using System.Threading.Tasks;

namespace Lab2_2
{
	class Program
	{
		public async Task Split(string[] args)
		{
			if(args[0].Equals("split"))
			{
				int numLines = 10;
				int numBytes = -1;
				string prefix = "x";
				string fileName = "";
				string postfixValue = "abcdefghijklmnopqrstuvwxyz";

				for(int i = 1; i < args.Length; i++)
				{
					if (args[i].Contains("-b") || args[i].Contains("--bytes"))
					{
						string size;
						int result = 0;

						if (args[i].Contains("-b"))
							size = args[i].Replace("-b=", "");
						else
							size = args[i].Replace("--bytes=", "");

						if (size.Contains("b"))
							int.TryParse(size.Replace("b", ""), out numBytes);
						else if (size.Contains("k"))
						{
							int.TryParse(size.Replace("k", ""), out result);
							numBytes = (int)Math.Pow(10, 3) * result;
						}
						else if (size.Contains("m"))
						{
							int.TryParse(size.Replace("m", ""), out result);
							numBytes = (int)Math.Pow(10, 6) * result;
						}
						else
							int.TryParse(size, out numBytes);
					}
					else if(args[i].Contains("-l") || args[i].Contains("--lines"))
					{
						if (args[i].Contains("-l"))
							int.TryParse(args[i].Replace("-l=", ""), out numLines);
						else
							int.TryParse(args[i].Replace("--lines=", ""), out numLines);
					}
					else if(args[i].Contains("-d") || args[i].Contains("--numericsuffixes"))
					{
						postfixValue = "0123456789";
					}
					else
					{
						if (args[i].Contains(".txt"))
							fileName = args[i];
						else
							prefix = args[i];
					}
				}

				string arr = "";

				if(string.IsNullOrEmpty(fileName))
				{
					fileName = "x.txt";

					string str = Console.ReadLine();
					while (!str.Contains("#"))
					{
						arr += str;
						arr += "\n";
						str = Console.ReadLine();
					}
				}
				
				try
				{
					if (arr.Length != 0)
					{
						var strArr = arr.Split("\n");

						using (StreamWriter sw = new StreamWriter(fileName, false, System.Text.Encoding.Default))
						{
							for (int i = 0; i < strArr.Length; i++)
							{
								await sw.WriteLineAsync(strArr[i]);
							}
						}
					}

					if (numBytes == -1)
					{
						string line = null;
						int numFiles = -1;

						using (StreamReader sr = new StreamReader(fileName))
						{
							while (!sr.EndOfStream)
							{
								numFiles++;

								string newFileName = setFileName(prefix, postfixValue, numFiles);
								bool isText = true;

								using (StreamWriter sw = new StreamWriter(newFileName, false, System.Text.Encoding.Default))
								{
									for (int i = 0; i < numLines; i++)
									{
										line = sr.ReadLine();
										sw.WriteLine(line);
									}
								}
							}
						}
					}
					else
					{
						int numFiles = -1;
						int offset = 0;
						bool isText = true;

						using (FileStream fread = File.OpenRead(fileName))
						{
							while (isText)
							{
								numFiles++;
								string newFileName = setFileName(prefix, postfixValue, numFiles);

								using (StreamWriter sw = new StreamWriter(newFileName, false, System.Text.Encoding.Default))
								{
									byte[] array = new byte[numBytes];
									fread.Read(array, offset, numBytes);
									string textFromFile = System.Text.Encoding.Default.GetString(array);

									if(textFromFile.StartsWith('\0'))
									{
										isText = false;
										break;
									}

									sw.Write(textFromFile);
								}
							}
						}
					}
					
				}
				catch (FileNotFoundException e)
				{
					Console.WriteLine(e.Message);
				}
				catch(IOException e)
				{
					Console.WriteLine(e.Message);
				}
			}
		}

		public string setFileName(string prefix, string postfixValue, int numFles)
		{
			string fileName = prefix;

			int i = numFles / postfixValue.Length;
			int j = numFles % postfixValue.Length;

			fileName += postfixValue[i];
			fileName += postfixValue[j];

			return fileName;
		}

		static void Main(string[] args)
		{
			Program lab = new Program();
			lab.Split(args);
		}
	}
}
