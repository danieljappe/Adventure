public class Adventure {

    public Adventure() {
        setupRooms();
    }

    Room room1 = new Room("room1", storyLine(1));
    Room room2 = new Room("room2", storyLine(2));
    Room room3 = new Room("room3", storyLine(3));
    Room room4 = new Room("room4", storyLine(4));
    Room room5 = new Room("room5", "room5 description");
    Room room6 = new Room("room6", storyLine(6));
    Room room7 = new Room("room7", storyLine(7));
    Room room8 = new Room("room8", storyLine(8));
    Room room9 = new Room("room9", storyLine(9));


    public void setupRooms() {
        room1.setEast(room2);
        room1.setSouth(room4);


        room2.setWest(room1);
        room2.setEast(room3);

        room3.setSouth(room6);
        room3.setWest(room2);

        room4.setNorth(room1);
        room4.setSouth(room7);

        room5.setSouth(room8);

        room6.setSouth(room9);
        room6.setNorth(room3);

        room7.setNorth(room4);
        room7.setEast(room8);

        room8.setWest(room7);
        room8.setEast(room9);
        room8.setNorth(room5);

        room9.setWest(room8);
        room9.setNorth(room6);
    }

    Room currentRoom = room1;

    public Room getCurrentRoom() {
        return currentRoom;
    }


    public boolean goNorth() {
        if (currentRoom.getNorth() == null) {
            return false;
        } else {
            currentRoom = currentRoom.getNorth();
            return true;
        }
    }

    public boolean goEast() {
        if (currentRoom.getEast() == null) {
            return false;
        } else {
            currentRoom = currentRoom.getEast();
            return true;
        }
    }

    public boolean goSouth() {
        if (currentRoom.getSouth() == null) {
            return false;
        } else {
            currentRoom = currentRoom.getSouth();
            return true;
        }
    }

    public boolean goWest() {
        if (currentRoom.getWest() == null) {
            return false;
        } else {
            currentRoom = currentRoom.getWest();
            return true;
        }
    }


    public String storyLine(int i) {
        String line = "";
        switch (i) {
            case 0:
                line = "After a couple of beers at the after-class-fridays-bar,\n" +
                        "a couple of you and your fellow students,\n" +
                        "decided to enjoy the sun on the grass of a nearby sematary.\n" +
                        "At least, that is what you remember\n" +
                        "You mut have fallen asleep..\n " +
                        "But why did no one wake you up?";
                break;
            case 1:
                line = "You are standing in the middle of a deserted graveyard, in the distance you hear the sound of\n " +
                        "traffic rumbling and people from a local pub chatting away, as old crooked branches and the pail\n" +
                        " moonlight shows you a path amidst silent tombstones";
                break;
            case 2:
                line = "As you walk along the path, you suddenly get the creepy feeling that you are being watched ";
                break;
            case 3:
                line = "You are standing by the grave of Soeren Kirkegaard, the famous danish philosefer ";
                break;
            case 4:
                line = "You are standing in front of are standing in front of a mausoleum";
                break;
            case 5:
                line = "5:";
                break;
            case 6:
                line = "You climb down the ladder into the sewer, the smell is unbearable.\n" +
                        "It is really dark, but you can carefully walk by the sidewalk.\n" +
                        "As you walk for a couple of minutes, a crack in the wall appears.";
                break;
            case 7:
                line = "One of the candles are looking a little out of place, do you want to pull it? (Ja / Nej)\n" +
                        "y: A small door opens, you can barely fit but make it through and walk down the stairways -> case 8\n" +
                        "n: You leave the candle and stay respectful towards the dead\n" +
                        "It is dusty inside the mausoleum and really dark. There is something looking like a torch on the wall.";
                break;
            case 8:
                line = "As you continue down the hallways you find a big door with a huge lock on it.\n" +
                        "You need a key to open the door.";
                break;

            case 9:
                line = "You crawl through the crack in the wall and find yourself in some mysterious hallways";
                break;

        }
        return line;
    }

}
