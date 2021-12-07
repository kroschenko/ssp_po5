using System;

namespace Lab6_3
{
	class Printer
	{
		private string _model;
		private int _paperNum;
		private double _occupancyPercentage;
		private double _clampingPercentage;
		private State _state;

		public Printer(string model, int paperNum, double occupancyPecentage, double clampingPercentage)
		{
			this._model = model;
			this._paperNum = paperNum;
			this._clampingPercentage = clampingPercentage;
			this._state = new State();
			
			if (occupancyPecentage < 100)
				this._occupancyPercentage = occupancyPecentage;
			else
				this._occupancyPercentage = 100;
		}

		public void GetName()
		{
			Console.WriteLine("\n"+this._model);
		}

		public void Print()
		{
			if (this._paperNum < 1)
			{
				this._state.Refusal();
				Console.WriteLine("бумага");
				this._state.Expectation();
				this.LoadPaper();
			}

			if (this._occupancyPercentage < 20)
			{
				this._state.Refusal();
				Console.WriteLine("краска");
				this._state.Expectation();
				this.CatridgeRefuling();
			}

			this._state.Print();

			if(this._clampingPercentage > 40)
			{
				this._state.Clamping();
				this.RecoveryPaperClamping();
				this._state.Print();
			}
		}

		private void RecoveryPaperClamping()
		{
			Console.WriteLine("Можем продолжить работу!");
		}

		private void LoadPaper()
		{
			this._paperNum = 50;
		}

		private void CatridgeRefuling()
		{
			this._occupancyPercentage = 100;
		}
	}
}
