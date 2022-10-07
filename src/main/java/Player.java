import ENUMS.TryEquipWeapon;

import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private ArrayList<Weapons> equippedWeapons;
    private ArrayList<Item> playerInventory;
    private int health;

    public Player() {
        playerInventory = new ArrayList<>();
        equippedWeapons = new ArrayList<>();
        health = 100;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public ArrayList<Weapons> getCurrentWeapon(){
        return equippedWeapons;
    }

    public int getHealth(){
        return health;
    }

    public void addToHealth(int healthValue){
        this.health += healthValue;
        if(health>=100){
            this.health = 100;
        }
        if(health<=0){
            this.health = 0;
        }
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
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

    public ArrayList<Weapons> getEquippedWeapons() {
        return equippedWeapons;
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

    public Item takeItemFromRoom(String commandParameter) {
        Item pickedUpItem = getCurrentRoom().removeItem(commandParameter);
        if(pickedUpItem!=null){
        addToInventory(pickedUpItem);
        }
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

    public Item getItemFromEquippedWeapons(String itemSearch) { //get but not remove item
        for (Item item : equippedWeapons) {
            if (item.getItemName().toLowerCase().equals(itemSearch.toLowerCase().trim())) {
                return item;
            }
        }
        return null; // vil aldrig blive kaldt hvis return i ifstatement bliver kaldt
    }

    public boolean hasWeapon(){
        if (equippedWeapons.size()>=1) {
            return true;
        } else {return false;}
    }

    public int eat(Food food){
        addToHealth(food.getHealthValue());
        return food.getHealthValue();
    }


    public TryEquipWeapon equipWeapon(String commandParameter) {
        Item equipWeapon = getItemFromInventory(commandParameter);
        if (equipWeapon != null) {
            if(equipWeapon instanceof Weapons) {
                if(equippedWeapons.size()!=2){
                    equippedWeapons.add((Weapons) equipWeapon);
                    playerInventory.remove(equipWeapon);
                }else {
                    return TryEquipWeapon.ALREADY_TWO_WEAPONS;
                }
                return TryEquipWeapon.IS_WEAPON;
            } else {
                return TryEquipWeapon.NOT_WEAPON;
            }
        } else{
            return TryEquipWeapon.ITEM_NOT_FOUND;
        }
    }

    public TryEquipWeapon unEquipWeapon(String commandParameter) {
        Item unEquipWeapon =  getItemFromEquippedWeapons(commandParameter);
        if (unEquipWeapon != null) {
            playerInventory.add(unEquipWeapon);
            equippedWeapons.remove(unEquipWeapon);
            return TryEquipWeapon.IS_WEAPON;
        } else {
            return TryEquipWeapon.ITEM_NOT_FOUND;
        }
    }
}

