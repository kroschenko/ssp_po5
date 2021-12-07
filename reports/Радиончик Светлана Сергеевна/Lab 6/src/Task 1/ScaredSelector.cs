namespace Lab6_1_1
{
	class ScaredSelector : Selector
	{
		public override void FactoryMethod(string name)
		{
			ScaredProduct p1 = new ScaredProduct();
			p1.ChooseInstrument(name);
		}
	}
}
