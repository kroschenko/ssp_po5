using System;
using System.Collections.Generic;
using System.Linq;

namespace lab3._1._9
{
    class Set
    {
        private List<double> list = new List<double>();
        public List<double> _List
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

        public void Crossing(Set lst1, Set lst2)
        {
            List<double> res = lst1._List.ToList().Intersect(lst2._List.ToList()).ToList();
            _List.AddRange(res);
            _List.Sort();
        }

        public bool FindElement(double element)
        {
            return _List.Exists(x => x == element);
        }

        public void AddElement(double element, int position)
        {
            if (!FindElement(element))
            {
                position--;
                _List.Insert(position, element);
            }
            else
            {
                Console.WriteLine("Такой элемент уже существует!");
            }
        }

        public void DeleteElement(double element)
        {
            int index = _List.FindIndex(x => x == element);
            _List.RemoveAt(index);
        }

        public override bool Equals(object obj)
        {
            if (obj == null)
                return false;
            Set set = obj as Set; // возвращает null если объект нельзя привести к типу Set
            if ((set as Set) == null)
                return false;

            return set._List == _List;
        }

        public override string ToString()
        {
            string str = "";
            if (_List == null)
                return base.ToString();
            else
            {
                for(int i = 0; i < _List.Count; i++)
                {
                    str += _List[i] + "  ";
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
            double[] arr = new double[Size];
            for (int i = 0; i < Size; i++)
            {
                arr[i] = Math.Round(temp.NextDouble() * 20, 1);
            }

            double[] tempArr = arr.Distinct().ToArray();

            for (int i = 0; i < tempArr.Count(); i++)
            {
                _List.Add(tempArr[i]);
            }
        }

        public Set(double[] arr)
        {
            double[] tempArr = arr.Distinct().ToArray();

            for (int i = 0; i < tempArr.Length; i++)
            {
                list.Add(tempArr[i]);
            }
        }
    }
}
