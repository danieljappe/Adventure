public class Adventure {

    Player player = new Player();

    public Room getCurrentRoom() {
        return player.currentRoom;
    }


    public boolean go(char direction) {
        switch (direction) {
            case 'n' -> {
                return player.goNorth();
            }
            case 's' -> {
                return player.goSouth();
            }
            case 'e' -> {
                return player.goEast();
            }
            case 'w' -> {
                return player.goWest();
            }
            default -> {
                return false;
            }
        }

    }
}


