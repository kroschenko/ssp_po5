namespace Lab4_2
{
	class Program
	{
		static void Main(string[] args)
		{
			Page page = new Page();

			page.AddWord(new Word("My"));
			page.AddWord(new Word("family"));
			page.AddWord(new Word("is"));
			page.AddWord(new Word("very"));
			page.AddWord(new Word("friendly."));

			page.GetPage();
		}
	}
}
