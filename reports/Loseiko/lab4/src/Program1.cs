using System;

namespace lab4._1._9
{
    class Program
    {
        static void Main(string[] args)
        {
            Mobile.IPhone phone1 = new Mobile.IPhone();
            phone1.Model = "IPhone 13";
            phone1.Properties = "SoC Apple A15 Bionic (6 процессорных ядер: 2 высокопроизводительных и 4 энергоэффективных, 4 графических ядра, 16 ядер Neural Engine). Сенсорный дисплей 6,1″, OLED, 2532×1170, 460 ppi, емкостной, мультитач / 5,4″, OLED, 2340×1080, 476 ppi, емкостной, мультитач. RAM(по информации Geekbench 5): 3,6 ГБ. Флэш - память 128 / 256 / 512 ГБ. Поддержка карт памяти отсутствует.Камеры: фронтальная(12 Мп, видео 4К 30 к / с, 720р 240 к / с) и тыльные модули 12 Мп(съемка видео 4К 60 к / с): широкоугольный и сверхширокоугольный";

            Mobile.IPhone phone2 = new Mobile.IPhone();

            phone1.Print();
            phone2.FindProperties("2 ядра");
        }
    }
}
