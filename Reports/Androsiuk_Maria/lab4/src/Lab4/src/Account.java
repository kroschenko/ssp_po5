public class Account 
{
	private class owner
	{
		int removals;
		int payments;
		int entrances;
		
		@Override
		public String toString()
		{
			return "removals "+removals+"$\n"+"payments "+payments+"$\n"+"entrances "+entrances+"$\n";
		}
	}
		owner own = new owner();
	public void Addowner (int removals, int payments, int entrances)
	{
		own.removals = removals;
		own.payments = payments;
		own.entrances = entrances;
	}
	
	public void show()
	{
		
		System.out.println(own.toString());
	}
	public void removeMoney(int rem)
	{
		own.removals += rem;
	}
	public void pay(int pay)
	{
		own.payments += pay;
	}
	public void entranc(int ent)
	{
		own.entrances += ent;
	}
}
