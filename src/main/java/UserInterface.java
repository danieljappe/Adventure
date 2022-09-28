import java.util.Scanner;

public class UserInterface {
    private Adventure adventure = new Adventure();


    public void start() {
        Scanner scan = new Scanner(System.in);
        System.out.println(adventure.getMap().storyLine(0));
        System.out.println(adventure.getMap().storyLine(1));
        do {
            System.out.println("\u001B[35mGo north/west/east/south\u001B[39m");
            String choice = scan.nextLine().toLowerCase();

            switch (choice) {
                case "go north", "north", "n" -> {
                    Room currentRoom = adventure.getCurrentRoom();
                    if (adventure.go('n')) {
                        System.out.println("\u001B[32mGoing north\u001B[39m");
                        System.out.println(currentRoom.getNorthDescription());
                    } else {
                        System.out.println("\u001B[31mCan´t go that way\u001B[39m");
                    }
                }

                case "go east", "east", "e" -> {
                    Room currentRoom = adventure.getCurrentRoom();
                    if (adventure.go('e')) {
                        System.out.println("\u001B[32mGoing east\u001B[39m");
                        System.out.println(currentRoom.getEastDescription());
                    } else {
                        System.out.println("\u001B[31mCan´t go that way\u001B[39m");
                    }
                }

                case "go south", "south", "s" -> {
                    if (adventure.go('s')) {
                        Room currentRoom = adventure.getCurrentRoom();
                        System.out.println("\u001B[32mGoing south\u001B[39m");
                        System.out.println(currentRoom.getSouthDescription());
                    } else {
                        System.out.println("\u001B[31mCan´t go that way\u001B[39m");
                    }
                }


                case "go west", "west", "w" -> {
                    Room currentRoom = adventure.getCurrentRoom();
                    if (adventure.go('w')) {
                        System.out.println("\u001B[32mGoing west\u001B[39m");
                        System.out.println(currentRoom.getWestDescription());
                    } else {
                        System.out.println("\u001B[31mCan´t go that way\u001B[39m");
                    }
                }

                case "look" -> {
                    System.out.println(adventure.getCurrentRoom().getRoomDescription());
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

