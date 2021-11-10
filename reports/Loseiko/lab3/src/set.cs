using System;
using System.Collections.Generic;
using System.Linq;

namespace lab3._1._9
{
    class Set
    {
        private List<double> list = new List<double>();
        public List<double> List
        {
            get 
            { 
                return list; 
            }
            set 
            { 
                list = value; 
            }
        }
        public void Print()
        {
            for(int i = 0; i < list.Count; i++)
            {
                Console.Write($"{list[i]}  ");
            }
            Console.WriteLine();
        }

        public void Crossing(List<double> lst1, List<double> lst2)
        {
            List<double> res = lst1.Union(lst2).ToList();
            List.AddRange(res);
            List.Sort();
        }

        public void FindElement(double element)
        {
            if(List.Exists(x => x == element))
            {
                Console.WriteLine("Элемент {0} найден", element);
            }
            else
                Console.WriteLine("Элемент {0} не найден", element);
        }

        public void AddElement(double element, int position)
        {
            position--;
            List.Insert(position, element);
        }

        public void DeleteElement(int position)
        {
            position--;
            List.RemoveAt(position);
        }

        public override bool Equals(object obj)
        {
            if (obj == null)
                return false;
            Set set = obj as Set; // возвращает null если объект нельзя привести к типу Set
            if ((set as Set) == null)
                return false;

            return set.List == List;
        }

        public override string ToString()
        {
            string str = "";
            if (List == null)
                return base.ToString();
            else
            {
                for(int i = 0; i < List.Count; i++)
                {
                    str += List[i] + "  ";
                }
            }
            return str;
        }

        public Set()
        {
            
        }

        public Set(int Size)
        {
            Random temp = new Random();
            for (int i = 0; i < Size; i++)
            {
                list.Add(temp.NextDouble() * 20);
            }
        }

        public Set(int Size, double[] arr)
        {
            for (int i = 0; i < Size; i++)
            {
                list.Add(arr[i]);
            }
        }
    }
}
