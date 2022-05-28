using System;
using System.Collections.Generic;

namespace lab6._3._9
{
    // Контекст определяет интерфейс, представляющий интерес для клиентов.
    class Context
    {
        // Контекст хранит ссылку на один из объектов Стратегии. Контекст не
        // знает конкретного класса стратегии. Он должен работать со всеми
        // стратегиями через интерфейс Стратегии.
        private IStrategy _strategy;

        public Context()
        { }

        // Обычно Контекст принимает стратегию через конструктор, а также
        // предоставляет сеттер для её изменения во время выполнения.
        public Context(IStrategy strategy)
        {
            this._strategy = strategy;
        }

        // Обычно Контекст позволяет заменить объект Стратегии во время
        // выполнения.
        public void SetStrategy(IStrategy strategy)
        {
            this._strategy = strategy;
        }

        // Вместо того, чтобы самостоятельно реализовывать множественные версии
        // алгоритма, Контекст делегирует некоторую работу объекту Стратегии.
        public void DoSomeBusinessLogic()
        {
            string str = "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...";
            //Console.WriteLine(str);
            var result = _strategy.DoAlgorithm(str);
            Console.WriteLine(result);
        }
    }

    // Интерфейс Стратегии объявляет операции, общие для всех поддерживаемых
    // версий некоторого алгоритма.
    //
    // Контекст использует этот интерфейс для вызова алгоритма, определённого
    // Конкретными Стратегиями.
    public interface IStrategy
    {
        object DoAlgorithm(object data);
    }

    // Конкретные Стратегии реализуют алгоритм, следуя базовому интерфейсу
    // Стратегии. Этот интерфейс делает их взаимозаменяемыми в Контексте.
    class VowelRemoval : IStrategy // удаление гласных
    {
        public object DoAlgorithm(object date)
        {
            string res = date.ToString();
            string[] temp = { "e", "y", "u", "i", "o", "a", "E", "Y", "U", "I", "O", "A", };
            for(int i = 0; i < temp.Length; i++)
            {
                res = res.Replace(temp[i], "");
            }
            return res;
        }
    }

    class Shift : IStrategy // Сдвиг
    {
        public object DoAlgorithm(object date)
        {
            string res = date.ToString();
            string[] alphabet = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };
            string[] ALPHABET = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };

            int shift = 10;
            
            for(int i = 0; i < alphabet.Length; i++)
            {
                int temp = i + shift;
                if(temp >= alphabet.Length)
                {
                    temp = temp - alphabet.Length;
                }
                res = res.Replace(alphabet[i], alphabet[temp]);
            }

            for (int i = 0; i < ALPHABET.Length; i++)
            {
                int temp = i + shift;
                if (temp >= ALPHABET.Length)
                {
                    temp = temp - ALPHABET.Length;
                }
                res = res.Replace(ALPHABET[i], ALPHABET[temp]);
            }

            return res;
        }
    }

    class reverseWithXOR : IStrategy // применение операции исключающее
    {
        public object DoAlgorithm(object date)
        {
            string temp = date.ToString();
            char[] array = temp.ToCharArray();
            int length = array.Length;
            double val = array.Length / 2;
            int half = (int)Math.Floor(val);
            for (int i = 0; i < half; i++)
            {
                array[i] ^= array[length - i - 1];
                array[length - i - 1] ^= array[i];
                array[i] ^= array[length - i - 1];
            }
            return new string(array);
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            // Клиентский код выбирает конкретную стратегию и передаёт её в
            // контекст. Клиент должен знать о различиях между стратегиями,
            // чтобы сделать правильный выбор.
            var context = new Context();

            Console.WriteLine("Client: Strategy is VowelRemoval");
            context.SetStrategy(new VowelRemoval());
            context.DoSomeBusinessLogic();
            
            Console.WriteLine();
            
            Console.WriteLine("Client: Strategy is Shift");
            context.SetStrategy(new Shift());
            context.DoSomeBusinessLogic();

            Console.WriteLine();

            Console.WriteLine("Client: Strategy is reverseWithXOR");
            context.SetStrategy(new reverseWithXOR());
            context.DoSomeBusinessLogic();
        }
    }
}
