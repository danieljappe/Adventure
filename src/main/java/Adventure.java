public class Adventure {

    Map map = new Map();
    Player player = new Player();

    public Room getCurrentRoom() {
        return player.currentRoom;
    }


    public boolean go(int direction) {
        switch (direction) {
            case 1 -> {
                return player.goNorth();
            }
            case 3 -> {
                return player.goSouth();
            }
            case 2 -> {
                return player.goEast();
            }
            case 4 -> {
                return player.goWest();
            }
            default -> {
                return false;
            }
        }

    }
}


