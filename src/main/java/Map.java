public class Map {

    public Map() {
        buildMap();
    }
    // Keys
    private Item torch = new Key("torch",KeyType.TORCH);
    private Item rustyKey = new Key("RustyKey",KeyType.RUSTY_KEY);
    private Item goldenKey = new Key("GoldenKey",KeyType.GOLDEN_KEY);
    private Item ironBar = new Key("IronBar",KeyType.IRON_BAR);
    private Item wrench = new Key("Wrench",KeyType.WRENCH);
    private Item boneKey = new Key("BoneKey",KeyType.BONE_KEY);

    // Food items
    private Item cheese = new Food("cheese",10); // virker det stadig?
    private Item ham = new Food("ham",15);
    private Item dead_rat = new Food("dead rat",-10);
    private Item shoe = new Food("shoe",-5);
    private Item beans = new Food("beans",20);
    private Item apple = new Food("apple",10);

    // Weapons
    private Item sword = new MeleeWeapon("sword",20);
    private Weapons revolver = new RangedWeapon("revolver", 15, 6, AmmunitionType.BULLETS);
    private Weapons bow = new RangedWeapon("bow", 20, 5,AmmunitionType.ARROWS);

    // Ammo
    private Item arrows = new Ammunition("arrows",3,AmmunitionType.ARROWS);

    // Enemy

    private Enemy monster = new Enemy("Monster Teacher", 50,10);
    private Enemy zombie = new Enemy("Zombie Student", 30,6);
    private Enemy giantRat = new Enemy("Giant Rat", 35,7);
    private Enemy spider = new Enemy("Spider", 20,5);
    private Enemy werewolf = new Enemy("Werewolf",40,12);
    private Enemy vampire = new Enemy("Vampire",35,8);
    private Enemy rastaFairy = new Enemy("Rasta Fairy",20,12);


    Room room1 = new Room("room1", storyLine(100),"",storyLine(140),storyLine(120),""); // north south east west
    Room room2 = new Room("room2", storyLine(200),"","",storyLine(230),storyLine(210));
    Room room3 = new Room("room3", storyLine(300),"",storyLine(360),"",storyLine(320));
    Room room4 = new Room("room4", storyLine(400),storyLine(410),storyLine(470),"","");
    Room room5 = new Room("room5", "room5 description","","","","");
    Room room6 = new Room("room6", storyLine(600),storyLine(610),storyLine(630),"","");
    Room room7 = new Room("room7", storyLine(700),storyLine(710),"",storyLine(720),"");
    Room room8 = new Room("room8", storyLine(800),storyLine(810),"",storyLine(820),storyLine(840));
    Room room9 = new Room("room9", storyLine(900),storyLine(910),"","",storyLine(940));


    Door door12 = new Door("no obstical",true,storyLine(121),storyLine(122),null);
    Door door23 = new Door("iron gate",false,storyLine(231),storyLine(232), KeyType.RUSTY_KEY);
    Door door36 = new Door("grid in the ground",false,storyLine(361),storyLine(362),KeyType.WRENCH);
    Door door69 = new Door("gap in the wall",true,storyLine(691),storyLine(692),null);
    Door door89 = new Door("door89",true,storyLine(981),storyLine(982),null);
    Door door58 = new Door("big gate",true,storyLine(851),storyLine(852),KeyType.GOLDEN_KEY);
    Door door78 = new Door("door78",true,storyLine(781),storyLine(782),null);
    Door door47 = new Door("Stone slade of the coffin",true,storyLine(471),storyLine(472),KeyType.IRON_BAR);
    Door door14 = new Door("door to the mausoleum",true,storyLine(141),storyLine(142),KeyType.BONE_KEY);




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
                        "After a couple of beers at the after class fridaysbar,\n" +
                        "a couple of you and your fellow students decided\n" +
                        "to enjoy the sun on the grass of a nearby sematary.\n" +
                        "At least, that is what you remember\n" +
                        "You must have fallen asleep..\n" +
                        "Why did no one wake you up?";
                break;
            case 100:
                line = "You are standing in the middle of a deserted graveyard, in the distance you hear the sound of\n" +
                        "traffic rumbling and people from a local pub chatting away, as old crooked branches and the pail\n" +
                        "moonlight shows you a path amidst silent tombstones\n";
                break;
            case 120 :
                line = "You leave the place woke up and wander into the darkness";
                break;
            case 140:
                line ="Your path ends in front of a mausoleum\n" ;
                break;
            case 141:
                line ="the door to the closed\n";
                break;
            case 142:
                line ="the door is open you walk in\n";
                break;
            case 200:
                line = "As you walk along the path, you suddenly get the ery feeling that someone\n" +
                        "or something is watching you\n";
                break;
            case 210:
                line = "You walk out of the darkness back to the place were you woke up some time ago";
                break;
            case 230:
                line = "following the path going east you get to a small rusty gate in a high spiked iron fence,\n";
                break;
            case 231:
                line = "Following the path going east, you get to a small rusty gate in a high spiked iron fence.\n" +
                        "The gate is locked \n";
                break;
            case 232:
                 line = "You put the key in the lock, turn it, it opens, and you walk through\n";
                break;
            case 300:
                line = "It seems like you have reached a dead end. You are standing in small circular clearing between hedges\n" +
                        "there is a bench and a pipe sticking out of the ground\n" +
                        "with a water tab, where a small metal water bucket is hanging\n" +
                        "probably for watering flowers. The water from the tab is running into the already filled bucket\n" +
                        "and spilling onto the ground, flowing down through a grid\n";

                break;
            case 320:
                line = "leaving the clearing through the rusty gate\n";
                break;
            case 360:
                line = "As you get closer, you can see a ladder fixed into the cement on the other side of the grid."+
                        "A person could with a little effort pass through the opening. It could be your imagination,\n" +
                        "but it seams to you that you can hear the sound of a violin playing\n" +
                        "for a moment, and the sound seemed to be coming from down there\n";
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
                line = "You turn to the door leading out of the mausoleum\n";
            case 411:
                line ="it is closed, you cant get out\n";
                break;
            case 412:
                line ="its open, you walk out\n";
                break;
            case 470:
                line = "You walk down the stairs into the darkness\n";
                break;
            case 471:
                line = "You push, but the stone slab won't budge\n";
            case 472:
                line = "The stone slab moves aside, revealing a hidden staircase\n ";
            case 500:
                line = "Slutrum";
                break;
            case 600:
                line =  "The smell is unbearable and big rodents rushes away into the shadows.\n" +
                        "It is really dark, but you can carefully sneak by the sidewalk.\n" +
                        "As you walk for a couple of minutes, a crack in the wall appears.\n";
                break;
            case 610:
                line = "You climb up the ladder, out of the sewer, and into the moonlight\n" +
                        "Finally some fresh air.";
                break;
            case 630:
                line = "You can barely fit through the crack, but you somehow manage to get through.\n" +
                        "It is really dark (Mulighed for at det kræver fakkel).\n";
                break;
            case 700:
                line = "You enter some form of ancient chamber.\n" +
                        "The room is pitch black and you get covered in spiderwebs where ever you move.\n" +
                        "Its impossible to navigate around in these conditions\n";
                break;
            case 710:
                line = "You walk up the stairs back to the mausoleum.\n" +
                        "It is brighter here, thanks to the torches.";
                break;
            case 720:
                line = "You follow the archway out of the chamber, which leads to an endless hallway.";
                break;
            case 800:
                line = "In the middle of the hallway, there is a huge door.\n" +
                        "On closer inspection the door is locked with a gold padlock.\n" +
                        "Something important must be in here. But how do you get in?";
                break;
            case 810:
                line = "The door is locked! You need to find a key.";
                break;
            case 820:
                line = "You walk down the hallways surrounded by old portraits and enter a smaller room,";
                break;
            case 840:
                line = "You follow the hallways and enter a room.";
                break;
            case 900:
                line = "This room is filled with barrels, some bigger than others.\n" +
                        "It smells better in here, it might be wine stored in these barrels.\n";
                break;
            case 910:
                line = "You crawl through the big crack in the wall behind one of the bigger barrels\n" +
                        "It already smells horrible.";
                break;
            case 940:
                line = "You leave the wine cellar and follow the path.";
                break;
            // 10 = north / 20 = east / 30 = south / 40 = west
        }
        return line;
    }

    public void buildMap() {
        room1.setEast(room2);
        room1.setSouth(room4);
        room1.setDoors(null,door14,door12,null);
        room1.addItem(torch);
        room1.addItem(rustyKey);
        room1.addItem(cheese);
        room1.addItem(ham);
        room1.addItem(sword);
        room1.addItem(revolver);
        room1.addItem(bow);
        room1.addEnemy(zombie);

        room2.setWest(room1);
        room2.setEast(room3);
        room2.setDoors(null,null,door23,door12);
        room2.addItem(shoe);
        room2.addItem(arrows);
        room2.addItem(wrench);
        room2.addEnemy(werewolf);


        room3.setSouth(room6);
        room3.setWest(room2);
        room3.setDoors(null,door36,null,door23);
        room3.addEnemy(rastaFairy);

        room4.setNorth(room1);
        room4.setSouth(room7);
        room4.setDoors(door14,door47,null,null);
        room4.addEnemy(spider);

        room5.setSouth(room8);
        room5.setDoors(null,door58,null,null);

        room6.setSouth(room9);
        room6.setNorth(room3);
        room6.setDoors(door36,door69,null,null);
        room6.addItem(boneKey);
        room6.addEnemy(giantRat);

        room7.setNorth(room4);
        room7.setEast(room8);
        room7.setDoors(door47,null,door78,null);
        room7.addItem(beans);
        room7.addEnemy(vampire);

        room8.setWest(room7);
        room8.setEast(room9);
        room8.setNorth(room5);
        room8.setDoors(door58,null,door89,door78);

        room9.setWest(room8);
        room9.setNorth(room6);
        room9.setDoors(door69,null,null,door89); //n s e w
        room9.addItem(ironBar);
    }
    public Room getStartRoom() {
        return room1;
    }







}
