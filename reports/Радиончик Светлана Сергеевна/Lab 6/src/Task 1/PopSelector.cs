namespace Lab6_1_1
{
	class PopSelector : Selector
	{
		public override void FactoryMethod(string name)
		{
			PopProduct p1 = new PopProduct();
			p1.ChooseInstrument(name);
		}
	}
}
