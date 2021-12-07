namespace Lab6_2
{
	class LevelOne : Decorator
	{
		public LevelOne(Level lev) : base(lev) { }

		public override string GetLevel()
		{
			return "level 1";
		}

		public override string AddToFavourites()
		{
			return $"You can add to favourites at {this.GetLevel()}";

		}

		public override string GetDiscont()
		{
			return $"You can't get discont at {this.GetLevel()}";
		}
	}
}
