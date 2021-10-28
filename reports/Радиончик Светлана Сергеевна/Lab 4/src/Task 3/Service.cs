using System.Collections.Generic;

namespace Lab4_3
{
	class Service
	{
		public List<string> RefusalService = new List<string>();

		public bool MMS { get; set; }
		public bool SMS { get; set; }
		public bool Internet { get; set; }

		public void setRefusalSeviceList(string service)
		{
			RefusalService.Add(service);
		}
	}
}
