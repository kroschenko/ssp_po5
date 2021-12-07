using System;
using System.Collections.Generic;

namespace lab4._1._9
{
    class Program
    {
        static void Main(string[] args)
        {
            Mobile.Phone.Camera LowCamera = new Mobile.Phone.Camera(1, "no name");
            Mobile.Phone.Camera MediumCamera = new Mobile.Phone.Camera(32, "Optimus 3D");
            Mobile.Phone.Camera HighCamera = new Mobile.Phone.Camera(108, "808 PureView");


            Mobile.Phone IPhone8 = new Mobile.Phone("IPhone 8");
            Mobile.Phone Nokia3310 = new Mobile.Phone("Nokia 3310");
            Mobile.Phone OnePlus8Pro = new Mobile.Phone("OnePlus 8 Pro");

            IPhone8.AddCamera(MediumCamera);
            IPhone8.AddCamera(HighCamera);

            Nokia3310.AddCamera(LowCamera);

            OnePlus8Pro.AddCamera(HighCamera);
            OnePlus8Pro.AddCamera(HighCamera);
            OnePlus8Pro.AddCamera(MediumCamera);

            List<Mobile.Phone> Mobiles1 = new List<Mobile.Phone>();
            Mobiles1.Add(IPhone8);
            Mobiles1.Add(Nokia3310);
            Mobiles1.Add(OnePlus8Pro);

            Mobile mobiles = new Mobile(new string("Mobiles 1"));
            mobiles.SetPositions(Mobiles1);

            Console.WriteLine(mobiles.GetName() + ":");

            foreach (Mobile.Phone phone in mobiles.GetPositions())
            {
                Console.WriteLine("\t" + phone.GetName() + ":");

                foreach (Mobile.Phone.Camera camera in phone.GetCamera())
                {
                    Console.WriteLine("\t\t" + camera.GetName() + "\t" + camera.GetMegapixels() + " Megapixels");
                }
                Console.WriteLine();
            }
        }
    }
}