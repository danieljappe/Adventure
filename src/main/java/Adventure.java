public class Adventure {
    private Map map = new Map();
    private Player player = new Player();

    public Room getCurrentRoom() {
        return player.getCurrentRoom();
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

    public Map getMap() {
        return map;
    }
}


