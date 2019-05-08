public class Reservation {
		private String clientName;
		private int roomType;
		private Room room;
		private int stayCost;
		private double totalCost;
		
		
		public Reservation(String name,int type,Room room,int stayCost,double totalCost)
		{
			this.clientName=name;
			this.roomType=type;
			this.room=room;
			this.stayCost=stayCost;
			this.totalCost=totalCost;
		}
		
		@Override 
		public String toString()
		{
			String tempType="";
			if(roomType==1)
				tempType="ломойкимо";
			else if(roomType==2)
				tempType="дийкимо";
			else if(roomType==3)
				tempType="тяийкимо";
			else if(roomType==4)
				tempType="тетяайкимо";
			
			return ("Name: "+clientName+" "+"Type: " +tempType);
		
		}
		
		public Room getRoom()
		{
			return room;
		}
		
		public String getClientName()
		{
			return clientName;
		}
		
		public int getRoomType()
		{
			return roomType;
		}

		public void setTotalCost(double totalCost) {
			this.totalCost = totalCost;
		}
		
		
}//END_OF_CLASS