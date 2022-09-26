public class Room {
    private String roomName;
    private String roomDescription;
    private String northLeadTo;
    private String southLeadTo;
    private String eastLeadTo;
    private String westLeadTo;

    public Room(String roomName,String roomDescription,
                String northLeadTo, String southLeadTo, String eastLeadTo, String westLeadTo){
        this.roomName = roomName;
        this.roomDescription = roomDescription;
        this.northLeadTo= northLeadTo;
        this.southLeadTo = southLeadTo;
        this.eastLeadTo= eastLeadTo;
        this.westLeadTo=westLeadTo;
    }
}
