using System;

namespace lab1
{
    class lab1
    {
        static long[] RemoveElement(long[] array, long element)
        {
            int a = 0;
            for (int i = 0; i < array.Length; i++)
            {
                if (array[i] == element)
                {
                    a++;
                }
            }
            long[] res = new long[array.Length - a];
            Console.WriteLine("Исходный массив:");

            for (int i = 0, j = 0; i < array.Length; i++)
            {
                Console.Write($"{array[i]} ");
                if (array[i] != element)
                {
                    res[j] = array[i];
                    j++;
                }
            }
            return res;
        }

        static string randomString(int lenght, bool asciiOnly)
        {
            Random rand = new Random();
            Console.OutputEncoding = System.Text.Encoding.UTF8;

            string a = "";
            if (asciiOnly)
            {
                for (int i = 0; i < lenght; i++)
                {
                    a += (char)rand.Next(0x0020, 0x007E);
                }
            }
            else
            {
                for (int i = 0; i < lenght; i++)
                {
                    a += (char)rand.Next(0x0020, 0x0400);

                }
            }
            return a;
        }

        static void Main(string[] args)
        {
            Random rand = new Random();
            int N = Convert.ToInt32(args[0]);
            int[] nums = new int[N];
            for (int i = 0; i < N; i++)
            {
                nums[i] = rand.Next(-10, 11);
                Console.WriteLine($"{i+1}) {nums[i]}");
            }
            for (int i = 0; i < nums.Length; i++)
            {
                for (int j = i + 1; j < nums.Length; j++) 
                {
                    if (nums[i] > nums[j])
                    {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                    }
                }
            }
            Console.WriteLine($"Размах последовательности: {nums[N-1]-nums[0]}\n");
            Console.WriteLine("Задание 2:");

            long[] res;
            long[] arr = new long[] { 1, 3, 5, 7, 9, 5, 5 };
            res = RemoveElement(arr, 5);

            for (int i = 0; i < res.Length; i++)
            {
                Console.Write($"\n{i + 1}) {res[i]}");
            }

            Console.WriteLine("\n\nЗадание 3:");
            Console.WriteLine(randomString(30, true));
            Console.WriteLine(randomString(15, false));
        }
    }
}