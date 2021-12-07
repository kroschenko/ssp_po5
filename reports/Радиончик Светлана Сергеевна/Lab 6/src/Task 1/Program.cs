using System.Threading;
using System.Threading.Tasks;

namespace Lab6_1_1
{
	class Program
	{
		static void Main(string[] args)
		{
			Parallel.Invoke(() => new Client().Main("Customer 1"), () => 
				{ Thread.Sleep(3000); new Client().Main("Customer 2"); }, () => 
				{ Thread.Sleep(6000); new Client().Main("Customer 3"); });
		}
	}
}
