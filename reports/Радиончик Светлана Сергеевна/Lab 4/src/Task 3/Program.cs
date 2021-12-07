namespace Lab4_3
{
	class Program
	{
		static void Main(string[] args)
		{
			Abonent abonent = new Abonent("+375334579865", "001");
			Administrator admin = new Administrator();

			abonent.GetData();
			abonent.PhoneChangeRequest();
			abonent.ServiceRefusalRequest("MMS");

			admin.AddAbonent(abonent);
			admin.ChangePhoneNumber(abonent, "+375339043245");
			admin.ServiceRefusal(abonent);
			abonent.GetData();
			admin.Block(abonent);
			
			abonent.GetData();
			abonent.PayedBill();
			abonent.GetData();
		}
	}
}
