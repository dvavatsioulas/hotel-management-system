public class Reservation {
		private String clientName;
		private Room room;
		private int stayCost;
		private double totalCharge;
		
		public Reservation(String name,Room room,int stayCost,double totalCost)
		{
			this.clientName=name;
			this.room=room;
			this.stayCost=stayCost;
			this.totalCharge=totalCost;
		}
		
		public Room getRoom()
		{
			return room;
		}
		
		public String getClientName()
		{
			return clientName;
		}

		public void setTotalCharge(double totalCharge) {
			this.totalCharge = totalCharge;
		}

		public double getTotalCharge() {
			return totalCharge;
		}

		
		
		
		
}//END_OF_CLASS