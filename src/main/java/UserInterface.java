import java.util.Scanner;

public class UserInterface {
    private Adventure adventure = new Adventure();

    public void start() {

        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("Go north/west/east/south");
            String choice = scan.nextLine().toLowerCase();

            switch (choice) {
                case "go north","north","n" -> {if(adventure.goNorth()){System.out.println("Going north");
                                                adventure.goNorth();}else System.out.println(); }
                case "go east","east","e" -> {System.out.println("Going east");
                                                adventure.goEast();}
                case "go south","south","s" -> {System.out.println("Going south");}
                case "go west","west","w" -> {System.out.println("Going west");}
                case "look" -> {System.out.println("Du er i " + adventure.getCurrentRoom().getRoomName() +
                        " og kigger på " + adventure.getCurrentRoom().getRoomDescription());}
                case "help" -> {System.out.println("Print hjælp ud");}
                case "exit" -> {System.exit(0);}
                default -> {System.out.println("Invalid input");}
            }
        } while (true);
    }
}

