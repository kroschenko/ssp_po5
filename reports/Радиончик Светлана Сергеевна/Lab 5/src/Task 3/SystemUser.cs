using System;
using System.Collections.Generic;
using System.Text;

namespace Lab5_3
{
	abstract class SystemUser
	{
		public string Name { get; set; }
		public UserPosition Position { get; set; }

		public enum UserPosition
		{
			Abonent,
			Administrator
		}

		public SystemUser()
		{
			Name = null;
			Position = 0;
		}

		public SystemUser(string name, UserPosition position)
		{
			Name = name;
			Position = position;
		}

		public string GetData()
		{
			return $"Name: {Name}\n Position: {nameof(Position)}";
		}
	}
}
