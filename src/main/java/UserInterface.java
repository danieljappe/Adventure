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

              /*
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
                }*/

                case "look"-> {
                    //System.out.println(adventure.getCurrentRoom().getRoomDescription());
                    System.out.println(room.getRoomName());
                    System.out.println(room.getRoomDescription());
                    System.out.println(room.getRoomItems());
                }

                case "inventory" -> {
                    System.out.println(adventure.getPlayer().getPlayerInventory());
                }

                case "take" -> {
                    Item pickedUpItem = adventure.takeItem(commandParameter);
                    if (pickedUpItem == null){
                        System.out.println("Nothing");
                    } else {
                        System.out.println("You have picked up " + pickedUpItem);
                    }
                }

                case "drop" -> {
                    Item droppedItem = adventure.dropItem(commandParameter);
                    if (droppedItem == null) {
                        System.out.println("Nothing");
                    } else {
                        System.out.println("You have dropped " + droppedItem);
                    }
                }
                case "health" -> {
                    System.out.println(adventure.getHealth());
                }
                case "eat" -> {
                    //findes ikke
                    Item itemToEat = adventure.takeItem(commandParameter);
                    if(itemToEat == null){
                        itemToEat = adventure.dropItem(commandParameter);
                        if(itemToEat == null){
                            System.out.println("item not in room or inventory");
                        }
                    }
                    if(itemToEat != null){

                        if(itemToEat instanceof Food){
                            Food foodToEat = (Food) itemToEat;
                            int healthGained = adventure.eat(foodToEat);
                            System.out.println("Du får "+ healthGained+" health point");
                        }
                        //TODO is item food???

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

