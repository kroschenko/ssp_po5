namespace Lab6_2
{
	class LevelTwo : Decorator
	{
		public LevelTwo(Level lev) : base(lev) { }

		public override string GetLevel()
		{
			return "level 2";
		}

		public override string AddToFavourites()
		{
			return $"You can add to favourites at {this.GetLevel()}";

		}

		public override string GetDiscont()
		{
			return $"You can get discont at {this.GetLevel()}";
		}
	}
}
