import java.util.ArrayList;

public class Player {

    private Room currentRoom;
    private ArrayList<Item> playerInventory;

    public Player(){
        playerInventory = new ArrayList<>();
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public boolean isRoomNorth() {
        if (currentRoom.getNorth() == null) {
            return false;
        } else {
            return true;
        }
    }

    public void goNorth(){
        currentRoom = currentRoom.getNorth();
    }
    public boolean isRoomEast(){
        if (currentRoom.getEast()==null){
            return false;
        }else{
            return true;
        }
    }
    public void goEast() {
        currentRoom = currentRoom.getEast();
    }

    public boolean isRoomSouth() {
        if (currentRoom.getSouth() == null) {
            return false;
        } else {
            return true;
        }
    }
    public void goSouth(){
        currentRoom = currentRoom.getSouth();
    }

    public boolean isRoomWest() {
        if (currentRoom.getWest() == null) {
            return false;
        } else {
            return true;
        }
    }
    public void goWest(){
        currentRoom = currentRoom.getWest();
    }



    public ArrayList<Item> getPlayerInventory() {
        return playerInventory;
    }
    public void addToInventory(Item item){
        playerInventory.add(item);
    }
}
