public class Room {
    private String roomName;
    private String roomDescription;
    private Room north;
    private Room south;
    private Room east;
    private Room west;

    public Room(String roomName,String roomDescription,
                String northLeadTo, String southLeadTo, String eastLeadTo, String westLeadTo){
        this.roomName = roomName;
        this.roomDescription = roomDescription;
        this.north= north;
        this.south = south;
        this.east= east;
        this.west=west;
    }
}
