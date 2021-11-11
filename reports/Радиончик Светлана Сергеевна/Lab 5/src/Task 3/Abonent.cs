using System;
using System.Collections.Generic;
using System.Text;

namespace Lab5_3
{
	class Abonent : SystemUser
	{
		public string Number { get; set; }
		public bool IsBlocked { get; set; }
		public Service Services = new Service();
		public bool IsPhoneChangeRequest { get; set; }
		public Bill Bill = new Bill();
		public bool IsServiceRefusalRequest { get; set; }

		public Abonent(string number, string billNumber)
		{
			Number = number;
			IsBlocked = false;
			Services.SMS = true;
			Services.MMS = true;
			Services.Internet = true;
			IsPhoneChangeRequest = false;
			Bill.Number = billNumber;
			Bill.IsPayed = false;
			IsServiceRefusalRequest = false;
		}

		public void PayedBill()
		{
			Bill.IsPayed = true;
			IsBlocked = false;
		}

		public void PhoneChangeRequest()
		{
			IsPhoneChangeRequest = true;
		}

		public void ServiceRefusalRequest(string service)
		{
			IsServiceRefusalRequest = true;
			Services.setRefusalSeviceList(service);
		}

		new public void GetData()
		{
			Console.WriteLine("Information:");
			Console.WriteLine($"Bill: {Bill.Number}");
			Console.WriteLine(Number);
			Console.WriteLine($"Blocked: {IsBlocked}");
			Console.WriteLine($"The bill is paid: {Bill.IsPayed }");
			Console.WriteLine($"Services: SMS - {Services.SMS}, MMS - {Services.MMS}, Internet - {Services.Internet}\n");
		}
	}
}
