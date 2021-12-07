using System;

namespace Lab3_2
{
	class Room
	{
		public int Id { get; set; }
		public int RoomCount { get; set; }
		public int Area { get; set; }
		public int Floor { get; set; }
		public string Address { get; set; }
		public double RentalPrice { get; set; }
		public bool IsRent { get; set; }
		
		public void Print()
		{
			Console.WriteLine($"Id: {this.Id}");
			Console.WriteLine($"Number of rooms: {this.RoomCount}");
			Console.WriteLine($"Area: {this.Area}");
			Console.WriteLine($"Floor: {this.Floor}");
			Console.WriteLine($"Price: {this.RentalPrice}");
			Console.WriteLine($"Is for rent: {this.IsRent}\n");
		}
	}
}
