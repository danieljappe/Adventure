import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private ArrayList<Item> playerInventory;

    public Player() {
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

        public boolean isRoomEast() {
            if (currentRoom.getEast() == null) {
                return false;
            } else {
                return true;
            }
        }

        public boolean isRoomSouth() {
            if (currentRoom.getSouth() == null) {
                return false;
            } else {
                return true;
            }
        }

        public boolean isRoomWest() {
            if (currentRoom.getWest() == null) {
                return false;
            } else {
                return true;
            }
        }

        public ArrayList<Item> getPlayerInventory() {
            return playerInventory;
        }

        public void addToInventory (Item item){
            playerInventory.add(item);
        }

        public Item getAndRemoveItem (String itemName){
            for (Item item : playerInventory) {
                if (item.getItemName().equals(itemName)) {
                    playerInventory.remove(item);
                    return item;
                }
            }
            return null;
        }
        public Item getItemFromInventory (String itemSearch){ //get but not remove item
            for (Item item : playerInventory) {
                if (item.getItemName().toLowerCase().equals(itemSearch.toLowerCase().trim())) {
                    return item;
                }
            }
            return null; // vil aldrig blive kaldt hvis return i ifstatement bliver kaldt
        }
        public void removeItemFromInventory (Item itemToRemove){
            playerInventory.remove(itemToRemove);
        }


    }
}
