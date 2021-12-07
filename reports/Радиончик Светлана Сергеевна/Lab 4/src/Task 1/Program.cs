namespace Lab4_1
{
	class Program
	{
		static void Main(string[] args)
		{
			Catalog catalog = new Catalog();

			Catalog.BookTracker LostInfo1 = new Catalog.BookTracker("Vakham V.N", "12.10.2019 - 12.02.2020");
			Catalog.BookTracker LostInfo2 = new Catalog.BookTracker("Grenz K.L", "21.09.2020 - 12.02.2021");
			Catalog.BookTracker LostInfo3 = new Catalog.BookTracker("Hall R.N", "03.03.2021 - 12.03.2021");
			Catalog.BookTracker CinderellaInfo1 = new Catalog.BookTracker("Solla H.F", "10.10.2020 - 12.12.2021");

			catalog.AddBook("Cinderella");
			catalog.AddBook("Lost");

			catalog.AddBookInfo("Lost", LostInfo1);
			catalog.AddBookInfo("Lost", LostInfo2);
			catalog.AddBookInfo("Lost", LostInfo3);
			catalog.AddBookInfo("Cinderella", CinderellaInfo1);

			catalog.List();
			catalog.ListOfReader("Lost");
		}
	}
}
