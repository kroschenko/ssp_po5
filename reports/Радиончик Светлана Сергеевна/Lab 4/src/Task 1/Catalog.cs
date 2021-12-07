using System;
using System.Collections.Generic;

namespace Lab4_1
{
	class Catalog
	{
		public Dictionary<string, List<BookTracker>> Book;

		public Catalog()
		{
			Book = new Dictionary<string, List<BookTracker>>();
		}

		public void AddBook(string nameBook)
		{
			Book.Add(nameBook, new List<BookTracker>());
		}

		public void AddBookInfo(string bookTitle, BookTracker info)
		{
			foreach(var book in Book)
			{
				if(book.Key == bookTitle)
				{
					book.Value.Add(info);
				}
			}
		}

		public void List()
		{
			foreach (var book in Book)
			{
				Console.WriteLine($"\n{book.Key}:");
				var bookInfo = book.Value;
				foreach(var record in bookInfo)
					Console.WriteLine(record.GetRecord());
			}
		}

		public void ListOfReader(string bookTitle)
		{
			foreach (var book in Book)
			{
				if(book.Key == bookTitle)
				{
					Console.WriteLine($"\n{book.Key}:");
					var bookInfo = book.Value;
					foreach (var record in bookInfo)
						Console.WriteLine(record.GetReader());
				}
			}
		}

		public class BookTracker
		{
			public string Reader { get; set; }
			public string Period { get; set; }

			public BookTracker(string reader, string period)
			{
				Reader = reader;
				Period = period;
			}

			public string GetRecord()
			{
				BookTracker bookTracker = this;
				return $"Reader: {Reader} Period: {bookTracker.Period}";
			}

			public string GetReader()
			{
				return $"{Reader}";
			}
		}
	}
}
