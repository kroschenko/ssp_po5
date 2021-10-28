namespace Lab4_2
{
	class Word
	{
		public string NewWord { get; set; }

		public Word(string newWord)
		{
			NewWord = newWord;
		}

		public string GetWord()
		{
			return NewWord;
		}
	}
}
