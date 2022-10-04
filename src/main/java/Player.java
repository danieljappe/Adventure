import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private ArrayList<Item> playerInventory;
    private int health;

    public Player() {
        playerInventory = new ArrayList<>();
        health = 100;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
    public int getHealth(){
        return health;
    }
    public void addToHealth(int healthValue){
        this.health += healthValue;
        if(health>100){
            this.health = 100;
        }
        if(health<0){
            this.health = 0;
        }
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

    public boolean go(String direction) {
        Room requestedRoom = null;

        switch (direction) {

            case "n", "north" -> {
                requestedRoom = currentRoom.getNorth();
            }
            case "s", "south" -> {
                requestedRoom = currentRoom.getSouth();
            }
            case "e", "east" -> {
                requestedRoom = currentRoom.getEast();
            }
            case "w", "west" -> {
                requestedRoom = currentRoom.getWest();
            }
        }
        if (requestedRoom != null) {
            currentRoom = requestedRoom;
            return true;
        } else {
            return false;
        }
    }



    public ArrayList<Item> getPlayerInventory() {
        return playerInventory;
    }

    public void addToInventory(Item item) {
        playerInventory.add(item);
    }

    public Item removeFromInventory(String name) {
        for (Item item : playerInventory) {
            if (item.getItemName().equals(name)) {
                playerInventory.remove(item);
                return item;
            }
        }
        return null;
    }

    public Item takeItem(String commandParameter) {
        Item pickedUpItem = getCurrentRoom().removeItem(commandParameter);
        addToInventory(pickedUpItem);
        return pickedUpItem;
    }

    public Item dropItem(String commandParameter) {
        Item droppedItem = removeFromInventory(commandParameter);
        currentRoom.addItem(droppedItem);
        return droppedItem;
    }


    public Item getItemFromInventory(String itemSearch) { //get but not remove item
        for (Item item : playerInventory) {
            if (item.getItemName().toLowerCase().equals(itemSearch.toLowerCase().trim())) {
                return item;
            }
        }
        return null; // vil aldrig blive kaldt hvis return i ifstatement bliver kaldt
    }

    public int eat(Food food){
        addToHealth(food.getHealthValue());
        return food.getHealthValue();
    }



}

