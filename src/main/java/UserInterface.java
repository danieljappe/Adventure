import java.util.Scanner;

public class UserInterface {
    public void start() {
        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("Type \"go north\" / \"go east\" / \"go south\" / \"go west\"");
            String choice = scan.nextLine();

            switch (choice) {
                case "go north" -> System.out.println("Going north");
                case "go east" -> System.out.println("Going east");
                case "go south" -> System.out.println("Going south");
                case "go west" -> System.out.println("Going west");
                case "look" -> System.out.println("Kigger rundt i rum");
                case "help" -> System.out.println("Print hjælp ud");
                case "exit" -> System.exit(0);
                default -> System.out.println("Invalid input");
            }
        } while (true);
    }
}

