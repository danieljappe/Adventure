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

    public TryEatResponse tryToEat(String commandParameter){
        Item itemToEat = player.takeItemFromRoom(commandParameter);
        if(itemToEat == null) {
            itemToEat = player.dropItem(commandParameter);
        }
        if(itemToEat != null){
            if(itemToEat instanceof Food){
                Food foodToEat = (Food) itemToEat;
                int healthGained = player.eat(foodToEat);
                returnString = Integer.toString(healthGained);
                return TryEatResponse.YOU_EAT;
            }else{
                return TryEatResponse.IS_NOT_FOOD;
            }

        }else{
            return TryEatResponse.FOOD_NOT_FOUND;
        }
    }

    public TryEquipWeapon equipWeapon(String commandParameter) {
        return player.equipWeapon(commandParameter);
    }

    public TryEquipWeapon unEquipWeapon(String commandParameter) {
        return player.unEquipWeapon(commandParameter);
    }
    public TryUseWeapon useWeapon(String commandParameter){
        Weapons inHandWeapon;
        for(Weapons weapon : player.getEquippedWeapons()){
            if(weapon.getItemName().equals(commandParameter.toLowerCase().trim())){
                if(weapon instanceof RangedWeapon){
                    if(((RangedWeapon) weapon).getShots() > 0){
                        return TryUseWeapon.YOU_HIT_TARGET; // hvis vi går ud fra vi rammer hver gang
                        //TODO hvis du ikke rammer
                        //return TryUseWeapon.YOU_MISS;
                    }else{
                        return TryUseWeapon.NO_AMMO;
                    }
                }else{
                    return TryUseWeapon.YOU_HIT_TARGET; // med svær, hvis vi rammer hver gang
                    //TODO hvis du ikke rammer
                    //return TryUseWeapon.YOU_MISS;
                }
            }else{
                return TryUseWeapon.WEAPON_NOT_IN_HAND;
            }
        }
        return null;// ved ikke hvorfor den er nødvendig
    }


    public String look() {
        return getCurrentRoom().getRoomName() + "\n" + getCurrentRoom().getRoomDescription() + "\n" + getCurrentRoom().getRoomItems();
    }

    public ArrayList<Item> viewInventory() {
        return player.getPlayerInventory();
    }

    public ArrayList<Weapons> viewEquippedWeapons() {
        return player.getEquippedWeapons();
    }


}


