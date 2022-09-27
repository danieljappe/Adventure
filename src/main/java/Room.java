public class Room {
    private String roomName;
    private String roomDescription;
    private Room north;
    private Room south;
    private Room east;
    private Room west;

    public Room(String roomName, String roomDescription) {
        this.roomName = roomName;
        this.roomDescription = roomDescription;
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

    public void setNorth(Room north) {
        this.north = north;
    }
    public void setSouth(Room south) {
        this.south = south;
    }
    public void setEast(Room east) {
        this.east = east;
    }
    public void setWest(Room west) {
        this.west = west;
    }

    public Room getNorth() {
        return north;
    }
    public void setEast(Room east) {
        this.east = east;
    }


    public Room getSouth() {
        return south;
    }



    public Room getEast() {
        return east;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public Room getWest() {
        return west;
    }
}
