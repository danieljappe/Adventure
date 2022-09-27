import java.util.Scanner;

public class UserInterface {
    private Adventure adventure = new Adventure();

    public void start() {

        Scanner scan = new Scanner(System.in);


        do {
            System.out.println("Go north/west/east/south");
            String choice = scan.nextLine().toLowerCase();

            switch (choice) {
                case "go north", "north", "n" -> {
                    if (adventure.goNorth()) {
                        System.out.println("Going north");
                        System.out.println(adventure.getCurrentRoom().getRoomDescription());
                    } else {
                        System.out.println("Can´t go that way");
                    }
                }

                case "go east", "east", "e" -> {
                    if (adventure.goEast()) {
                        System.out.println("Going east");
                        System.out.println(adventure.getCurrentRoom().getRoomDescription());
                    } else {
                        System.out.println("Can´t go that way");
                    }
                }

                case "go south", "south", "s" -> {
                    if (adventure.goSouth()) {
                        System.out.println("Going south");
                        System.out.println(adventure.getCurrentRoom().getRoomDescription());
                    } else {
                        System.out.println("Can´t go that way");
                    }
                }


                case "go west", "west", "w" -> {
                    if (adventure.goWest()) {
                        System.out.println("Going west");
                        System.out.println(adventure.getCurrentRoom().getRoomDescription());
                    } else {
                        System.out.println("Can´t go that way");
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

