public class Map {
    //private boolean door12open = true; // her er bare en sti uden forhindring
    private boolean door23open = false; // gitterlåge, her skal bruges nøgle
    private boolean door36open = false; // kloak rist, måske skal bruge skruenøgle
    //private boolean door69open = true; // revne i kloakens side, måske skal man bruge stearinlys
    private boolean door89open;
    private boolean door58open = false; // store dør i grotte
    private boolean door78open;
    private boolean door47open = false; // tungt kistelåg, en løftestang el.
    private boolean door14open = false;// dør til mausoleum, skal bruge nøgle


    public Map() {
        buildMap();
    }

    Room room1 = new Room("room1", storyLine(100),"",storyLine(140),storyLine(120),""); // north south east west
    Room room2 = new Room("room2", storyLine(200),"","",storyLine(230),storyLine(210));
    Room room3 = new Room("room3", storyLine(300),"",storyLine(360),"",storyLine(320));
    Room room4 = new Room("room4", storyLine(400),storyLine(410),storyLine(470),"","");
    Room room5 = new Room("room5", "room5 description","","","","");
    Room room6 = new Room("room6", storyLine(600),storyLine(630),storyLine(690),"","");
    Room room7 = new Room("room7", storyLine(700),storyLine(740),"",storyLine(780),"");
    Room room8 = new Room("room8", storyLine(800),storyLine(850),"",storyLine(890),storyLine(870));
    Room room9 = new Room("room9", storyLine(900),storyLine(960),"","",storyLine(980));

    public String storyLine(int i) {
        String line = "";
        switch (i) {
            case 0:
                line = """
                        [0m
                        
                               ▄▄▄▄▄▄
                            [1;30m▐[0m██▀   ▀▀██
                           [1;30m▐[0m██        ▀█
                           [1;30m▐[0m█                                           █
                           [1;30m▐[0m█                                           █  ▄
                           [1;30m▐[0m█    ▄▄▄▄▄  █▄▄▄   █▀▀▀█▄▀█▄    ▄█▀▄▄▄      █
                           [1;30m▐[0m█▄   ██▀ ▀█ █▀ ▀█      [1;30m▐[0m█  █▄  ▄█ ▄▀ ▀█ ▄▀▀██  ▄    ▄▄▄   ▄▄▄   ▄▄   ▄
                            [1;30m▐[0m█▄  ▀▀  [1;30m▐[0m█ █      ▄█▀▀▀█  [1;30m▐[0m█ █▀ [1;30m▐[0m█▄▄▄█ █▄ [1;30m▐[0m█ [1;30m▐[0m█   █  ▀█ █  ▀█ █▀▀█ [1;30m▐[0m██▀█
                             [1;30m▐[0m██▄   [1;30m▐[0m█▀ █     ▀█▄  ██   ▀██  [1;30m▐[0m█▄     █ ▄█ [1;30m▐[0m█▄  ▀▄ ▄█ ▀▄ ▄█ █▀▀▀ [1;30m▐[0m█
                                ▀▀▀▀▀▀          ▀▀▀ ▀▀   ▀     ▀▀▀   ▀▀▀ ▀  ▀▀  ▀▀▀█  ▀▀▀█ ▀█▄█ [1;30m▐[0m█
                                                                               ▄  ▄█ ▄  ▄█
                                                                               ▀▀▀▀  ▀▀▀▀
                          [1;30m▐[47m▀▀▀▀▀▀▀▀▀▀▀[40m▌[0m      [31m▄█[37m
                          [1;30m▐[0m█[1;30m█[47m▀▄[0m█[1;30;47m▀[0m█[1;30m█[47m▀▄[0m█[1;30m▌[0m     [31m▄▀█[37m        [31m█[37m                     [31m▄[37m
                          [1;30m▐[0m█[1;30m█[47m▀▄[0m█[1;30m█[0m█[1;30m█[47m▀[0m██[1;30m▌[0m    [31m▄█[37m [31m█[37m        [31m██▄[37m     [31m▄█[37m          [31m▄▄█▄▄[37m
                          [1;30m▐[0m███████████[1;30m▌[0m    [31m█[37m   [31m█[37m  [31m▄█▀▀▀█[37m [31m█▄[37m   [31m▄█[37m [31m█▀▀█▄[37m [31m█▄▄▄[37m  [31m█[37m     [31m█[37m   [31m█[37m  [31m█▄▄▄▄[37m [31m▄▄▄▄[37m
                          [1;30m▐[0m███████████[1;30m▌[0m   [31m██▄▄▄▄█[37m [31m█[37m    [31m█[37m  [31m█▄[37m  [31m█[37m  [31m█▄▄▄█[37m [31m█[37m  [31m▀█[37m [31m█[37m     [31m█[37m   [31m█[37m  [31m█▀[37m  [31m▀[37m [31m█[37m  [31m██[37m
                          [1;30m▐[0m███████████[1;30m▌[0m   [31m█[37m     [31m▀█▀█▄▄▄█[37m   [31m█▄█[37m   [31m█▄[37m    [31m█[37m   [31m█[37m [31m▀█[37m  [31m▄[37m [31m▀▄[37m [31m█▀[37m  [31m█[37m     [31m█▀▀▀[37m
                         [1;30m██████████████[0m  [31m▄▀[37m      [31m▀█[37m    [31m▀[37m    [31m▀[37m     [31m▀▀▀▀[37m [31m▀[37m   [31m▀[37m  [31m▀▀▀[37m   [31m▀▀▀[37m   [31m▀[37m     [31m▀█▄▄▄█[37m
                        [33m█[1;30;43m▀▀▀▀▀▀▀▀▀▀▀▀▀▀[0;33m▄[37m """ +
                        "\n\u001B[39m" +
                        "After a couple of beers at the after-class-fridays-bar,\n" +
                        "a couple of you and your fellow students,\n" +
                        "decided to enjoy the sun on the grass of a nearby sematary.\n" +
                        "At least, that is what you remember\n" +
                        "You mut have fallen asleep..\n " +
                        "But why did no one wake you up?";
                break;
            case 100:
                line = "You are standing in the middle of a deserted graveyard, in the distance you hear the sound of\n" +
                        "traffic rumbling and people from a local pub chatting away, as old crooked branches and the pail\n" +
                        "moonlight shows you a path amidst silent tombstones\n";
                break;
            case 120 :
                line = "You leve the place were woke and wonder into the darkness";
                break;
            case 140:
                line ="Your path ends in front of a mausoleum\n" +
                        "the dor to the closed\n" +
                        "the dor is open you walk in\n";
                break;
            case 200:
                line = "As you walk along the path, you suddenly get the ery feeling that someone\n" +
                        "or something is watching you\n";
                break;
            case 210:
                line = "You walk out of the darkness back to the place were you woke up some time ago";
                break;
            case 230:
                line = "following the path going east you get to a smale rusty gate in a high spiked iron fence,\n";
                break;
            case 231:
                line = "the gate is Locked/Open , You and turn and back/ \n";
                break;
            case 232:
                 line = "You put the key in the lock, turn it, it opens, and you walk through\n";
                break;
            case 300:
                line = "It seams like you have reached a dead end. You are a small circular clearing between hedges\n" +
                        "  there a bench and a pipe sticking out of the ground\n" +
                        "with a water tab, where a small metal water bucket is hanging\n" +
                        "probably for watering flowers. The water from the tab is running into the already filled bucket\n" +
                        "and spilling onto the ground, flowing down a grid\n" +

                break;
            case 320:
                line = "leaving the clearing thru the rusty gate\n";
                break;
            case 360:
                line = "As you get closer, you can see a latter fixed into the cement on the other side of the grid."+
                        "A person could with a little effort pass thue the opening. It could be your imagination,\n" +
                        "but it seams to you that you can hear the sound of a violin playing\n" +
                        " for a moment, and the sound seamed to be coming from down there\n";
                break;
            case 361:
                line = "The grid is fixed with a bolt\n";
                break;
            case 362:
                line = "You unscrew the bolt, and you are able to lift it aside,\n" +
                        "and climb down the ladder into the sewer\n";
            case 400:
                line = "You are inside a mausoleum, the room is lit with candles, its so quiet that it makes you feel uneasy,\n" +
                        "in the middle a sarcophagus of marble\n";
                break;
            case 410:
                line = "You turn to the dor leading out of the mausoleum\n" +
                        "it is closed\n" +
                        "its open, you walk out\n";

                break;
            case 470:
                line = "";
                break;
            case 500:
                line = "5:";
                break;
            case 600:
                line =  "The smell is unbearable.\n" +
                        "It is really dark, but you can carefully walk by the sidewalk.\n" +
                        "As you walk for a couple of minutes, a crack in the wall appears.\n";
                break;
            case 630:
                line = "You climb up the ladder and out of the sewer";//from room6 to room3
                break;
            case 690:
                line = " ";
                break;
            case 700:
                line = "One of the candles are looking a little out of place, do you want to pull it? (Ja / Nej)\n" +
                        "y: A small door opens, you can barely fit but make it through and walk down the stairways -> case 8\n" +
                        "n: You leave the candle and stay respectful towards the dead\n" +
                        "It is dusty inside the mausoleum and really dark. There is something looking like a torch on the wall.";
                break;

        }
        return line;
    }

    public void buildMap() {
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
}
