using System;
using System.Collections.Generic;
using System.Linq;

namespace lab3._2._5
{
    class Program
    {
        static void GenerateFileSystem(List<File> file, int[] freeSpace, int numFiles)
        {
            for (int i = 0; i < numFiles; i++)
            {
                File file1 = new File(i + 1, freeSpace);
                if (!file1.Empty)
                {
                    file.Add(file1);
                }
            }
        }

        static void DeleteFile(List<File> file, int[] freeSpace, string fileName)
        {
            for(int i = 0; i < file.Count; i++)
            {
                if(file[i].FN == fileName)
                {
                    int temp1 = Array.IndexOf(freeSpace, file[i].ID);
                    int temp2 = Array.IndexOf(freeSpace, file[i].ID) + file[i].FS;
                    file.RemoveAt(i);
                    for(int j = temp1; j < temp2; j++)
                    {
                        freeSpace[j] = 0;
                    }
                    i--;
                    Console.WriteLine("Файл удален!");
                    //break; //Если нужно удалять только один файл 
                }
            }
        }

        static void AddFile(List<File> file, int[] freeSpace)
        {
            int[] tempArr = freeSpace;
            IEnumerable<int> nums = tempArr.Distinct();
            tempArr = nums.ToArray();
            int j = 0;
            for(; j < tempArr.Length + 1; j++)
            {
                if (!tempArr.Contains(j))
                {
                    break;
                }
            }

            File file1 = new File(j, freeSpace);
            if (!file1.Empty)
            {
                file.Add(file1);
            }
        }

        static void Main(string[] args)
        {
            int[] FreeSpace = new int[1440];
            int NumFiles = 10;
            List<File> FileSystem = new List<File>();
            GenerateFileSystem(FileSystem, FreeSpace, NumFiles);
            for(int i = 0; i < FileSystem.Count; i++)
            {
                FileSystem[i].Print();
            }
            DeleteFile(FileSystem, FreeSpace, "da");

            AddFile(FileSystem, FreeSpace);

            for (int i = 0; i < FileSystem.Count; i++)
            {
                FileSystem[i].Print();
            }
        }
    }
}
