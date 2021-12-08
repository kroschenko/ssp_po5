using System;

namespace lab3._2._5
{
    class File
    {
        public static int FileSystemSize = 1440;

        private int FileSize;
        private string FileExtension;
        private string FileName;

        public int ID;
        public int NumOfFiles;
        public bool Empty;

        public int FS
        {
            get
            {
                return FileSize;
            }
            set
            {
                FileSize = value;
            }
        }

        public string FE
        {
            get
            {
                return FileExtension;
            }
            set
            {
                FileExtension = value;
            }
        }

        public string FN
        {
            get
            {
                return FileName;
            }
            set
            {
                FileName = value;
            }
        }

        static string randomString(int lenght)
        {
            Random rand = new Random();
            Console.OutputEncoding = System.Text.Encoding.UTF8;

            string a = "";
            
            for (int i = 0; i < lenght; i++)
            {
                a += (char)rand.Next(0x0061, 0x007A);
            }
            return a;
        }

        public void Print()
        {
            Console.WriteLine("Название файла: {0}\t Расширение: {1}\t Размер: {2}", FN, FE, FS);
        }

        public void CheckFreeSpace()
        {
            for(int i = 0; i < FileSystemSize; i++)
            {

            }
        }

        public void FillingFreeSpace(int[] FreeSpace)
        {
            if (ID == 1)
            {
                for (int i = 0; i < FS; i++)
                {
                    FreeSpace[i] = ID;
                }
            }
            else
            {
                int index = Array.IndexOf(FreeSpace, 0);
                int total = 0;
                for (int i = index; i < FreeSpace.Length - 1; i++)
                {
                    if (FreeSpace[i] == 0)
                    {
                        total++;
                        if (total == FS)
                        {
                            for (int j = index; j < FS + index; j++)
                            {
                                FreeSpace[j] = ID;
                            }
                            break;
                        }
                    }
                    else
                    {
                        total = 0;
                        index = Array.IndexOf(FreeSpace, 0, i);
                    }
                }
                if (total < FS)
                {
                    Console.WriteLine("Не хватает места для файла!");
                    Empty = true;
                }
                else Empty = false;
            }
        }

        public File(int id, int[] FreeSpace)
        {
            Random temp = new Random();
            string[] fe = new string[] { ".txt", ".rar", ".bat", ".dox", ".exe" };
            string[] fn = new string[] { "tre", "da", "net", "ladno" };
            ID = id;
            FS = temp.Next(150, 250);
            FE = fe[temp.Next(0, 5)];
            FN = fn[temp.Next(0, 4)];//randomString(temp.Next(3, 8));

            FillingFreeSpace(FreeSpace);
        }
    }
}   