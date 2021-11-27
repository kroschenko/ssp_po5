using System.Threading;
using System.Threading.Tasks;

namespace Lab6_1
{
	class Program
	{
		static void Main(string[] args)
		{
			Customer c1 = new Customer("Customer 1");
			Customer c2 = new Customer("Customer 2");
			Customer c3 = new Customer("Customer 3");

			Parallel.Invoke(() => c1.Serve(),  () => { Thread.Sleep(3000);  c2.Serve(); }, () => { Thread.Sleep(6000); c3.Serve(); });
		}
	}
}
