namespace Lab6_2
{
	class ConcreteLevel : Level
	{
		public override string AddToFavourites()
		{
			return $"You can't add to favourites at {this.GetLevel()}";
		}

		public override string GetDiscont()
		{
			return $"You can't get discont at {this.GetLevel()}";
		}

		public override string GetLevel()
		{
			return "level 0";
		}
	}
}
