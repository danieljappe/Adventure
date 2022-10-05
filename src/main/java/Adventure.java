import java.util.ArrayList;

public class Adventure {
    private Map map = new Map();
    private Player player = new Player();
    private String returnString;
    public enum tryEat {FOOD_NOT_FOUND, IS_NOT_FOOD,YOU_EAT}
    public String getReturnString(){
        return this.returnString;
    }
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

    public Item takeItemFromRoom(String commandParameter) {
        return player.takeItemFromRoom(commandParameter);
    }

    public Item dropItem(String commandParameter) {
        return player.dropItem(commandParameter);
    }
    public int getHealth(){
        return player.getHealth();
    }

    public tryEat tryToEat(String commandParameter){
        Item itemToEat = player.takeItemFromRoom(commandParameter);
        if(itemToEat == null) {
            itemToEat = player.dropItem(commandParameter);
        }
        if(itemToEat != null){
            if(itemToEat instanceof Food){
                Food foodToEat = (Food) itemToEat;
                int healthGained = player.eat(foodToEat);
                returnString = Integer.toString(healthGained);
                return tryEat.YOU_EAT;
            }else{
                return tryEat.IS_NOT_FOOD;
            }

        }else{
            return tryEat.FOOD_NOT_FOUND ;
        }
    }




    public String look() {
        return getCurrentRoom().getRoomName() + "\n" + getCurrentRoom().getRoomDescription() + "\n" + getCurrentRoom().getRoomItems();
    }

    public ArrayList<Item> viewInventory() {
        return player.getPlayerInventory();
    }


}


