import java.util.ArrayList;

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
        return player.takeItem(commandParameter);
    }

    public Item dropItem(String commandParameter) {
        return player.dropItem(commandParameter);
    }

    public String look() {
        return getCurrentRoom().getRoomName() + "\n" + getCurrentRoom().getRoomDescription() + "\n" + getCurrentRoom().getRoomItems();
    }

    public ArrayList<Item> viewInventory() {
        return player.getPlayerInventory();
    }


}


