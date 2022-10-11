import java.util.Scanner;

public class UserInterface {
    private Adventure adventure = new Adventure();


    public void start() {
        Scanner scan = new Scanner(System.in);

        System.out.println(adventure.getMap().storyLine(0));
        System.out.println(adventure.getMap().storyLine(100));
        do {
            System.out.println("\u001B[35mGo north/west/east/south\u001B[39m");

            String choice = scan.nextLine();

            String[] userInputList = choice.split(" ");
            String command = userInputList[0];
            String commandParameter = "";
            String secondParameter = "";
            if (userInputList.length > 1) {
                commandParameter = userInputList[1];
                if(userInputList.length >2){
                    secondParameter = userInputList[userInputList.length-1];
                }
            }

            switch (command) {
                case "go" -> {
                    Direction direction = null;
                    switch (commandParameter){
                        case "n","north","up" -> direction = Direction.NORTH;
                        case "s","south","down" -> direction = Direction.SOUTH;
                        case "e","east" -> direction = Direction.EAST;
                        case "w","west" -> direction = Direction.WEST;
                        default -> {
                            System.out.println("invalid indput");
                        }
                    }
                    if(direction==null) break;
                    TryGo outcome = adventure.go(direction);
                    if(outcome == TryGo.GOING){
                        System.out.println("\u001B[32mGoing "+commandParameter+"\u001B[39m");
                        System.out.println(adventure.getCurrentRoom().getRoomDescription());
                    }else if( outcome == TryGo.CANT_GO){
                        System.out.println("\u001B[31mCan´t go that way\u001B[39m");
                    }else if( outcome == TryGo.IS_LOCKED){
                        System.out.println(adventure.getReturnString());
                    }
                }

                case "look"-> {
                    System.out.println(adventure.look());
                }

                case "inventory", "inv", "ammo" -> {
                    System.out.println("Backpack: " + adventure.viewInventory());
                    System.out.println("Equipped weapons: " + adventure.viewEquippedWeapons());
                    System.out.println("Ammunition: " + adventure.getAmmo() + " " + adventure.getAmmoName());

                }

                case "take" -> {
                    Item pickedUpItem = adventure.takeItemFromRoom(commandParameter);
                    if (pickedUpItem == null){
                        System.out.println("Nothing was picked up");
                    } else {
                        System.out.println("You have picked up the " + pickedUpItem);
                    }
                }

                case "equip" -> {
                    TryEquipWeapon equipWeapon = adventure.equipWeapon(commandParameter);
                    if (equipWeapon == TryEquipWeapon.ITEM_NOT_FOUND) {
                        System.out.println(commandParameter+" is not in inventory");
                    } else if (equipWeapon == TryEquipWeapon.NOT_WEAPON){
                        System.out.println(commandParameter + " is not a weapon");
                    } else if (equipWeapon == TryEquipWeapon.IS_WEAPON){
                        System.out.println("You have equipped " + commandParameter);
                    } else if (equipWeapon == TryEquipWeapon.ALREADY_TWO_WEAPONS){
                        System.out.println("You already have a weapon equipped, unequip the weapon");
                    }
                }

                case "unequip" -> {
                    TryEquipWeapon unEquipWeapon = adventure.unEquipWeapon(commandParameter);
                    if (unEquipWeapon == TryEquipWeapon.ITEM_NOT_FOUND) {
                        System.out.println(commandParameter+" is not found or equipped");
                    } else if (unEquipWeapon == TryEquipWeapon.IS_WEAPON) {
                        System.out.println(commandParameter + " is unequipped and added to backpack");

                    }
                }
                case "attack","shoot","fire","throw","swing","stab" -> {
                    Enemy enemy = adventure.findEnemy(commandParameter);
                    if(enemy!=null) {
                        boolean inBattle = true;
                        while (inBattle) {
                            adventure.battle(enemy);
                        }
                    }else {
                        System.out.println("There is no "+commandParameter+" in the room");
                    }

                    /*TryUseWeapon useWeapon = adventure.useWeapon();
                    if(useWeapon == TryUseWeapon.NO_AMMO){
                        System.out.println("No more " + adventure.getAmmoName() + " for your "+adventure.viewEquippedWeapons()+
                                "\nTry to reload, or use another weapon");
                    } else if(useWeapon == TryUseWeapon.YOU_MISS) {
                        System.out.println("You almost hit the target, but you missed ");
                    } else if(useWeapon == TryUseWeapon.WEAPON_NOT_IN_HAND){
                        System.out.println("You are not holding the "+adventure.viewEquippedWeapons()+" in your hand right now\n"+
                        "Try to equip the "+ commandParameter +" if you already picked it up");
                    } else if(useWeapon == TryUseWeapon.YOU_HIT_TARGET_RANGED){
                        System.out.println("The "+adventure.viewEquippedWeapons()+" makes a perfect hit\n" +
                                "The monster loses "+adventure.getReturnString()+" hitpoints\n" +
                                "You have " + adventure.getAmmo() + " " + adventure.getAmmoName());
                    } else if(useWeapon == TryUseWeapon.YOU_HIT_TARGET_MELEE){
                        System.out.println("The "+adventure.viewEquippedWeapons()+" makes a perfect hit\n" +
                                "The monster loses "+adventure.getReturnString()+" hitpoints\n");
                    }*/
                }


                case "drop" -> {
                    Item droppedItem = adventure.dropItem(commandParameter);
                    if (droppedItem == null) {
                        System.out.println("Nothing was dropped");
                    } else {
                        System.out.println("You have dropped " + droppedItem);
                    }
                }

                case "health", "hp" -> {
                    System.out.println(adventure.getHealth());
                }

                case "eat" -> {
                    TryEatResponse eat = adventure.tryToEat(commandParameter);
                    if(eat == TryEatResponse.FOOD_NOT_FOUND){
                        System.out.println("Can't find the "+commandParameter);
                    }else if(eat == TryEatResponse.IS_NOT_FOOD){
                        System.out.println("The "+commandParameter+" is not eatable");
                    }else if(eat == TryEatResponse.YOU_EAT){
                        System.out.println("You eat the "+commandParameter+" and gain "+ adventure.getReturnString()+
                                " points of health");
                    }
                }
                case  "unlock", "open" -> {
                    TryOpen tryOpen = adventure.unlock(commandParameter, secondParameter);
                    switch (tryOpen){
                        case CANT_FIND_DOOR -> System.out.println("Cannot find the "+ commandParameter+ " you " +
                                "wamted to open");
                        case DONT_HAVE_KEY -> System.out.println("You dont have the "+secondParameter+" in your" +
                                "inventory");
                        case IS_NOT_A_DOOR -> System.out.println("The "+commandParameter+" cant be opend");
                        case IS_NOT_A_KEY -> System.out.println("The "+ secondParameter+" cant be used to open " +
                                "anything with");
                        case NOT_RIGHT_KEY -> System.out.println("You try to open the "+ commandParameter+ " with" +
                                "the "+secondParameter+",\nbut unfortunately it doesn't work ");
                        case IT_OPENS -> System.out.println(adventure.getReturnString());
                    }

                }

                case "help" -> {
                    System.out.println("Print hjælp ud");
                }

                case "exit" -> {
                    System.exit(0);
                }
                case "attac" -> {
                    adventure.battle()
                }

                default -> {
                    System.out.println("Invalid input");
                }
            }
        } while (true);
    }
}


