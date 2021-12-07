namespace Lab6_2
{
	class Decorator : Level
	{
		protected Level _level;

		public Decorator (Level level)
		{
			this._level = level;
		}

		public void SetLevel(Level level)
		{
			this._level = level;
		}

		public override string GetLevel()
		{
			if (this._level != null)
			{
				return this._level.GetLevel();
			}
			else
			{
				return string.Empty;
			}
		}

		public override string AddToFavourites()
		{
			if (this._level != null)
			{
				return this._level.AddToFavourites();
			}
			else
			{
				return string.Empty;
			}
		}

		public override string GetDiscont()
		{
			if (this._level != null)
			{
				return this._level.GetDiscont();
			}
			else
			{
				return string.Empty;
			}
		}
	}
}
