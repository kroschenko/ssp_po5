using System;
using System.Collections.Generic;
using System.Text;

namespace lab4._1._9
{
    class Mobile
    {
        public class IPhone
        {
            public string Model { get; set; }
            public string Properties { get; set; }

            public IPhone()
            {
                Model = "IPhone 6";
                Properties = "SoC Apple A8 @1,4 ГГц (2 ядра, 64-битная архитектура ARMv8-A). Сопроцессор движения Apple M8 (включает акселерометр, гироскоп и компас). GPU PowerVR GX6650 (предположительно). RAM 1 ГБ. Флэш - память 16 / 64 / 128 ГБ. Поддержка карт памяти microSD отсутствует. Операционная система iOS 8.0. Сенсорный дисплей IPS, 4,7″, 1334×750(326 ppi), емкостной, мультитач. Камеры 8 Мп с размером пикселя 1,5 мкм и диафрагмой ƒ/ 2,2(съемка видео Full HD 30 или 60 к / с) и 1,2 Мп с диафрагмой ƒ/ 2,2(съемка видео — 720р)";
            }

            public void Print()
            {
                Console.WriteLine($"\tМодель: {Model}\n\tСвойства: {Properties}\n________________________________________________________________________________________________________________________");
            }

            public void FindProperties(string mainWord)
            {
                if(Properties.Contains(mainWord))
                {
                    Print();
                }
            }
        }
    }
}
