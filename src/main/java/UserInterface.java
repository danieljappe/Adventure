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
            String choice = scan.nextLine().toLowerCase();
            String itemWant = null;
            if(choice.contains("take")){//TODO find en bedre måde
                itemWant = choice;
                choice = "take";
                System.out.println("CHOICE TAKE KØRER");
                System.out.println(itemWant);
            }
            switch (choice) {
                case "go north", "north", "n" -> {
                    Room currentRoom = adventure.getCurrentRoom();
                    if (adventure.go('n')) {
                        System.out.println("\u001B[32mGoing north\u001B[39m");
                        System.out.println(currentRoom.getNorthDescription());
                        currentRoom = adventure.getCurrentRoom();
                        System.out.println(currentRoom.getRoomDescription());

                    } else {
                        System.out.println("\u001B[31mCan´t go that way\u001B[39m");
                    }
                }

                case "go east", "east", "e" -> {
                    Room currentRoom = adventure.getCurrentRoom();
                    if (adventure.go('e')) {
                        System.out.println("\u001B[32mGoing south\u001B[39m");
                        System.out.println(currentRoom.getEastDescription());
                        currentRoom = adventure.getCurrentRoom();
                        System.out.println(currentRoom.getRoomDescription());
                    } else {
                        System.out.println("\u001B[31mCan´t go that way\u001B[39m");
                    }
                    //System.out.println(adventure.go('e'));
                }

                case "go south", "south", "s" -> {
                    Room currentRoom = adventure.getCurrentRoom();
                    if (adventure.go('s')) {
                        System.out.println("\u001B[32mGoing south\u001B[39m");
                        System.out.println(currentRoom.getSouthDescription());
                        currentRoom = adventure.getCurrentRoom();
                        System.out.println(currentRoom.getRoomDescription());
                    } else {
                        System.out.println("\u001B[31mCan´t go that way\u001B[39m");
                    }
                }


                case "go west", "west", "w" -> {
                    Room currentRoom = adventure.getCurrentRoom();
                    if (adventure.go('w')) {
                        System.out.println("\u001B[32mGoing west\u001B[39m");
                        System.out.println(currentRoom.getWestDescription());
                        currentRoom = adventure.getCurrentRoom();
                        System.out.println(currentRoom.getRoomDescription());
                    } else {
                        System.out.println("\u001B[31mCan´t go that way\u001B[39m");
                    }
                }

                case "look"-> {
                    //System.out.println(adventure.getCurrentRoom().getRoomDescription());
                    System.out.println(adventure.getCurrentRoom().getRoomItems());
                }

                case "inventory" -> {
                    System.out.println(adventure.getPlayer().getPlayerInventory());
                }

                case "take" -> {
                    System.out.println("TAKE MENU");
                    //System.out.println("what do you want to take?");
                    //choice = scan.nextLine().toLowerCase();
                    if(adventure.getCurrentRoom().isInRoom(itemWant)){
                        System.out.println("ER I RUM");
                        Item item = adventure.getCurrentRoom().takeItem(itemWant);
                        adventure.getPlayer().addToInventory(item);
                    } else {
                        System.out.println("INTET FUNDET");
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

