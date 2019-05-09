public class Reservation {
		private String clientName;
		private Room room;
		private int stayCost;
		private double totalCost;
		
		public Reservation(String name,Room room,int stayCost,double totalCost)
		{
			this.clientName=name;
			this.room=room;
			this.stayCost=stayCost;
			this.totalCost=totalCost;
		}
		
		public Room getRoom()
		{
			return room;
		}
		
		public String getClientName()
		{
			return clientName;
		}

		public void setTotalCost(double totalCost) {
			this.totalCost = totalCost;
		}
		
}//END_OF_CLASS