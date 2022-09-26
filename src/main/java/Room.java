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
    }
}
