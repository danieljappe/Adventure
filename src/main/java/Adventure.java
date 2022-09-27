public class Adventure {


    Room room1 = new Room("room1",storyLine(1));
    Room room2 = new Room("room2",storyLine(2));
    Room room3 = new Room("room3",storyLine(3));
    Room room4 = new Room("room4",storyLine(4));
    Room room5 = new Room("room5","room5 description");
    Room room6 = new Room("room6","room6 description");
    Room room7 = new Room("room7","room7 description");
    Room room8 = new Room("room8","room8 description");
    Room room9 = new Room("room9","room9 description");

    private Room currentRoom = null;

    public Room getCurrentRoom() {
        return currentRoom;
    }
    public void goNorth(){
        currentRoom = currentRoom.getNorth();
    }



private String storyLine(int i) {
        String line ="";
        switch(i) {
            case 0 : line = "After a couple of beers at the after class fridays bar , a couple of you and your fellow  " +
                "students decided to enjoy the sun on the grass of a nearby sematary. At least, that is what you remember" +
                "You mut have fallen asleep.. But why did no one wake you up";
            break;
            case 1 : line = "You are standing in the middle of a deserted graveyard, in the distance you hear the sound of " +
                "traffic rumbling and people from a local pub chatting away, as old crooked branches and the pail moonlight " +
                "shows you a path amidst silent tombstones";
            break;
            case 2 : line =  "As you walk along the path, you suddenly get the creepy feeling that you are being watched ";
            break;
            case 3 : line =  "You are standing by the grave of Soeren Kirkegaard, the famous danish philosefer ";
            break;
            case 4 : line = "You are standing in front of are standing in front of a mausoleum";
            break;


            case 6 : line = "You climb down the ladder into the sewer, the smell is unbearable. It is really dark, " +
                    "but you can carefully walk by the sidewalk. As you walk for a couple of minutes, a crack in the wall appears.";
            /*case 7 : line = "One of the candles are looking a little out of place, do you want to pull it?" (Ja / Nej)
                        Y : "A small door opens, you can barely fit but make it through and walk down the stairways -> case 8
                        N: "You leave the candle and stay respectful towards the dead" +
                        "It is dusty inside the mausoleum and really dark. There is something looking like a torch on the wall.";*/
            case 8 : line = "As you continue down the hallways you find a big door with a huge lock on it. You need a key to open the door.";

            case 9 : line = "You crawl through the crack in the wall and find yourself in some mysterious hallways";


        }
        return line;
    }
}
