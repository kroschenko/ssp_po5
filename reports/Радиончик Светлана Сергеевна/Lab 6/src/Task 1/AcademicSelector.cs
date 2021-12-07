namespace Lab6_1_1
{
	class AcademicSelector : Selector
	{
		public override void FactoryMethod(string name)
		{
			AcademicProduct p1 = new AcademicProduct();
			p1.ChooseInstrument(name);
		}
	}
}
