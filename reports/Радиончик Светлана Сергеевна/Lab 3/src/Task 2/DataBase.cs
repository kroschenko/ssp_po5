using System;
using System.Collections.Generic;
using System.Linq;

namespace Lab3_2
{
	class DataBase
	{
		public List<Room> rooms = new List<Room>();

		public DataBase FreeRoomsList()
		{
			DataBase freeRoom = new DataBase();
			
			foreach(var room in rooms)
			{
				if(room.IsRent)
					freeRoom.rooms.Add(room);
			}

			return freeRoom;
		}

		public DataBase OccupiedRoomsList()
		{
			DataBase occupiedRoom = new DataBase();

			foreach(var room in rooms)
			{
				if(!room.IsRent)
					occupiedRoom.rooms.Add(room);
			}

			return occupiedRoom;
		}

		public DataBase SuitableOption(int roomCount, int floor, double area)
		{
			DataBase suitableRoom = new DataBase();

			foreach (var room in rooms)
			{
				if(room.RoomCount == roomCount && room.Floor == floor)
				{
					double areaDifference =  room.Area - area > 0 ? room.Area - area : Math.Abs(room.Area - area);

					if (areaDifference <= 10)
						suitableRoom.rooms.Add(room);
				}
			}

			return suitableRoom;
		}

		public DataBase SuitableOptionWithCertainRoomsNumber(int roomCount)
		{
			DataBase suitableRoom = new DataBase();

			foreach (var room in rooms)
			{
				if (room.RoomCount == roomCount)
				{
					suitableRoom.rooms.Add(room);
				}
			}

			return suitableRoom;
		}

		public DataBase SuitableOptionWithCertainRoomsNumberAndFloor(int roomCount, int from, int to)
		{
			DataBase suitableRoom = new DataBase();

			foreach (var room in rooms)
			{
				if (room.RoomCount == roomCount && room.Floor >= from && room.Floor <= to)
				{
					suitableRoom.rooms.Add(room);
				}
			}

			return suitableRoom;
		}

		public DataBase SuitableOptionWithLargerRoomsArea(int area)
		{
			DataBase suitableRoom = new DataBase();

			foreach (var room in rooms)
			{
				if (room.Area > area)
					suitableRoom.rooms.Add(room);
			}

			return suitableRoom;
		}

		public void FromFreeToOccupiedList(Room room)
		{
			var relocatable = rooms.FirstOrDefault(e => e == room);
			relocatable.IsRent = false;
		}

		public void FromOccupiedToFreeList(Room room)
		{
			var relocatable = rooms.FirstOrDefault(e => e == room);
			relocatable.IsRent = true;
		}

		public void Print()
		{
			foreach (var room in rooms)
				room.Print();

		}
	}
}
