using System;
using System.IO;
using System.Diagnostics;

namespace lab2._2
{
    class Program
    {
        static void Main(string[] args)
        {
            string str = "";
            for (int j = 0; j < args.Length; j++)
            {
                str += args[j];
            }
            char[] separators = new char[] { ' ' };
            string[] subs = str.Split(separators, StringSplitOptions.RemoveEmptyEntries);

            if (subs.Length != 4)
            {
                Console.WriteLine("Неверный формат ввода!1");
                Process.GetCurrentProcess().Kill();
            }
            if (subs[0] != "cp")
            {
                Console.WriteLine("Неверный формат ввода!2");
                Process.GetCurrentProcess().Kill();
            }

            char[] temp = subs[1].ToCharArray();

            if (temp[0] != '-')
            {
                Console.WriteLine("Неверный формат ввода!3");
                Process.GetCurrentProcess().Kill();
            }
            if (temp.Length > 4)
            {
                Console.WriteLine("Неверный формат ввода!4");
                Process.GetCurrentProcess().Kill();
            }

            int f = 0, i = 0, n = 0;
            bool[] fin = new bool[] { false, false, false };
            foreach (var A in temp)
            {
                switch (A)
                {
                    case 'f':
                        f++;
                        if (f > 1)
                        {

                            Console.WriteLine("Неверный формат ввода!5");
                            Process.GetCurrentProcess().Kill();
                        }
                        fin[0] = true;
                        if (fin[2] == true)
                        {
                            fin[1] = false;
                        }
                        break;
                    case 'i':
                        i++;
                        if (i > 1)
                        {
                            Console.WriteLine("Неверный формат ввода!6");
                            Process.GetCurrentProcess().Kill();
                        }
                        fin[1] = true;
                        if (fin[2] == true)
                        {
                            fin[1] = false;
                        }
                        break;
                    case 'n':
                        n++;
                        if (n > 1)
                        {
                            Console.WriteLine("Неверный формат ввода!7");
                            Process.GetCurrentProcess().Kill();
                        }
                        fin[2] = true;
                        if (fin[2] == true)
                        {
                            fin[1] = false;
                        }
                        break;
                }
            }

            if (fin[0] == true && fin[2] == true)
            {
                //Console.WriteLine("fn");

                FileStream file = File.OpenWrite(subs[3]);
                FileInfo iFile = new FileInfo(subs[3]);

                if (file == null)
                {
                    file.Close();
                    iFile.Delete();
                    System.IO.File.Create(subs[3]);
                }
                file.Close();
                
                CopyWithoutRewriting(subs);

                Process.GetCurrentProcess().Kill();
            }

            if (fin[0] == true && fin[1] == true)
            {
                //Console.WriteLine("fi");

                FileStream file = File.OpenWrite(subs[3]);
                FileInfo iFile = new FileInfo(subs[3]);

                if (file == null)
                {
                    file.Close();
                    iFile.Delete();
                    System.IO.File.Create(subs[3]);
                }
                file.Close();

                Console.WriteLine("Перезаписать целевой файл? (y/n):");
                string YorN = Console.ReadLine();

                if (YorN == "y" || YorN == "Y" || YorN == "yes" || YorN == "Yes")
                {
                    Copy(subs);
                }
                else
                {
                    CopyWithoutRewriting(subs);
                }

                Process.GetCurrentProcess().Kill();
            }

            if (fin[2] == true)
            {
                //Console.WriteLine("n");

                CopyWithoutRewriting(subs);

                Process.GetCurrentProcess().Kill();
            }

            if (fin[1] == true)
            {
                //Console.WriteLine("i");
                Console.WriteLine("Перезаписать целевой файл? (y/n):");
                string YorN = Console.ReadLine();

                if(YorN == "y" || YorN == "Y" || YorN == "yes" || YorN == "Yes")
                {
                    Copy(subs);
                }
                else
                {
                    CopyWithoutRewriting(subs);
                }

                Process.GetCurrentProcess().Kill();
            }

            if (fin[0] == true)
            {
                //Console.WriteLine("f");

                FileStream file = File.OpenWrite(subs[3]);
                FileInfo iFile = new FileInfo(subs[3]);

                if (file == null)
                {
                    file.Close();
                    iFile.Delete();
                    System.IO.File.Create(subs[3]);
                }
                file.Close();

                Copy(subs);

                Process.GetCurrentProcess().Kill();
            }
        }
        static void Copy(string[] subs)
        {
            FileStream fstream = File.OpenRead(subs[2]);
            byte[] array = new byte[fstream.Length];
            fstream.Read(array, 0, array.Length);
            using (FileStream fstream1 = new FileStream(subs[3], FileMode.OpenOrCreate))
                fstream1.Write(array, 0, array.Length);
        }
        static void CopyWithoutRewriting(string[] subs)
        {
            FileStream fstream = File.OpenRead(subs[2]);
            byte[] array = new byte[fstream.Length];
            fstream.Read(array, 0, array.Length);
            using (FileStream fstream1 = new FileStream(subs[3], FileMode.Append))
                fstream1.Write(array, 0, array.Length);
        }
    }
}