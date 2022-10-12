import java.util.ArrayList;
import java.util.Random;

public class Adventure {
    private Map map = new Map();
    private Player player = new Player();
    private String returnString;


    public enum tryEat {FOOD_NOT_FOUND, IS_NOT_FOOD, YOU_EAT}

    public String getReturnString() {
        return this.returnString;
    }

    public void buildMap() {
        map.buildMap();
    }

    public Adventure() {
        player.setCurrentRoom(map.getStartRoom());
    }

    public Room getCurrentRoom() {
        return player.getCurrentRoom();
    }

    public TryGo go(Direction direction) {
        Room requestedRoom = null;
        if (player.getCurrentRoom().getDoor(direction) == null || player.getCurrentRoom().getDoor(direction).isOpen()) {
            requestedRoom = player.getCurrentRoom().getDirection(direction);
        } else {
            returnString = player.getCurrentRoom().getDoor(direction).getClosedDescription();
            return TryGo.IS_LOCKED;
        }
        if (requestedRoom != null) {
            player.setCurrentRoom(requestedRoom);
            return TryGo.GOING;
        } else {
            return TryGo.CANT_GO;
        }
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

    public int getHealth() {
        return player.getHealth();
    }

    public TryEatResponse tryToEat(String commandParameter) {
        Item itemToEat = player.takeItemFromRoom(commandParameter);
        if (itemToEat == null) {
            itemToEat = player.dropItem(commandParameter);
        }
        if (itemToEat != null) {
            if (itemToEat instanceof Food) {
                Food foodToEat = (Food) itemToEat;
                int healthGained = player.eat(foodToEat);
                returnString = Integer.toString(healthGained);
                return TryEatResponse.YOU_EAT;
            } else {
                return TryEatResponse.IS_NOT_FOOD;
            }
        } else {
            return TryEatResponse.FOOD_NOT_FOUND;
        }
    }

    public TryEquipWeapon equipWeapon(String commandParameter) {
        return player.equipWeapon(commandParameter);
    }

    public TryEquipWeapon unEquipWeapon(String commandParameter) {
        return player.unEquipWeapon(commandParameter);
    }

    public TryUseWeapon useWeapon() {
        for (Weapons weapon : player.getEquippedWeapons()) {
            Random hitChance = new Random();
            if (weapon == null) {
                return TryUseWeapon.WEAPON_NOT_IN_HAND;
            } else if (weapon instanceof RangedWeapon) {
                if (((RangedWeapon) weapon).getAmmo() > 0) {
                    //returnString = Integer.toString(weapon.getWeaponDamage());
                    ((RangedWeapon) weapon).getAmmo();
                    weapon.useOneShot();
                    // Chance to hit
                    if (weapon.hitChance >= hitChance.nextInt(1, 100)) {
                        System.out.println("hitChance = " + hitChance);
                        System.out.println("weapon.hitChance = " + weapon.getHitChance());
                        return TryUseWeapon.YOU_HIT_TARGET_RANGED;
                    } else if (weapon.hitChance < hitChance.nextInt(1, 100)) {
                        System.out.println("hitChance = " + hitChance);
                        System.out.println("weapon.hitChance = " + weapon.getHitChance());
                        return TryUseWeapon.YOU_MISS;

                    } else {
                        return TryUseWeapon.NO_AMMO;
                    }

                }else if (weapon instanceof MeleeWeapon) {
                    returnString = Integer.toString(weapon.getWeaponDamage());
                    if (weapon.hitChance >= hitChance.nextInt(1, 100)) {
                        return TryUseWeapon.YOU_HIT_TARGET_MELEE;
                    } else if (weapon.hitChance < hitChance.nextInt(1, 100)) {
                        return TryUseWeapon.YOU_MISS;
                    }
                }
            }
        }
        return null;
    }


    public String look() {
        return getCurrentRoom().getRoomName() + "\n" + getCurrentRoom().getRoomDescription() +
                "\n" + getCurrentRoom().getRoomItems() + "\n" + getCurrentRoom().getEnemylist();
    }

    public ArrayList<Item> viewInventory() {
        return player.getPlayerInventory();
    }

    public ArrayList<Weapons> viewEquippedWeapons() {
        return player.getEquippedWeapons();
    }

    public TryOpen unlock(String doorSearch, String keySearch) {
        Item key = player.getItemFromInventory(keySearch);
        if (key != null) {
            if (key instanceof Key) {
                Direction[] directions = {Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST};
                Direction directionSaved = null;
                Door door = null;
                for (int i = 0; i < 4; i++) {
                    if (player.getCurrentRoom().getDoor(directions[i]) != null) {
                        if (player.getCurrentRoom().getDoor(directions[i]).getName().contains(doorSearch)) {
                            door = player.getCurrentRoom().getDoor(directions[i]);
                            directionSaved = directions[i];
                        }
                    }
                }
                if (door != null) {
                    if (door instanceof Door) {
                        if (door.openDoor(((Key) key).getKeyType())) {
                            returnString = door.getOpenDescription();
                            go(directionSaved);
                            returnString += player.getCurrentRoom().getRoomDescription();
                            return TryOpen.IT_OPENS;
                        } else {
                            return TryOpen.NOT_RIGHT_KEY;
                        }
                    } else {
                        return TryOpen.IS_NOT_A_DOOR;
                    }
                } else {
                    return TryOpen.CANT_FIND_DOOR;
                }
            } else {
                return TryOpen.IS_NOT_A_KEY;
            }
        } else {
            return TryOpen.DONT_HAVE_KEY;
        }
    }

    public String getAmmo() {
        for (Weapons weapon : player.getEquippedWeapons()) {
            if (weapon instanceof RangedWeapon) {
                return String.valueOf(((RangedWeapon) weapon).getAmmo());
            }
        }
        return null;
    }

    public AmmunitionType getAmmoName() {
        for (Weapons weapon : player.getEquippedWeapons()) {
            if (weapon instanceof RangedWeapon) {
                return ((RangedWeapon) weapon).getAmmoName();
            }
        }
        return null;
    }

    public BattleOutcome battle(Enemy enemy) {
        Random dice = new Random();
        dice.nextInt(1, 10);
        int theyTakeDamage = 0;
        int youTakeDamage = 0;

        BattleOutcome outcome = new BattleOutcome();

        TryUseWeapon useWeapon = useWeapon();
        if(useWeapon == TryUseWeapon.NO_AMMO){

        } else if(useWeapon == TryUseWeapon.YOU_MISS) {
            outcome.addOutcome(TryUseWeapon.THEY_MISS);
        } else if(useWeapon == TryUseWeapon.WEAPON_NOT_IN_HAND){
            outcome.addOutcome(TryUseWeapon.WEAPON_NOT_IN_HAND);
        } else if(useWeapon == TryUseWeapon.YOU_HIT_TARGET_RANGED){
            outcome.addOutcome(TryUseWeapon.YOU_HIT_TARGET_RANGED);
            theyTakeDamage = -dice.nextInt(1,player.getCurrentWeapon().get(0).weaponDamage);
            enemy.setEnemyHealth(enemy.getEnemyHealth() + theyTakeDamage);
            if (enemy.getEnemyHealth() > 0) {

                // ENEMY ATTACK BACK
                useWeapon = enemyAttack(enemy);
                switch (useWeapon) {
                    case THEY_HIT -> {
                        outcome.addOutcome(TryUseWeapon.THEY_HIT);
                        youTakeDamage = -dice.nextInt(1, enemy.getDamage());
                        player.setHealth(player.getHealth() + youTakeDamage);
                        if (player.playerDeath() == true){
                            playerDeathOutput();
                        }
                    }
                    case THEY_MISS -> {
                        outcome.addOutcome(TryUseWeapon.THEY_MISS);
                    }
                }
            } else {
                outcome.addOutcome(TryUseWeapon.ENEMY_DIES);
                getCurrentRoom().enemyDeath(enemy);
            }

        } else if (useWeapon == TryUseWeapon.YOU_HIT_TARGET_MELEE) {
            outcome.addOutcome(TryUseWeapon.YOU_HIT_TARGET_MELEE);
            theyTakeDamage = -15;
            enemy.setEnemyHealth(enemy.getEnemyHealth() + theyTakeDamage);
            if (enemy.getEnemyHealth() > 0) {

                // ENEMY ATTACK BACK
                useWeapon = enemyAttack();
                switch (useWeapon){
                    case THEY_HIT -> {
                        outcome.addOutcome(TryUseWeapon.THEY_HIT);
                        youTakeDamage = -10;
                        player.setHealth(player.getHealth() + youTakeDamage);
                        if (player.playerDeath() == true){
                            playerDeathOutput();
                        }
                    }
                    case THEY_MISS -> {
                        outcome.addOutcome(TryUseWeapon.THEY_MISS);
                    }
                }
            } else {
                outcome.addOutcome(TryUseWeapon.ENEMY_DIES);
                getCurrentRoom().enemyDeath(enemy);
            }
        }
        outcome.setEnemyDamage(theyTakeDamage);
        outcome.setPlayerDamage(youTakeDamage);
        return outcome;
    }

    public TryUseWeapon playerDeathOutput(){
        return TryUseWeapon.PLAYER_DIES;
    }

    public Enemy findEnemy(String monster) {
        for (Enemy enemy : player.getCurrentRoom().getEnemylist()) {
            if (enemy.getEnemyName().toLowerCase().equals(monster.trim())) {
                return enemy;
            }
        }
        return null;
    }

    public TryUseWeapon enemyAttack(Enemy enemy) {
        boolean hit = true;
        Random dice = new Random();
        if (dice.nextInt(1, 100) < enemy.getChanceToHit()) {
            return TryUseWeapon.THEY_HIT;
        } else {
            return TryUseWeapon.THEY_MISS;
        }
    }


}


