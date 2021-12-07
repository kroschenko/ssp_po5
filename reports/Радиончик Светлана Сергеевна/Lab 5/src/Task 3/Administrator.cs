using System;
using System.Collections.Generic;
using System.Text;

namespace Lab5_3
{
	class Administrator : SystemUser
	{
		public List<Abonent> Abonents = new List<Abonent>();

		public void AddAbonent(Abonent abonent)
		{
			Abonents.Add(abonent);
		}

		public void ChangePhoneNumber(Abonent abonent, string number)
		{
			if (Abonents.Contains(abonent))
			{
				if (abonent.IsPhoneChangeRequest)
					abonent.Number = number;
				else
					Console.WriteLine("No such request");
			}
			else
				Console.WriteLine("Error. Undefined abonent");
		}

		public void ServiceRefusal(Abonent abonent)
		{
			if (Abonents.Contains(abonent))
			{
				if (abonent.IsServiceRefusalRequest)
				{
					foreach (var sercvice in abonent.Services.RefusalService)
					{
						if (sercvice == "MMS")
							abonent.Services.MMS = false;
						else if (sercvice == "SMS")
							abonent.Services.SMS = false;
						else if (sercvice == "Internet")
							abonent.Services.Internet = false;
						else
							Console.WriteLine("Error. Undefined service");

					}
				}
				else
					Console.WriteLine("No such request");
			}
			else
				Console.WriteLine("Error. Undefined abonent");
		}

		public void Block(Abonent abonent)
		{
			if (!abonent.Bill.IsPayed)
				abonent.IsBlocked = true;
		}
	}
}
