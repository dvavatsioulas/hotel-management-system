
public class Room {
		
	private int roomNumber;
	private int roomType;
	private boolean isFree=true;
	
	public Room(int roomNumber, int roomType, boolean isFree) {
		this.roomNumber = roomNumber;
		this.roomType = roomType;
		this.isFree = isFree;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public int getRoomType() {
		return roomType;
	}

	public boolean isFree() {
		return isFree;
	}

	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}
}//END_OF_CLASS
