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

    private Room currentRoom = room1;

    public Room getCurrentRoom() {
        return currentRoom;
    }
private String storyLine(int i) {
        String line ="";
        switch(i) {
            case 0 : line = "After a coble of beers at the after class fridays bar , a couple of you and your fellow  " +
                "students decided to enjoy the sun on the grass of a nearby sematary. At least, that is what you remember" +
                "You mut have fallen asleep.. But why did no one wake you ";
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

        }
        return line;
    }
}
