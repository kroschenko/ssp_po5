using System;
using System.IO;
using ExcelDataReader;

namespace Lab3_2
{
	class Program
	{
		static void Main(string[] args)
		{
			DataBase data = new DataBase() { };

			string FilePath = "D://Rooms.xlsx";
			FileStream fileStream = File.Open(FilePath, FileMode.Open, FileAccess.Read);

			using (var stream = new MemoryStream())
			{
				fileStream.CopyTo(stream);
				stream.Position = 0;

				System.Text.Encoding.RegisterProvider(System.Text.CodePagesEncodingProvider.Instance);

				using (var reader = ExcelReaderFactory.CreateReader(stream))
				{
					reader.Read();
					int lineNumber = 0;

					while (reader.Read())
					{
						int columnCount = reader.FieldCount;

						var roomCount = columnCount > 0 ? reader.GetValue(0) : null;
						var area = columnCount > 0 ? reader.GetValue(1) : null;
						var floor = columnCount > 0 ? reader.GetValue(2) : null;
						var address = columnCount > 0 ? reader.GetValue(3) : null;
						var price = columnCount > 0 ? reader.GetValue(4) : null;
						var isRent = columnCount > 0 ? reader.GetValue(5) : null;

						data.rooms.Add(new Room()
						{
							Id = ++lineNumber,
							RoomCount = roomCount is double ? Convert.ToInt32(roomCount) : 0,
							Area = area is double ? Convert.ToInt32(area) : 0,
							Floor = floor is double ? Convert.ToInt32(floor) : 0,
							Address = address is string ? (string)address : null,
							RentalPrice = price is double ? (double)price : 0,
							IsRent = (string)isRent == "true" ? true : false
						});
					}
				}
			}

			Console.WriteLine("Данные из xlsx файла: ");
			data.Print();

			Console.WriteLine("Свободные квартиры: ");
			var fr = data.FreeRoomsList();
			fr.Print();

			Console.WriteLine("Занятые квартиры: ");
			var or = data.OccupiedRoomsList();
			or.Print();

			Console.WriteLine("Поиск подходящего варианта: ");
			var so = data.SuitableOption(3, 4, 85);
			so.Print();

			Console.WriteLine("Удаление квартиры из списка свободных квартир: ");
			data.FromFreeToOccupiedList(data.rooms.Find(r => r.Id == 1));
			data.Print();
			Console.WriteLine("Свободные квартиры: ");
			var frAfterDelete = data.FreeRoomsList();
			frAfterDelete.Print();

			Console.WriteLine("Удаление квартиры из списка сдаваемых квартир: ");
			data.FromOccupiedToFreeList(data.rooms.Find(r => r.Id == 2));
			data.Print();
			Console.WriteLine("Занятые квартиры: ");
			var orAfterDelete = data.OccupiedRoomsList();
			orAfterDelete.Print();

			Console.WriteLine("Список квартир, имеющих заданное число комнат: ");
			var roomWithCertainRoomsNumber = data.SuitableOptionWithCertainRoomsNumber(2);
			roomWithCertainRoomsNumber.Print();

			Console.WriteLine("Список квартир, имеющих заданное число комнат и расположенных на этаже, который находится в заданном промежутке: ");
			var roomWithCertainRoomsNumberAndFloor = data.SuitableOptionWithCertainRoomsNumberAndFloor(3, 2, 5);
			roomWithCertainRoomsNumberAndFloor.Print();

			Console.WriteLine("Список квартир, имеющих площадь, превосходящую заданную: ");
			var roomWithCertainArea = data.SuitableOptionWithLargerRoomsArea(60);
			roomWithCertainArea.Print();
		}
	}
}
