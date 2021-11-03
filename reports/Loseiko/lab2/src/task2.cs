using System;
using System.IO;
using System.Diagnostics;
using System.Linq;

namespace lab2_task2
{
    class lab2_task2
    {
        static string Result(string[] str1, string[] str2, int first, int second, int numlex)
        {
            string Res = "";
            int k = 0;
            int n = 1;
            int nn = 0;
            first--;
            second--;

            for (int i = first; i < str1.Length; i += numlex)
            {
                for (int j = second; j < str2.Length; j += numlex)
                {
                    if (str1[i] == str2[j])
                    {
                        Res += str1[i] + ' ';
                        for (; k < numlex * n; k++)
                        {
                            if (k != first + numlex*nn)
                            {
                                Res += str1[k] + ' ';
                            }
                            if (k != second + numlex*nn)
                            {
                                Res += str2[k] + ' ';
                            }
                        }
                        Res += "\n";
                    }
                    n++;
                    nn++;
                }
                n = 1;
                nn = 0;
            }

            return Res;
        }

        static string ReadFile(string path)
        {
            // чтение из файла
            FileStream fstream = File.OpenRead(path);

            // преобразуем строку в байты
            byte[] ArrFile = new byte[fstream.Length];

            // считываем данные
            fstream.Read(ArrFile, 0, ArrFile.Length);

            // декодируем байты в строку
            string fileText = System.Text.Encoding.Default.GetString(ArrFile);

            return fileText;
        }
        static void Main(string[] args)
        {
            string path1, path2;                                    // Пути к файлам
            string strRes;                                          // Результат выполнения программы
            string writePath;                                       // Путь к файлу для записи
            string file1Text, file2Text;                            // Декодированная строка байтов
            string firstLine;                                       // Первая строка из файла, нужна чтобы посчитать кол-во лексем
            string str = "";                                        // Строка с командой

            for (int j = 0; j < args.Length; j++)
            {
                str += args[j];
            }

            char[] separators = new char[] { ' ', '\r', '\n' };     // Разделители
            string[] strFile1, strFile2;                            // Массив лексем строки
            string[] subs = str.Split(separators, StringSplitOptions.RemoveEmptyEntries);
            string[] tempStr;                                       // Массив строк для подсчёта кол-ва лексем в строке

            int firstLexeme, secondLexeme;                          // По какой лексеме сравнивать
            int numLex;                                             // Кол-во лексем в строке

            if (subs.Length == 3 || subs.Length == 4)
            {
                if (subs[0] != "join")
                {
                    Console.WriteLine("Ошибка!");
                    Console.ReadLine();
                    Process.GetCurrentProcess().Kill();
                }

                if (subs[1] == "-" && subs[2] == "-")
                {
                    Console.WriteLine("Ошибка!");
                    Console.ReadLine();
                    Process.GetCurrentProcess().Kill();
                }

                if (subs[1] == "-")
                {
                    string[] strText2 = new string[3];
                    string temp2 = "";
                    for (int i = 0; i < 3; i++)
                    {
                        temp2 += Console.ReadLine() + " ";
                    }

                    string[] str2Text = temp2.Split(separators, StringSplitOptions.RemoveEmptyEntries);

                    path2 = $@"D:\repos\spp\lab2_task2\{subs[2]}";

                    firstLine = File.ReadLines(path2).Skip(0).First();
                    tempStr = firstLine.Split(separators, StringSplitOptions.RemoveEmptyEntries);
                    numLex = tempStr.Length;

                    if (!File.Exists(path2))
                    {
                        Console.WriteLine("Ошибка!");
                        Console.ReadLine();
                        Process.GetCurrentProcess().Kill();
                    }

                    file2Text = ReadFile(path2);

                    strFile2 = file2Text.Split(separators, StringSplitOptions.RemoveEmptyEntries);

                    strRes = Result(str2Text, strFile2, 1, 1, numLex);

                    if (subs.Length == 4)
                    {
                        writePath = $@"D:\repos\spp\lab2_task2\{subs[3]}";

                        try
                        {
                            using StreamWriter swrite = new StreamWriter(writePath, false, System.Text.Encoding.Default);
                            swrite.WriteLine(strRes);
                        }
                        catch (Exception e)
                        {
                            Console.WriteLine(e.Message);
                        }
                    }
                    else
                    {
                        Console.WriteLine(strRes);
                        Console.ReadLine();
                    }
                }
                else if (subs[2] == "-")
                {
                    string temp1 = "";
                    for (int i = 0; i < 3; i++)
                    {
                        temp1 += Console.ReadLine() + " ";
                    }

                    string[] str1Text = temp1.Split(separators, StringSplitOptions.RemoveEmptyEntries);

                    path1 = $@"D:\repos\spp\lab2_task2\{subs[1]}";

                    firstLine = File.ReadLines(path1).Skip(0).First();
                    tempStr = firstLine.Split(separators, StringSplitOptions.RemoveEmptyEntries);
                    numLex = tempStr.Length;

                    if (!File.Exists(path1))
                    {
                        Console.WriteLine("Ошибка!");
                        Console.ReadLine();
                        Process.GetCurrentProcess().Kill();
                    }

                    file1Text = ReadFile(path1);

                    strFile1 = file1Text.Split(separators, StringSplitOptions.RemoveEmptyEntries);

                    strRes = Result(strFile1, str1Text, 1, 1, numLex);

                    if (subs.Length == 4)
                    {
                        writePath = $@"D:\repos\spp\lab2_task2\{subs[3]}";

                        try
                        {
                            using StreamWriter swrite = new StreamWriter(writePath, false, System.Text.Encoding.Default);
                            swrite.WriteLine(strRes);
                        }
                        catch (Exception e)
                        {
                            Console.WriteLine(e.Message);
                        }
                    }
                    else
                    {
                        Console.WriteLine(strRes);
                        Console.ReadLine();
                    }
                }
                else
                {
                    path1 = $@"D:\repos\spp\lab2_task2\{subs[1]}";
                    path2 = $@"D:\repos\spp\lab2_task2\{subs[2]}";

                    if (!File.Exists(path1) || !File.Exists(path2))
                    {
                        Console.WriteLine("Ошибка!");
                        Console.ReadLine();
                        Process.GetCurrentProcess().Kill();
                    }

                    firstLine = File.ReadLines(path1).Skip(0).First();
                    tempStr = firstLine.Split(separators, StringSplitOptions.RemoveEmptyEntries);
                    numLex = tempStr.Length;

                    file1Text = ReadFile(path1);
                    file2Text = ReadFile(path2);

                    strFile1 = file1Text.Split(separators, StringSplitOptions.RemoveEmptyEntries);
                    strFile2 = file2Text.Split(separators, StringSplitOptions.RemoveEmptyEntries);

                    strRes = Result(strFile1, strFile2, 1, 1, numLex);

                    if (subs.Length == 4)
                    {
                        writePath = $@"D:\repos\spp\lab2_task2\{subs[3]}";

                        try
                        {
                            using StreamWriter swrite = new StreamWriter(writePath, false, System.Text.Encoding.Default);
                            swrite.WriteLine(strRes);
                        }
                        catch (Exception e)
                        {
                            Console.WriteLine(e.Message);
                        }
                    }
                    else
                    {
                        Console.WriteLine(strRes);
                        Console.ReadLine();
                    }
                }
            }
            else if (subs.Length == 7 || subs.Length == 8)
            {
                if (subs[0] != "join")
                {
                    Console.WriteLine("Ошибка!");
                    Console.ReadLine();
                    Process.GetCurrentProcess().Kill();
                }

                if (subs[1] != "-1" || subs[3] != "-2")
                {
                    Console.WriteLine("Ошибка!");
                    Console.ReadLine();
                    Process.GetCurrentProcess().Kill();
                }

                if(!int.TryParse(subs[2], out firstLexeme))
                {
                    Console.WriteLine("Ошибка!");
                    Console.ReadLine();
                    Process.GetCurrentProcess().Kill();
                }
                if (!int.TryParse(subs[4], out secondLexeme))
                {
                    Console.WriteLine("Ошибка!");
                    Console.ReadLine();
                    Process.GetCurrentProcess().Kill();
                }

                if (subs[5] == "-" && subs[6] == "-")
                {
                    Console.WriteLine("Ошибка!");
                    Process.GetCurrentProcess().Kill();
                }

                if (subs[5] == "-")
                {
                    string[] strText2 = new string[3];
                    string temp2 = "";
                    for (int i = 0; i < 3; i++)
                    {
                        temp2 += Console.ReadLine() + " ";
                    }

                    string[] str2Text = temp2.Split(separators, StringSplitOptions.RemoveEmptyEntries);

                    path2 = $@"D:\repos\spp\lab2_task2\{subs[6]}";
                    if (!File.Exists(path2))
                    {
                        Console.WriteLine("Ошибка!");
                        Console.ReadLine();
                        Process.GetCurrentProcess().Kill();
                    }

                    firstLine = File.ReadLines(path2).Skip(0).First();
                    tempStr = firstLine.Split(separators, StringSplitOptions.RemoveEmptyEntries);
                    numLex = tempStr.Length;

                    file2Text = ReadFile(path2);

                    strFile2 = file2Text.Split(separators, StringSplitOptions.RemoveEmptyEntries);

                    strRes = Result(str2Text, strFile2, firstLexeme, secondLexeme, numLex);

                    if (subs.Length == 8)
                    {
                        writePath = $@"D:\repos\spp\lab2_task2\{subs[7]}";

                        try
                        {
                            using StreamWriter swrite = new StreamWriter(writePath, false, System.Text.Encoding.Default);
                            swrite.WriteLine(strRes);
                        }
                        catch (Exception e)
                        {
                            Console.WriteLine(e.Message);
                        }
                    }
                    else
                    {
                        Console.WriteLine(strRes);
                        Console.ReadLine();
                    }
                }
                else if (subs[6] == "-")
                {
                    string temp1 = "";
                    for (int i = 0; i < 3; i++)
                    {
                        temp1 += Console.ReadLine() + " ";
                    }

                    string[] str1Text = temp1.Split(separators, StringSplitOptions.RemoveEmptyEntries);

                    path1 = $@"D:\repos\spp\lab2_task2\{subs[5]}";
                    if (!File.Exists(path1))
                    {
                        Console.WriteLine("Ошибка!");
                        Console.ReadLine();
                        Process.GetCurrentProcess().Kill();
                    }

                    firstLine = File.ReadLines(path1).Skip(0).First();
                    tempStr = firstLine.Split(separators, StringSplitOptions.RemoveEmptyEntries);
                    numLex = tempStr.Length;

                    file1Text = ReadFile(path1);

                    strFile1 = file1Text.Split(separators, StringSplitOptions.RemoveEmptyEntries);

                    strRes = Result(strFile1, str1Text, firstLexeme, secondLexeme, numLex);

                    if (subs.Length == 8)
                    {
                        writePath = $@"D:\repos\spp\lab2_task2\{subs[7]}";

                        try
                        {
                            using StreamWriter swrite = new StreamWriter(writePath, false, System.Text.Encoding.Default);
                            swrite.WriteLine(strRes);
                        }
                        catch (Exception e)
                        {
                            Console.WriteLine(e.Message);
                        }
                    }
                    else
                    {
                        Console.WriteLine(strRes);
                        Console.ReadLine();
                    }
                }
                else
                {
                    path1 = $@"D:\repos\spp\lab2_task2\{subs[5]}";
                    path2 = $@"D:\repos\spp\lab2_task2\{subs[6]}";

                    if (!File.Exists(path1) || !File.Exists(path2))
                    {
                        Console.WriteLine("Ошибка!");
                        Console.ReadLine();
                        Process.GetCurrentProcess().Kill();
                    }

                    firstLine = File.ReadLines(path1).Skip(0).First();
                    tempStr = firstLine.Split(separators, StringSplitOptions.RemoveEmptyEntries);
                    numLex = tempStr.Length;

                    file1Text = ReadFile(path1);
                    file2Text = ReadFile(path2);

                    strFile1 = file1Text.Split(separators, StringSplitOptions.RemoveEmptyEntries);
                    strFile2 = file2Text.Split(separators, StringSplitOptions.RemoveEmptyEntries);

                    strRes = Result(strFile1, strFile2, firstLexeme, secondLexeme, numLex);

                    if (subs.Length == 8)
                    {
                        writePath = $@"D:\repos\spp\lab2_task2\{subs[7]}";

                        try
                        {
                            using StreamWriter swrite = new StreamWriter(writePath, false, System.Text.Encoding.Default);
                            swrite.WriteLine(strRes);
                        }
                        catch (Exception e)
                        {
                            Console.WriteLine(e.Message);
                        }
                    }
                    else
                    {
                        Console.WriteLine(strRes);
                        Console.ReadLine();
                    }
                }
            }
            else
            {
                Console.WriteLine("Ошибка!");
                Process.GetCurrentProcess().Kill();
            }
        }
    }
}