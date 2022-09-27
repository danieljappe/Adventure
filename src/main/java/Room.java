public class Room {
    private String roomName;
    private String roomDescription;
    private Room north;
    private Room south;
    private Room east;
    private Room west;

    public Room(String roomName,String roomDescription){
        this.roomName = roomName;
        this.roomDescription = roomDescription;
        this.north = null;
        this.south = null;
        this.east = null;
        this.west = null;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    public void setNorth(Room room){
        this.north = room;
    }
    public Room getNorth(){
        return north;
    }



}
