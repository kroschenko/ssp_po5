namespace Lab6_1_1
{
	class FolkSelector : Selector
	{
		public override void FactoryMethod(string name)
		{
			FolkProduct p1 = new FolkProduct();
			p1.ChooseInstrument(name);
		}
	}
}
