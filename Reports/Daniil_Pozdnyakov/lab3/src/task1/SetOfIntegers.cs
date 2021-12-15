using System;
using System.Linq;

namespace lab3._1._5
{
    class SetOfIntegers
    {
        private static int N = 10;
        int[] Set = new int[N];

        public int[] GetSet()
        {
            return Set;
        }
        public void SetSet(int[] set)
        {
            Set = set;
        }

        public override bool Equals(object obj)
        {
            if (obj == null)
                return false;
            SetOfIntegers set = obj as SetOfIntegers; // возвращает null если объект нельзя привести к типу Set
            if ((set as SetOfIntegers) == null)
                return false;

            return set.Set == Set;
        }

        public override string ToString()
        {
            string str = "";
            if (Set == null)
                return base.ToString();
            else
            {
                for (int i = 0; i < Set.Length; i++)
                {
                    str += Set[i] + "  ";
                }
            }
            return str;
        }

        public SetOfIntegers()
        {

        }

        public SetOfIntegers(int[] arr)
        {
            if (arr.Length != 10)
            {
                Console.WriteLine("Неверный размер массива!");
            }

            var nums = arr.Distinct();
            arr = nums.ToArray();
            while(arr.Length < 10)
            {
                Random rand = new Random();
                int[] temp = new int[10];
                for(int i = 0; i < arr.Length; i++)
                {
                    temp[i] = arr[i];
                }
                temp[9] = rand.Next(0, 100);
                nums = temp.Distinct();
                arr = nums.ToArray();
            }

            for (int i = 0; i < N; i++)
            {
                Set[i] = arr[i];
            }
        }

        public void Print()
        {
            for (int i = 0; i < this.Set.Length; i++)
            {
                Console.Write($"{this.Set[i]} ");
            }
            Console.WriteLine();
        }

        public int[] UnionOfSets(SetOfIntegers set1, SetOfIntegers set2)
        {
            int[] Res = new int[set1.GetSet().Length + set2.GetSet().Length];
            for (int i = 0; i < set1.GetSet().Length; i++)
            {
                Res[i] = set1.GetSet()[i];
            }
            for (int i = set1.GetSet().Length, j = 0; i < Res.Length; i++, j++)
            {
                Res[i] = set2.GetSet()[j];
            }
            var temp = Res.Distinct();
            Res = temp.ToArray();
            SetSet(Res);
            return Res;
        }

        public void BelongsToTheSet(int element)
        {
            for (int i = 0; i < GetSet().Length; i++)
            {
                if (GetSet()[i] == element)
                {
                    Console.WriteLine($"{element} принадлежит множеству");
                    return;
                }
            }
            Console.WriteLine($"{element} не принадлежит множеству");
        }

        public void DeleteElementOfSet(int NumElement)
        {
            NumElement--;
            if (NumElement > GetSet().Length || NumElement < 1)
            {
                Console.WriteLine("Ошибка! Введено слишком большое или слишком маленькое значение!");
                return;
            }

            int[] Res = new int[GetSet().Length - 1];

            for (int i = 0, j = 0; i < GetSet().Length; i++)
            {
                if (i != NumElement)
                {
                    Res[j] = GetSet()[i];
                    j++;
                }
            }

            SetSet(Res);
        }

        public void AddElementOfSet(int NumElement)
        {
            int[] Temp = new int[GetSet().Length];
            for(int i = 0; i < Temp.Length; i++)
            {
                Temp[i] = GetSet()[i];
            }
            if(Array.IndexOf(Temp, NumElement) != -1)
            {
                Console.WriteLine("Такой элемент уже есть");
                return;
            }

            int[] Res = new int[GetSet().Length + 1];

            for (int i = 0; i < GetSet().Length; i++)
            {
                Res[i] = GetSet()[i];
            }
            Res[Res.Length - 1] = NumElement;

            SetSet(Res);
        }
    }
}