import java.util.ArrayList;

public class Room {
    private String roomName;
    private String roomDescription;
    private Room north;
    private String northDescription;
    private Room south;
    private String southDescription;
    private Room east;
    private String eastDescription;
    private Room west;
    private String westDescription;
    boolean beenThere;


    public Room(String roomName, String roomDescription, String northDescription, String southDescription,
                String eastDescription, String westDescription) {
        this.roomName = roomName;
        this.roomDescription = roomDescription;
        this.northDescription = northDescription;
        this.southDescription = southDescription;
        this.eastDescription = eastDescription;
        this.westDescription = westDescription;
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

    public Room getSouth() {
        return south;
    }

    public Room getEast() {
        return east;
    }

    public Room getWest() {
        return west;
    }

    public String getNorthDescription() {
        return northDescription;
    }

    public String getEastDescription() {
        return eastDescription;
    }

    public String getSouthDescription() {
        return southDescription;
    }

    public String getWestDescription() {
        return westDescription;
    }

    ArrayList<Item> roomItems = new ArrayList<>();

    public ArrayList<Item> getRoomItems() {
        return roomItems;
    }

    public boolean isInRoom(String itemSearch) {
        boolean isThere = false;
        for (Item item : roomItems) {
            if (item.getItemName().toLowerCase().contains(itemSearch.toLowerCase().trim())) {
                isThere=true;
            }
        }
        return isThere;
    }

        public void addItemToRoom (Item item){
            roomItems.add(item);
        }

        public Item takeItem (String itemSearch){
        Item itemReturn = null;
            for(Item item : roomItems){
                if(item.getItemName().contains(itemSearch.toLowerCase().trim())){
                    itemReturn = item;
                    System.out.println("TAGER ITEM");
                }
            }
            roomItems.remove(itemReturn);
            return itemReturn;
        }

    }
