import java.util.ArrayList;
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
            String direction = "";
            if (userInputList.length > 1) {
                direction = userInputList[1];
            }

            switch (command) {
                case "go north", "north", "n" -> {

                    if (adventure.isRoom('n')) {
                        System.out.println("\u001B[32mGoing north\u001B[39m");
                        System.out.println(adventure.getCurrentRoom().getNorthDescription());
                        if(adventure.getCurrentRoom().getDoor('n').isOpen()) {
                            adventure.go('n');
                            System.out.println(adventure.getCurrentRoom().getRoomDescription());
                        }else{
                            System.out.println(adventure.getCurrentRoom().getDoor('n').getClosedDescription());
                            //TODO make option to use key
                        }
                    } else {
                        System.out.println("\u001B[31mCan´t go that way\u001B[39m");
                    }
                }

                case "go east", "east", "e" -> {
                    if (adventure.isRoom('e')) {
                        System.out.println("\u001B[32mGoing east\u001B[39m");
                        System.out.println(adventure.getCurrentRoom().getEastDescription());
                        if(adventure.getCurrentRoom().getDoor('e').isOpen()) {
                            adventure.go('e');
                            System.out.println(adventure.getCurrentRoom().getRoomDescription());
                        }else{
                            System.out.println(adventure.getCurrentRoom().getDoor('e').getClosedDescription());
                            //TODO make option to use key
                        }
                    } else {
                        System.out.println("\u001B[31mCan´t go that way\u001B[39m");
                    }
                }

                case "go south", "south", "s" -> {
                    if (adventure.isRoom('s')) {
                        System.out.println("\u001B[32mGoing south\u001B[39m");
                        System.out.println(adventure.getCurrentRoom().getSouthDescription());
                        if(adventure.getCurrentRoom().getDoor('s').isOpen()) {
                            adventure.go('s');
                            System.out.println(adventure.getCurrentRoom().getRoomDescription());
                        }else{
                            System.out.println(adventure.getCurrentRoom().getDoor('s').getClosedDescription());
                            //TODO make option to use key
                        }
                    } else {
                        System.out.println("\u001B[31mCan´t go that way\u001B[39m");
                    }
                }

                case "go west", "west", "w" -> {
                    if (adventure.isRoom('w')) {
                        System.out.println("\u001B[32mGoing west\u001B[39m");
                        System.out.println(adventure.getCurrentRoom().getWestDescription());
                        if(adventure.getCurrentRoom().getDoor('w').isOpen()) {
                            adventure.go('w');
                            System.out.println(adventure.getCurrentRoom().getRoomDescription());
                        }else{
                            System.out.println(adventure.getCurrentRoom().getDoor('w').getClosedDescription());
                            //TODO make option to use key
                        }
                    } else {
                        System.out.println("\u001B[31mCan´t go that way\u001B[39m");
                    }
                }

                case "look"-> {
                    //System.out.println(adventure.getCurrentRoom().getRoomDescription());
                    System.out.println(adventure.getCurrentRoom().getRoomName());
                    System.out.println(adventure.getCurrentRoom().getRoomDescription());
                    System.out.println(adventure.getCurrentRoom().getRoomItems());
                }

                case "inventory" -> {
                    System.out.println(adventure.getPlayer().getPlayerInventory());
                }

                case "take" -> {
                    Item pickedUpItem = adventure.getPlayer().getCurrentRoom().removeItem(direction);
                    if (pickedUpItem == null){
                        System.out.println("Nothing");
                    } else {
                        System.out.println("You have picked up " + pickedUpItem);
                        adventure.getPlayer().addToInventory(pickedUpItem);
                    }
                }

                case "help" -> {
                    System.out.println("Print hjælp ud");
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

