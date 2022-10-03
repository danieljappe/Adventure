public class Adventure {
    private Map map = new Map();
    private Player player = new Player();

    public void buildMap(){
        map.buildMap();
    }

    public Adventure() {
        player.setCurrentRoom(map.getStartRoom());
    }

    public Room getCurrentRoom() {
        return player.getCurrentRoom();
    }

    public boolean go(String direction) {
        return player.go(direction);
    }



    public Map getMap() {
        return map;
    }

    public Player getPlayer() {
        return player;
    }

    public Item takeItem(String commandParameter) {
        Item pickedUpItem = player.getCurrentRoom().removeItem(commandParameter);
        player.addToInventory(pickedUpItem);
        return pickedUpItem;
    }

    public Item dropItem(String commandParameter) {
        Item droppedItem = player.getCurrentRoom().addItem(commandParameter);
        player.removeItemFromInventory(droppedItem);
        return droppedItem;
    }


}


