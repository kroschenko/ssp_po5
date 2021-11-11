namespace Lab5_2
{
	abstract class Pet
	{
		private string name;
		private string color;

		protected Pet(string name, string color)
		{
			this.name = name;
			this.color = color;
		}

		public void SetName(string name)
		{
			this.name = name;
		}

		public void SetColor(string color)
		{
			this.color = color;
		}

		public string GetName()
		{
			return this.name;
		}

		public string GetColor()
		{
			return this.color;
		}

		public abstract void DetData();
	}
}
