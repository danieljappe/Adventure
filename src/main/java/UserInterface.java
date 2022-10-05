import java.util.Scanner;

public class UserInterface {
    private Adventure adventure = new Adventure();


    public void start() {
        Scanner scan = new Scanner(System.in);
        Room room = adventure.getCurrentRoom();

        System.out.println(adventure.getMap().storyLine(0));
        System.out.println(adventure.getMap().storyLine(100));
        do {
            System.out.println("\u001B[35mGo north/west/east/south\u001B[39m");

            String choice = scan.nextLine();

            String[] userInputList = choice.split(" ");
            String command = userInputList[0];
            String commandParameter = "";
            String obstacle = "";
            if (userInputList.length > 1) {
                commandParameter = userInputList[1];
                if(userInputList.length >2){
                    obstacle = userInputList[userInputList.length-1];
                }
            }

            switch (command) {
                case "go" -> {
                    if(adventure.go(commandParameter)){
                        System.out.println("\u001B[32mGoing "+commandParameter+"\u001B[39m");
                    }else{
                        System.out.println("\u001B[31mCan´t go that way\u001B[39m");
                    }
                }

                case "look"-> {
                    System.out.println(adventure.look());
                }

                case "inventory" -> {
                    System.out.println(adventure.viewInventory());
                }

                case "take" -> {
                    Item pickedUpItem = adventure.takeItemFromRoom(commandParameter);
                    if (pickedUpItem == null){
                        System.out.println("Nothing was picked up");
                    } else {
                        System.out.println("You have picked up " + pickedUpItem);
                    }
                }

                case "drop" -> {
                    Item droppedItem = adventure.dropItem(commandParameter);
                    if (droppedItem == null) {
                        System.out.println("Nothing was dropped");
                    } else {
                        System.out.println("You have dropped " + droppedItem);
                    }
                }
                case "health" -> {
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
                case "use" -> {
                    //System.out.println(adventure.use(commandParameter,obstacle));
                    Item keyItem;
                    keyItem = adventure.getPlayer().getItemFromInventory(commandParameter);
                    if(keyItem == null){
                        System.out.println("You don't have that item");
                    }else{
                        char[] nsew ={'n','s','e','w'};
                        Door door = null;
                        for(int i =0; i<nsew.length;i++) {
                            if (adventure.getCurrentRoom().getDoor(nsew[i]).getName().contains(obstacle.toLowerCase().trim())) {
                                door = adventure.getCurrentRoom().getDoor(nsew[i]);
                            }
                        }
                        if(door == null){
                            System.out.println("cant find "+obstacle);
                        }else{
                            if(door.openDoor(keyItem)){
                                System.out.println(door.getOpenDescription());
                            }else {
                                System.out.println("You try it,\nbut it doesn't work ");
                            }
                        }
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

