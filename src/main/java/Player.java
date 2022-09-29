import java.util.ArrayList;

public class Player {
    private Map map = new Map();
    private Room currentRoom = map.room1;

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public boolean goNorth() {
        if (currentRoom.getNorth() == null) {
            return false;
        } else {
            currentRoom = currentRoom.getNorth();
            return true;
        }
    }
    public boolean isEast(){
        if (currentRoom.getEast()==null){
            return false;
        }else{
            return true;
        }
    }
    public void goEast() {
            currentRoom = currentRoom.getEast();
    }

    public boolean goSouth() {
        if (currentRoom.getSouth() == null) {
            return false;
        } else {
            currentRoom = currentRoom.getSouth();
            return true;
        }
    }

    public boolean goWest() {
        if (currentRoom.getWest() == null) {
            return false;
        } else {
            currentRoom = currentRoom.getWest();
            return true;
        }
    }

    ArrayList<Item> playerInventory = new ArrayList<>();

    public ArrayList<Item> getPlayerInventory() {
        return playerInventory;
    }
    public void addToInventory(Item item){
        playerInventory.add(item);
    }
}
