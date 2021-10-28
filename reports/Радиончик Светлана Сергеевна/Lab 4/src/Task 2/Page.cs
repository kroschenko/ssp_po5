using System;
using System.Collections.Generic;

namespace Lab4_2
{
	class Page
	{
		public List<Word> TextPage;

		public Page()
		{
			TextPage = new List<Word>();
		}

		public void AddWord(Word word)
		{
			TextPage.Add(word);
		}

		public void GetPage()
		{
			foreach(var word in TextPage)
			{
				Console.Write($"{word.GetWord()} ");
			}
		}
	}
}
