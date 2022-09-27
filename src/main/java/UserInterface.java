import java.util.Scanner;

public class UserInterface {
    private Adventure adventure = new Adventure();

    public void start() {
        Scanner scan = new Scanner(System.in);
        System.out.println(adventure.storyLine(0));
        System.out.println(adventure.storyLine(1));
        do {
            System.out.println("Go north/west/east/south");
            String choice = scan.nextLine().toLowerCase();

            switch (choice) {
                case "go north", "north", "n" -> {
                    if (adventure.goNorth()) {
                        System.out.println("\u001B[32mGoing north\u001B[39m");
                        System.out.println(adventure.getCurrentRoom().getRoomDescription());
                    } else {
                        System.out.println("\u001B[31mCan´t go that way\u001B[39m");
                    }
                }

                case "go east", "east", "e" -> {
                    if (adventure.goEast()) {
                        System.out.println("\u001B[32mGoing east\u001B[39m");
                        System.out.println(adventure.getCurrentRoom().getRoomDescription());
                    } else {
                        System.out.println("\u001B[31mCan´t go that way\u001B[39m");
                    }
                }

                case "go south", "south", "s" -> {
                    if (adventure.goSouth()) {
                        System.out.println("\u001B[32mGoing south\u001B[39m");
                        System.out.println(adventure.getCurrentRoom().getRoomDescription());
                    } else {
                        System.out.println("\u001B[31mCan´t go that way\u001B[39m");
                    }
                }


                case "go west", "west", "w" -> {
                    if (adventure.goWest()) {
                        System.out.println("\u001B[32mGoing west\u001B[39m");
                        System.out.println(adventure.getCurrentRoom().getRoomDescription());
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

