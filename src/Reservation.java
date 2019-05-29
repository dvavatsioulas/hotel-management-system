public class Reservation {
		private String clientName;
		private Room room;
		private int stayCharge;
		private double totalCharge;
		
		public Reservation(String name,Room room,int stayCharge,double totalCost) //to stayCharge anaferetai stin xreosi gia ti diamoni. to totalCost einai to SINOLIKO
																				//poso pou tha plirosei gia diamoni+bar+drastiriotites
		{
			this.clientName=name;
			this.room=room;
			this.stayCharge=stayCharge;
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
}