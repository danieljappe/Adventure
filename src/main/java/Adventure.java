public class Adventure {
    private Map map = new Map();
    private Player player = new Player();

    public Room getCurrentRoom() {
        return player.getCurrentRoom();
    }


    public void go(char direction) {

        switch (direction) {
            case 'n' -> {
                player.goNorth();
            }
            case 's' -> {
                player.goSouth();
            }
            case 'e' -> {
                player.goEast();
            }
            case 'w' -> {
                player.goWest();
            }
        }
    }
    public boolean isRoom(char direction) {

        switch (direction) {
            case 'n' -> {
                return player.isRoomNorth();
            }
            case 's' -> {
                return player.isRoomSouth();
            }
            case 'e' -> {
                return player.isRoomEast();
            }
            case 'w' -> {
               return player.isRoomWest();
            }
            default -> {
                return false;
            }
        }
    }
    public Map getMap() {
        return map;
    }

    public Player getPlayer() {
        return player;
    }
}


