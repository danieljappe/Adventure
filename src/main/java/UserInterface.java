import java.util.Scanner;

public class UserInterface {
    private Adventure adventure = new Adventure();

    public void start() {
        Scanner scan = new Scanner(System.in);

        System.out.println(adventure.getMap().storyLine(0));
        System.out.println(adventure.getMap().storyLine(100));
        if(adventure.getCurrentRoom().getEnemylist().size()>0){
            System.out.println("Out of the shadows emerges a horrific "+adventure.getCurrentRoom().getEnemylist()+
                    " and its heading right for you.");
        }
        System.out.println("To get help, type \u001B[35m\"help\u001B[39m\"");
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
                            System.out.println("Invalid input");
                        }
                    }
                    if(direction==null) break;
                    TryGo outcome = adventure.go(direction);
                    if(outcome == TryGo.GOING){
                        System.out.println("\u001B[32mGoing "+commandParameter+"\u001B[39m");
                        System.out.print(adventure.getCurrentRoom().getRoomDescription());
                        if(adventure.getCurrentRoom().getEnemylist().size()>0){
                            System.out.println("Out of the shadows emerges a horrific "+adventure.getCurrentRoom().getEnemylist()+
                                    " and its heading right for you.");
                        }
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
                    //TODO if (adventure.viewEquippedWeapons() instanceof RangedWeapon)
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
                    if (adventure.getPlayer().getEquippedWeapons().size() == 0) {
                        System.out.println("You have no weapon equipped");
                    }
                        else if (enemy != null && adventure.getPlayer().getEquippedWeapons().size() > 0) {
                            boolean inBattle = true;
                            String weapon = adventure.getPlayer().getEquippedWeapons().get(0).getItemName();
                            AmmunitionType ammo = adventure.getPlayer().getEquippedWeapons().get(0).getAmmoName();
                            while (inBattle) {
                                BattleOutcome outcome = adventure.battle(enemy);

                                for (TryUseWeapon message : outcome.getOutComeList()) {
                                    switch (message) {
                                        case WEAPON_NOT_IN_HAND -> {
                                            System.out.println("You have not equipped a weapon");
                                            inBattle = false;
                                        }
                                        case YOU_HIT_TARGET_MELEE -> {
                                            System.out.println("You swing your " + weapon +
                                                    " hitting the " + enemy.getEnemyName() + ", giving it "
                                                    + outcome.getEnemyDamage() + " point of damage");
                                        }
                                        case YOU_HIT_TARGET_RANGED -> {
                                            System.out.println("You fire a shot with your " + weapon +
                                                    " and hit the " + enemy.getEnemyName() + ", dealing it "
                                                    + outcome.getEnemyDamage() + " point of damage");
                                        }
                                        case YOU_MISS -> {
                                            System.out.println("So close, but you barely miss the " + enemy.getEnemyName());
                                        }
                                        case NO_AMMO -> {
                                            System.out.println("Oh no you ran out of " + ammo.toString() +
                                                    " you wasted your turn ");
                                        }
                                        case YOU_RELOAD -> {
                                            System.out.println("You reload");
                                        }
                                        case YOU_EAT -> {
                                        }
                                        case PLAYER_DIES -> {
                                            System.out.println("\u001B[0m\n" +
                                                    "                         \u001B[31m▄\u001B[37m   \u001B[31m▄\u001B[37m            \u001B[31m▄▄▄\u001B[37m\n" +
                                                    "                         \u001B[31m▀█\u001B[37m \u001B[31m█▀\u001B[37m \u001B[31m▄▄\u001B[37m  \u001B[31m▄\u001B[37m  \u001B[31m▄\u001B[37m   \u001B[31m█\u001B[37m  \u001B[31m▀▄\u001B[37m \u001B[31m▀\u001B[37m         \u001B[31m█\u001B[37m\n" +
                                                    "                          \u001B[31m▀█▀\u001B[37m \u001B[31m█\u001B[37m  \u001B[31m█\u001B[37m \u001B[31m█\u001B[37m  \u001B[31m█\u001B[37m   \u001B[31m█\u001B[37m   \u001B[31m█\u001B[37m \u001B[31m▄\u001B[37m \u001B[31m█▀▀▄\u001B[37m  \u001B[31m▄▄█\u001B[37m\n" +
                                                    "                           \u001B[31m█\u001B[37m  \u001B[31m█\u001B[37m  \u001B[31m█\u001B[37m \u001B[31m█\u001B[37m  \u001B[31m█\u001B[37m   \u001B[31m█\u001B[37m  \u001B[31m▄▀\u001B[37m \u001B[31m█\u001B[37m \u001B[31m█▀▀\u001B[37m  \u001B[31m█\u001B[37m  \u001B[31m█\u001B[37m\n" +
                                                    "           \u001B[31m▄█▀▀▀▀▀█▄\u001B[37m       \u001B[31m▀\u001B[37m   \u001B[31m▀▀\u001B[37m   \u001B[31m▀▀\u001B[37m    \u001B[31m▀▀▀\u001B[37m   \u001B[31m▀\u001B[37m  \u001B[31m▀▀▀\u001B[37m  \u001B[31m▀▀\u001B[37m \u001B[31m▀\u001B[37m\n" +
                                                    "          \u001B[31m▄█\u001B[37m       \u001B[31m▀█\u001B[37m\n" +
                                                    "          \u001B[31m█\u001B[37m           \u001B[31m▄█▀▀█▄\u001B[37m\n" +
                                                    "          \u001B[31m█\u001B[37m           \u001B[31m▀\u001B[37m    \u001B[31m█\u001B[37m   \u001B[31m███▄█▀█\u001B[37m                ▄████\u001B[1;47m▀\u001B[40m█\u001B[0m▄▄\n" +
                                                    "          \u001B[31m█\u001B[37m    \u001B[31m▄▄▄\u001B[37m         \u001B[31m█\u001B[37m  \u001B[31m█▀\u001B[37m  \u001B[31m█▀\u001B[37m  \u001B[31m█\u001B[37m \u001B[31m▄█▀▀█▄\u001B[37m       ███▀███▀███\n" +
                                                    "          \u001B[31m█\u001B[37m      \u001B[31m▀▀█\u001B[37m  \u001B[31m█▀▀▀██\u001B[37m  \u001B[31m█\u001B[37m   \u001B[31m▀\u001B[37m   \u001B[31m█\u001B[37m \u001B[31m█▄\u001B[37m  \u001B[31m▄█\u001B[37m       ██   █   \u001B[1;47m▄\u001B[0m█\n" +
                                                    "          \u001B[31m▀▄\u001B[37m       \u001B[31m█\u001B[37m  \u001B[31m█\u001B[37m   \u001B[31m▄█▄\u001B[37m \u001B[31m█\u001B[37m       \u001B[31m█\u001B[37m \u001B[31m█\u001B[37m \u001B[31m▀▀▀\u001B[37m     \u001B[1m▄\u001B[47m▀\u001B[0m \u001B[1m▀\u001B[0m█▄▄█▀█▄\u001B[1m▄█\u001B[0m▀ \u001B[1;47m▀\u001B[40m▄\u001B[0m\n" +
                                                    "           \u001B[31m▀▀█▄▄▄▄█▀\u001B[37m  \u001B[31m▀█▄▄█\u001B[37m \u001B[31m█\u001B[37m \u001B[31m█\u001B[37m       \u001B[31m█\u001B[37m \u001B[31m▀█▄\u001B[37m  \u001B[31m▄█\u001B[37m     ▀   \u001B[1;47m▄\u001B[0m▀\u001B[1;47m▄\u001B[0m▀\u001B[1;47m▄\u001B[0m   ▀\n" +
                                                    "         ▄▄▄▄▄▄▄▄▄▄▄                      \u001B[31m▀▀▀▀\u001B[37m         \u001B[1m▄\u001B[0m \u001B[1m▄\u001B[0m \u001B[1m▄\u001B[0m ▄\n" +
                                                    "         █\u001B[1;30;47m▄▄\u001B[0m████████                                 ▄ ▀█\u001B[1;47m▀\u001B[0m███▀ ▄\n" +
                                                    "         █\u001B[1;30m█\u001B[0m█\u001B[1;30m█\u001B[0m█\u001B[1;30;47m▀\u001B[0m█\u001B[1;30m█\u001B[47m▀▄\u001B[0m█       \u001B[31m▄█▀▀▀▀▀▀█\u001B[37m               \u001B[1m▀\u001B[47m▄\u001B[0m           \u001B[1m█▀\u001B[0m\n" +
                                                    "         █\u001B[1;30m█\u001B[47m▀▄\u001B[0m█\u001B[1;30m█\u001B[0m█\u001B[1;30m█\u001B[47m▀\u001B[0m██       \u001B[31m█\u001B[37m        \u001B[31m█\u001B[37m\n" +
                                                    "         █\u001B[1;30;47m▀\u001B[0m█\u001B[1;30;47m▀\u001B[0m█\u001B[1;30;47m▀\u001B[0m█\u001B[1;30;47m▀\u001B[0m███      \u001B[31m█▀\u001B[37m        \u001B[31m▀█\u001B[37m \u001B[31m▄\u001B[37m          \u001B[31m▄▄▄\u001B[37m   \u001B[31m▄\u001B[37m  \u001B[31m▄▄\u001B[37m\n" +
                                                    "         ███████████      \u001B[31m█\u001B[37m          \u001B[31m█\u001B[37m  \u001B[31m█\u001B[37m     \u001B[31m█\u001B[37m \u001B[31m█▀\u001B[37m   \u001B[31m█\u001B[37m  \u001B[31m█▄▀\u001B[37m \u001B[31m▀▀\u001B[37m\n" +
                                                    "         ███████████      \u001B[31m█\u001B[37m          \u001B[31m█\u001B[37m   \u001B[31m█\u001B[37m   \u001B[31m▄█\u001B[37m \u001B[31m█▀▄▄▄▀\u001B[37m  \u001B[31m█\u001B[37m\n" +
                                                    "         ███████████      \u001B[31m█\u001B[37m          \u001B[31m█\u001B[37m   \u001B[31m█\u001B[37m   \u001B[31m█\u001B[37m  \u001B[31m█\u001B[37m       \u001B[31m█\u001B[37m\n" +
                                                    "       \u001B[1;30m▄▄\u001B[47m▄▄▄▄▄▄▄▄▄▄▄\u001B[40m▄▄\u001B[0m    \u001B[31m▀█\u001B[37m        \u001B[31m█▀\u001B[37m   \u001B[31m▀█\u001B[37m \u001B[31m▄▀\u001B[37m  \u001B[31m█▄\u001B[37m   \u001B[31m▄█\u001B[37m \u001B[31m█\u001B[37m\n" +
                                                    "       \u001B[1;30m███████████████\u001B[0m     \u001B[31m▀▀█▄▄▄▄▄▄▀\u001B[37m      \u001B[31m█▀\u001B[37m    \u001B[31m▀▀▀▀▀\u001B[37m  \u001B[31m▀\u001B[37m\n" +
                                                    "       \u001B[1;30m███████████████\u001B[0m\n" +
                                                    "       \u001B[1;30m███████████████\u001B[0m");
                                            System.exit(0);
                                        }
                                        case THEY_HIT -> {
                                            System.out.println("The " + enemy.getEnemyName() + " got you, and it deals you " +
                                                    outcome.getPlayerDamage() + " points of damage ");
                                        }
                                        case THEY_MISS -> {
                                            System.out.println("The " + enemy.getEnemyName() + " attacks, but it misses you");
                                        }
                                        case ENEMY_DIES -> {
                                            System.out.println("You managed to kill the " + enemy.getEnemyName());
                                            inBattle = false;
                                        }

                                    }
                                }
                                System.out.println("\nYou now have " + adventure.getPlayer().getHealth() + "hp");
                                if (enemy.getEnemyHealth() > 0) {
                                    System.out.println("Enemy now has " + enemy.getEnemyHealth() + "hp");
                                }
                                System.out.println("\nTo continue press enter\nTo reload type reload\n" +
                                        "To run type run");
                                choice = scan.nextLine();
                                switch (choice) {
                                    case "run" -> {
                                        System.out.println("You ran away from the fight");
                                        inBattle = false;
                                    }
                                    case "reload" -> {
                                        adventure.reloadWeapon();
                                    }

                                }

                            }

                        } else {
                            System.out.println("There is no " + commandParameter + " in the room");
                        }//TODO mulighed for at skyde blindt


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

                case  "unlock", "open","light","illuminate" -> {
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
                        case IT_OPENS -> {
                            System.out.println(adventure.getReturnString());
                            if(adventure.getCurrentRoom().getEnemylist().size()>0){
                                System.out.println("Out of the shadows emerges a horrific "+adventure.getCurrentRoom().getEnemylist()+
                                        " and its heading right for you.");
                            }
                        }
                    }

                }

                case "help" -> {
                    System.out.println("\u001B[35m\"look\"\u001B[39m to get a description of the room.\n" +
                            "\u001B[35m\"inventory\" or \"inv\"\u001B[39m to look in your backpack, see equipped weapons and ammunition.\n" +
                            "\u001B[35m\"take\"\u001B[39m to pick up an item.\n" +
                            "\u001B[35m\"equip\"\u001B[39m to equip a weapon.\n" +
                            "\u001B[35m\"unequip\"\u001B[39m to unequip equipped weapon.\n" +
                            "\u001B[35m\"attack, \"shoot\", \"fire\", \"throw\", \"swing\", \"stab\"\u001B[39m to attack an enemy.\n" +
                            "\u001B[35m\"drop\"\u001B[39m to drop an item from inventory.\n" +
                            "\u001B[35m\"health\" or \"hp\"\u001B[39m to view players health points.\n" +
                            "\u001B[35m\"eat\"\u001B[39m to eat an edible item to gain health points.\n" +
                            "\u001B[35m\"unlock\" or \"open\"\u001B[39m to open doors.");
                }

                case "exit" -> {
                    System.exit(0);
                }


                default -> {
                    System.out.println("Invalid input");
                }
            }
        } while (true);
    }
}


