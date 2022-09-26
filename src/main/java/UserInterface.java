import java.util.Scanner;

public class UserInterface {
    public void start() {
        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("Type \"North\" / \"East\" / \"South\" / \"West\"");
            String choice = scan.nextLine();

            switch (choice) {
                case "north" -> System.out.println("Going north");
                case "east" -> System.out.println("Going east");
                case "south" -> System.out.println("Going south");
                case "west" -> System.out.println("Going west");
                case "exit" -> System.exit(0);
                default -> System.out.println("Invalid input");
            }
        } while (true);
    }
}

